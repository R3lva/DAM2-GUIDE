import java.util.Scanner;

public  class CreateProcess {	
	void	main() throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		int op = sc.nextInt();
		/*ProcessBuilder pb = new ProcessBuilder("cmd" ,"/c", "mkdir Carpeta && echo hola > prueba");// 1 Solo proceso 2 comandos */
		switch (op) {
			case 1:
				System.out.println("Que Carpeta quieres crear (nombre)");
				sc.nextLine();
				String dir = sc.nextLine();
				ProcessBuilder pb = new ProcessBuilder("cmd" ,"/c", "mkdir", dir);
				pb.start();
				break;
			case 2:
				System.out.println("Que archivo quieres crear (nombre)");
				sc.nextLine();
				String arch = sc.nextLine();
				ProcessBuilder pb2 = new ProcessBuilder("cmd" ,"/c", "echo hola >", arch);
				pb2.start();
				break;
			default:
				break;
		}
		
    }
}