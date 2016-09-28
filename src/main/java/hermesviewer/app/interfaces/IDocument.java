package hermesviewer.app.interfaces;


import java.io.File;
import java.io.IOException;

public interface IDocument {
    void load(File file) throws IOException;
    void save(File file) throws IOException;
    void close() throws IOException;
}
