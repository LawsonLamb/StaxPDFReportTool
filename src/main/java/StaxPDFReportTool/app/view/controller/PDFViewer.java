package StaxPDFReportTool.app.view.controller;

import StaxPDFReportTool.app.ReportAppComponent;
import StaxPDFReportTool.app.logic.ReportViewerLogic;
import StaxPDFReportTool.app.model.ReportField;
import StaxPDFReportTool.app.model.ReportViewerModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageTree;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class PDFViewer extends ReportAppComponent implements Initializable {

    @FXML
    ListView<ReportField> fieldListView;
    @FXML
    TextField idTextField;
    @FXML
    TextField mappingIDTextField;
    @FXML
    BorderPane borderPane;
    @FXML
    MenuBar menuBar;
    @FXML
    Menu fileMenu;
    @FXML
    MenuItem openMenuItem;
    @FXML
    Menu exportMenuBar;
    @FXML
    MenuItem saveAsImageMenuItem;
    @FXML
    MenuItem exitMenuItem;
    @FXML
    AnchorPane documentPanel;
    @FXML
    ScrollPane scrollPane;
    @FXML
    VBox imageVBox;

    private int numberOfPages = 0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    //  ---------  FXML Methods   ------- //

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
    public void exitMenuItemAction(ActionEvent event) {
        app().logic().reportViewerLogic().exitApplication();
    }


    @FXML
    public void getFieldProperty(javafx.scene.input.MouseEvent event) {

        //// TODO: 8/17/2016  error checking
        updateViewFromModel();

        // // TODO: 8/17/2016  make so we don't have to call setcellfactory every time we mouse click
         setCellFactory();



    }
    public void setCellFactory(){

        fieldListView.setCellFactory(new Callback<ListView<ReportField>, ListCell<ReportField>>() {
            @Override
            public ListCell<ReportField> call(ListView<ReportField> param) {
                {

                    ListCell<ReportField> cell = new ListCell<ReportField>() {

                        @Override
                        protected void updateItem(ReportField t, boolean bln) {
                            super.updateItem(t, bln);
                            if (t != null) {
                                setText(t.getID());
                            }
                        }

                    };

                    return cell;
                }
            }



        });
    }

    public void updateViewFromModel() {

        if (getLogic().getCurrentField() != null) {
            idTextField.textProperty().unbindBidirectional(getLogic().getCurrentField().iDProperty());
        }
        int index = fieldListView.getSelectionModel().getSelectedIndex();
        getLogic().setCurrentField(getModel().getFieldList().GetObserableList().get(index));

        if (getLogic().getCurrentField() != null) {

            idTextField.textProperty().bindBidirectional(getLogic().getCurrentField().iDProperty());
        }


    }

    private void setupVbox() {
        for (int i = 0; i < numberOfPages; i++) {
            imageVBox.getChildren().add(getLogic().createPage(i));
        }
    }

    // methods
    // // TODO: 8/17/2016 move to logic if possible
    private void openPDFFile(File file) throws Exception {
        PDDocument document = app().model().reportViewerModel().getDocument();
        if (document != null) {
            document.close();
            // documentPanel.removeAll();
            documentPanel.getChildren().removeAll();
        }

        app().model().reportViewerModel().setDocument(PDDocument.load(file));
        //  pdfRenderer = new PDFRenderer(pdfDocument);
        PDPageTree pageTree = app().model().reportViewerModel().getDocument().getPages();
        numberOfPages = pageTree.getCount();
        fieldListView.setItems(app().model().reportViewerModel().getFieldList().GetObserableList());
        setCellFactory();
        setupVbox();

    }

    public ReportViewerLogic getLogic() {

        return app().logic().reportViewerLogic();
    }

 //TODO: 8/17/2016  make sure view never directly interacts with model, must go though logic
    public ReportViewerModel getModel(){
        return app().model().reportViewerModel();
    }










}
