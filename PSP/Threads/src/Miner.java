import java.text.ListFormat.Style;

public class Miner extends Thread{
    String name;

    public Miner (String name){this.name = name;}

@Override 
public  void run()  
{
    for (int i = 0; i < 10; i++){
        System.out.println(name+ " Picando--" + i);
    }
}




}
