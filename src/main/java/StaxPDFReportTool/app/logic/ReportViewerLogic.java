package StaxPDFReportTool.app.logic;

import StaxPDFReportTool.app.ReportAppComponent;
import StaxPDFReportTool.app.model.ReportField;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;

public class ReportViewerLogic extends ReportAppComponent{

    //-- logging --//
    private static final Logger logger = LoggerFactory.getLogger(ReportViewerLogic.class);

    //-- properties --//
    private ReportField currentField;

    //-- constructors --//
    public ReportField getCurrentField(){
        return currentField;
    }



    public void setCurrentField(ReportField field){
        currentField = field;
    }


    public void exitApplication()
    {
        try
        {
            PDDocument pdfDocument = app().model().reportViewerModel().getDocument();
            if (pdfDocument!= null)
            {
                pdfDocument.close();
            }
        }
        catch (IOException io)
        {

        }

    }

    public Image getImage(int pageNumber) {
        PDFRenderer pdfRenderer = app().model().reportViewerModel().getRenderer();
        BufferedImage pageImage;
        try {
            pageImage = pdfRenderer.renderImage(pageNumber,1.0f);
        } catch (IOException ex) {
            throw new UncheckedIOException("PDFRenderer throws IOException", ex);
        }
        return SwingFXUtils.toFXImage(pageImage, null);
    }
    public ImageView createPage(int index){
        ImageView view = new ImageView(getImage(index));
        return view;
    }

    public File savePDF(String filePath){
        File file = new File(filePath);

        return file;
    }







}
