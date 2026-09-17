package ProgramacionProcesos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.stream.Stream;

public class Guardian {
    void main() throws Exception
    {
		Scanner sc = new  Scanner(System.in);
		ProcessBuilder pb = new ProcessBuilder("tasklist");
		Process p = pb.start();
		InputStream ips = p.getInputStream();
		InputStreamReader ir = new InputStreamReader(ips);
		BufferedReader readers = new BufferedReader(ir);
		String linea;
		Boolean active = false;
		while ((linea = readers.readLine()) != null ) {
			System.out.println(linea);
			if (linea.contains("firefox"))
				active = true;
	}
	}
	if (active == false)
		ProcessBuilder pb2 = new ProcessBuilder("cmd","/c","start", "firefox" ,"google.com");
		pb2.start();
			
}
