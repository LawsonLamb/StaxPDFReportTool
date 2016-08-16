package StaxReport;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.*;

import java.io.IOException;
import java.util.List;

public class StaxReport {


    public static void printField(PDDocument pdfDocument) throws IOException {

        PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();
        PDAcroForm acroForm = docCatalog.getAcroForm();
        List<PDField> fields = acroForm.getFields();
        System.out.println(fields.size() + " top-level fields were found on the form");
        for (PDField field : fields) {
            processField(field, "|--", field.getPartialName());
        }


    }

    private static void processField(PDField field, String sLevel, String sParent) throws IOException {
        String partialName = field.getPartialName();
        if (field instanceof PDNonTerminalField)
        {
            if (!sParent.equals(field.getPartialName()))
            {
                if (partialName != null)
                {
                    sParent = sParent + "." + partialName;
                }
            }
            System.out.println(sLevel + sParent);

            for (PDField child : ((PDNonTerminalField)field).getChildren())
            {
                processField(child, "|  " + sLevel, sParent);
            }
        }
        else
        {
            String fieldValue = field.getValueAsString();
            StringBuilder outputString = new StringBuilder(sLevel);
            outputString.append(sParent);
            if (partialName != null)
            {
                outputString.append(".").append(partialName);
            }
            outputString.append(" = ").append(fieldValue);
            outputString.append(",  type=").append(field.getClass().getName());
            System.out.println(outputString);
        }
    }

    public static PDDocument showFields(PDDocument pdfDocument) throws IOException {

        PDDocumentCatalog docCatalog = pdfDocument.getDocumentCatalog();
        PDAcroForm acroForm = docCatalog.getAcroForm();
        List<PDField> fields = acroForm.getFields();

        for (PDField field : fields) {

            if(field.getClass()  == PDTextField.class){
                PDTextField pdTextField =(PDTextField)field;
                pdTextField.setValue(pdTextField.getPartialName());
            }
            else if(field.getClass() ==  PDCheckBox.class){
                PDCheckBox pdCheckBox = (PDCheckBox) field;
                pdCheckBox.check();
            }
        }

        return pdfDocument;

    }







}
