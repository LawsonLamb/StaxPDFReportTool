package hermesviewer.app.view.controller;


import hermesviewer.app.ReportAppComponent;
import hermesviewer.app.logic.MasterViewLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController extends ReportAppComponent implements Initializable {
    @FXML
    BorderPane borderPane;
    @FXML
    private Parent viewTabView;
    @FXML
    private Parent editTabView;
    @FXML
    public EditTabController editTabViewController;
    @FXML
    public ViewTabController viewTabViewController;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void openMenuItemAction(ActionEvent event) {

        try {
            masterViewLogic().Open(this.viewTabView);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // TODO: 8/30/2016  Error Handling

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

    }

    @FXML
    void saveAsMenuItemAction(ActionEvent event) {

        masterViewLogic().SaveAs(borderPane);
        //todo implement error logic

    }

    @FXML
    void saveMenuitemAction(ActionEvent event) {

             masterViewLogic().Save(borderPane);
            // TODO: 8/19/2016 implement error logic

    }

    MasterViewLogic masterViewLogic(){
        return app().logic().masterViewLogic();
    }
}
