package StaxPDFReportTool.app.view.controller;

import StaxPDFReportTool.app.ReportAppComponent;
import StaxPDFReportTool.app.logic.ReportViewerLogic;
import StaxPDFReportTool.app.model.ReportField;
import StaxPDFReportTool.app.model.ReportViewerModel;
import StaxReport.StaxReport;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.fdf.FDFDocument;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PDFViewer extends ReportAppComponent implements Initializable {

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

    //region FXML  MENU Action Methods

    @FXML
    public void openMenuItemAction(ActionEvent event) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open Resource File");
    File file =  fileChooser.showOpenDialog(borderPane.getScene().getWindow());
    if (file != null){
        try {
            openPDFFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

    @FXML
     void setIdAsMenuItemAction(ActionEvent event){
        try {
            getLogic().setFormFieldIDValues();
            getModel().getDocument().save(currentFilename);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    void setMappingIdAsValueMenuItemAction(ActionEvent event){

        try {

            getLogic().setFormFieldMappingValues(getModel().getAcroForm().getFields());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    void importFDFMenuItemAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(" import FDF file location");
        File file =  fileChooser.showOpenDialog(borderPane.getScene().getWindow());
        if(file!=null) {
          //  getModel().getAcroForm().importFDF(new FDFDocument());
            // TODO: 8/21/16  Implement importing of FDF file
        }



    }


    @FXML
    void exportFDFMenuItemAction(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(" export FDF file location");
        File file =  fileChooser.showSaveDialog(borderPane.getScene().getWindow());
        if(file!=null){
            try {
                getModel().getAcroForm().exportFDF().save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @FXML
    void fieldFormsMenuItemAction(ActionEvent event) {
    //// TODO: 8/19/2016  implement

            app().view().openPdfFormPropertyPane();

    }

    @FXML
    void pdfPropertysMenuItem(ActionEvent event) {
        //// TODO: 8/19/2016 implement
    }
    @FXML
    public void exitMenuItemAction(ActionEvent event) {
        app().logic().reportViewerLogic().exitApplication();
    }

    @FXML
    void saveAsMenuItemAction(ActionEvent event) {
         FileChooser fileChooser = new FileChooser();
         fileChooser.setTitle("Save As ");

        if(currentFilename!=null) {
            fileChooser.setInitialDirectory(new File(currentFilename));
        }
                       File file =  fileChooser.showOpenDialog(borderPane.getScene().getWindow());
        if(file!=null){
            try {
                getModel().savePDF(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
                     //todo implement error logic
    }

    @FXML
    void saveMenuitemAction(ActionEvent event) {
        if (currentFilename != null) {

            try {
                getModel().savePDF(currentFilename);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        else{

            // TODO: 8/19/2016 implement error logic
        }
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
    public ReportViewerLogic getLogic() {

        return app().logic().reportViewerLogic();
    }

 //TODO: 8/17/2016  make sure view never directly interacts with model, must go though logic
    public ReportViewerModel getModel(){
        return app().model().reportViewerModel();
    }

    public BorderPane getRoot() {
        return  borderPane;
    }
    //endregion










}
