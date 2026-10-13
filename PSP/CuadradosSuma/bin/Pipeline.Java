import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception 
    {
        ///---------------------
        /// Made By Fernando Relva
        /// Date: 01/10/26
        /// @r3lva
        /// ----------------------
        /// (PIPELINE)
        //...Read Numbers...//
        ProcessBuilder p1 = new ProcessBuilder("C:\\Users\\DAM2\\Desktop\\Curso\\DAM2-GUIDE\\PSP\\CuadradosSuma\\src\\cuadrados.bat");
        ProcessBuilder p2 = new ProcessBuilder("C:\\Users\\DAM2\\Desktop\\Curso\\DAM2-GUIDE\\PSP\\CuadradosSuma\\src\\suma.bat");
        List <Process>  pipeline = ProcessBuilder.startPipeline(List.of(p1,p2));


        System.out.println("Numbers: ");
        String opciones = IO.readln();


        Process ultimoProceso = pipeline.get(pipeline.size() - 1);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(ultimoProceso.getInputStream()))) {
            br.lines().forEach(System::println);
        }
    }
    }
}