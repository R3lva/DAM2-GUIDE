import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class app {
    public static void main(String[] args) throws Exception {
		/*Thread.activeCount();
		Thread.currentThread();
		Thread.sleep(500);*/

		ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		Suma sumar = new Suma(lista);
		Multiplicacion multi = new Multiplicacion(lista);
		sumar.start();
		multi.start();
		sumar.join();
		multi.join();
		System.out.println(multi.getResultado() - sumar.getResultado());

    }
}
