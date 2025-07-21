package co.cenitiumdev.researchassistant;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import java.util.concurrent.Callable;

@Command(
        name = "assistant",
        version = "Asistente de Investigación v1.0",
        description = "Una herramienta CLI para analizar documentos académicos con IA.",
        mixinStandardHelpOptions = true
)
public class App implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("✅ Asistente de Investigación listo. Usa --help para ver los comandos.");
        return 0;
    }

    public static void main( String[] args ) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

}
