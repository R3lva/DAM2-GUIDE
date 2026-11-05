import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class app {
    public static void main(String[] args) throws Exception {
/* 
Made by : R3lva
Date: 26/10/2026	
Implementa un programa en Java que calcule la media de un array de números enteros,
utilizando hilos. El número de hilos que se deben utilizar será especificado por el usuario. El
trabajo se debe dividir equitativamente entre los hilos, y cada hilo calculará la suma de una
porción del array. Al final, la media total del array se deberá calcular a partir de las sumas
parciales obtenidas por cada hilo*/

		ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		Module sumar = new Module(lista);
		Multiplicacion multi = new Multiplicacion(lista);
		sumar.start();
		multi.start();
		sumar.join();
		multi.join();
		System.out.println(multi.getResultado() - sumar.getResultado());

    }
}
