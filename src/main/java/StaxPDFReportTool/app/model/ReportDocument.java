package StaxPDFReportTool.app.model;

import javafx.beans.InvalidationListener;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.rendering.PDFRenderer;

public class ReportDocument {


    private ObjectProperty<PDDocument> pdDocument;
    private ObjectProperty<PDFRenderer> pdfRenderer;
    private ObjectProperty<PDDocumentCatalog> pdDocumentCatalog;
    private ObjectProperty<PDAcroForm> pdAcroForm;
    private ObjectProperty<PDPageTree> pdPageTree;
    private ListProperty<PDField> fieldListProperty;

    public ReportDocument(){
    }

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

}


