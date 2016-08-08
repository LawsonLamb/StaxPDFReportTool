package StaxPDFReportTool.app.Logic;

import StaxPDFReportTool.app.ReportAppComponent;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportEditLogic extends ReportAppComponent {
    //-- logging --//
    private static final Logger logger = LoggerFactory.getLogger(ReportEditLogic.class);


    //-- properties --//
    private PDField currentField;
    //-- constructors --//

    public PDField getCurrentField(){
        return currentField;
    }

    public void setCurrentField(PDField field){
        currentField = field;
    }









}
