package hermesviewer.app.view.renderer.canvas;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javafx.scene.canvas.Canvas;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.jfree.fx.FXGraphics2D;

public class PDFCanvas extends Canvas {


   private PDFRenderer renderer;
    double dragStartMouseX;
    double dragStartMouseY;
    double pdfX;
    double pdfY;
    int page;
    int pdfScale;
    BufferedImage image;
    FXGraphics2D g2;

    public PDFCanvas(PDDocument doc, int page, int scale){

        renderer = new PDFRenderer(doc);
        this.pdfScale = scale;
        this.page = page;

        /*
        setOnMousePressed(e -> {
            dragStartMouseX = e.getSceneX();
            dragStartMouseY = e.getSceneY();
            getScene().setCursor(Cursor.CLOSED_HAND);
        });

        setOnMouseReleased(e -> {
            double offsetX = e.getSceneX() - dragStartMouseX;
            double offsetY = e.getSceneY() - dragStartMouseY;
            pdfX = pdfX + offsetX;
            pdfY = pdfY + offsetY;

            getScene().setCursor(Cursor.DEFAULT);
            renderPdf();
        });

    */
    }

    public void reDraw(){
        g2.clearRect(0, 0, (int) getWidth(), (int)getHeight());
        try {
            renderer.renderPageToGraphics(page, g2, pdfScale);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void renderPdf() {
        g2 = new FXGraphics2D(this.getGraphicsContext2D());
        g2.setBackground(Color.white);
        g2.clearRect(0, 0, (int) getWidth(), (int)getHeight());
       // AffineTransform savedAffineTrasform = g2.getTransform();
      //  g2.setTransform(AffineTransform.getTranslateInstance(pdfX, pdfY));

        try {
            renderer.renderPageToGraphics(page, g2, pdfScale);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

              //  g2.setTransform(savedAffineTrasform);

        }

    }

    @Override
    public boolean isResizable() {
        return true;
    }

    @Override
    public double prefWidth(double height) {
        return getWidth();
    }

    @Override
    public double prefHeight(double width) {
        return getHeight();
    }

}
