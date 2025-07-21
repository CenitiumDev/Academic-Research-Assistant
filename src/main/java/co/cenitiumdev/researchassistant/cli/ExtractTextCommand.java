package co.cenitiumdev.researchassistant.cli;

import co.cenitiumdev.researchassistant.service.PdfReaderService;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(
        name = "extract-text",
        description = "Extrae todo el texto de un archivo PDF y lo imprime en la consola."
)
public class ExtractTextCommand implements Callable<Integer> {

    @Parameters(
            index = "0",
            description = "La ruta al archivo PDF del cual se extraerá el texto."
    )
    private String filePath;

    @Override
    public Integer call() {
        System.out.println("Extrayendo texto de: " + filePath);
        PdfReaderService readerService = new PdfReaderService();
        try {
            String text = readerService.extractText(filePath);
            System.out.println("--- INICIO DEL TEXTO ---");
            System.out.println(text);
            System.out.println("--- FIN DEL TEXTO ---");
            return 0;
        } catch (Exception e) {
            System.err.println("❌ Error al leer el archivo PDF: " + e.getMessage());
            return 1;
        }
    }
}
