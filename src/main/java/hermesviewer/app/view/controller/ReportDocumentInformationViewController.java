package hermesviewer.app.view.controller;

import hermesviewer.app.interfaces.Include;
import hermesviewer.app.ReportApp;
import hermes.report.pdmodel.ReportDocumentInformation;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.net.URL;
import java.util.ResourceBundle;

public class ReportDocumentInformationViewController implements Include, Initializable {

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


    private ReportDocumentInformation reportDocumentInformation = new ReportDocumentInformation();

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
    public void open(){

        reportDocumentInformation.bindBidirectional(app().model().reportDocument().reportDocumentInformationProperty());
        if(reportDocumentInformation!=null) {
            authorsNameTextField.textProperty().bindBidirectional(reportDocumentInformation.authorProperty());
            producerNameTextField.textProperty().bindBidirectional(reportDocumentInformation.producerProperty());
            creatorNameTextField.textProperty().bindBidirectional(reportDocumentInformation.creatorProperty());
            subjectTextField.textProperty().bindBidirectional(reportDocumentInformation.subjectProperty());
            titleTextField.textProperty().bindBidirectional(reportDocumentInformation.titleProperty());
            dateCreatedValue.textProperty().bindBidirectional(reportDocumentInformation.creationDateProperty());
            dateModifiedValue.textProperty().bindBidirectional(reportDocumentInformation.modificationDateProperty());

        }
    }



    @Override
    public ReportApp app() {
        return ReportApp.currentApp();
    }


}
