package StaxPDFReportTool.app.View;

import StaxPDFReportTool.app.ReportAppComponent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class ReportEditController extends ReportAppComponent implements Initializable {


    @FXML
    ListView<PDField> fieldListView;
    @FXML
    TextField idTextField;
    @FXML
    TextField mappingIDTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        fieldListView.setItems(app().model().getReportEditModel().getFieldList().GetObserableList());
        fieldListView.setCellFactory(new Callback<ListView<PDField>, ListCell<PDField>>() {
            @Override
            public ListCell<PDField> call(ListView<PDField> param) {
                {

                    ListCell<PDField> cell = new ListCell<PDField>(){

                        @Override
                        protected void updateItem(PDField t, boolean bln) {
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

    @FXML
    private void getFieldProperty(ActionEvent event){

        int index = fieldListView.getSelectionModel().getSelectedIndex();
       app().logic().editLogic();
    }
}
