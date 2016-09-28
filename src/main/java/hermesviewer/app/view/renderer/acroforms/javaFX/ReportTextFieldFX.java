package hermesviewer.app.view.renderer.acroforms.javaFX;

import javafx.geometry.Point2D;
import javafx.scene.control.TextField;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextField;

public class ReportTextFieldFX extends TextField   {

    PDRectangle rectangle;
    PDAnnotationWidget annotationWidget;

    double posX;
    double posY;

    public ReportTextFieldFX(PDField field){

        annotationWidget = field.getWidgets().get(0);
        rectangle = annotationWidget.getRectangle();
        posX = MidPoint(rectangle.getLowerLeftX(),rectangle.getUpperRightX());
        posY = MidPoint(rectangle.getLowerLeftY(),rectangle.getUpperRightY());
        Point2D p = this.localToScene(0.0, 0.0);

        this.setTranslateX(posX);
        this.setTranslateX(posY);

        this.setMinWidth(10);
        this.setMinHeight(rectangle.getHeight());
       // Point2D pos =  Convert(this.localToScene(0,0),this);
        System.out.println(posX);
        System.out.println(posY);


    }

    public ReportTextFieldFX(PDTextField textField){
        annotationWidget = textField.getWidgets().get(0);
        rectangle = annotationWidget.getRectangle();
        posX = MidPoint(rectangle.getLowerLeftX(),rectangle.getUpperRightX());
        posY = MidPoint(rectangle.getLowerLeftY(),rectangle.getUpperRightY());
        Point2D p = this.localToScene(0.0, 0.0);
        this.setTranslateX(posX);
        this.setTranslateX(posY);
        //Point2D pos =  Convert(this.localToScene(0,0),this);
        System.out.println(posX);
        System.out.println(posY);
    }



    public double MidPoint(double x,double y){

        return ((x+y)/2);

    }
}



