package StaxPDFReportTool.app;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ReportModel extends ReportAppComponent {


    //-- logging --//
    private static final Logger logger = LoggerFactory.getLogger(ReportModel.class);

    //-- properties --//
    PDDocument document;

    //-- constructors --//
    public ReportModel(){

    }




    public PDAcroForm getAcroForm(){
        return document.getDocumentCatalog().getAcroForm();
    }

    public List<PDField> getPDFieldList(){
        return getAcroForm().getFields();
    }

}
