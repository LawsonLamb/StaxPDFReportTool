package StaxPDFReportTool.app.logic;

import StaxPDFReportTool.app.ReportAppComponent;
import StaxPDFReportTool.app.model.ReportField;
import StaxPDFReportTool.app.model.ReportViewerModel;
import StaxPDFReportTool.app.view.controller.PDFViewer;
import StaxPDFReportTool.app.view.controller.ReportViewComponent;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;

public class ReportViewerLogic extends ReportAppComponent{

    //-- logging --//
    private static final Logger logger = LoggerFactory.getLogger(ReportViewerLogic.class);

    //-- properties --//
    private ReportField currentField;
    private String currentFilename = null;
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
    public void setFormFieldIDValues() throws IOException {
        List<PDField> fieldList = getModel().getDocument().getDocumentCatalog().getAcroForm().getFields();
        for (int i = 0; i < fieldList.size(); i++) {
            PDField pdField = fieldList.get(i);
            if (pdField.getClass() == PDTextField.class) {
                PDTextField textField = (PDTextField) pdField;
                textField.setValue(textField.getPartialName());
            }
        }
    }

    public void setFormFieldMappingValues(List<PDField> fieldList) throws IOException {


        for (int i = 0; i < fieldList.size(); i++) {
            PDField pdField = fieldList.get(i);
            if (pdField.getClass() == PDTextField.class) {
                pdField.setValue(pdField.getMappingName());
            }
        }
    }


    public ReportViewerModel getModel(){
     return   app().model().reportViewerModel();
    }
    public ReportViewComponent<PDFViewer> getView(){
        return app().view().pdfViewerReportViewComponent();
    }



}
