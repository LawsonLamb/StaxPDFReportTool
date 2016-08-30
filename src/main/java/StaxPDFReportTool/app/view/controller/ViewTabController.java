package StaxPDFReportTool.app.view.controller;

import StaxPDFReportTool.app.model.pdf.IDocument;
import StaxPDFReportTool.app.ReportAppComponent;
import StaxPDFReportTool.app.logic.ViewTabLogic;
import StaxPDFReportTool.app.model.pdf.ReportDocument;
import StaxPDFReportTool.app.model.pdf.ReportField;
import StaxPDFReportTool.app.model.ViewTabModel;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import org.apache.pdfbox.pdmodel.PDDocument;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewTabController extends ReportAppComponent implements Initializable,IDocument{

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

        ReportField reportField = getModel().getCurrentField();

        if (reportField != null) {
            partialNameTextField.textProperty().unbindBidirectional(reportField.partialNameProperty());
            mappingNameTextField.textProperty().unbindBidirectional(reportField.mappingNameProperty());
            alternativeNameTextField.textProperty().unbindBidirectional(reportField.altNameProperty());
            noExportCheckBox.selectedProperty().unbindBidirectional(reportField.isNoExportProperty());
            readOnlyCheckBox.selectedProperty().unbindBidirectional(reportField.readOnlyProperty());
            isRequiredCheckBox.selectedProperty().unbindBidirectional(reportField.isRequiredProperty());
        }
        int index = fieldListView.getSelectionModel().getSelectedIndex();
        getModel().setCurrentField(getModel().get(index));
        reportField = getModel().getCurrentField();

        if (reportField != null) {
            partialNameTextField.textProperty().bindBidirectional(reportField.partialNameProperty());
            mappingNameTextField.textProperty().bindBidirectional(reportField.mappingNameProperty());
            alternativeNameTextField.textProperty().bindBidirectional(reportField.altNameProperty());
            noExportCheckBox.selectedProperty().bindBidirectional(reportField.isNoExportProperty());
            readOnlyCheckBox.selectedProperty().bindBidirectional(reportField.readOnlyProperty());
            isRequiredCheckBox.selectedProperty().bindBidirectional(reportField.isRequiredProperty());
        }

    }




    @Override
    public void Load(File file) throws IOException {
        PDDocument document = reportDocument().getPdDocument();
        if (document != null) {
            document.close();
            imageVBox.getChildren().removeAll();
        }
        reportDocument().Load(file);
        // TODO: 8/30/2016  rendering not working!!
        for (int i = 0; i < reportDocument().getPdPageTree().getCount(); i++) {
            imageVBox.getChildren().add(createPage(i));
        }


        // TODO: 8/30/2016 FieldList Not Working
    //fieldListView.setItems(getModel().GetObservableList());
     //   setCellFactory();
    }

    public Image getImage(int pageNumber)  {
        BufferedImage pageImage = null;
        try {
            pageImage = reportDocument().getPdfRenderer().renderImage(pageNumber,1.0f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SwingFXUtils.toFXImage(pageImage, null);
    }
    public ImageView createPage(int index) throws IOException {
    ImageView imageView = new ImageView(getImage(index));
        return imageView;
    }


    @Override
    public void Save(File file) throws IOException {

    }

    @Override
    public void Close() throws IOException {

    }
    //endregion


    //region Accessors
    public ViewTabLogic getLogic() {

        return app().logic().reportViewerLogic();
    }


    public ViewTabModel getModel(){
        return app().model().reportViewerModel();
    }


  private ReportDocument reportDocument() {
      return app().model().reportDocument();
  }

    public BorderPane getRoot() {
        return  borderPane;
    }


    //endregion










}
