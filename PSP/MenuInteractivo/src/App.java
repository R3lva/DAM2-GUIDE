import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
         ArrayList<String> pidlist = new ArrayList<String>();
        while (true) {
            
        System.out.println("--------------------");
        System.out.println("-> Primer Plano ");
        System.out.println("-> Segundo Plano ");
        System.out.println("-> PIDs ");
        System.out.println("-> Exit ");
        System.out.println("--------------------");
        Scanner op = new Scanner(System.in);
            System.out.println("Opcion :");
        int selec = op.nextInt();

        ProcessBuilder p1 = new ProcessBuilder("cmd","/c", "timeout /t 10");

    switch (selec) {
        case 1:
             try {
            p1.inheritIO();
            Process pr = p1.start();
            pidlist.add(String.valueOf(pr.pid()));
            pr.waitFor();
            System.out.println("Espera");
            } catch (Exception e) {}
            break;
       case 2:
             try {
           // p1.inheritIO();
            Process pr = p1.start();
            pidlist.add(String.valueOf(pr.pid()));
            } catch (Exception e) {}
            break;
         case 3:
             try {
           // p1.inheritIO();
            for (String pidname : pidlist) {
                 System.out.println(pidname);
                }
            } catch (Exception e) {}
            break;
         case 4:
             try {
           // p1.inheritIO();
            System.exit(0);
            } catch (Exception e) {}
            break;
        default:
            break;
    }
    }
    }
}
