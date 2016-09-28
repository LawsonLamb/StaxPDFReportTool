package hermesviewer.app;

import hermes.report.pdmodel.ReportDocument;
import hermesviewer.app.model.ViewTabModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportModel extends ReportAppComponent {


    //-- logging --//
    private static final Logger logger = LoggerFactory.getLogger(ReportModel.class);

    //-- properties --//

    private ViewTabModel reportViewerModel;
    private ReportDocument PDDocumentFX;

    //-- constructors --//
    public ReportModel() {
        PDDocumentFX = new ReportDocument();
        reportViewerModel = new ViewTabModel();


    }

    public ViewTabModel reportViewerModel( ){

        return reportViewerModel;
    }

    public ReportDocument reportDocument(){
        return PDDocumentFX;
    }









}
