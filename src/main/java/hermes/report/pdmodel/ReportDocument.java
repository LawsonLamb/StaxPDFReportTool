package hermes.report.pdmodel;

import hermes.report.pdmodel.interactive.ReportAcroForm;
import hermes.report.rendering.ReportRenderer;
import hermesviewer.app.interfaces.IDocument;
import hermes.report.ReportField;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
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

public class ReportDocument extends SimpleObjectProperty<PDDocument> implements IDocument {

    //region Property Variables
    private final ReportDocumentCatalog reportDocumentCatalog = new ReportDocumentCatalog();
    private final ReportRenderer reportRenderer = new ReportRenderer();
    private final ReportDocumentInformation reportDocumentInformation = new ReportDocumentInformation();

    private String currentFilename = null;
    //endregion

    //region Constructors
    public ReportDocument(){
        this.addListener((observable, oldValue, newValue) -> onChanged(newValue));
    }

    //endregion

    //region Methods
    private void onChanged(PDDocument document){
        this.set(document);
        setPdfRenderer(new PDFRenderer(document));
        setPdDocumentCatalog(document.getDocumentCatalog());
        reportDocumentInformation.set(document.getDocumentInformation());

    }
    @Override
    public void load(File file) throws IOException {
        currentFilename = file.getAbsolutePath();
       this.set(PDDocument.load(file));
    }

    @Override
    public void save(File file) throws IOException {
        reportDocumentCatalog.save();
        this.get().save(file);
    }

    @Override
    public void close() throws IOException {
        //// TODO: 8/30/2016  prompt save before close
        if(this.get()!=null) {
            this.get().close();
        }
    }

    private Image getImage(int pageNumber) throws IOException {
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
    public PDDocumentInformation getReportDocumentInformation() {
        return reportDocumentInformation.get();
    }




    public PDFRenderer getPdfRenderer() {
        return reportRenderer.get();
    }
    public void setPdfRenderer(PDFRenderer pdfRenderer) {
        this.reportRenderer.set(pdfRenderer);
    }

    public PDDocumentCatalog getPdDocumentCatalog() {
        return reportDocumentCatalog.get();
    }
    public void setPdDocumentCatalog(PDDocumentCatalog pdDocumentCatalog) {this.reportDocumentCatalog.set(pdDocumentCatalog);}

    public PDAcroForm getPdAcroForm() {
        return reportDocumentCatalog.getAcroForm();
    }
    public void setPdAcroForm(PDAcroForm pdAcroForm) {
        this.reportDocumentCatalog.setAcroForm(pdAcroForm);
    }

    public PDPageTree getPdPageTree() {
        return reportDocumentCatalog.getReportPageTree();
    }

    public ObjectProperty<PDPageTree> pdPageTreeProperty() {
        return reportDocumentCatalog.reportPageTreeProperty();
    }
    public void setPdPageTree(PDPageTree pdPageTree) {
        this.reportDocumentCatalog.setReportPageTree((pdPageTree));
    }


    public ObservableList<ReportField> getReportFieldObservableList() {return reportDocumentCatalog.acroFormProperty().getReportFields();}

    public String getCurrentFilename() {
        return currentFilename;
    }


    public ReportRenderer pdfRendererProperty() {return reportRenderer;}
    public ReportDocumentCatalog pdDocumentCatalogProperty() {return reportDocumentCatalog;}
    public ReportAcroForm pdAcroFormProperty() {return reportDocumentCatalog.acroFormProperty();}
    public ReportDocumentInformation reportDocumentInformationProperty() {return reportDocumentInformation;}
    //endregion
}


