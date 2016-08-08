package StaxPDFReportTool.app.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

public class ReportFieldList  {

    private ObservableList<PDField> reportFields;

    ReportFieldList(PDAcroForm acroForm){

        reportFields= FXCollections.observableList(acroForm.getFields());

    }

    public ObservableList<PDField> GetObserableList(){
        return  reportFields;

    }



}
