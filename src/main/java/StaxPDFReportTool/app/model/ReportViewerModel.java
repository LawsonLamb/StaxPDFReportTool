package StaxPDFReportTool.app.model;

import javafx.beans.property.ObjectProperty;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.io.File;
import java.io.IOException;

public class ReportViewerModel {


    private PDDocument document;

    private PDFRenderer renderer;

    private ReportFieldList fieldList;

    public ReportViewerModel( PDDocument Document){
        this.document = Document;
        renderer = new PDFRenderer(this.document);
        fieldList = new ReportFieldList(document.getDocumentCatalog().getAcroForm());

    }

    public ReportViewerModel(File fileName) throws IOException {
        this.document = PDDocument.load(fileName);
        renderer = new PDFRenderer(this.document);
        fieldList = new ReportFieldList(document.getDocumentCatalog().getAcroForm());

    }
    public ReportViewerModel(String FileName) throws IOException {
        this.document = PDDocument.load(new File(FileName));
        renderer = new PDFRenderer(this.document);
        fieldList = new ReportFieldList(document.getDocumentCatalog().getAcroForm());
    }

    public ReportFieldList getFieldList(){
        return fieldList;
    }
    public void setFieldList(ReportFieldList field) {
        fieldList = field;
    }

    public PDDocument getDocument(){
        return document;
    }
    public void setDocument(PDDocument Document){
        document = Document;
    }
    public PDFRenderer getRenderer(){
        return renderer;
    }
    public void setRenderer(PDFRenderer Renderer){
        this.renderer = Renderer;
    }
}
