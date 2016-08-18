package StaxPDFReportTool.app.logic;

import StaxPDFReportTool.app.ReportAppComponent;
import StaxPDFReportTool.app.ReportLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportErrorLogic extends ReportAppComponent{

    //-- logging --//
    private static final Logger logger = LoggerFactory.getLogger(ReportErrorLogic.class);

    public void showInfo(String message) {
        showInfo(message, null);
    }

    public void showInfo(String message, Throwable exception) {
        // TODO implement UI error dialog
        logger.info(message, exception);
    }

    public void showWarning(String message) {
        showWarning(message, null);
    }

    public void showWarning(String message, Throwable exception) {
        // TODO implement UI error dialog
        logger.warn(message, exception);
    }

    public void showError(String message) {
        showError(message, null);
    }

    public void showError(String message, Throwable exception) {
        // TODO implement UI error dialog
        logger.error(message, exception);
    }
}
