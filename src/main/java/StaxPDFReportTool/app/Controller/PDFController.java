package StaxPDFReportTool.app.Controller;
import StaxPDFReportTool.app.View.Field.CheckBoxListView;
import StaxPDFReportTool.app.View.Field.TextFieldListView;
import javafx.scene.canvas.Canvas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.jfree.fx.FXGraphics2D;


import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PDFController implements Initializable {

// FXML
    @FXML
    private TextField PartialNameTextField;
    @FXML
    private TextField MappingNameTextField;
    @FXML
    private TitledPane TextFieldPane;
    @FXML
    private TitledPane FieldPane;
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
   TextFieldListView textFieldListView;
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
            pdDocument =  PDDocument.load(new File("StaxPDFReportTool/app/LGS_Business_Personal_Property_Tax_Return_PT50P.pdf"));
            pdDocumentCatalog = pdDocument.getDocumentCatalog();
            acroForm =  pdDocumentCatalog.getAcroForm();
            createPDFCanvas(pdDocument);
            checkBoxListView = new CheckBoxListView();
            textFieldListView = new TextFieldListView();
            checkBoxListView.Setup(acroForm);
            textFieldListView.Setup(acroForm);

            textFieldList.setOnMouseClicked(e->UpdateTextFields());
            textFieldList.itemsProperty().bind(textFieldListView.itemsProperty());
            checkBoxList.itemsProperty().bind(checkBoxListView.itemsProperty());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void UpdateTextFields(){

        int index = textFieldList.getSelectionModel().getSelectedIndex();
        index = getFieldbyName( textFieldList.getItems().get(index));
        PDField field =  acroForm.getFields().get(index);
        PartialNameTextField.setText(field.getPartialName());

    }

    public int getFieldbyName(String Name){
        List<PDField> fieldList = acroForm.getFields();
        for(int i=0;i<fieldList.size();i++){

          if(Name.equals(fieldList.get(i).getPartialName())){
              return i;
          }

        }
        return -1;
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
