import java.util.List;
import model.Producto;
import dao.InterfazProductoDAO;
import dao.ProductoDao;

public class App {
    public static void main(String[] args) throws Exception {
    InterfazProductoDAO dao = new ProductoDao("C:\\Users\\DAM2\\Desktop\\Curso\\DAM2-GUIDE\\DataAcces\\Productos\\src\\Productos.dat", ",");
    List<Producto> productos = dao.listarTodosBinario();
    while (true)
    {
    
        System.out.println("------GESTOR-----------");
        System.out.println("------1. Ver Productos");
        System.out.println("------2. Añadir producto");
        System.out.println("------3. Salir");
        System.out.println("------GESTOR-----------");
        String op = IO.readln();
        switch (op) {
            case "1":
                for (Producto p : productos){
                    System.out.println(p.getId()+" - "+p.getNombre()+" - "+p.getPrecio());
                }
                break;
            case "2":
                int id = Integer.parseInt(IO.readln("Introduce el ID\n"));
                String nombre = IO.readln("Introduce el Nombre \n");
                double precio = Double.parseDouble(IO.readln("Introduce el precioi"+"\n"));
                Producto pn = new Producto(id, nombre, precio);
                productos.add(pn);
                dao.guardarTodosBinario(productos);
                break;
                case "3":
                    System.exit(0);
                break;
            default:
                break;
        }
    }
    }

}
