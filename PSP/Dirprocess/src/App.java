import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class App {
    public static void main(String[] args) throws Exception {
     ProcessBuilder p1 = new ProcessBuilder("cmd");
	 String comando = IO.readln();
	 try {
	Process pe = p1.start();
	OutputStream po = pe.getOutputStream();
	OutputStreamWriter w = new OutputStreamWriter(po);
	PrintWriter writer = new PrintWriter(w, true);
	 InputStreamReader ip = new InputStreamReader(pe.getInputStream());
	 BufferedReader br = new  BufferedReader(ip);
	{	
	writer.println(comando);
	String linea;
	while ((linea = br.readLine()) != null) {
	System.out.println(linea);
	}}
	 } catch (Exception e) {
		e.printStackTrace();
	 }
    }
}
