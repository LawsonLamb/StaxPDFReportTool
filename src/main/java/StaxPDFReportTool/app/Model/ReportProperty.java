package StaxPDFReportTool.app.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ReportProperty {
    //-- properties --//
    private StringProperty iD = new SimpleStringProperty();
    private StringProperty mappingId = new SimpleStringProperty();

    //-- constructors --//
    public ReportProperty(){

    }

    public  String getID(){return iD.get();}

    // Define a setter for the property's value
    public  void setID(String value){
        iD.set(value);
    }

    public String getMappingID() {
        return mappingId.get();
    }

    public void setMappingID(String MappingID){
        this.mappingId.setValue(MappingID);
    }

//-- javafx properties --//

    public StringProperty iDProperty(){

        return iD;
    }

    public StringProperty mappingIdProperty(){
        return mappingId;
    }

}
