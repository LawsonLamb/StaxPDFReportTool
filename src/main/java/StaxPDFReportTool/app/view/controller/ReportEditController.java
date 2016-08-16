package StaxPDFReportTool.app.view.controller;

import StaxPDFReportTool.app.logic.ReportEditLogic;
import StaxPDFReportTool.app.model.ReportField;
import StaxPDFReportTool.app.ReportAppComponent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class ReportEditController extends ReportAppComponent implements Initializable {

    @FXML
    ListView<ReportField> fieldListView;
    @FXML
    TextField idTextField;
    @FXML
    TextField mappingIDTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fieldListView.setItems(app().model().getReportEditModel().getFieldList().GetObserableList());

        fieldListView.setCellFactory(new Callback<ListView<ReportField>, ListCell<ReportField>>() {
            @Override
            public ListCell<ReportField> call(ListView<ReportField> param) {
                {

                    ListCell<ReportField> cell = new ListCell<ReportField>(){

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

    @FXML
    public void getFieldProperty(javafx.scene.input.MouseEvent event){
        updateViewFromModel();

        fieldListView.setCellFactory(new Callback<ListView<ReportField>, ListCell<ReportField>>() {
            @Override
            public ListCell<ReportField> call(ListView<ReportField> param) {
                {

                    ListCell<ReportField> cell = new ListCell<ReportField>(){

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


    public void updateViewFromModel(){

        if(getLogic().getCurrentField()!=null){
            idTextField.textProperty().unbindBidirectional(getLogic().getCurrentField().iDProperty());
        }

        int index = fieldListView.getSelectionModel().getSelectedIndex();

        app().logic().editLogic().setCurrentField(app().model().getReportEditModel().getFieldList().GetObserableList().get(index));

       if(getLogic().getCurrentField()!=null){

           idTextField.textProperty().bindBidirectional(getLogic().getCurrentField().iDProperty());

       }


    }
    public ReportEditLogic getLogic(){

        return app().logic().editLogic();
    }







}
