import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {
     ProcessBuilder p1 = new ProcessBuilder();
	 p1.command("tasklist");
	 Process pe = p1.start();
	 InputStreamReader ip = new InputStreamReader(pe.getInputStream());
	 BufferedReader br = new  BufferedReader(ip);
	String linea;
	int num = 0;
	while ((linea = br.readLine()) != null) {
		//System.out.println(linea);
		num++;
	}
	System.out.println("Numero de Procesos : " + (num - 4));
	System.out.println(ProcessHandle.allProcesses().count());
	ip.close();
	br.close();
    }
}
