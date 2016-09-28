package hermes.report.pdmodel;


import javafx.beans.property.SimpleObjectProperty;
import org.apache.pdfbox.pdmodel.PDDocumentNameDestinationDictionary;

public class ReportDocumentNameDestinationDictionary extends SimpleObjectProperty<PDDocumentNameDestinationDictionary>{

    public ReportDocumentNameDestinationDictionary() {
    }

    public ReportDocumentNameDestinationDictionary(PDDocumentNameDestinationDictionary initialValue) {
        super(initialValue);
    }
}
