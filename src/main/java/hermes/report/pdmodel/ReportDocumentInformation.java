package hermes.report.pdmodel;

import hermes.report.Interfaces.ISave;
import hermesviewer.app.interfaces.Update;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;

public class ReportDocumentInformation extends SimpleObjectProperty<PDDocumentInformation> implements Update,ISave{

    private final StringProperty author = new SimpleStringProperty();
    private final StringProperty creator = new SimpleStringProperty();
    private final StringProperty producer = new SimpleStringProperty();
    private final StringProperty subject = new SimpleStringProperty();
    private final StringProperty title = new SimpleStringProperty();
    private final StringProperty creationDate = new SimpleStringProperty();
    private final StringProperty modificationDate = new SimpleStringProperty();

    public ReportDocumentInformation(PDDocumentInformation pdDocumentInformation){
        super(pdDocumentInformation);
        this.addListener((observable, oldValue, newValue) ->onChanged(newValue));


    }

    private void onChanged(PDDocumentInformation information){
        this.set(information);
        update();

    }
    public ReportDocumentInformation() {
        this.addListener((observable, oldValue, newValue) ->onChanged(newValue));
    }

    @Override
    public void update() {
        PDDocumentInformation pdDocumentInformation = this.get();
        if(pdDocumentInformation!=null) {
            author.setValue(pdDocumentInformation.getAuthor());

            creator.setValue(pdDocumentInformation.getCreator());
            producer.setValue(pdDocumentInformation.getProducer());
            subject.setValue(pdDocumentInformation.getSubject());
            title.setValue(pdDocumentInformation.getTitle());
            creationDate.setValue(pdDocumentInformation.getCreationDate().getTime().toString());
            modificationDate.setValue(pdDocumentInformation.getModificationDate().getTime().toString());

        }
    }
    @Override
    public void save() {
        PDDocumentInformation pdDocumentInformation = this.get();
        if(pdDocumentInformation!=null){

        }
    }
    public String getAuthor() {return author.get();}
    public void setAuthor(String author) {this.author.set(author);}

    public String getCreator() {return creator.get();}
    public void setCreator(String creator) {this.creator.set(creator);}

    public String getProducer() {return producer.get();}
    public void setProducer(String producer) {this.producer.set(producer);}

    public String getSubject() {return subject.get();}
    public void setSubject(String subject) {this.subject.set(subject);}

    public String getTitle() {return title.get();}
    public void setTitle(String title) {this.title.set(title);}

    public String getCreationDate() {return creationDate.get();}
    public void setCreationDate(String creationDate) {this.creationDate.set(creationDate);}

    public String getModificationDate() {return modificationDate.get();}
    public void setModificationDate(String modificationDate) {this.modificationDate.set(modificationDate);}


    public StringProperty authorProperty() {return author;}
    public StringProperty creatorProperty() {return creator;}
    public StringProperty producerProperty() {return producer;}
    public StringProperty subjectProperty() {return subject;}
    public StringProperty titleProperty() {return title;}
    public StringProperty creationDateProperty() {return creationDate;}
    public StringProperty modificationDateProperty() {return modificationDate;}


}


