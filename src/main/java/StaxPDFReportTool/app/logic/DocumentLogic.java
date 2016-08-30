package StaxPDFReportTool.app.logic;


import StaxPDFReportTool.app.ReportAppComponent;
import StaxPDFReportTool.app.model.pdf.ReportDocument;
import StaxPDFReportTool.app.model.pdf.ReportField;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;

public class DocumentLogic extends ReportAppComponent {


    private String currentFilename = null;
    private int numberOfPages;
    //-- constructors --//
    public void Load(File file,Pane pane) throws IOException {
        PDDocument document = documentModel().getPdDocument();
        if (document != null) {
            document.close();
            pane.getChildren().removeAll();
        }
    }

    public Image getImage(int pageNumber) {
        PDFRenderer pdfRenderer = app().model().reportViewerModel().getRenderer();
        BufferedImage pageImage;
        try {
            pageImage = pdfRenderer.renderImage(pageNumber,1.0f);
        } catch (IOException ex) {
            throw new UncheckedIOException("PDFRenderer throws IOException", ex);
        }
        return SwingFXUtils.toFXImage(pageImage, null);
    }
    public ImageView createPage(int index){
        ImageView view = new ImageView(getImage(index));
        return view;
    }

    public void setupVbox(VBox vBox){
        for (int i = 0; i < numberOfPages; i++) {
            vBox.getChildren().add(createPage(i));
        }
    }
    public void setCellFactory(ListView fieldListView){
        fieldListView.setCellFactory(new Callback<ListView<ReportField>, ListCell<ReportField>>() {
            @Override
            public ListCell<ReportField> call(ListView<ReportField> param) {
                {

                    ListCell<ReportField> cell = new ListCell<ReportField>() {
                        @Override
                        protected void updateItem(ReportField t, boolean bln) {
                            super.updateItem(t, bln);
                            if (t != null) {
                                setText(t.getPartialName());
                            }
                        }

                    };
                    return cell;
                }
            }



        });

    }
    //end

    public ReportDocument documentModel(){
        return app().model().reportDocument();
    }

    public String getCurrentFilename() {
        return currentFilename;
    }

    public void setCurrentFilename(String currentFilename) {
        this.currentFilename = currentFilename;
    }




}
