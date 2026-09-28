import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class App {
	/// Never Gonna Give You Up (Proceso Guardian)///
	/// Made by Fernando Relva 
	/// Date: 24/09/2026
	/// github: @r3lva
	/// Description: Start firefox process if  him not opened yet.
    public static void main(String[] args) throws Exception {
    ///--- Declarations ---///
    ProcessBuilder p1 = new ProcessBuilder("tasklist");
    ProcessBuilder p2= new ProcessBuilder("cmd", "/c", "findstr firefox");
    ProcessBuilder p3= new ProcessBuilder("cmd", "/c", "start firefox https://www.youtube.com/watch?v=dQw4w9WgXcQ&list=RDdQw4w9WgXcQ&start_radio=1");
    String salida = "";
    ///... Bucle ...///
	while (true) {
	///... Tasklist ...///
	 try {
		Process pe = p1.start();
	 	InputStreamReader ip = new InputStreamReader(pe.getInputStream());
	 	BufferedReader br = new  BufferedReader(ip);
	{
		salida = br.readAllAsString();
	}
	 } catch (Exception e) {
		e.printStackTrace();
	 }
	 ///... findstr firefox && start firefox ... ///
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
     	//System.out.println(salida2); ///... Print
     if (salida2.isEmpty())
        p3.start();

    }
	 } catch (Exception e) {
		e.printStackTrace();
	 }
	// ... Thread Seleep --- Usage: This optimize the code ... /// 
	Thread.sleep(1000);
    }
    }
	/// ----------------Final...-------------------- ///
}
