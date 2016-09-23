package StaxPDFReportTool.app.view.controller;

import StaxPDFReportTool.app.Include;
import StaxPDFReportTool.app.ReportApp;
import StaxPDFReportTool.app.model.pdf.ReportDocument;
import StaxPDFReportTool.app.model.pdf.ReportField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
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

    public PropertyTabController propertyViewController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


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
      //  propertyViewController.Open();

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
          TreeItem<String> fieldRoot = new TreeItem<>("field");
            System.out.println(reportField.getField().getAlternateFieldName());
            rootItem.getChildren().add(fieldRoot);
            for(PDAnnotationWidget widget: reportField.getField().getWidgets()){
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
