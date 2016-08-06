package StaxPDFReportTool.app;
import javafx.application.Application;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ReportApp extends Application{
    //-- logging --//
    private static final Logger logger = LoggerFactory.getLogger(ReportApp.class);

    //-- singleton --//
    private static ReportApp currentApp;

    //-- properties --//
    private final ReportModel model;
    private final ReportView view;
    private final ReportLogic logic;

    public static ReportApp currentApp() {
        return currentApp;
    }


    public ReportApp(){
        logger.info("Creating Report App.");
        currentApp = this;
        model = new ReportModel();
        view = new ReportView();
        logic = new ReportLogic();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        view.start(primaryStage);
    }


    //-- accessors --//
    public ReportModel model() {
        return model;
    }

    public ReportView view() {
        return view;
    }

    public ReportLogic logic() {
        return logic;
    }

}



