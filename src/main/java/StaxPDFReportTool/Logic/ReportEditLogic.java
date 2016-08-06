package StaxPDFReportTool.Logic;

import StaxPDFReportTool.app.ReportAppComponent;
import javafx.collections.ObservableArray;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ReportEditLogic extends ReportAppComponent {
    //-- logging --//
    private static final Logger logger = LoggerFactory.getLogger(ReportEditLogic.class);

    private PDDocument document;
    //-- properties --//
    private PDField currentField;
    //-- constructors --//

    public PDField getCurrentField(){
        return currentField;
    }

    public void setCurrentField(PDField field){
        currentField = field;
    }

    public PDDocument getDocument(){
        return document;
    }
    public void setDocument(PDDocument Document){
        document = Document;
    }









}
