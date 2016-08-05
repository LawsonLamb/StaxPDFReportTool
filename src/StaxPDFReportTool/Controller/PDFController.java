package StaxPDFReportTool.Controller;
import StaxPDFReportTool.View.Field.CheckBoxListView;
import StaxPDFReportTool.View.Field.TextFieldListView;
import javafx.scene.canvas.Canvas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ScrollPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.jfree.fx.FXGraphics2D;


import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PDFController implements Initializable {
// FXML
    @FXML
    private TitledPane TextFieldPane;
    @FXML
    private TitledPane  FieldPane;
    @FXML
    private TitledPane CheckBoxPane;
    @FXML
    private ListView<String> textFieldList;
    @FXML
    private  ListView<String> checkBoxList;
    @FXML
    private AnchorPane pdfAnchorPane;
    @FXML
    private Canvas pdfCanvas;

    private CheckBoxListView checkBoxListView;
    // other variables
    private int pageIndex =2;
    private float pageScale =1;
    private PDFRenderer renderer;
    private PDDocument pdDocument;
    private FXGraphics2D g2;
    private PDAcroForm acroForm;
    private PDDocumentCatalog pdDocumentCatalog;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            pdDocument =  PDDocument.load(new File("LGS_Business_Personal_Property_Tax_Return_PT50P.pdf"));
            pdDocumentCatalog = pdDocument.getDocumentCatalog();
            acroForm =  pdDocumentCatalog.getAcroForm();
            createPDFCanvas(pdDocument);
            CheckBoxListView checkBoxListView = new CheckBoxListView(acroForm);
            TextFieldListView textFieldListView = new TextFieldListView(acroForm);
                    textFieldList.itemsProperty().bind(textFieldListView.itemsProperty());
                    checkBoxList.itemsProperty().bind(checkBoxListView.itemsProperty());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void createPDFCanvas(PDDocument document){

        renderer = new PDFRenderer(document);
        g2 = new FXGraphics2D(pdfCanvas.getGraphicsContext2D());
        g2.setBackground(Color.white);


        pdfCanvas.widthProperty().addListener(e->DrawPDF());
        pdfCanvas.heightProperty().addListener(e->DrawPDF());
        pdfCanvas.widthProperty().bind(pdfAnchorPane.widthProperty());
        pdfCanvas.heightProperty().bind(pdfAnchorPane.heightProperty());
      //  g2.clearRect(0, 0, (int) pdfCanvas.getWidth(), (int)pdfCanvas.getWidth());


    }


    public void DrawPDF() {
        try {

           // g2.clearRect(0, 0, (int) pdfCanvas.getWidth(), (int)pdfCanvas.getWidth());
         //   g2.fillRect(0,0,(int) pdfCanvas.getWidth(), (int)pdfCanvas.getWidth());
            renderer.renderPageToGraphics(pageIndex, g2, pageScale);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
