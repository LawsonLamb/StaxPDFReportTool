package hermesviewer.app.view.renderer.javafx;

import hermesviewer.app.view.renderer.acroforms.javaFX.ReportCheckBoxFX;
import hermesviewer.app.view.renderer.acroforms.javaFX.ReportTextFieldFX;
import javafx.scene.image.Image;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;

import java.util.List;

public class ReportPage {

    List<ReportTextFieldFX> reportTextFieldFXList;
    List<ReportCheckBoxFX>  reportCheckBoxFXList;
    ReportImageViewFX reportImageViewFX;
    public ReportPage(Image image){

        reportImageViewFX = new ReportImageViewFX(image);
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
