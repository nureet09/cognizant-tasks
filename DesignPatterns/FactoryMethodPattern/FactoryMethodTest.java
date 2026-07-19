package DesignPatterns.FactoryMethodPattern;

public class FactoryMethodTest {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        System.out.println("--- Testing Document Creation via Factory Method ---");
        wordFactory.openDocument();
        pdfFactory.openDocument();
        excelFactory.openDocument();
    }
}