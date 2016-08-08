package StaxPDFReportTool.app.Model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

public class ReportField {

    private ObjectProperty<PDField> pdFieldObjectProperty;
    private StringProperty id ;
    private StringProperty mappindID;

    public ReportField(PDField field){
        pdFieldObjectProperty  = new SimpleObjectProperty<PDField>(field);
        id = new SimpleStringProperty(field.getPartialName());
        mappindID = new SimpleStringProperty(field.getMappingName());

    }

    public PDField getField(){
        return pdFieldObjectProperty.get();
    }

    public void setField(PDField field){

        pdFieldObjectProperty.setValue(field);
    }

    public String getID(){return id.get();}

    // Define a setter for the property's value
    public  void setID(String value){
        id.set(value);
    }


    public StringProperty iDProperty(){

        return id;
    }








}
