package StaxPDFReportTool.app;

import StaxPDFReportTool.app.view.controller.PDFViewer;
import StaxPDFReportTool.app.view.controller.PdfFormPropertyPaneController;
import StaxPDFReportTool.app.view.controller.ReportViewComponent;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ReportView extends ReportAppComponent{
    //-- logging --//
    private static final Logger logger = LoggerFactory.getLogger(ReportView.class);

    //-- properties --//
    private Stage stage;


    private ReportViewComponent<PDFViewer> pdfViewerReportViewComponent;
    private ReportViewComponent<PdfFormPropertyPaneController> pdfFormPropertyPaneControllerReportViewComponent;

    //-- constructors --//
    public ReportView(){
        try {
            logger.info("Loading and intializing FXML view components.");


            pdfViewerReportViewComponent = new ReportViewComponent<>("PDFViewer");
           pdfFormPropertyPaneControllerReportViewComponent = new ReportViewComponent<>("Form_Field_StackPane");

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
        openPdfViewer();
        stage.show();
    }


    public void openPdfViewer(){
        stage.setScene(pdfViewerReportViewComponent.scene());
    }
    public void openPdfFormPropertyPane()  {
        stage.setScene(pdfFormPropertyPaneControllerReportViewComponent.scene());
        pdfFormPropertyPaneControllerReportViewComponent.controller().Open();
    }

   public ReportViewComponent<PDFViewer> pdfViewerReportViewComponent(){
       return pdfViewerReportViewComponent;
   }

}
