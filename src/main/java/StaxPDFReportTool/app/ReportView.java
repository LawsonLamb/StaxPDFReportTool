package StaxPDFReportTool.app;

import StaxPDFReportTool.app.view.controller.*;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportView extends ReportAppComponent{
        //-- logging --//
        private static final Logger logger = LoggerFactory.getLogger(ReportView.class);
        //-- properties --//
        private Stage stage;
        private ReportViewComponent<ViewTabController> pdfViewerReportViewComponent;
        private ReportViewComponent<MainWindowController> mainWindowControllerReportViewComponent;
        private ReportViewComponent<PdfPropertyPaneController> pdfPropertyPaneControllerReportViewComponent;
        private ReportViewComponent<EditTabController> pdfFormPropertyPaneControllerReportViewComponent;

        //-- constructors --//
        public ReportView(){
            try {
                logger.info("Loading and intializing FXML view components.");
                mainWindowControllerReportViewComponent = new ReportViewComponent<>("ReportToolMainWindow");
                pdfViewerReportViewComponent = new ReportViewComponent<>("ViewTab");
                pdfFormPropertyPaneControllerReportViewComponent = new ReportViewComponent<>("EditTab");
                pdfPropertyPaneControllerReportViewComponent = new ReportViewComponent<>("PDFPropertysStackPane");
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


    public void openPdfViewer(){
            stage.setScene(pdfViewerReportViewComponent.scene());
        }
    public void openMainWindow(){ stage.setScene(mainWindowControllerReportViewComponent.scene());
        }
    public void openPdfFormPropertyPane()  {
            stage.setScene(pdfFormPropertyPaneControllerReportViewComponent.scene());
            pdfFormPropertyPaneControllerReportViewComponent.controller().Open();
        }
    public void openPdfPropertyPane(){
            stage.setScene(pdfPropertyPaneControllerReportViewComponent.scene());
        }
    public ReportViewComponent<ViewTabController> pdfViewerReportViewComponent(){
           return pdfViewerReportViewComponent;
       }
    public ReportViewComponent<EditTabController> pdfFormPropertyPaneControllerReportViewComponent(){return pdfFormPropertyPaneControllerReportViewComponent;}
    public ReportViewComponent<PdfPropertyPaneController> pdfPropertyPaneViewComponent(){return pdfPropertyPaneControllerReportViewComponent;}

}
