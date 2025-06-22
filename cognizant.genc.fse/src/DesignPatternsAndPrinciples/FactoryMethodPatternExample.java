package DesignPatternsAndPrinciples;

import java.util.Scanner;

// This code follows both the Factory Method Pattern and the Single Responsibility Principle (SRP)

abstract class Document {
    public String content;

    public abstract boolean verifyContent(Document doc);

    void save(Document doc) {
        System.out.println("Document has been successfully saved.");
    }
}

// Concrete document types
class WORDDocument extends Document {
    @Override
    public boolean verifyContent(Document doc) {
        System.out.println("Verifying content for Word document...");
        System.out.println("Content is valid.");
        return true;
    }
}

class PDFDocument extends Document {
    @Override
    public boolean verifyContent(Document doc) {
        System.out.println("Verifying content for PDF document...");
        System.out.println("Content is verified.");
        return true;
    }
}

class EXCELDocument extends Document {
    @Override
    public boolean verifyContent(Document doc) {
        System.out.println("Verifying content for Excel document...");
        System.out.println("Document content: ");
        System.out.println(doc.content);
        System.out.println("Excel document content is valid.");
        return true;
    }
}

// Factory classes for each document type
abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordDocumentCreater extends DocumentFactory {
    @Override
    public Document createDocument() {
        System.out.println("Creating a Word document...");
        return new WORDDocument();
    }
}

class PdfDocumentCreater extends DocumentFactory {
    @Override
    public Document createDocument() {
        System.out.println("Creating a PDF document...");
        return new PDFDocument();
    }
}

class ExcelDocumentCreater extends DocumentFactory {
    @Override
    public Document createDocument() {
        System.out.println("Creating an Excel document...");
        return new EXCELDocument();
    }
}

// Factory Method Pattern use case:
// Useful when we have logic like verification, authorization, memory checks,
// or different construction steps for each document type.
// This avoids modifying existing source code and keeps creation logic decoupled
// from the client. The client interacts only with interfaces and concrete classes.

public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        System.out.println("Document Management System Started");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose document type: 1. Word  2. PDF  3. Excel");
        int choice = scanner.nextInt();
        DocumentFactory factory = null;

        switch (choice) {
            case 1:
                factory = new WordDocumentCreater();
                break;
            case 2:
                factory = new PdfDocumentCreater();
                break;
            case 3:
                factory = new ExcelDocumentCreater();
                break;
            default:
                System.out.println("Invalid choice.");
                System.exit(0);
        }

        Document doc = factory.createDocument();
        doc.content = "This is a document containing sensitive and structured information.";
        if (doc.verifyContent(doc)) {
            doc.save(doc);
        } else {
            System.out.println("Document verification failed. Cannot save.");
        }

        scanner.close();
        System.out.println("Document workflow completed.");
    }
}
/*
Additional Note:
For small-scale projects or where document creation is straightforward,
we can avoid creating multiple factory classes and simply use:

Map<String, Supplier<Document>> factoryMap = new HashMap<>();
factoryMap.put("WORD", () -> new WORDDocument());
factoryMap.put("PDF", () -> new PDFDocument());
factoryMap.put("EXCEL", () -> new EXCELDocument());
and we can simply say like factoryMap.get("WORD") gets the call back and simply call .get() with the supplier interface to get the instance
This keeps things concise without increasing the number of classes unnecessarily.
Choose the pattern that fits the scale and complexity of your application.
*/
