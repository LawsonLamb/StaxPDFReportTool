package StaxPDFReportTool.app.model;

import StaxPDFReportTool.app.model.pdf.ReportField;
import StaxPDFReportTool.app.model.pdf.ReportFieldList;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.rendering.PDFRenderer;


import java.io.File;
import java.io.IOException;

public class ViewTabModel {


//region Variables
    private ObjectProperty<PDDocument> pdDocumentObjectProperty;
    private PDFRenderer renderer;
    private PDAcroForm acroForm;
    private PDPageTree pageTree;
    private ReportFieldList fieldList;
    //endregion
    //region Constructors
    public ViewTabModel(){
    pdDocumentObjectProperty = new SimpleObjectProperty<>(null);
        setupListeners();
    }
    public ViewTabModel(PDDocument Document){
       setDocument(Document);
        init();
    }
    public ViewTabModel(File fileName) throws IOException {
       setDocument(PDDocument.load(fileName));
         init();

    }
    public ViewTabModel(String FileName) throws IOException {

        setDocument(PDDocument.load(new File(FileName)));
        init();
    }
//endregion

    //region Methods

   private void init(){
        if(renderer!=null){
            renderer = null;
            fieldList = null;
        }
        renderer = new PDFRenderer(getDocument());
        fieldList = new ReportFieldList(getDocument().getDocumentCatalog().getAcroForm());

    }


    private void setupListeners(){
        pdDocumentObjectProperty.addListener(new ChangeListener<PDDocument>() {
            @Override
            public void changed(ObservableValue<? extends PDDocument> observable, PDDocument oldValue, PDDocument newValue) {
                setDocument(newValue);
                 init();
            }
        });
    }
    public void savePDF(String FilePath) throws IOException {
        saveFields();
        pdDocumentObjectProperty.get().save(FilePath);
    }
    public void savePDF(File file) throws IOException {
        saveFields();
        pdDocumentObjectProperty.get().save(file);
    }

    private void saveFields(){
        PDAcroForm pdAcroForm =    pdDocumentObjectProperty.getValue().getDocumentCatalog().getAcroForm();
        for(int i=0;i<fieldList.GetObservableList().size();i++){

            PDField pdField = pdAcroForm.getFields().get(i);
            ReportField reportField = fieldList.get(i);
            pdField.setMappingName(reportField.getMappingName());
            pdField.setPartialName(reportField.getPartialName());
            pdField.setAlternateFieldName(reportField.getAltName());
            pdField.setReadOnly(reportField.getReadOnly());
            pdField.setNoExport(reportField.getIsNoExport());
            pdField.setRequired(reportField.getIsRequired());

        }
    }
    //endregion





    //region Accessors
    public ReportFieldList getFieldList(){
        return fieldList;
    }
    public void setFieldList(ReportFieldList field) {
        fieldList = field;
    }






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
//endregion

}
