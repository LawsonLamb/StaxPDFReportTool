package hermes.report.pdmodel;

import javafx.beans.property.SimpleObjectProperty;
import org.apache.pdfbox.pdmodel.PDPageTree;

/**
 * Created by @Lawson Lamb  on 9/27/2016.
 */
public class ReportPageTree extends SimpleObjectProperty<PDPageTree> {
    public ReportPageTree() {
    }

    public ReportPageTree(PDPageTree initialValue) {
        super(initialValue);
    }
}
