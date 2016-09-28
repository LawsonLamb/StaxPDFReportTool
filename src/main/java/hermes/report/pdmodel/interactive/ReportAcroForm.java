package hermes.report.pdmodel.interactive;


import hermes.report.Interfaces.ISave;
import hermes.report.Interfaces.Update;
import hermes.report.ReportField;
import hermes.report.pdmodel.ReportResources;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.fdf.FDFDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDXFAResource;

import java.util.ArrayList;
import java.util.List;

public class ReportAcroForm extends SimpleObjectProperty<PDAcroForm> implements ISave,Update{

    private final SimpleObjectProperty<FDFDocument> fdfDocument = new SimpleObjectProperty<>();
    private final StringProperty defaultAppearance = new SimpleStringProperty();
    private final ReportResources defaultResources = new ReportResources();

    //PDField  	getField(String fullyQualifiedName)
    //Iterator<PDField> 	getFieldIterator()
    //List<PDField> 	getFields()
    //PDFieldTree 	getFieldTree()
    private final BooleanProperty needAppearances = new SimpleBooleanProperty();
    private final IntegerProperty q = new SimpleIntegerProperty();
    private final SimpleObjectProperty<PDXFAResource> pdxfaResource =  new SimpleObjectProperty<>();
    private final BooleanProperty hasXFA = new SimpleBooleanProperty();
    private final BooleanProperty appendOnly = new SimpleBooleanProperty();
    private final BooleanProperty cachingFields = new SimpleBooleanProperty();
    private final BooleanProperty signaturesExist = new SimpleBooleanProperty();
    private final BooleanProperty xfaIsDynamic = new SimpleBooleanProperty();
    private final ListProperty<ReportField> reportFields = new SimpleListProperty<>();




    public ReportAcroForm(PDAcroForm initialValue) {
        super(initialValue);
        addListener((observable, oldValue, newValue) -> onChanged(newValue));
    }

    public ReportAcroForm() {
        super();
        addListener((observable, oldValue, newValue) -> onChanged(newValue));
    }
    private void onChanged(PDAcroForm form){
        this.set(form);
        reportFields.set(convertToReportFieldList(form.getFields()));
        update();
    }



    @Override
    public void save() {
        PDAcroForm acroForm = this.get();
        if(acroForm!=null){
            acroForm.setAppendOnly(appendOnly.get());
            acroForm.setCacheFields(cachingFields.get());
            acroForm.setDefaultAppearance(defaultAppearance.get());
            acroForm.setDefaultResources(defaultResources.get());
            reportFields.forEach(ReportField::save);
            acroForm.setNeedAppearances(needAppearances.get());
            acroForm.setSignaturesExist(signaturesExist.get());
            acroForm.setQ(q.get());
            acroForm.setXFA(pdxfaResource.get());

        }
    }

    @Override
    public void update() {
        PDAcroForm acroForm = this.get();
        if(acroForm!=null){
            setDefaultAppearance(acroForm.getDefaultAppearance());
            setAppendOnly(acroForm.isAppendOnly());
            setCachingFields(acroForm.isCachingFields());
            setNeedAppearances(acroForm.getNeedAppearances());
            setDefaultResources(acroForm.getDefaultResources());
             reportFields.set(convertToReportFieldList(acroForm.getFields()));
            setSignaturesExist(acroForm.isSignaturesExist());
            setQ(acroForm.getQ());
            setHasXFA(acroForm.hasXFA());
        }

    }

    private ObservableList<ReportField> convertToReportFieldList(List<PDField> pdFieldList){

        ArrayList<ReportField> reportFieldArrayList = new ArrayList<>();
        for (int i = 0; i < pdFieldList.size(); i++) {

            reportFieldArrayList.add(new ReportField(pdFieldList.get(i)));
        }
      return FXCollections.observableList(reportFieldArrayList);
    }


    public PDResources getDefaultResources() {
        return defaultResources.get();
    }

    public ReportResources defaultResourcesProperty() {
        return defaultResources;
    }

    public void setDefaultResources(PDResources defaultResources) {
        this.defaultResources.set(defaultResources);
    }

    public PDXFAResource getPdxfaResource() {
        return pdxfaResource.get();
    }

    public SimpleObjectProperty<PDXFAResource> pdxfaResourceProperty() {
        return pdxfaResource;
    }

    public void setPdxfaResource(PDXFAResource pdxfaResource) {
        this.pdxfaResource.set(pdxfaResource);
    }

    public boolean isAppendOnly() {
        return appendOnly.get();
    }

    public boolean isCachingFields() {
        return cachingFields.get();
    }

    public boolean isSignaturesExist() {
        return signaturesExist.get();
    }

    public ObservableList<ReportField> getReportFields() {
        return reportFields;
    }


    public FDFDocument getFdfDocument() {
        return fdfDocument.get();
    }

    public SimpleObjectProperty<FDFDocument> fdfDocumentProperty() {
        return fdfDocument;
    }

    public void setFdfDocument(FDFDocument fdfDocument) {
        this.fdfDocument.set(fdfDocument);
    }

    public String getDefaultAppearance() {
        return defaultAppearance.get();
    }

    public StringProperty defaultAppearanceProperty() {
        return defaultAppearance;
    }

    public void setDefaultAppearance(String defaultAppearance) {
        this.defaultAppearance.set(defaultAppearance);
    }

    public boolean isNeedAppearances() {
        return needAppearances.get();
    }

    public BooleanProperty needAppearancesProperty() {
        return needAppearances;
    }

    public void setNeedAppearances(boolean needAppearances) {
        this.needAppearances.set(needAppearances);
    }

    public int getQ() {
        return q.get();
    }

    public IntegerProperty qProperty() {
        return q;
    }

    public void setQ(int q) {
        this.q.set(q);
    }

    public boolean isHasXFA() {
        return hasXFA.get();
    }

    public BooleanProperty hasXFAProperty() {
        return hasXFA;
    }

    public void setHasXFA(boolean hasXFA) {
        this.hasXFA.set(hasXFA);
    }

    public boolean getAppendOnly() {
        return appendOnly.get();
    }

    public BooleanProperty appendOnlyProperty() {
        return appendOnly;
    }

    public void setAppendOnly(boolean appendOnly) {
        this.appendOnly.set(appendOnly);
    }

    public boolean getCachingFields() {
        return cachingFields.get();
    }

    public BooleanProperty cachingFieldsProperty() {
        return cachingFields;
    }

    public void setCachingFields(boolean cachingFields) {
        this.cachingFields.set(cachingFields);
    }

    public boolean getSignaturesExist() {
        return signaturesExist.get();
    }

    public BooleanProperty signaturesExistProperty() {
        return signaturesExist;
    }

    public void setSignaturesExist(boolean signaturesExist) {
        this.signaturesExist.set(signaturesExist);
    }

    public boolean isXfaIsDynamic() {
        return xfaIsDynamic.get();
    }

    public BooleanProperty xfaIsDynamicProperty() {
        return xfaIsDynamic;
    }

    public void setXfaIsDynamic(boolean xfaIsDynamic) {
        this.xfaIsDynamic.set(xfaIsDynamic);
    }


}
