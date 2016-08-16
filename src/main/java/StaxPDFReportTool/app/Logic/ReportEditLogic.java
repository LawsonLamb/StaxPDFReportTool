package StaxPDFReportTool.app.logic;

import StaxPDFReportTool.app.model.ReportField;
import StaxPDFReportTool.app.ReportAppComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportEditLogic extends ReportAppComponent {
    //-- logging --//
    private static final Logger logger = LoggerFactory.getLogger(ReportEditLogic.class);

    //-- properties --//
    private ReportField currentField;
    //-- constructors --//

    public ReportField getCurrentField(){
        return currentField;
    }

    public void setCurrentField(ReportField field){
        currentField = field;
    }









}
