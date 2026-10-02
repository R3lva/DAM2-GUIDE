import dao.db;
import  model.Persona;
public class App {
    public static void main(String[] args) throws Exception {
        db base = new db("C:\\Users\\DAM2\\Desktop\\Curso\\DAM2-GUIDE\\DataAcces\\Binario\\src\\bd.dat");

        System.out.println("MENU ----");
        System.out.println("1.Guardar persona ----");
        System.out.println("2. Leer todo ----");

        String op = IO.readln();
        switch (op) {
            case "1":
                Persona p = new Persona("Fernando", "Prueba@gmail", "contraseña");
                base.GuardarBinario(p);
                break;
                case "2":
                base.leerBinario();
                break;
        
            default:
                break;
        }
    }
}
