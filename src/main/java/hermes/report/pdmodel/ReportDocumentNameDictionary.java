package hermes.report.pdmodel;

import javafx.beans.property.SimpleObjectProperty;
import org.apache.pdfbox.pdmodel.PDDocumentNameDictionary;

public class ReportDocumentNameDictionary extends SimpleObjectProperty<PDDocumentNameDictionary> {

    public ReportDocumentNameDictionary() {
    }

    public ReportDocumentNameDictionary(PDDocumentNameDictionary initialValue) {
        super(initialValue);
    }
}
