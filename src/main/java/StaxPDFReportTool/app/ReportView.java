package StaxPDFReportTool.app;

import StaxPDFReportTool.View.ReportEditController;
import StaxPDFReportTool.View.ReportViewComponent;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportView extends ReportAppComponent{
    //-- logging --//
    private static final Logger logger = LoggerFactory.getLogger(ReportView.class);

    //-- properties --//
    private Stage stage;
    private ReportViewComponent<ReportEditController> reportEditView;

    //-- constructors --//
    public ReportView(){
        try {
            logger.info("Loading and intializing FXML view components.");
            reportEditView = new ReportViewComponent<>(ReportAppConstants.REPORT_EDIT_FXML);

            logger.info("Done loading and initializing FXML view components.");
        }
        catch (Throwable oopsie){

            showError("Error loading ReportView", oopsie);
        }
    }

    //-- StaxView methods --//
    public void start(Stage stage) {
        this.stage = stage;
        stage.setTitle(ReportAppConstants.MAIN_WINDOW_TITLE);
        stage.setMaximized(true);
         openFieldReportEdit();
        stage.show();
    }

    public void openFieldReportEdit(){
        stage.setScene(reportEditView.scene());

    }

}
