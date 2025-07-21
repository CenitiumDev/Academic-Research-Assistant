package co.cenitiumdev.researchassistant.service;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PdfReaderService {

    /**
     * Extrae todo el texto de un archivo PDF.
     *
     * @param filePath la ruta al archivo PDF.
     * @return una cadena con todo el texto del documento.
     * @throws IOException si ocurre un error al leer el archivo.
     */
    public String extractText(String filePath) throws IOException {
        File pdfFile = new File(filePath);

        try (PDDocument document = Loader.loadPDF(pdfFile)) {
            PDFTextStripper textStripper = new PDFTextStripper();
            return textStripper.getText(document);
        }
    }
}
