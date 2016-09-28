package hermesviewer.app.model;

import hermesviewer.app.ReportAppComponent;
import hermes.report.pdmodel.ReportDocument;
import hermes.report.ReportField;
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

    public ObservableList<ReportField> GetObservableList(){return  reportFields;}

    public ReportField get(int index){return reportDocument().getReportFieldObservableList().get(index);}
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
