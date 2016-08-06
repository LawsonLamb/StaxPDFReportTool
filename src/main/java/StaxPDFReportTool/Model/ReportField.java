package StaxPDFReportTool.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.Callback;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.io.IOException;
import java.util.List;
import java.util.Observable;

public class ReportField {

    private StringProperty id = new SimpleStringProperty();

    PDField field;
     public ReportField(){

    }

    public ReportField(PDField field){

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
