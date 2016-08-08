package StaxPDFReportTool.app.View.Field;


import javafx.beans.DefaultProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.util.ArrayList;
import java.util.List;
@DefaultProperty(value = "checkBoxList")
public class CheckBoxListView extends ListView<String> {
    @FXML  ListView<String> checkBoxList;
    public List<PDField> pdFields;


    public void Setup(PDAcroForm AcroForm){
    pdFields = AcroForm.getFields();
    setItems(ConvertCheckBoxToObservableList(getCheckBoxs()));
}


    public ObservableList<String> ConvertCheckBoxToObservableList(ArrayList<PDCheckBox> pdFields) {
        ArrayList<String> names = new ArrayList<>();
        for(int i=0;i<pdFields.size();i++){

            names.add(pdFields.get(i).getPartialName());

        }

        return FXCollections.observableArrayList(names);

    }

    public ArrayList<PDCheckBox> getCheckBoxs(){
        ArrayList<PDCheckBox> checkBoxes = new ArrayList<>();
        for(int i=0;i<pdFields.size();i++){

            PDField field=  pdFields.get(i);
            if(field.getClass() == PDCheckBox.class){
                checkBoxes.add((PDCheckBox) field);
            }


        }

        return checkBoxes;
    }




}
