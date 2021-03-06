package hermesviewer.app.logic;
import hermesviewer.app.ReportAppComponent;
import hermesviewer.app.model.ViewTabModel;
import hermesviewer.app.view.controller.ViewTabController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ViewTabLogic extends ReportAppComponent {

    //-- logging --//
    private static final Logger logger = LoggerFactory.getLogger(ViewTabLogic.class);

    //-- properties --//

    public ViewTabModel viewTabModel(){return   app().model().reportViewerModel();}
    public ViewTabController viewTabViewComponent(){return app().view().viewTabController();}


}
