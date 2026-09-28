import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class App {
	///
	/// Contador de palabras en archivos///
	/// Made by Fernando Relva 
	/// Date: 24/09/2026
	/// github: @r3lva
	/// Description: Count the words in archives.
    /// Exercise:
	/// 
    /*En el aula virtual encontrarás un shell script llamado contar_palabras.sh que recibe
    como argumentos un archivo de texto y una palabra, y devuelve el número de apariciones
    de esa palabra en el archivo.
    Escribe un programa en Java que utilice procesos para contar el número de apariciones de
    una determinada palabra en varios archivos de texto diferentes.
    Cada proceso debe escribir su resultado en un fichero llamado resultados.txt. Una vez
    que todos los procesos hayan terminado, el programa Java debe leer el fichero
    resultados.txt, sumar el número total de apariciones de la palabra en todos los
    archivos procesados, e imprimir el total por consola */

    //... Funcion contar -- Usage: Cuenta las palabras return (int) ...///
    public  static  int contar(String archiv) throws IOException, InterruptedException
    {
    ///--- Declarations ---///
    ProcessBuilder p1 = new ProcessBuilder("cmd", "/c", ".\\contar_palabras.bat", archiv, "fernando");
    p1.directory(new File("C:\\Users\\DAM2\\Desktop\\Curso\\DAM2-GUIDE\\PSP\\ContadorApariciones\\src"));
    Process pr = p1.start();
    InputStreamReader is = new InputStreamReader(pr.getInputStream());
    BufferedReader br = new BufferedReader(is);
    int num1 = Integer.parseInt(br.readAllAsString().trim());
    int codigo = pr.waitFor();
    //... Return Int ...//
    return num1;
    }
    public static void main(String[] args) throws Exception {
    ///--- Declarations ---///
    int total = contar("prueba.txt") + contar("prueba2.txt") ;
    File fr = new  File("C:\\Users\\DAM2\\Desktop\\Curso\\DAM2-GUIDE\\PSP\\ContadorApariciones\\src\\resultado.txt");
    FileWriter fw = new FileWriter(fr);
    BufferedWriter bw = new BufferedWriter(fw);

    //... Write on TXT ...//
    bw.write(Integer.toString(total));
    System.out.println(contar("prueba.txt") + contar("prueba2.txt"));
    bw.close();

	/// ----------------Final...-------------------- ///
    }
}
