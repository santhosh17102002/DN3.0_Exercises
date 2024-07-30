package exercise2;

import java.util.Scanner;

public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the type of document to create (Word, PDF, Excel): ");
        String documentType = scanner.nextLine();

        DocumentFactory factory;

        switch (documentType.toLowerCase()) {
            case "word":
                factory = new WordDocumentFactory();
                break;
            case "pdf":
                factory = new PdfDocumentFactory();
                break;
            case "excel":
                factory = new ExcelDocumentFactory();
                break;
            default:
                System.out.println("Unknown document type.");
                scanner.close();
                return;
        }

        Document document = factory.createDocument();
        document.open();
        document.save();
        document.close();

        scanner.close();
    }
}
