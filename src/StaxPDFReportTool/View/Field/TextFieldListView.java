package StaxPDFReportTool.View.Field;


import StaxPDFReportTool.View.Field.PDFieldListView;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;

public class TextFieldListView extends PDFieldListView {


    public TextFieldListView(PDAcroForm AcroForm) {
        super(AcroForm);
        setItems(ConvertPDTextFieldToObservableList(getTextFields()));
    }
}
