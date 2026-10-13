import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Module {
    

    public  static  String check(Trabajo tr)
    {
        String texto = "";
        try {
    String ruta = tr.getSourcePath();
     ProcessBuilder checkr = new ProcessBuilder("C:\\Users\\DAM2\\Desktop\\Curso\\DAM2-GUIDE\\PSP\\ ChapiChapuzas\\src\\check.bat");
     File fr = new File(ruta);
     FileReader fak = new FileReader(fr);
     BufferedReader br = new BufferedReader(fak);
      Process pch = checkr.start();
            String line = br.readAllAsString();
            //-- `Pasar a check.bat
            OutputStream ot =  pch.getOutputStream();
            ot.write(line.getBytes());
            ot.flush();
            ot.close();
        
        InputStreamReader ips = new InputStreamReader(pch.getInputStream());
        BufferedReader br2 = new BufferedReader(ips);
        texto = br2.readAllAsString();
        System.out.println(texto);
        return  texto;
        } catch (Exception e) {
        }
        return  texto;
    }

    public static String translate(Trabajo tr)
    {
               String texto = "";
        try {
    String ruta = tr.getSourcePath();
     ProcessBuilder checkr = new ProcessBuilder("C:\\Users\\DAM2\\Desktop\\Curso\\DAM2-GUIDE\\PSP\\ ChapiChapuzas\\src\\translate.bat ", tr.getLanguage());
     File fr = new File(ruta);
     FileReader fak = new FileReader(fr);
     BufferedReader br = new BufferedReader(fak);
      Process pch = checkr.start();
            String line = br.readAllAsString();
            //-- `Pasar a check.bat
            OutputStream ot =  pch.getOutputStream();
            ot.write(line.getBytes());
            ot.flush();
            ot.close();
        InputStreamReader ips = new InputStreamReader(pch.getInputStream());
        BufferedReader br2 = new BufferedReader(ips);
        texto = br2.readAllAsString();
        System.out.println(texto);
        return  texto;
        } catch (Exception e) {
        }
        return  texto;
    }
}
