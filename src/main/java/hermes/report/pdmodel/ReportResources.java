package hermes.report.pdmodel;

import javafx.beans.property.SimpleObjectProperty;
import org.apache.pdfbox.pdmodel.PDResources;

/**
 * Created by @Lawson Lamb  on 9/28/2016.
 */
public class ReportResources extends SimpleObjectProperty<PDResources> {


    public ReportResources() {
    }

    public ReportResources(PDResources initialValue) {
        super(initialValue);
    }
}
