package hermesviewer.app.view.renderer.javafx;

import javafx.beans.property.ObjectProperty;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UncheckedIOException;

public class ReportPagination  {

    ObjectProperty<Pagination> paginationObjectProperty;

    PDDocument pdDocument;
    PDFRenderer renderer;


    public ReportPagination(PDDocument document){
        pdDocument = document;
        this.renderer = new PDFRenderer(pdDocument);

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
    private ReportPage createPage(int index){
        return new ReportPage(getImage(index));
    }


    //property
    public void setPagination(Pagination pagination){
        this.paginationObjectProperty.setValue(pagination);
    }
    public Pagination getPagination(){
        return this.paginationObjectProperty.getValue();
    }
    public void setPaginationObjectProperty(ObjectProperty<Pagination> Property){
        this.paginationObjectProperty = Property;
    }
    public ObjectProperty<Pagination> getPaginationObjectProperty(){
        return paginationObjectProperty;
    }





}
