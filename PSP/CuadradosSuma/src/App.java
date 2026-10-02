import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {

        ///---------------------
        /// Made By Fernando Relva
        /// Date: 01/10/26
        /// @r3lva
        /// 
        /// ----------------------
        /// 
        /// --/// First Output
        ProcessBuilder p1 = new ProcessBuilder("C:\\Users\\DAM2\\Desktop\\Curso\\DAM2-GUIDE\\PSP\\CuadradosSuma\\src\\cuadrados.bat","1","2","3");
        Process pr = p1.start();
        InputStreamReader ip = new InputStreamReader(pr.getInputStream());
        BufferedReader br = new BufferedReader(ip);
        String linea = br.readAllAsString().trim();
        System.out.println(linea);
        ProcessBuilder p2 = new ProcessBuilder("C:\\Users\\DAM2\\Desktop\\Curso\\DAM2-GUIDE\\PSP\\CuadradosSuma\\src\\suma.bat",linea);
           Process pr2 = p2.start();
        InputStreamReader ip2 = new InputStreamReader(pr2.getInputStream());
        BufferedReader br2 = new BufferedReader(ip2);
        System.out.println(br2.readAllAsString());
    }
}
