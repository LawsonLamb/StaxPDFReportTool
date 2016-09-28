package hermes.report.pdmodel.interactive;


import javafx.beans.property.SimpleObjectProperty;
import org.apache.pdfbox.pdmodel.interactive.action.PDDocumentCatalogAdditionalActions;

public class ReportDocumentCatalogAdditionalActions extends SimpleObjectProperty<PDDocumentCatalogAdditionalActions> {
    public ReportDocumentCatalogAdditionalActions() {
    }

    public ReportDocumentCatalogAdditionalActions(PDDocumentCatalogAdditionalActions initialValue) {
        super(initialValue);
    }
}
