package hermes.report.pdmodel.common;

import javafx.beans.property.SimpleObjectProperty;
import org.apache.pdfbox.pdmodel.common.PDPageLabels;

/**
 * Created by @Lawson Lamb  on 9/27/2016.
 */
public class ReportPageLabels extends SimpleObjectProperty<PDPageLabels>{
    public ReportPageLabels() {
    }

    public ReportPageLabels(PDPageLabels initialValue) {
        super(initialValue);
    }
}
