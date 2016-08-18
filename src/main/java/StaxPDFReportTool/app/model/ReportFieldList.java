package StaxPDFReportTool.app.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.util.ArrayList;
import java.util.List;

public class ReportFieldList  {

    private ObservableList<ReportField> reportFields;
    PDAcroForm pdAcroForm;

    ReportFieldList(PDAcroForm acroForm){

        pdAcroForm = acroForm;
        reportFields= FXCollections.observableList(ConvertToArraryList(acroForm.getFields()));


    }
    private ArrayList<ReportField> ConvertToArraryList(List<PDField> pdFieldList){
        ArrayList<ReportField> reportFieldArrayList = new ArrayList<>();

        for(int i=0;i< pdFieldList.size();i++){
            reportFieldArrayList.add(new ReportField(pdFieldList.get(i)));

        }
        return reportFieldArrayList;
    }

    public ObservableList<ReportField> GetObserableList(){
        return  reportFields;

    }



}
