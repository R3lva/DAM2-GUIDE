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
        //...Read Numbers...//
        System.out.println("Numbers: ");
        String opciones = IO.readln();
        ///...Array Concat...
        String[] argsfirst = ("C:\\Users\\DAM2\\Desktop\\Curso\\DAM2-GUIDE\\PSP\\CuadradosSuma\\src\\cuadrados.bat "
        + opciones).split(" ");
        //................................//
        /// --/// First Output
        ProcessBuilder p1 = new ProcessBuilder(argsfirst);
        Process pr = p1.start();
        InputStreamReader ip = new InputStreamReader(pr.getInputStream());
        BufferedReader br = new BufferedReader(ip);
        String linea = br.readAllAsString();
        linea = linea.replaceAll("[\\r\\n]+", " ").trim();
        System.out.println("Cuadrados.bat: ");
        System.out.println(linea);
        ///-----------------------------------
        /// --/// Second Output
        System.out.println("Suma.bat:");
        ///...Array Concat...
        String[] argsSuma = ("C:\\Users\\DAM2\\Desktop\\Curso\\DAM2-GUIDE\\PSP\\CuadradosSuma\\src\\suma.bat "
        + linea).split(" ");
        ProcessBuilder p2 = new ProcessBuilder(argsSuma);
        Process pr2 = p2.start();
        InputStreamReader ip2 = new InputStreamReader(pr2.getInputStream());
        BufferedReader br2 = new BufferedReader(ip2);
        System.out.println(br2.readAllAsString());
        ///-----------------------------------
    }
    ///----------------Final.-------------------
}