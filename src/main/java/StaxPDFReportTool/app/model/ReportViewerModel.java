package StaxPDFReportTool.app.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.rendering.PDFRenderer;


import java.io.File;
import java.io.IOException;

public class ReportViewerModel {



    private ObjectProperty<PDDocument> pdDocumentObjectProperty;
    private PDFRenderer renderer;
    private PDAcroForm acroForm;
    private PDPageTree pageTree;
    private ReportFieldList fieldList;

    public ReportViewerModel(){
    pdDocumentObjectProperty = new SimpleObjectProperty<>(null);
        setupLisenters();
    }
    public ReportViewerModel( PDDocument Document){
       setDocument(Document);
        init();
    }

    public ReportViewerModel(File fileName) throws IOException {
       setDocument(PDDocument.load(fileName));
         init();

    }
    public ReportViewerModel(String FileName) throws IOException {

        setDocument(PDDocument.load(new File(FileName)));
        init();
    }

    void init(){
        if(renderer!=null){
            renderer = null;
            fieldList = null;
        }
        renderer = new PDFRenderer(getDocument());
        fieldList = new ReportFieldList(getDocument().getDocumentCatalog().getAcroForm());

    }

    void setupLisenters(){
        pdDocumentObjectProperty.addListener(new ChangeListener<PDDocument>() {
            @Override
            public void changed(ObservableValue<? extends PDDocument> observable, PDDocument oldValue, PDDocument newValue) {
                setDocument(newValue);
                 init();
            }
        });
    }

    public ReportFieldList getFieldList(){
        return fieldList;
    }
    public void setFieldList(ReportFieldList field) {
        fieldList = field;
    }


    // Accessors
    public PDDocument getDocument(){
        return pdDocumentObjectProperty.getValue();
    }
    public void setDocument(PDDocument Document){
        pdDocumentObjectProperty.setValue(Document);
      setRenderer( new PDFRenderer(Document));
    }
    public PDPageTree getPageTree() {
        return pageTree;
    }

    public void setPageTree(PDPageTree pageTree) {
        this.pageTree = pageTree;
    }

    public PDAcroForm getAcroForm() {
        return acroForm;
    }

    public void setAcroForm(PDAcroForm acroForm) {
        this.acroForm = acroForm;
    }

    public PDFRenderer getRenderer(){
        return renderer;
    }
    public void setRenderer(PDFRenderer Renderer){
        this.renderer = Renderer;
    }

    // Property Accessors
    public ObjectProperty<PDDocument>   PDDocumentObjectProperty(){
        return pdDocumentObjectProperty;
    }


}
