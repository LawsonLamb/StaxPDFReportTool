package StaxPDFReportTool.app.view.controller;

import StaxPDFReportTool.app.ReportAppComponent;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import org.apache.pdfbox.debugger.ui.ExtensionFileFilter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.rendering.PDFRenderer;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PDFViewer extends ReportAppComponent implements Initializable {

    @FXML
    BorderPane borderPane;
    @FXML
    MenuBar menuBar;
    @FXML
    Menu fileMenu;
    @FXML
    MenuItem openMenuItem;
    @FXML
    Menu exportMenuBar;
    @FXML
    MenuItem saveAsImageMenuItem;
    @FXML
    MenuItem exitMenuItem;
    @FXML
    AnchorPane documentPanel;
    @FXML
    ScrollPane scrollPane;
    @FXML
    VBox imageVBox;

    ImageView imageView;
    List<ImageView> imageViewList;
    private int currentPage = 0;
    private int numberOfPages = 0;
    private PDFRenderer pdfRenderer;
    private PDDocument pdfDocument;
    private PDPageTree pageTree;
    private String currentFilename = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    public void openMenuItemAction(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file =  fileChooser.showOpenDialog(borderPane.getScene().getWindow());
        if (file != null){
            try {
                openPDFFile(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @FXML
    public void saveAsImageMenuItemAction(ActionEvent event){
        //// TODO: 8/15/16  implment saveasMethod
    }

    @FXML
    public void exitMenuItemAction(ActionEvent event){
        exitApplication();
    }



    public void setupVbox(){
        ImageView view;
      for(int i=0;i<pageTree.getCount();i++){
          view = new ImageView(getImage(i));
          imageVBox.getChildren().add(view);
        // imageViewList.add(view);
      }
    }

    // methods
    private Image getImage(int pageNumber) {
        BufferedImage pageImage;
        try {
            pageImage =pdfRenderer.renderImage(pageNumber,1.0f);
        } catch (IOException ex) {
            throw new UncheckedIOException("PDFRenderer throws IOException", ex);
        }
        return SwingFXUtils.toFXImage(pageImage, null);
    }


    private ImageView createPage(int index){
        ImageView view = new ImageView(getImage(index));
        return view;
    }

    private void openPDFFile(File file) throws Exception
    {
        if (pdfDocument != null)
        {
            pdfDocument.close();
           // documentPanel.removeAll();
            documentPanel.getChildren().removeAll();
        }
             pdfDocument = PDDocument.load(file);
            pdfRenderer = new PDFRenderer(pdfDocument);
            pageTree = pdfDocument.getDocumentCatalog().getPages();
            numberOfPages = pageTree.getCount();
            currentFilename = file.getAbsolutePath();
          //  currentPage = 0;

            setupVbox();

    }

    private void exitApplication()
    {
        try
        {
            if (pdfDocument != null)
            {
               pdfDocument.close();
            }
        }
        catch (IOException io)
        {

        }

    }









}
