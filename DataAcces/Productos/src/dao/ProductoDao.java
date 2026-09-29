package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Producto;
///--------- Productos DAO ---------///
/// CREDITS
/// Made by : Fernando Relva Da Silva Marcos
/// Date : 29/09/26
/// ---------------------------------

public class ProductoDao implements InterfazProductoDAO{
    //...Variables...//
    String ruta, patron;
    


    //...File...//

    public ProductoDao(String ruta, String patron) {
        this.ruta = ruta;
        this.patron = patron;
    }
    @Override 
    public void guardarTodos(List<Producto> productos)
    {
        File db = new File(ruta);
        try 
        {
            //...Write on DB (IMPORTS)...//
            FileWriter fw = new FileWriter(db);
            BufferedWriter bw = new BufferedWriter(fw);
            //...LOOP...//
            for (int i = 0; i < productos.size(); i++)
             bw.write(productos.get(i).getId() + patron + productos.get(i).getNombre() + patron + productos.get(i).getPrecio() + "\n");

            bw.close();
         } 
         catch (IOException e) 
         {
            e.printStackTrace();
        }
        
    }
    @Override 
        public List<Producto> listarTodos()
    {
        File db = new File(ruta);
        ArrayList<Producto> products = new ArrayList<>();
        try 
        {
            //...Read the DB (IMPORTS)...//
            FileReader fr = new FileReader(db);
            BufferedReader bw = new BufferedReader(fr);
            String linea;
            //...LOOP...//
            while ((linea = bw.readLine()) != null) {
                //... Agregar producto...//
                String[] args = linea.split(patron);
                Producto pc = new Producto(Integer.parseInt(args[0]), args[1], Double.parseDouble(args[2]));
                products.add(pc);
            }
            bw.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return products;
    }
}
