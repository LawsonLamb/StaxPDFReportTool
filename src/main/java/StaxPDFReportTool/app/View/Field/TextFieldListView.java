package StaxPDFReportTool.app.View.Field;


import javafx.beans.DefaultProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;


import java.util.ArrayList;
import java.util.List;

@DefaultProperty(value = "textFieldList")
public class TextFieldListView extends ListView<String> {
    @FXML
    ListView<String> textFieldList;



    public List<PDField> pdFields;
    public void Setup(PDAcroForm AcroForm) {
        pdFields = AcroForm.getFields();
        setItems(ConvertPDTextFieldToObservableList(getTextFields()));
    }


    public ObservableList<String> ConvertPDTextFieldToObservableList(ArrayList<PDTextField> pdFields) {
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


}
