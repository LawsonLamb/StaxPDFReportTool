package StaxPDFReportTool.app.view.controller;

import StaxPDFReportTool.app.ReportAppComponent;
import StaxPDFReportTool.app.model.pdf.ReportField;
import StaxPDFReportTool.app.model.ViewTabModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class EditTabController extends ReportAppComponent implements Initializable {

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
    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }
    public void Open(){
        setupTree();
        fieldTableView.setItems(getViewerModel().GetObservableList());
        partialNameCol.setCellValueFactory(p -> p.getValue().partialNameProperty());
        mappingNameCol.setCellValueFactory(p->p.getValue().mappingNameProperty());
        altNameCol.setCellValueFactory(p->p.getValue().altNameProperty());
        typeCol.setCellValueFactory(p->p.getValue().fieldTypeProperty());
        noExportCol.setCellValueFactory(p->p.getValue().isNoExportProperty());
        readOnlyCol.setCellValueFactory(p->p.getValue().readOnlyProperty());
        isRequiredCol.setCellValueFactory(p->p.getValue().isRequiredProperty());

    }

    private void setupTree(){
        TreeItem<String> rootItem = new TreeItem<>("root");
        rootItem.setExpanded(true);
        List<ReportField> reportFields = getViewerModel().GetObservableList();
        for(int i=0; i< reportFields.size();i++){
         ReportField reportField  = getViewerModel().get(i);
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

    public ViewTabModel getViewerModel(){
        return app().model().reportViewerModel();
    }






}
