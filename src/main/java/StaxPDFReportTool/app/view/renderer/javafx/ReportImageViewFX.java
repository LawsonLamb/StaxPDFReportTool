package StaxPDFReportTool.app.view.renderer.javafx;

import StaxPDFReportTool.app.view.renderer.acroforms.javaFX.ReportCheckBoxFX;
import StaxPDFReportTool.app.view.renderer.acroforms.javaFX.ReportTextFieldFX;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;

import java.util.List;

public class ReportImageViewFX extends ImageView {

    List<ReportTextFieldFX>  reportTextFieldFXList;
    List<ReportCheckBoxFX>   reportCheckBoxFXList;

    public ReportImageViewFX(Image image){
        super(image);
    }

    public ReportImageViewFX(Image image, List<PDField> PDFieldList){
        super(image);
    }

    public void sortPdFieldList(List<PDField> fields) {
        for (PDField field : fields) {
            if (field.getClass() == PDTextField.class){
                PDTextField pdTextField =(PDTextField)field;
                reportTextFieldFXList.add(new ReportTextFieldFX(pdTextField));
            } else if (field.getClass() == PDCheckBox.class){
                PDCheckBox pdCheckBox = (PDCheckBox) field;
              //  reportCheckBoxFXList.add(new ReportCheckBoxFX(pdCheckBox));
            }
        }

    }

}
