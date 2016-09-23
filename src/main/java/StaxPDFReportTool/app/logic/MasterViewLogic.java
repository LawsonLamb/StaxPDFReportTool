package StaxPDFReportTool.app.logic;


import StaxPDFReportTool.app.model.pdf.IMainMenu;
import StaxPDFReportTool.app.ReportAppComponent;
import StaxPDFReportTool.app.model.pdf.ReportDocument;
import StaxPDFReportTool.app.view.controller.ViewTabController;
import javafx.scene.Node;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class MasterViewLogic extends ReportAppComponent implements IMainMenu{

    private String currentFilename = null;
    @Override
    public void Open(Node node) throws IOException {
        File file =  createFileChooser(node,"Open PDF ");
        if (file != null){
            viewTabController().Load(file);
            app().view().editTabController().Open();
            app().view().editTabController().propertyViewController.Open();
        }
    }

    @Override
    public void Save(Node node) {
        // TODO: 8/28/16 Save Logic
    }

    @Override
    public void SaveAs(Node node) {
        // TODO: 8/28/16 SaveAs Logic
    }


    public File createFileChooser(Node node, String title){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(title);
//         fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter(".pdf"));
        return fileChooser.showOpenDialog(node.getScene().getWindow());
    }

    public File createFileChooser(Node node, String title, FileChooser.ExtensionFilter extensionFilter){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(title);
        fileChooser.setSelectedExtensionFilter(extensionFilter);
        return fileChooser.showOpenDialog(node.getScene().getWindow());
    }

    public ReportDocument documentModel(){
        return app().model().reportDocument();
    }

    public ViewTabController viewTabController(){

        return app().view().viewTabController();
    }
}
