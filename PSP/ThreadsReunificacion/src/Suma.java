import java.text.ListFormat.Style;
import java.util.ArrayList;

public class Suma extends Thread{
    ArrayList <Integer> lista;
    int resultado = 0;
    public Suma (ArrayList <Integer> lista){this.lista = lista;}

@Override 
public  void run()  
{
    int suma = 0;
    for (int i = 0; i < lista.size()-1; i++){
        suma = suma + lista.get(i);
    }
    resultado = suma;
}

public int getResultado() {
    return resultado;
}




}
