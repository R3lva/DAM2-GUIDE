import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class App {
    public static void main(String[] args) throws Exception {
     ProcessBuilder p1 = new ProcessBuilder("tasklist");
      ProcessBuilder p2= new ProcessBuilder("cmd", "/c", "findstr java");
      String salida = "";
	 try {
	Process pe = p1.start();
	 InputStreamReader ip = new InputStreamReader(pe.getInputStream());
	 BufferedReader br = new  BufferedReader(ip);
	{	
	 salida = br.readAllAsString();
     System.out.println(salida);
    }
	 } catch (Exception e) {
		e.printStackTrace();
	 }

      try {
	Process pe = p2.start();
	OutputStream po = pe.getOutputStream();
	OutputStreamWriter w = new OutputStreamWriter(po);
	PrintWriter writer = new PrintWriter(w, true);
	 InputStreamReader ip = new InputStreamReader(pe.getInputStream());
	 BufferedReader br = new  BufferedReader(ip);
	{	
    writer.println(salida);
	writer.close();
	String salida2 = br.readAllAsString();
     System.out.println(salida2);
    }
	 } catch (Exception e) {
		e.printStackTrace();
	 }
    }
}
