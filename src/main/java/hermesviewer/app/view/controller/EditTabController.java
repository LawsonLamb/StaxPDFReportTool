package hermesviewer.app.view.controller;

import hermesviewer.app.interfaces.Include;
import hermesviewer.app.ReportApp;
import hermes.report.pdmodel.ReportDocument;
import hermes.report.ReportField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class EditTabController implements Initializable,Include {

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
    private TreeView<String> widgetTreeView;

    @FXML
    private Parent propertyView;

    public ReportDocumentInformationViewController propertyViewController;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        fieldTableView.setEditable(true);



    }

    public void Open(){
        setupTree();

        fieldTableView.setItems(getViewerModel().getReportFieldObservableList());
        partialNameCol.setCellValueFactory(p -> p.getValue().partialNameProperty());
        mappingNameCol.setCellValueFactory(p->p.getValue().mappingNameProperty());
        altNameCol.setCellValueFactory(p->p.getValue().altNameProperty());
        typeCol.setCellValueFactory(p->p.getValue().fieldTypeProperty());
        noExportCol.setCellValueFactory(p->p.getValue().isNoExportProperty());
        readOnlyCol.setCellValueFactory(p->p.getValue().readOnlyProperty());
        isRequiredCol.setCellValueFactory(p->p.getValue().isRequiredProperty());

        partialNameCol.setCellFactory(TextFieldTableCell.<ReportField>forTableColumn());
        altNameCol.setCellFactory(TextFieldTableCell.<ReportField>forTableColumn());
        mappingNameCol.setCellFactory(TextFieldTableCell.<ReportField>forTableColumn());
        noExportCol.setCellFactory(CheckBoxTableCell.forTableColumn(noExportCol));
        readOnlyCol.setCellFactory(CheckBoxTableCell.forTableColumn(readOnlyCol));
        isRequiredCol.setCellFactory(CheckBoxTableCell.forTableColumn(isRequiredCol));


        partialNameCol.setOnEditCommit(event -> {
            ReportField reportField = (ReportField) event.getTableView().getItems().get(event.getTablePosition().getRow());
            reportField.setPartialName(event.getNewValue());
        });
        altNameCol.setOnEditCommit(event -> {
            ReportField reportField = (ReportField) event.getTableView().getItems().get(event.getTablePosition().getRow());
            reportField.setAltName(event.getNewValue());
        });
        mappingNameCol.setOnEditCommit(event -> {
            ReportField reportField = (ReportField) event.getTableView().getItems().get(event.getTablePosition().getRow());
            reportField.setMappingName(event.getNewValue());

        });
        noExportCol.setOnEditCommit(event -> {
            ReportField reportField = (ReportField) event.getTableView().getItems().get(event.getTablePosition().getRow());
            reportField.setIsNoExport(event.getNewValue());
        });
        readOnlyCol.setOnEditCommit(event -> {
            ReportField reportField = (ReportField) event.getTableView().getItems().get(event.getTablePosition().getRow());
            reportField.setReadOnly(event.getNewValue());
        });
        isRequiredCol.setOnEditCommit(event -> {
            ReportField reportField = (ReportField) event.getTableView().getItems().get(event.getTablePosition().getRow());
            reportField.setIsRequired(event.getNewValue());
        });



         propertyViewController.open();
    }

    @Override
    public ReportApp app() {
        return ReportApp.currentApp();
    }
    private void setupTree(){
        TreeItem<String> rootItem = new TreeItem<>("root");
        rootItem.setExpanded(true);
        List<ReportField> reportFields = getViewerModel().getReportFieldObservableList();
        for(int i=0; i< reportFields.size();i++){
         ReportField reportField  = getViewerModel().getReportFieldObservableList().get(i);
          TreeItem<String> fieldRoot = new TreeItem<>(reportField.getAltName());
            rootItem.getChildren().add(fieldRoot);
            for(PDAnnotationWidget widget: reportField.get().getWidgets()){
                TreeItem<String> widgetTreeItem = new TreeItem<>("widget");
                fieldRoot.getChildren().add(widgetTreeItem);
            }

        }

    widgetTreeView.setRoot(rootItem);

    }
    public ReportDocument getViewerModel(){
        return app().model().reportDocument();
    }



}
