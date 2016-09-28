package hermesviewer.app;

import hermesviewer.app.logic.MasterViewLogic;
import hermesviewer.app.logic.ReportErrorLogic;
import hermesviewer.app.logic.ViewTabLogic;
import javafx.application.Platform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportLogic extends ReportAppComponent {
    //-- logging --//
    private static final Logger logger = LoggerFactory.getLogger(ReportLogic.class);
    //-- properties --//
    private final ReportErrorLogic errorLogic;
    private final ViewTabLogic reportViewerLogic;
    private final MasterViewLogic masterViewLogic;

    //-- constructors --//
    public ReportLogic() {
        this.errorLogic = new ReportErrorLogic();
        this.reportViewerLogic = new ViewTabLogic();
        this.masterViewLogic = new MasterViewLogic();
    }

    //region  ReportLogic methods


    public void exitApp(){
        logger.info("exiting the app" );
        Platform.exit();

    }
//endregion


    //region //-- accessors --//
    public ReportErrorLogic errorLogic() {
        return errorLogic;
    }


    public ViewTabLogic reportViewerLogic(){
        return  reportViewerLogic;
    }
    public MasterViewLogic masterViewLogic(){return masterViewLogic;}
//endregion


}
