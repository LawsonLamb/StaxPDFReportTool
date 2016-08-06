package StaxPDFReportTool.app;

import StaxPDFReportTool.Logic.ReportEditLogic;
import StaxPDFReportTool.Logic.ReportErrorLogic;
import javafx.application.Platform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportLogic extends ReportAppComponent {
    //-- logging --//
    private static final Logger logger = LoggerFactory.getLogger(ReportLogic.class);

    //-- properties --//
    private final ReportErrorLogic errorLogic;
    private final ReportEditLogic editLogic;


    //-- constructors --//
    public ReportLogic() {
        this.errorLogic = new ReportErrorLogic();
        this.editLogic = new ReportEditLogic();

    }

    //-- ReportLogic methods --//
    public void openMainMenu() {
       // app().view().openMainMenu();
    }

    // close the app
    public void exitApp(){
        logger.info("exiting the app" );

        Platform.exit();

    }
    //-- StaxAppComponent homework --//

    //-- accessors --//
    public ReportErrorLogic errorLogic() {
        return errorLogic;
    }

    public ReportEditLogic editLogic(){
        return editLogic;
    }


}
