package StaxPDFReportTool;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.PDDocument;
import StaxPDFReportTool.app.view.renderer.canvas.ICEPDFCanvas;
import StaxPDFReportTool.app.view.renderer.canvas.PDFCanvas;

import java.io.File;
import java.io.IOException;

public class Main extends Application {
    static Pane pane;
    static int width = 590;
    static  int height = 840;

    @Override
    public void start(Stage primaryStage) throws Exception{
       // FXSceneInit(primaryStage);
      PDFFXSceneInit(primaryStage);
      //  PDFCanvasTest(primaryStage);
       // ICE_TEST(primaryStage);

    }

    private  void FXSceneInit(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("app/view/PDFReportToolScene.fxml"));
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
    }
    private void PDFCanvasTest(Stage primaryStage) throws IOException {

        PDDocument doc = PDDocument.load(new File("StaxPDFReportTool/app/LGS_Business_Personal_Property_Tax_Return_PT50P.pdf"));
        PDFCanvas canvas = new PDFCanvas(doc, 2, 1);
        canvas.widthProperty().addListener(e->canvas.reDraw());
        pane = new Pane();
        canvas.setWidth(width);
        canvas.setHeight(height);
        pane.getChildren().add(canvas);
        canvas.renderPdf();

        Scene scene = new Scene(pane, width, height);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

        canvas.widthProperty().bind(pane.widthProperty());
        canvas.heightProperty().bind(pane.heightProperty());
    }

    private  void ICE_TEST(Stage primaryStage) throws IOException {
        final SwingNode swingNode = new SwingNode();
        pane = new Pane();
        PDDocument doc = PDDocument.load(new File("StaxPDFReportTool/app/LGS_Business_Personal_Property_Tax_Return_PT50P.pdf"));
        ICEPDFCanvas icepdfCanvas = new ICEPDFCanvas("StaxPDFReportTool/app/LGS_Business_Personal_Property_Tax_Return_PT50P.pdf");
        icepdfCanvas.Swing(swingNode);
        pane.getChildren().add(swingNode);
        Scene scene = new Scene(pane, width, height);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void PDFFXSceneInit(Stage primaryStage) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("app/view/PDFView.fxml"));
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
    }





    public static void main(String[] args) {
        launch(args);
    }
}
