package StaxPDFReportTool.app.view.controller;

import StaxPDFReportTool.app.ReportAppComponent;
import StaxPDFReportTool.app.view.renderer.acroforms.javaFX.ReportTextFieldFX;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReportDrawController extends ReportAppComponent implements Initializable {
    @FXML
    private AnchorPane pdfpane;
    @FXML
    private Pagination pdfPagination;
    private PDDocument document;
    private PDFRenderer renderer;
    ReportTextFieldFX textField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {

            document = PDDocument.load(new File("/Users/ItBNinja/StaxPDFReportTool/src/main/java/StaxPDFReportTool/app/LGS_Business_Personal_Property_Tax_Return_PT50P.pdf"));
            renderer = new PDFRenderer(document);
            textField = new ReportTextFieldFX(document.getDocumentCatalog().getAcroForm().getFields().get(0));
             pdfpane.getChildren().add(textField);



            this.pdfPagination.setPageCount(document.getNumberOfPages());
            this.pdfPagination.setPageFactory(pageint->createPage(pageint));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    // methods
    private Image getImage(int pageNumber) {
        BufferedImage pageImage;
        try {
            pageImage = renderer.renderImage(pageNumber,1.0f);
        } catch (IOException ex) {
            throw new UncheckedIOException("PDFRenderer throws IOException", ex);
        }
        return SwingFXUtils.toFXImage(pageImage, null);
    }

    private ImageView createPage(int index){
        return new ImageView(getImage(index));
    }


}
