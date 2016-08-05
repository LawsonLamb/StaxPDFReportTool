package StaxPDFReportTool.View.Canvas;
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
        // bbox in user units
        Shape bbox = getLinePath().getBounds2D();

        // draw path (note that getLinePath() is now reset)
        super.fillPath(windingRule);

        // save
        Graphics2D graphics = getGraphics();
        Color color = graphics.getColor();
        Stroke stroke = graphics.getStroke();
        Shape clip = graphics.getClip();

        // draw
        graphics.setClip(graphics.getDeviceConfiguration().getBounds());
        graphics.setColor(Color.GREEN);
        graphics.setStroke(new BasicStroke(.5f));
        graphics.draw(bbox);

        // restore
        graphics.setStroke(stroke);
        graphics.setColor(color);
        graphics.setClip(clip);
    }

    private PDRectangle getFieldArea(PDField field) {
        COSDictionary fieldDict = field.getCOSObject();
        COSArray fieldAreaArray = (COSArray) fieldDict.getDictionaryObject(COSName.RECT);
        PDRectangle result = new PDRectangle(fieldAreaArray);
        return result;
    }
}
