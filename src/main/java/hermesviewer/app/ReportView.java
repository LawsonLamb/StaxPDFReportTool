package hermesviewer.app;

import hermesviewer.app.view.controller.*;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportView extends ReportAppComponent{
        //-- logging --//
        private static final Logger logger = LoggerFactory.getLogger(ReportView.class);
        //-- properties --//
        private Stage stage;

        private ReportViewComponent<MainWindowController> masterControllerViewComponent;
        private ReportViewComponent<ReportDocumentInformationViewController> pdfPropertyPaneControllerReportViewComponent;
        private ReportViewComponent<EditTabController> pdfFormPropertyPaneControllerReportViewComponent;

        //-- constructors --//
        public ReportView(){
            try {
                logger.info("Loading and intializing FXML view components.");

                masterControllerViewComponent = new ReportViewComponent<>("ReportToolMainWindow");
             //   pdfViewerReportViewComponent = new ReportViewComponent<>("ViewTab");
               // pdfFormPropertyPaneControllerReportViewComponent = new ReportViewComponent<>("EditTab");
              //  pdfPropertyPaneControllerReportViewComponent = new ReportViewComponent<>("PDFPropertysStackPane");
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
            openMainWindow();
            stage.show();
        }


    
    public void openMainWindow(){ stage.setScene(masterControllerViewComponent.scene());
        }
  
    public ViewTabController viewTabController(){
           return masterControllerViewComponent.controller().viewTabViewController;
       }
    public EditTabController editTabController(){return  masterControllerViewComponent.controller().editTabViewController;}
    public ReportViewComponent<ReportDocumentInformationViewController> pdfPropertyPaneViewComponent(){return pdfPropertyPaneControllerReportViewComponent;}

}
