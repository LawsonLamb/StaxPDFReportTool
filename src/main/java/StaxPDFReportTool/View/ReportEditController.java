package StaxPDFReportTool.View;

import StaxPDFReportTool.Model.ReportProperty;
import StaxPDFReportTool.app.ReportAppComponent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class ReportEditController extends ReportAppComponent implements Initializable {


    @FXML
    ListView<String> fieldListView;
    @FXML
    TextField idTextField;
    @FXML
    TextField mappingIDTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void getFieldProperty(ActionEvent event){

        int index = fieldListView.getSelectionModel().getSelectedIndex();
       app().logic().editLogic();
    }
}
