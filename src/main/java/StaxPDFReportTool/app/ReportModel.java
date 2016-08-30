package StaxPDFReportTool.app;

import StaxPDFReportTool.app.model.pdf.ReportDocument;
import StaxPDFReportTool.app.model.ViewTabModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportModel extends ReportAppComponent {


    //-- logging --//
    private static final Logger logger = LoggerFactory.getLogger(ReportModel.class);

    //-- properties --//

    private ViewTabModel reportViewerModel;
    private ReportDocument reportDocument;

    //-- constructors --//
    public ReportModel() {
            reportViewerModel = new ViewTabModel();
        reportDocument = new ReportDocument();

    }

    public ViewTabModel reportViewerModel( ){

        return reportViewerModel;
    }

    public ReportDocument reportDocument(){
        return reportDocument;
    }









}
