package StaxPDFReportTool.app.model;

import javafx.beans.property.*;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

public class ReportField {

    private ObjectProperty<PDField> pdFieldObjectProperty;
    private StringProperty id ;
    private StringProperty mappindID;


    public ReportField(PDField field){
        pdFieldObjectProperty  = new SimpleObjectProperty<PDField>(field);
        id = new SimpleStringProperty(field.getPartialName());
        mappindID = new SimpleStringProperty(field.getMappingName());
      ;


    }
    public void Update(){
        if(pdFieldObjectProperty.getValue()!=null) {

                setID(getField().getPartialName());

        }
    }
    public PDField getField(){
        return pdFieldObjectProperty.get();
    }

    public void setField(PDField field){

        pdFieldObjectProperty.setValue(field);
    }



    public String getID(){return id.get();}

    // Define a setter for the property's value
    public void setID(String value){
        id.set(value);
    }


    public StringProperty iDProperty(){

        return id;
    }

    public ObjectProperty<PDField> PDFieldProperty(){
        return pdFieldObjectProperty;
    }










}
