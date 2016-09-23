package StaxPDFReportTool.app.model.pdf;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReportDocument implements IDocument {

    //region Property Variables
    private ObjectProperty<PDDocument> pdDocument;
    private ObjectProperty<PDFRenderer> pdfRenderer;
    private ObjectProperty<PDDocumentCatalog> pdDocumentCatalog;
    private ObjectProperty<PDAcroForm> pdAcroForm;
    private ObjectProperty<PDPageTree> pdPageTree;
    private ListProperty<PDField> fieldListProperty;

    public ObservableList<ReportField> getReportFieldObservableList() {
        return reportFieldObservableList;
    }

    private ObservableList<ReportField> reportFieldObservableList;
    private String currentFilename = null;
    //endregion

    //region Constructors
    public ReportDocument(){
        pdDocument = new SimpleObjectProperty<>();
        pdfRenderer = new SimpleObjectProperty<>();
        pdDocumentCatalog = new SimpleObjectProperty<>();
        pdAcroForm  = new SimpleObjectProperty<>();
        pdPageTree =  new SimpleObjectProperty<>();
        fieldListProperty = new SimpleListProperty<>();


        pdDocument.addListener((observable, oldValue, newValue) -> {
           pdDocument.set(newValue);
            pdPageTree.set(newValue.getPages());
            pdfRenderer.set(new PDFRenderer(newValue));
            pdDocumentCatalog.set(newValue.getDocumentCatalog());
        });

        pdDocumentCatalog.addListener((observable, oldValue, newValue)->{
            pdAcroForm.set(newValue.getAcroForm());
        });

        pdAcroForm.addListener((observable, oldValue, newValue) -> {
            fieldListProperty.set(FXCollections.observableArrayList(newValue.getFields()));
        });

        fieldListProperty.addListener(((observable, oldValue, newValue) -> {

                    ArrayList<ReportField> reportFieldArrayList = new ArrayList<>();

                    for (int i = 0; i < newValue.size(); i++) {
                        reportFieldArrayList.add(new ReportField(newValue.get(i)));

                    }
                   reportFieldObservableList = FXCollections.observableList(reportFieldArrayList);


        }));

    }

    //endregion

    //region Methods
    @Override
    public void Load(File file) throws IOException {
        currentFilename = file.getAbsolutePath();
        setPdDocument(PDDocument.load(file));
    }

    @Override
    public void Save(File file) throws IOException {
        getPdDocument().save(file);
    }

    @Override
    public void Close() throws IOException {
        //// TODO: 8/30/2016  prompt save before close
        if(pdDocument.get()!=null) {
            pdDocument.get().close();
        }
    }

    public Image getImage(int pageNumber) throws IOException {
          BufferedImage pageImage = getPdfRenderer().renderImage(pageNumber,1.0f);
        return SwingFXUtils.toFXImage(pageImage, null);
    }
    public ImageView createPage(int index) throws IOException {
       return  new ImageView(getImage(index));

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

    public ObservableList<PDField> getFieldList() {
        return fieldListProperty.get();
    }

    public ListProperty<PDField> fieldListProperty() {
        return fieldListProperty;
    }

    public void setFieldList(ObservableList<PDField> fieldListProperty) {
        this.fieldListProperty.set(fieldListProperty);
    }


    public String getCurrentFilename() {
        return currentFilename;
    }

    public void setCurrentFilename(String currentFilename) {
        this.currentFilename = currentFilename;
    }


    //endregion
}


