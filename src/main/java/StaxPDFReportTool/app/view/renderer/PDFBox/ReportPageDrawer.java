package StaxPDFReportTool.app.view.renderer.PDFBox;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.rendering.PageDrawer;
import org.apache.pdfbox.rendering.PageDrawerParameters;

import java.awt.*;
import java.io.IOException;

public class ReportPageDrawer extends PageDrawer {
    public ReportPageDrawer(PageDrawerParameters parameters) throws IOException {
        super(parameters);


    }


    @Override
    public void fillPath(int windingRule) throws IOException
    {

    }


    private PDRectangle getFieldArea(PDField field) {
        COSDictionary fieldDict = field.getCOSObject();
        COSArray fieldAreaArray = (COSArray) fieldDict.getDictionaryObject(COSName.RECT);
        PDRectangle result = new PDRectangle(fieldAreaArray);
        return result;
    }



}
