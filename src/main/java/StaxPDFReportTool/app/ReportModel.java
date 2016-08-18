package StaxPDFReportTool.app;

import StaxPDFReportTool.app.model.ReportViewerModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportModel extends ReportAppComponent {


    //-- logging --//
    private static final Logger logger = LoggerFactory.getLogger(ReportModel.class);

    //-- properties --//

   private ReportViewerModel reportViewerModel;

    //-- constructors --//
    public ReportModel() {
            reportViewerModel = new ReportViewerModel();

    }

    public ReportViewerModel reportViewerModel( ){

        return reportViewerModel;
    }









}
