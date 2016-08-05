package StaxPDFReportTool.View.Field;


import javafx.collections.ObservableList;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.util.ArrayList;

public class CheckBoxListView extends PDFieldListView {

    public CheckBoxListView(PDAcroForm AcroForm) {
        super(AcroForm);

        setItems(ConvertCheckBoxToObservableList(getCheckBoxs()));
    }



}
