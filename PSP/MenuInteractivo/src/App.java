import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Process> pidlist = new ArrayList<Process>();
        Scanner op = new Scanner(System.in);

        while (true) {
            System.out.println("--------------------");
            System.out.println("1. Primer Plano");
            System.out.println("2. Segundo Plano");
            System.out.println("3. PIDs");
            System.out.println("4. Exit");
            System.out.println("--------------------");
            System.out.print("Opcion: ");

            if (!op.hasNextInt()) {
                op.next();
                continue;
            }

            int selec = op.nextInt();
            ProcessBuilder p1 = new ProcessBuilder("cmd", "/c", "timeout /t 10");

            switch (selec) {
                case 1:
                    try {
                        p1.inheritIO();
                        Process pr = p1.start();
                        pidlist.add(pr);
                        pr.waitFor();
                        System.out.println("Espera finalizada");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    try {
                        Process pr = p1.start();
                        pidlist.add(pr);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    try {
                        Iterator<Process> it = pidlist.iterator();
                        while (it.hasNext()) {
                            Process dame = it.next();
                                System.out.println("PID [+] = " + dame.pid());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 4:
                    try {
                        Iterator<Process> it = pidlist.iterator();
                        while (it.hasNext()) {
                            Process dame = it.next();
                            if (dame.isAlive()) {
                                dame.destroy();
                                System.out.println("PID [+] = " + dame.pid() + " - Delete");
                            }
                            it.remove(); 
                        }
                        op.close();
                        System.exit(0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}