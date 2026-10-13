import java.nio.file.Files;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) throws Exception {
        Trabajo tr = new Trabajo("C:\\Users\\DAM2\\Desktop\\Curso\\DAM2-GUIDE\\PSP\\ ChapiChapuzas\\src\\disc.txt","-es","C:\\Users\\DAM2\\Desktop\\Curso\\DAM2-GUIDE\\PSP\\ChapiChapuzas\\src\\disc2.txt");
        Module md = new Module();
        String cr = md.check(tr);
        String trans = md.translate(tr);
       


    }
}
