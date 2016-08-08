package StaxPDFReportTool.app;

import StaxPDFReportTool.app.Model.ReportEditModel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ReportModel extends ReportAppComponent {


    //-- logging --//
    private static final Logger logger = LoggerFactory.getLogger(ReportModel.class);

    //-- properties --//
    PDDocument document;
    ReportEditModel reportEditModel;
    //-- constructors --//
    public ReportModel() {
        try {

            document = PDDocument.load(new File("/Users/ItBNinja/StaxPDFReportTool/src/main/java/StaxPDFReportTool/app/LGS_Business_Personal_Property_Tax_Return_PT50P.pdf"));
            reportEditModel = new ReportEditModel(document);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ReportEditModel getReportEditModel(){

        return reportEditModel;
    }

    public void setReportEditModel(ReportEditModel editModel){

        reportEditModel = editModel;
    }




    public PDAcroForm getAcroForm(){
        return document.getDocumentCatalog().getAcroForm();
    }

    public List<PDField> getPDFieldList(){
        return getAcroForm().getFields();
    }

}
