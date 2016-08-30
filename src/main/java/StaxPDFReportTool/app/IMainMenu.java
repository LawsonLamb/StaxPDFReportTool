package StaxPDFReportTool.app;

import javafx.scene.Node;

import java.io.IOException;

public interface IMainMenu {
    void Open(Node node) throws IOException;
    void Save(Node node);
    void SaveAs(Node node);
}
