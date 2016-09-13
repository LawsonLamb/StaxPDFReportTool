package StaxPDFReportTool.app.model.pdf;


import java.io.File;
import java.io.IOException;

public interface IDocument {
    void Load(File file) throws IOException;
    void Save(File file) throws IOException;
    void Close() throws IOException;
}