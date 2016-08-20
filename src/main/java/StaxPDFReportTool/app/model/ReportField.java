package StaxPDFReportTool.app.model;

import javafx.beans.property.*;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

public class ReportField {

    private ObjectProperty<PDField> pdFieldObjectProperty;
    private StringProperty partialNameProperty;
    private StringProperty mappingNameProperty;
    private StringProperty fullNameProperty;
    private StringProperty altName;
    private BooleanProperty isNoExportProperty;
    private BooleanProperty readOnlyProperty;
    private BooleanProperty isRequiredProperty;


    public ReportField(){
        pdFieldObjectProperty  = new SimpleObjectProperty<PDField>(null);
        partialNameProperty = new SimpleStringProperty();
        mappingNameProperty = new SimpleStringProperty();
        fullNameProperty = new SimpleStringProperty();
        altName = new SimpleStringProperty();
        isNoExportProperty = new SimpleBooleanProperty();
        readOnlyProperty = new SimpleBooleanProperty();
        isRequiredProperty = new SimpleBooleanProperty();
    }

    public ReportField(PDField field){
        pdFieldObjectProperty  = new SimpleObjectProperty<>(field);
        partialNameProperty = new SimpleStringProperty(field.getPartialName());
        mappingNameProperty = new SimpleStringProperty(field.getMappingName());
        fullNameProperty = new SimpleStringProperty(field.getFullyQualifiedName());
        altName = new SimpleStringProperty(field.getAlternateFieldName());
        isNoExportProperty = new SimpleBooleanProperty(field.isNoExport());
        readOnlyProperty = new SimpleBooleanProperty(field.isReadOnly());
        isRequiredProperty = new SimpleBooleanProperty(field.isRequired());


    }


    public void UpdatePropertys(){
        if(getField()!=null) {

            setPartialName(getField().getPartialName());
            setMappingName(getField().getMappingName());
            setAltName(getField().getAlternateFieldName());
            setFullName(getField().getFullyQualifiedName());
            setIsNoExport(getField().isNoExport());
            setReadOnly(getField().isReadOnly());
            setIsRequired(getField().isRequired());
        }
    }

    public void Save(){
        if(getField()!=null) {
            getField().setPartialName(getPartialName());
            getField().setMappingName(getMappingName());
            getField().setAlternateFieldName(getAltName());
            getField().setNoExport(getIsNoExport());
            getField().setReadOnly(getReadOnly());
            getField().setRequired(getIsRequired());
        }
    }





    //region Value Accessors

    public PDField getField(){
        return pdFieldObjectProperty.get();
    }
    public void setField(PDField field){
        pdFieldObjectProperty.set(field);
    }

    public String getMappingName(){
        return mappingNameProperty.get();
    }
    public void setMappingName(String value){
         mappingNameProperty.set(value);
    }

    public String getFullName(){
        return  fullNameProperty.get();
    }
    public void setFullName(String Value){
      fullNameProperty.set(Value);
    }

    public String getAltName(){return  altName.get();}
    public void setAltName(String Value){
        altName.set(Value);
    }

    public Boolean getIsNoExport(){return isNoExportProperty.get();}
    public void setIsNoExport(Boolean Value){
        isNoExportProperty.set(Value);
    }

    public Boolean getReadOnly(){
  return  readOnlyProperty.get();
}
    public void setReadOnly(Boolean Value){
    readOnlyProperty.set(Value);
}

    public Boolean getIsRequired(){return isRequiredProperty.get();}
    public void setIsRequired(Boolean Value){
        isRequiredProperty.set(Value);
    }

    public String getPartialName(){return partialNameProperty.get();}
    public void setPartialName(String value){
        partialNameProperty.set(value);
    }


    //endregion

    //region Property Accessors


    public ObjectProperty<PDField> PDFieldProperty(){
        return pdFieldObjectProperty;
    }
    public StringProperty partialNameProperty(){
        return partialNameProperty;
    }
    public StringProperty mappingNameProperty(){
        return mappingNameProperty;
    }
    public StringProperty fullNameProperty(){
        return fullNameProperty;
    }
    public StringProperty altNameProperty(){
        return altName;
    }
    public BooleanProperty isNoExportProperty( ){
        return isNoExportProperty;
    }
    public BooleanProperty readOnlyProperty(){
        return readOnlyProperty;
    }
    public BooleanProperty isRequiredProperty(){
        return isRequiredProperty;
    }



    //endregion










}
