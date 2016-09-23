package StaxPDFReportTool.app.logic;
import StaxPDFReportTool.app.ReportAppComponent;
import StaxPDFReportTool.app.model.ViewTabModel;
import StaxPDFReportTool.app.view.controller.ViewTabController;
import StaxPDFReportTool.app.view.controller.ReportViewComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ViewTabLogic extends ReportAppComponent{

    //-- logging --//
    private static final Logger logger = LoggerFactory.getLogger(ViewTabLogic.class);

    //-- properties --//

    public ViewTabModel viewTabModel(){return   app().model().reportViewerModel();}
    public ViewTabController viewTabViewComponent(){return app().view().viewTabController();}


}
