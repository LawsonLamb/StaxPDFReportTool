package StaxPDFReportTool.app.model.pdf;

import StaxPDFReportTool.app.IDocument;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;
import org.apache.pdfbox.rendering.PDFRenderer;
import javafx.scene.image.Image;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.*;
import java.util.List;

public class ReportDocument implements IDocument {
    //region Property Variables
    private ObjectProperty<PDDocument> pdDocument;
    private ObjectProperty<PDFRenderer> pdfRenderer;
    private ObjectProperty<PDDocumentCatalog> pdDocumentCatalog;
    private ObjectProperty<PDAcroForm> pdAcroForm;
    private ObjectProperty<PDPageTree> pdPageTree;
    private ListProperty<PDField> fieldListProperty;
    private IntegerProperty numberOfPages;
    //endregion

    //region variables
    private ReportField currentField;
    private String currentFilename = null;
    //endregion


    //region Constructors
    public ReportDocument(){
    }

    //endregion

    //region Methods
    @Override
    public void Load(File file) throws IOException {

        setPdDocument(PDDocument.load(file));
    }

    @Override
    public void Save(File file) throws IOException {
        getPdDocument().save(file);
    }

    public Image getImage(int pageNumber) throws IOException {
        PDFRenderer Renderer =   pdfRenderer.get();
        BufferedImage pageImage;
        pageImage = Renderer.renderImage(pageNumber,1.0f);
        return SwingFXUtils.toFXImage(pageImage, null);
    }
    public ImageView createPage(int index) throws IOException {
        ImageView view = new ImageView(getImage(index));
        return view;
    }

    public void setFormFieldIDValues(List<PDField> fieldList) throws IOException {
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



    //endregion

    //region Property Accessors
    public PDDocument getPdDocument() {
        return pdDocument.get();
    }

    public ObjectProperty<PDDocument> pdDocumentProperty() {
        return pdDocument;
    }

    public void setPdDocument(PDDocument pdDocument) {
        this.pdDocument.set(pdDocument);
    }

    public PDFRenderer getPdfRenderer() {
        return pdfRenderer.get();
    }

    public ObjectProperty<PDFRenderer> pdfRendererProperty() {
        return pdfRenderer;
    }

    public void setPdfRenderer(PDFRenderer pdfRenderer) {
        this.pdfRenderer.set(pdfRenderer);
    }

    public PDDocumentCatalog getPdDocumentCatalog() {
        return pdDocumentCatalog.get();
    }

    public ObjectProperty<PDDocumentCatalog> pdDocumentCatalogProperty() {
        return pdDocumentCatalog;
    }

    public void setPdDocumentCatalog(PDDocumentCatalog pdDocumentCatalog) {
        this.pdDocumentCatalog.set(pdDocumentCatalog);
    }

    public PDAcroForm getPdAcroForm() {
        return pdAcroForm.get();
    }

    public ObjectProperty<PDAcroForm> pdAcroFormProperty() {
        return pdAcroForm;
    }

    public void setPdAcroForm(PDAcroForm pdAcroForm) {
        this.pdAcroForm.set(pdAcroForm);
    }

    public PDPageTree getPdPageTree() {
        return pdPageTree.get();
    }

    public ObjectProperty<PDPageTree> pdPageTreeProperty() {
        return pdPageTree;
    }

    public void setPdPageTree(PDPageTree pdPageTree) {
        this.pdPageTree.set(pdPageTree);
    }



    //endregion
}

