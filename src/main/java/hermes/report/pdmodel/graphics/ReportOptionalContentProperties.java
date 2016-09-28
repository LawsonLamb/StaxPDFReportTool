package hermes.report.pdmodel.graphics;

import javafx.beans.property.SimpleObjectProperty;
import org.apache.pdfbox.pdmodel.graphics.optionalcontent.PDOptionalContentProperties;

/**
 * Created by @Lawson Lamb  on 9/27/2016.
 */
public class ReportOptionalContentProperties extends SimpleObjectProperty<PDOptionalContentProperties>{
    public ReportOptionalContentProperties() {
    }

    public ReportOptionalContentProperties(PDOptionalContentProperties initialValue) {
        super(initialValue);
    }
}
