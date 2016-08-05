package StaxPDFReportTool.View.Field;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;
import java.util.ArrayList;
import java.util.List;

public  class PDFieldListView extends ListView<String>{


    public List<PDField> pdFields;

    public PDFieldListView(PDAcroForm AcroForm){
        pdFields = AcroForm.getFields();
    }


    public ObservableList<String> ConvertPDFieldToObservableList(ArrayList<PDField> pdFields) {
        ArrayList<String> names = new ArrayList<>();
        for(int i=0;i<pdFields.size();i++){

            names.add(pdFields.get(i).getPartialName());

        }

       return FXCollections.observableArrayList(names);

    }

    public ObservableList<String> ConvertPDTextFieldToObservableList(ArrayList<PDTextField> pdFields) {
        ArrayList<String> names = new ArrayList<>();
        for(int i=0;i<pdFields.size();i++){

            names.add(pdFields.get(i).getPartialName());

        }

        return FXCollections.observableArrayList(names);

    }

    public ObservableList<String> ConvertCheckBoxToObservableList(ArrayList<PDCheckBox> pdFields) {
        ArrayList<String> names = new ArrayList<>();
        for(int i=0;i<pdFields.size();i++){

            names.add(pdFields.get(i).getPartialName());

        }

        return FXCollections.observableArrayList(names);

    }



    public ArrayList<PDTextField> getTextFields(){
        ArrayList<PDTextField> textFields = new ArrayList<>();
        for(int i=0;i<pdFields.size();i++){

          PDField field=  pdFields.get(i);
            if(field.getClass() == PDTextField.class){
                textFields.add((PDTextField) field);
            }


        }

        return textFields;
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







    public void SetItems(ArrayList<PDField> Fields){
        this.setItems(ConvertPDFieldToObservableList(Fields));
    }



}
