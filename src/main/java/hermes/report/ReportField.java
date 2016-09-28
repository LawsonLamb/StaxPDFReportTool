package hermes.report;

import hermes.report.Interfaces.ISave;
import hermes.report.Interfaces.Update;
import javafx.beans.property.*;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

public class ReportField  extends SimpleObjectProperty<PDField> implements ISave,Update{


    private final StringProperty partialNameProperty = new SimpleStringProperty();
    private final StringProperty mappingNameProperty = new SimpleStringProperty();
    private final StringProperty fullNameProperty = new SimpleStringProperty();
    private final StringProperty altName = new SimpleStringProperty();
    private final StringProperty fieldTypeProperty = new SimpleStringProperty();
    private final BooleanProperty isNoExportProperty = new SimpleBooleanProperty();
    private final BooleanProperty readOnlyProperty =  new SimpleBooleanProperty();
    private final BooleanProperty isRequiredProperty= new SimpleBooleanProperty();


    public ReportField(){
        super();
        addListener((observable, oldValue, newValue) -> this.onChanged(newValue));
    }

    public ReportField(PDField field){
      super(field);
        onChanged(field);
        addListener((observable, oldValue, newValue) -> this.onChanged(newValue));
    }

    private void onChanged(PDField field){
        this.set(field);
        update();
    }
    @Override
    public void update() {
        if(this.get()!=null) {
            setPartialName(this.get().getPartialName());
            setMappingName(this.get().getMappingName());
            setAltName(this.get().getAlternateFieldName());
            setFullName(this.get().getFullyQualifiedName());
            setIsNoExport(this.get().isNoExport());
            setReadOnly(this.get().isReadOnly());
            setIsRequired(this.get().isRequired());
            setFieldType(this.get().getFieldType());
        }
    }

    @Override
    public void save(){
        if(this.get()!=null) {
            this.get().setPartialName(getPartialName());
            this.get().setMappingName(getMappingName());
            this.get().setAlternateFieldName(getAltName());
            this.get().setNoExport(getIsNoExport());
            this.get().setReadOnly(getReadOnly());
            this.get().setRequired(getIsRequired());

        }
    }





    //region Value Accessors


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

    public String getFieldType(){return fieldTypeProperty.get();}
    public void setFieldType(String value){
        fieldTypeProperty.set(value);
    }


    //endregion

    //region Property Accessors


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
    public StringProperty fieldTypeProperty(){return fieldTypeProperty;}


    //endregion










}
