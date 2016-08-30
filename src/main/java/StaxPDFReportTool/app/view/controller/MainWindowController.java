package StaxPDFReportTool.app.view.controller;


import StaxPDFReportTool.app.ReportAppComponent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController extends ReportAppComponent implements Initializable {
    @FXML
    BorderPane borderPane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    void openMenuItemAction(ActionEvent event) {



    }
    @FXML
    void setIdAsMenuItemAction(ActionEvent event){
        /*
        try {
            getLogic().setFormFieldIDValues();
            viewTabModel().getDocument().save(currentFilename);
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
    }
    @FXML
    void setMappingIdAsValueMenuItemAction(ActionEvent event){
/*
        try {

            getLogic().setFormFieldMappingValues(viewTabModel().getAcroForm().getFields());
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
    }
    @FXML
    void importFDFMenuItemAction(ActionEvent event) {
        /*
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(" import FDF file location");
        File file =  fileChooser.showOpenDialog(borderPane.getScene().getWindow());
        if(file!=null) {
            //  viewTabModel().getAcroForm().importFDF(new FDFDocument());
            // TODO: 8/21/16  Implement importing of FDF file
        }

*/

    }

    @FXML
    void exportFDFMenuItemAction(ActionEvent event) {
        /*
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(" export FDF file location");
        File file =  fileChooser.showSaveDialog(borderPane.getScene().getWindow());
        if(file!=null){
            try {
                viewTabModel().getAcroForm().exportFDF().save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        */
    }

    @FXML
    public void exitMenuItemAction(ActionEvent event) {
        app().logic().reportViewerLogic().exitApplication();
    }

    @FXML
    void saveAsMenuItemAction(ActionEvent event) {

        /*
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save As ");
        if() {
            fileChooser.setInitialDirectory(new File(currentFilename));
        }
        File file =  fileChooser.showOpenDialog(borderPane.getScene().getWindow());
        if(file!=null){
            try {
               // viewTabModel().savePDF(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //todo implement error logic
        */
    }

    @FXML
    void saveMenuitemAction(ActionEvent event) {
        /*
        if (currentFilename != null) {

            try {
              //  viewTabModel().savePDF(currentFilename);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        else{

            // TODO: 8/19/2016 implement error logic
        }
        */
    }
}
