package StaxPDFReportTool.app.Model;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;

public class ReportEditModel {


  private PDDocument document;

  private ReportFieldList fieldList;

  public ReportEditModel( PDDocument Document){
    this.document = Document;
    fieldList = new ReportFieldList(document.getDocumentCatalog().getAcroForm());

    }

  public ReportEditModel(File fileName) throws IOException {
    this.document = PDDocument.load(fileName);
    fieldList = new ReportFieldList(document.getDocumentCatalog().getAcroForm());

  }
  public ReportEditModel(String FileName) throws IOException {
    this.document = PDDocument.load(new File(FileName));
    fieldList = new ReportFieldList(document.getDocumentCatalog().getAcroForm());
  }

  public ReportFieldList getFieldList(){
    return fieldList;
  }
  public void setFieldList(ReportFieldList field) {
    fieldList = field;
  }

  public PDDocument getDocument(){
    return document;
  }
  public void setDocument(PDDocument Document){
    document = Document;
  }



}
