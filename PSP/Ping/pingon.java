package Ping;

import java.util.Scanner;

public class pingon {
    void main() throws Exception
    {
		Scanner sc = new  Scanner(System.in);
		System.out.println("Direccion:");
		String dir = sc.nextLine();
		ProcessBuilder pb = new ProcessBuilder("cmd","/c","ping",dir);
		System.out.println("Trabajando");
		Process p = pb.start();
		int exit = p.waitFor();
		if (exit == 1)
			System.out.println("Error");
		else
			System.out.println("Proceso Ok");
	}
}
