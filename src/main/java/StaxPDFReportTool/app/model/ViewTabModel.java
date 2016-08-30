package StaxPDFReportTool.app.model;

import StaxPDFReportTool.app.ReportAppComponent;
import StaxPDFReportTool.app.model.pdf.ReportDocument;
import StaxPDFReportTool.app.model.pdf.ReportField;
import StaxPDFReportTool.app.model.pdf.ReportFieldList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;


import java.util.ArrayList;
import java.util.List;

public class ViewTabModel extends ReportAppComponent {


//region Variables

    private ReportField currentField;
    private ObservableList<ReportField> reportFields;


    //endregion
    //region Constructors
    public ViewTabModel() {

        /*
        reportDocument().fieldListProperty().addListener((observable, oldValue, newValue)-> {
                if(newValue!=null){
                    initReportFields(newValue);
                }
        });
        */

    }
    private void initReportFields(List<PDField> pdFieldList){
        if(pdFieldList!=null) {
            ArrayList<ReportField> reportFieldArrayList = new ArrayList<>();

            for (int i = 0; i < pdFieldList.size(); i++) {
                reportFieldArrayList.add(new ReportField(pdFieldList.get(i)));

            }
            reportFields = FXCollections.observableList(reportFieldArrayList);
        }
    }

    public ObservableList<ReportField> GetObservableList(){
        return  reportFields;

    }

    public ReportField get(int index){
        return reportFields.get(index);
    }
//endregion




    //region Accessors

    public ReportField getCurrentField(){
        return currentField;
    }
    public void setCurrentField(ReportField field) {
        currentField = field;
    }

    public ReportDocument reportDocument(){
        return  app().model().reportDocument();
    }






}
