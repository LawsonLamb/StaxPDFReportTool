package hermes.report.pdmodel.graphics.color;

import javafx.beans.property.SimpleObjectProperty;
import org.apache.pdfbox.pdmodel.graphics.color.PDOutputIntent;

/**
 * Created by @Lawson Lamb  on 9/27/2016.
 */
public class ReportOutputIntent extends SimpleObjectProperty<PDOutputIntent> {
    public ReportOutputIntent() {
    }

    public ReportOutputIntent(PDOutputIntent initialValue) {
        super(initialValue);
    }
}
