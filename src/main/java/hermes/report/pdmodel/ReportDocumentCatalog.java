package hermes.report.pdmodel;


import hermes.report.Interfaces.ISave;
import hermes.report.pdmodel.interactive.ReportAcroForm;
import hermes.report.pdmodel.interactive.ReportDocumentCatalogAdditionalActions;
import hermes.report.pdmodel.common.ReportMetadata;
import hermes.report.pdmodel.common.ReportPageLabels;
import hermes.report.pdmodel.documentinterchange.logicalstructure.ReportMarkInfo;
import hermes.report.pdmodel.documentinterchange.logicalstructure.ReportStructureTreeRoot;
import hermes.report.pdmodel.documentinterchange.outline.ReportDocumentOutline;
import hermes.report.pdmodel.graphics.ReportOptionalContentProperties;
import hermes.report.pdmodel.interactive.ReportViewerPreferences;
import hermes.report.pdmodel.interactive.action.ReportURIDictionary;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.common.PDMetadata;
import org.apache.pdfbox.pdmodel.common.PDPageLabels;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDMarkInfo;
import org.apache.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureTreeRoot;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentProperties;
import org.apache.pdfbox.pdmodel.interactive.action.PDDocumentCatalogAdditionalActions;
import org.apache.pdfbox.pdmodel.interactive.action.PDURIDictionary;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.viewerpreferences.PDViewerPreferences;

import java.io.IOException;


public class ReportDocumentCatalog extends SimpleObjectProperty<PDDocumentCatalog> implements ISave{

    private final ReportAcroForm acroForm = new ReportAcroForm();
    private final ReportDocumentCatalogAdditionalActions reportDocumentCatalogAdditionalActions = new ReportDocumentCatalogAdditionalActions();
    private final ReportDocumentNameDestinationDictionary reportDocumentNameDestinationDictionary = new ReportDocumentNameDestinationDictionary();
    private final ReportDocumentOutline reportDocumentOutline = new ReportDocumentOutline();
    private final StringProperty language = new SimpleStringProperty();
    private final ReportMarkInfo reportMarkInfo = new ReportMarkInfo();
    private final ReportMetadata reportMetadata = new ReportMetadata();
    private final ReportDocumentNameDictionary reportDocumentNameDictionary = new ReportDocumentNameDictionary();
    private final ReportOptionalContentProperties reportOptionalContentProperties = new ReportOptionalContentProperties();
    private final ReportPageLabels reportPageLabels = new ReportPageLabels();
    private final ReportPageLayout reportPageLayout = new ReportPageLayout();
    private final ReportPageMode reportPageMode = new ReportPageMode();
    private final ReportPageTree reportPageTree = new ReportPageTree();
    private final ReportStructureTreeRoot reportStructureTreeRoot = new ReportStructureTreeRoot();
    //List<PDThread>
    //List<PDOutoutIntent>
    private final ReportURIDictionary reportURIDictionary = new ReportURIDictionary();
    private final StringProperty version = new SimpleStringProperty();
    private final ReportViewerPreferences reportViewerPreferences = new ReportViewerPreferences();




    public ReportDocumentCatalog(PDDocumentCatalog initialValue) {
        super(initialValue);
    }

    public ReportDocumentCatalog() {
        super();
        this.addListener((observable, oldValue, newValue) -> {
            acroForm.set(newValue.getAcroForm());
            reportDocumentCatalogAdditionalActions.set(newValue.getActions());
            reportDocumentNameDestinationDictionary.set(newValue.getDests());
            reportDocumentOutline.set(newValue.getDocumentOutline());
            language.set(newValue.getLanguage());
            reportMarkInfo.set(newValue.getMarkInfo());
            reportMetadata.set(newValue.getMetadata());
            reportDocumentNameDictionary.set(newValue.getNames());
            reportOptionalContentProperties.set(newValue.getOCProperties());
            try {
                reportPageLabels.set(newValue.getPageLabels());
                reportPageMode.set(newValue.getPageMode());
                reportPageLayout.set(newValue.getPageLayout());
                reportPageTree.set(newValue.getPages());
                reportStructureTreeRoot.set(newValue.getStructureTreeRoot());
                reportURIDictionary.set(newValue.getURI());
                version.setValue(newValue.getVersion());
                reportViewerPreferences.setValue(newValue.getViewerPreferences());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    @Override
    public void save() {
        acroForm.save();
    }
    public PDAcroForm getAcroForm() {
        return acroForm.get();
    }

    public ReportAcroForm acroFormProperty() {
        return acroForm;
    }

    public void setAcroForm(PDAcroForm acroForm) {
        this.acroForm.set(acroForm);
    }

    public PDDocumentCatalogAdditionalActions getReportDocumentCatalogAdditionalActions() {
        return reportDocumentCatalogAdditionalActions.get();
    }

    public ReportDocumentCatalogAdditionalActions reportDocumentCatalogAdditionalActionsProperty() {
        return reportDocumentCatalogAdditionalActions;
    }

    public void setReportDocumentCatalogAdditionalActions(PDDocumentCatalogAdditionalActions reportDocumentCatalogAdditionalActions) {
        this.reportDocumentCatalogAdditionalActions.set(reportDocumentCatalogAdditionalActions);
    }

    public PDDocumentNameDestinationDictionary getReportDocumentNameDestinationDictionary() {
        return reportDocumentNameDestinationDictionary.get();
    }

    public ReportDocumentNameDestinationDictionary reportDocumentNameDestinationDictionaryProperty() {
        return reportDocumentNameDestinationDictionary;
    }

    public void setReportDocumentNameDestinationDictionary(PDDocumentNameDestinationDictionary reportDocumentNameDestinationDictionary) {
        this.reportDocumentNameDestinationDictionary.set(reportDocumentNameDestinationDictionary);
    }

    public PDDocumentOutline getReportDocumentOutline() {
        return reportDocumentOutline.get();
    }

    public ReportDocumentOutline reportDocumentOutlineProperty() {
        return reportDocumentOutline;
    }

    public void setReportDocumentOutline(PDDocumentOutline reportDocumentOutline) {
        this.reportDocumentOutline.set(reportDocumentOutline);
    }

    public String getLanguage() {
        return language.get();
    }

    public StringProperty languageProperty() {
        return language;
    }

    public void setLanguage(String language) {
        this.language.set(language);
    }

    public PDMarkInfo getReportMarkInfo() {
        return reportMarkInfo.get();
    }

    public ReportMarkInfo reportMarkInfoProperty() {
        return reportMarkInfo;
    }

    public void setReportMarkInfo(PDMarkInfo reportMarkInfo) {
        this.reportMarkInfo.set(reportMarkInfo);
    }

    public PDMetadata getReportMetadata() {
        return reportMetadata.get();
    }

    public ReportMetadata reportMetadataProperty() {
        return reportMetadata;
    }

    public void setReportMetadata(PDMetadata reportMetadata) {
        this.reportMetadata.set(reportMetadata);
    }

    public PDDocumentNameDictionary getReportDocumentNameDictionary() {
        return reportDocumentNameDictionary.get();
    }

    public ReportDocumentNameDictionary reportDocumentNameDictionaryProperty() {
        return reportDocumentNameDictionary;
    }

    public void setReportDocumentNameDictionary(PDDocumentNameDictionary reportDocumentNameDictionary) {
        this.reportDocumentNameDictionary.set(reportDocumentNameDictionary);
    }

    public PDOptionalContentProperties getReportOptionalContentProperties() {
        return reportOptionalContentProperties.get();
    }

    public ReportOptionalContentProperties reportOptionalContentPropertiesProperty() {
        return reportOptionalContentProperties;
    }

    public void setReportOptionalContentProperties(PDOptionalContentProperties reportOptionalContentProperties) {
        this.reportOptionalContentProperties.set(reportOptionalContentProperties);
    }

    public PDPageLabels getReportPageLabels() {
        return reportPageLabels.get();
    }

    public ReportPageLabels reportPageLabelsProperty() {
        return reportPageLabels;
    }

    public void setReportPageLabels(PDPageLabels reportPageLabels) {
        this.reportPageLabels.set(reportPageLabels);
    }

    public PageLayout getReportPageLayout() {
        return reportPageLayout.get();
    }

    public ReportPageLayout reportPageLayoutProperty() {
        return reportPageLayout;
    }

    public void setReportPageLayout(PageLayout reportPageLayout) {
        this.reportPageLayout.set(reportPageLayout);
    }

    public PageMode getReportPageMode() {
        return reportPageMode.get();
    }

    public ReportPageMode reportPageModeProperty() {
        return reportPageMode;
    }

    public void setReportPageMode(PageMode reportPageMode) {
        this.reportPageMode.set(reportPageMode);
    }

    public PDPageTree getReportPageTree() {
        return reportPageTree.get();
    }

    public ReportPageTree reportPageTreeProperty() {
        return reportPageTree;
    }

    public void setReportPageTree(PDPageTree reportPageTree) {
        this.reportPageTree.set(reportPageTree);
    }

    public PDStructureTreeRoot getReportStructureTreeRoot() {
        return reportStructureTreeRoot.get();
    }

    public ReportStructureTreeRoot reportStructureTreeRootProperty() {
        return reportStructureTreeRoot;
    }

    public void setReportStructureTreeRoot(PDStructureTreeRoot reportStructureTreeRoot) {
        this.reportStructureTreeRoot.set(reportStructureTreeRoot);
    }

    public PDURIDictionary getReportURIDictionary() {
        return reportURIDictionary.get();
    }

    public ReportURIDictionary reportURIDictionaryProperty() {
        return reportURIDictionary;
    }

    public void setReportURIDictionary(PDURIDictionary reportURIDictionary) {
        this.reportURIDictionary.set(reportURIDictionary);
    }

    public String getVersion() {
        return version.get();
    }

    public StringProperty versionProperty() {
        return version;
    }

    public void setVersion(String version) {
        this.version.set(version);
    }

    public PDViewerPreferences getReportViewerPreferences() {
        return reportViewerPreferences.get();
    }

    public ReportViewerPreferences reportViewerPreferencesProperty() {
        return reportViewerPreferences;
    }

    public void setReportViewerPreferences(PDViewerPreferences reportViewerPreferences) {
        this.reportViewerPreferences.set(reportViewerPreferences);
    }


}


