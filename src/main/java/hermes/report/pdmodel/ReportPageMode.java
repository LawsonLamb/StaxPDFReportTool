package hermes.report.pdmodel;

import javafx.beans.property.SimpleObjectProperty;
import org.apache.pdfbox.pdmodel.PageMode;

/**
 * Created by @Lawson Lamb  on 9/27/2016.
 */
public class ReportPageMode extends SimpleObjectProperty<PageMode> {
    public ReportPageMode() {
    }

    public ReportPageMode(PageMode initialValue) {
        super(initialValue);
    }
}
