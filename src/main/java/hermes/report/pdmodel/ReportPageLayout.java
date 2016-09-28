package hermes.report.pdmodel;

import javafx.beans.property.SimpleObjectProperty;
import org.apache.pdfbox.pdmodel.PageLayout;

/**
 * Created by @Lawson Lamb  on 9/27/2016.
 */
public class ReportPageLayout extends SimpleObjectProperty<PageLayout>{
    public ReportPageLayout() {
    }

    public ReportPageLayout(PageLayout initialValue) {
        super(initialValue);
    }
}
