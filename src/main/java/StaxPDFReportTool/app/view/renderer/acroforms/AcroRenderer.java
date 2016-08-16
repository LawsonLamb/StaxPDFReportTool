package StaxPDFReportTool.app.view.renderer.acroforms;

import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.util.List;

public class AcroRenderer {
    List<PDField> pdFieldList;
    PDAcroForm pdAcroForm;

    public AcroRenderer(PDAcroForm form){
        pdAcroForm = form;
        pdFieldList = pdAcroForm.getFields();

    }



}
