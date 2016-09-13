package StaxPDFReportTool.app;

import javafx.scene.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ReportAppComponent  {

    //-- logging --//
    private static final Logger logger = LoggerFactory.getLogger(ReportAppComponent.class);

    //-- properties --//
    private final ReportApp app;

    //-- constructors --//
    public ReportAppComponent(ReportApp app) {
        this.app = app;
    }

    public ReportAppComponent() {
        this(ReportApp.currentApp());
    }

    //-- convenience methods --//
    public void showInfo(String message) {
        if (app().logic() != null)
            app().logic().errorLogic().showInfo(message);
        else
            logger.info(message);
    }

    public void showWarning(String message, Throwable exception) {
        if (app().logic() != null)
            app().logic().errorLogic().showWarning(message, exception);
        else
            logger.info(message, exception);
    }

    public void showError(String message, Throwable exception) {
        if (app().logic() != null)
            app().logic().errorLogic().showError(message, exception);
        else
            logger.error(message, exception);
    }

    //-- accessors --//
    public ReportApp app() {
        return app;
    }

}
