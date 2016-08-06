package StaxPDFReportTool.View.Canvas;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

public class ReportRenderer extends PDFRenderer {

    public ReportRenderer(PDDocument document) {
        super(document);
    }

}
