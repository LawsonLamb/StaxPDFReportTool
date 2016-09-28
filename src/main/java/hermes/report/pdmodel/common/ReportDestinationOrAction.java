package hermes.report.pdmodel.common;

import javafx.beans.property.SimpleObjectProperty;
import org.apache.pdfbox.pdmodel.common.PDDestinationOrAction;

/**
 * Created by @Lawson Lamb  on 9/27/2016.
 */
public class ReportDestinationOrAction extends SimpleObjectProperty<PDDestinationOrAction> {
    public ReportDestinationOrAction() {
    }

    public ReportDestinationOrAction(PDDestinationOrAction initialValue) {
        super(initialValue);
    }
}
