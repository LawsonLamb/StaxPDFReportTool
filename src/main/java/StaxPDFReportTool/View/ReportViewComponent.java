package StaxPDFReportTool.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Abstract superclass for view components, which loads and stores
 * both the JavaFX view and viewController.
 *
 * @author Paul Reavis
 *
 * @param <T> type of view controller
 */
public class ReportViewComponent<T> {

    //-- logging --//
    private static final Logger logger = LoggerFactory.getLogger(ReportViewComponent.class);

    //-- properties --//
    private String name;
    private final Scene scene;
    private final Parent view;
    private final T controller;

    //-- constructors --//
    /**
     * Creates and loads the view from a FXML file with the same basename in the view package.
     * @param name base name of FXML file
     * @throws IOException if it cannot load the file
     */
    public ReportViewComponent(String name) throws IOException {
        this.name = name;

        logger.info("Loading FXML for " + name);
        FXMLLoader fxmlLoader = new FXMLLoader();
        view = fxmlLoader.load(getClass().getResource(name + ".fxml").openStream());
        controller = fxmlLoader.getController();
        scene = new Scene(view, 800, 600);
    }

    //-- Object homework --//
    @Override
    public String toString() {
        return name;
    }

    //-- accessors --//
    public String name() {
        return name;
    }

    public Scene scene() {
        return scene;
    }

    public Parent view() {
        return view;
    }

    public T controller() {
        return controller;
    }
}
