package StaxPDFReportTool.app.view.controller;

import StaxPDFReportTool.app.ReportAppComponent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class PdfPropertyPaneController extends ReportAppComponent implements Initializable {

    @FXML
    private TextField authorsNameTextField;

    @FXML
    private TextField producerNameTextField;

    @FXML
    private TextField creatorNameTextField;

    @FXML
    private TextField subjectTextField;

    @FXML
    private TextField titleTextField;

    @FXML
    private Label dateCreatedValue;

    @FXML
    private Label dateModifiedValue;

    @FXML
    private CheckBox assembleDocumentCheckBox;

    @FXML
    private CheckBox extractContentCheckBox;

    @FXML
    private CheckBox extractAccessCheckBox;

    @FXML
    private CheckBox fillFormCheckBox;

    @FXML
    private CheckBox modifyCheckBox;

    @FXML
    private CheckBox modifyAnnotationsCheckBox;

    @FXML
    private CheckBox printCheckBox;

    @FXML
    private CheckBox printDegraded;

    @FXML
    private CheckBox ownerAcessPermission;

    @FXML
    private CheckBox revison3PermissionCheckBox;

    @FXML
    private CheckBox ownersPermissionCheckBox;

    @FXML
    private CheckBox readOnlyCheckBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
