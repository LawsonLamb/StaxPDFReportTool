package hermesviewer.app;

import hermes.report.ReportField;
import hermes.report.pdmodel.ReportDocument;
import hermesviewer.app.model.ViewTabModel;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class ReportModel extends ReportAppComponent {


    //-- logging --//
    private static final Logger logger = LoggerFactory.getLogger(ReportModel.class);

    //-- properties --//

    private ViewTabModel reportViewerModel;
    private ReportDocument PDDocumentFX;

    //-- constructors --//
    public ReportModel() {
        PDDocumentFX = new ReportDocument();
        reportViewerModel = new ViewTabModel();


    }

    public ViewTabModel reportViewerModel( ){

        return reportViewerModel;
    }

    public ReportDocument reportDocument(){
        return PDDocumentFX;
    }


    public void exportToXmlMapping() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory dbFactory =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();
        // root element
        Element rootElement = doc.createElement("root");
        doc.appendChild(rootElement);
        for (ReportField reportField:PDDocumentFX.getReportFieldObservableList()) {

            Element child = doc.createElement(reportField.getPartialName());
            System.out.println(reportField.getPartialName());
            child.setAttribute("id",reportField.getMappingName());
            rootElement.appendChild(child);


        }


        // write the content into xml file
        TransformerFactory transformerFactory =
                TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        //StreamResult result = new StreamResult(new File("C:\\cars.xml"));
       // transformer.transform(source, result);
        // Output to console for testing
        StreamResult consoleResult =
                new StreamResult(System.out);
        transformer.transform(source, consoleResult);
    }









}
