package StaxPDFReportTool.app.view.controller;

import StaxPDFReportTool.app.ReportAppComponent;
import StaxPDFReportTool.app.logic.ViewTabLogic;
import StaxPDFReportTool.app.model.pdf.ReportField;
import StaxPDFReportTool.app.model.ViewTabModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageTree;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewTabController extends ReportAppComponent implements Initializable {

    //region FXML Member Variables

    @FXML
    private BorderPane borderPane;

    @FXML
    private ListView<ReportField> fieldListView;

    @FXML
    private TextField partialNameTextField;

    @FXML
    private TextField mappingNameTextField;

    @FXML
    private TextField alternativeNameTextField;

    @FXML
    private CheckBox noExportCheckBox;

    @FXML
    private CheckBox readOnlyCheckBox;

    @FXML
    private CheckBox isRequiredCheckBox;

    @FXML
    private AnchorPane documentPanel;

    @FXML
    private VBox imageVBox;

// endregion

    private int numberOfPages = 0;
    private String currentFilename = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    //region FXML Field List View Methods
    @FXML
    public void getFieldProperty(javafx.scene.input.MouseEvent event) {
        //// TODO: 8/17/2016  error checking
        updateViewFromModel();
        // // TODO: 8/17/2016  make so we don't have to call set cell factory every time we mouse click
         setCellFactory();
    }
    //endregion


    //region FXML Property actions Methods



    @FXML
    void partialNameTextFieldAction(ActionEvent event) {
       setCellFactory();
    }

    //endregion


    // region Controller Methods
    private void setCellFactory(){

        fieldListView.setCellFactory(new Callback<ListView<ReportField>, ListCell<ReportField>>() {
            @Override
            public ListCell<ReportField> call(ListView<ReportField> param) {
                {

                    ListCell<ReportField> cell = new ListCell<ReportField>() {
                        @Override
                        protected void updateItem(ReportField t, boolean bln) {
                            super.updateItem(t, bln);
                            if (t != null) {
                                setText(t.getPartialName());
                            }
                        }

                    };
                    return cell;
                }
            }



        });
    }

    private void updateViewFromModel() {
        if (getLogic().getCurrentField() != null) {
            partialNameTextField.textProperty().unbindBidirectional(getLogic().getCurrentField().partialNameProperty());
            mappingNameTextField.textProperty().unbindBidirectional(getLogic().getCurrentField().mappingNameProperty());

            alternativeNameTextField.textProperty().unbindBidirectional(getLogic().getCurrentField().altNameProperty());
            noExportCheckBox.selectedProperty().unbindBidirectional(getLogic().getCurrentField().isNoExportProperty());
            readOnlyCheckBox.selectedProperty().unbindBidirectional(getLogic().getCurrentField().readOnlyProperty());
            isRequiredCheckBox.selectedProperty().unbindBidirectional(getLogic().getCurrentField().isRequiredProperty());
        }
        int index = fieldListView.getSelectionModel().getSelectedIndex();
        getLogic().setCurrentField(getModel().getFieldList().get(index));
       // getLogic().getCurrentField().Update();


        if (getLogic().getCurrentField() != null) {
            partialNameTextField.textProperty().bindBidirectional(getLogic().getCurrentField().partialNameProperty());
            mappingNameTextField.textProperty().bindBidirectional(getLogic().getCurrentField().mappingNameProperty());
            alternativeNameTextField.textProperty().bindBidirectional(getLogic().getCurrentField().altNameProperty());
            noExportCheckBox.selectedProperty().bindBidirectional(getLogic().getCurrentField().isNoExportProperty());
            readOnlyCheckBox.selectedProperty().bindBidirectional(getLogic().getCurrentField().readOnlyProperty());
            isRequiredCheckBox.selectedProperty().bindBidirectional(getLogic().getCurrentField().isRequiredProperty());
        }

    }

    private void setupVbox() {
        for (int i = 0; i < numberOfPages; i++) {
            imageVBox.getChildren().add(getLogic().createPage(i));
        }
    }

    private void openPDFFile(File file) throws Exception {
        PDDocument document = app().model().reportViewerModel().getDocument();
        if (document != null) {
            document.close();
            // documentPanel.removeAll();
            documentPanel.getChildren().removeAll();
        }
        currentFilename = file.getAbsolutePath();
        app().model().reportViewerModel().setDocument(PDDocument.load(file));
        PDPageTree pageTree = app().model().reportViewerModel().getDocument().getPages();
        numberOfPages = pageTree.getCount();
        fieldListView.setItems(app().model().reportViewerModel().getFieldList().GetObservableList());
        setCellFactory();
        setupVbox();

    }


    //endregion


    //region Accessors
    public ViewTabLogic getLogic() {

        return app().logic().reportViewerLogic();
    }

 //TODO: 8/17/2016  make sure view never directly interacts with model, must go though logic
    public ViewTabModel getModel(){
        return app().model().reportViewerModel();
    }

    public BorderPane getRoot() {
        return  borderPane;
    }
    //endregion










}
