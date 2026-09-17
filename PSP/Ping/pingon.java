package Ping;

import java.util.Scanner;

public class pingon {
    void main() throws Exception
    {
		Scanner sc = new  Scanner(System.in);
		System.out.println("Direccion:");
		String dir = sc.nextLine();
		ProcessBuilder pb = new ProcessBuilder("cmd","/c","ping",dir);
		Process p = pb.start();
		while (p.isAlive()) {
			System.out.println("Trabajando...");
			Thread.sleep(1000);
		}
		int exit = p.exitValue();
		if (exit == 1)
			System.out.println("Error");
		else
			System.out.println("Proceso Ok");
	}
}
