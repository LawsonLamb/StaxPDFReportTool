package StaxPDFReportTool.app.view.controller;

import StaxPDFReportTool.app.ReportAppComponent;
import StaxPDFReportTool.app.model.ReportField;
import StaxPDFReportTool.app.model.ReportFieldList;
import StaxPDFReportTool.app.model.ReportViewerModel;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class PdfFormPropertyPaneController extends ReportAppComponent implements Initializable {

    @FXML
    private TableView<ReportField> fieldTableView;

    @FXML
    private TableColumn<ReportField, String> partialNameCol;

    @FXML
    private TableColumn<ReportField, String> mappingNameCol;

    @FXML
    private TableColumn<ReportField, String> altNameCol;

    @FXML
    private TableColumn<ReportField, String> typeCol;

    @FXML
    private TableColumn<ReportField, Boolean> noExportCol;

    @FXML
    private TableColumn<ReportField, Boolean> readOnlyCol;

    @FXML
    private TableColumn<ReportField, Boolean> isRequiredCol;

    @FXML
    private TreeView<ReportField> widgetTreeView;
    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }
    public void Open(){

        fieldTableView.setItems(getViewerModel().getFieldList().GetObservableList());
        partialNameCol.setCellValueFactory(p -> p.getValue().partialNameProperty());
        mappingNameCol.setCellValueFactory(p->p.getValue().mappingNameProperty());
        altNameCol.setCellValueFactory(p->p.getValue().altNameProperty());
        typeCol.setCellValueFactory(p->p.getValue().fieldTypeProperty());
        noExportCol.setCellValueFactory(p->p.getValue().isNoExportProperty());
        readOnlyCol.setCellValueFactory(p->p.getValue().readOnlyProperty());
        isRequiredCol.setCellValueFactory(p->p.getValue().isRequiredProperty());

    }

    private void setupTree(){



    }

    public ReportViewerModel getViewerModel(){
        return app().model().reportViewerModel();
    }



}
