package StaxPDFReportTool.app.model.pdf;

import StaxPDFReportTool.app.model.pdf.ReportField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.util.ArrayList;
import java.util.List;

public class ReportFieldList  {

    private ObservableList<ReportField> reportFields;
    PDAcroForm pdAcroForm;

   public ReportFieldList(PDAcroForm acroForm){

        pdAcroForm = acroForm;
        reportFields= FXCollections.observableList(ConvertToArrayList(acroForm.getFields()));

    }
    private ArrayList<ReportField> ConvertToArrayList(List<PDField> pdFieldList){
        ArrayList<ReportField> reportFieldArrayList = new ArrayList<>();

        for(int i=0;i< pdFieldList.size();i++){
            reportFieldArrayList.add(new ReportField(pdFieldList.get(i)));

        }
        return reportFieldArrayList;
    }

    public ObservableList<ReportField> GetObservableList(){
        return  reportFields;

    }

    public ReportField get(int index){
       return reportFields.get(index);
    }



}
