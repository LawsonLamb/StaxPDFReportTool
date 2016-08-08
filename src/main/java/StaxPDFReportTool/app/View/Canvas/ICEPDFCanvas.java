package StaxPDFReportTool.app.View.Canvas;
import javafx.embed.swing.SwingNode;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.icepdf.ri.util.FontPropertiesManager;
import org.icepdf.ri.util.PropertiesManager;

import javax.swing.*;

import java.util.ResourceBundle;
public class ICEPDFCanvas {

    String filePath ="";
    public ICEPDFCanvas(  String filepath){
        filePath = filepath;
    }

    public void Swing(SwingNode swingNode){

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // build a component controller
                SwingController controller = new SwingController();
                controller.setIsEmbeddedComponent(true);

                PropertiesManager properties = new PropertiesManager(
                        System.getProperties(),
                        ResourceBundle.getBundle(PropertiesManager.DEFAULT_MESSAGE_BUNDLE));

                // read/store the font cache.
                ResourceBundle messageBundle = ResourceBundle.getBundle(
                        PropertiesManager.DEFAULT_MESSAGE_BUNDLE);
                new FontPropertiesManager(properties, System.getProperties(), messageBundle);

                properties.set(PropertiesManager.PROPERTY_DEFAULT_ZOOM_LEVEL, "1.25");

                SwingViewBuilder factory = new SwingViewBuilder(controller, properties);

                // add interactive mouse link annotation support via callback
                controller.getDocumentViewController().setAnnotationCallback(
                        new org.icepdf.ri.common.MyAnnotationCallback(controller.getDocumentViewController()));
                JPanel viewerComponentPanel = factory.buildViewerPanel();
               // JFrame applicationFrame = new JFrame();
                swingNode.setContent(viewerComponentPanel);
               // applicationFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
               // applicationFrame.getContentPane().add(viewerComponentPanel);
                // Now that the GUI is all in place, we can try openning a PDF
                controller.openDocument(filePath);

                // add the window event callback to dispose the controller and
                // currently open document.
              //  applicationFrame.addWindowListener(controller);

                // show the component
               // applicationFrame.pack();
               // applicationFrame.setVisible(true);
            }
        });
    }
}
