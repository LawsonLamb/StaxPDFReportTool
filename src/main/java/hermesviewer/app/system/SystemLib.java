package hermesviewer.app.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;

public class SystemLib {
    //-- logging --//
    private static final Logger logger = LoggerFactory.getLogger(SystemLib.class);


    public static String readResourceAsString(Class clazz, String path) throws IOException, URISyntaxException {
        URL url = clazz.getResource(path);
        logger.info("Got URL " + url + " searching for " + path + " from " + clazz);
        return readUrlAsString(url);
    }

    public static String readUrlAsString(URL url) throws IOException, URISyntaxException {
        Path resPath = java.nio.file.Paths.get(url.toURI());
        String result = new String(java.nio.file.Files.readAllBytes(resPath), "UTF8");
        return result;
    }
}
