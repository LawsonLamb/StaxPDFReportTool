package hermes.report.pdmodel.interactive.documentnavigation.destination;

import javafx.beans.property.SimpleObjectProperty;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.destination.PDPageDestination;

public class ReportPageDestination extends SimpleObjectProperty<PDPageDestination> {
    public ReportPageDestination() {
    }

    public ReportPageDestination(PDPageDestination initialValue) {
        super(initialValue);
    }
}
