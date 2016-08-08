package StaxPDFReportTool.app.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.awt.image.BufferedImage;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.jfree.fx.FXGraphics2D;



public class Controller implements Initializable {
    @FXML
    private ListView<String> viewPDFList;
    @FXML
    private Canvas viewPDFPage;

    private PDDocument document;
    private PDFRenderer renderer;
    double dragStartMouseX;
    double dragStartMouseY;
    double pdfX;//PDF描画の起点（X座標）
    double pdfY;//PDF描画の起点（Y座標）
    FXGraphics2D g2;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {

            document = PDDocument.load(new File("StaxPDFReportTool/app/LGS_Business_Personal_Property_Tax_Return_PT50P.pdf"));
            DrawPDFView(document);
            DrawList(document);
          document.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void redrawPDF(){

        g2 = new FXGraphics2D(viewPDFPage.getGraphicsContext2D());
      //  g2.fillRect(0,0,(int)viewPDFPage.getWidth(),(int)viewPDFPage.getHeight());
    //    viewPDFPage.getGraphicsContext2D().fillRect(0, 0, viewPDFPage.getWidth(), viewPDFPage.getHeight());
        g2.setBackground(Color.white);
        try {
            renderer.renderPageToGraphics(2, g2, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void OnMouseEntered(){
        redrawPDF();

    }


    private void DrawPDFView(PDDocument document) throws IOException {

        renderer = new PDFRenderer(document);
        g2 = new FXGraphics2D(viewPDFPage.getGraphicsContext2D());
        viewPDFPage.getGraphicsContext2D().clearRect(0, 0, viewPDFPage.getBoundsInParent().getWidth(), viewPDFPage.getHeight());
        g2.setBackground(Color.white);
        renderer.renderPageToGraphics(2, g2, 2);
        viewPDFPage.isResizable();
        viewPDFPage.widthProperty().addListener(observable -> redrawPDF());
        viewPDFPage.heightProperty().addListener(observable -> redrawPDF());


    }

    private void DrawList(PDDocument document){

        PDAcroForm form = document.getDocumentCatalog().getAcroForm();
        List<PDField> fields = form.getFields();
        ArrayList<String> names = new ArrayList<>();
        for(int i=0;i<fields.size();i++){

            names.add(fields.get(i).getPartialName());
        }
        ObservableList<String> display = FXCollections.observableArrayList(names);
        viewPDFList.setItems(display);


    }

    public ListView<String> getViewPDFList() {
        return viewPDFList;
    }

    public void setViewPDFList(ListView<String> viewPDFList) {
        this.viewPDFList = viewPDFList;
    }
    int numPages() {
        return document.getPages().getCount();
    }
    Image getImage(int pageNumber) {
        BufferedImage pageImage = null;

        try {
            pageImage = renderer.renderImage(pageNumber);
           
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SwingFXUtils.toFXImage(pageImage, null);

    }
}


