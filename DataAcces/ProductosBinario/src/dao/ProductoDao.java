package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
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
    public void guardarTodosBinario(List<Producto> productos)
    {
        File db = new File(ruta);
        try 
        {
            //...Write on DB (IMPORTS)...//
            FileOutputStream fo = new FileOutputStream(db);
            ObjectOutputStream OB = new ObjectOutputStream(fo);
            //...LOOP...//
            for (int i = 0; i < productos.size(); i++)
            OB.writeObject(productos.get(i));
            OB.close();
         } 
         catch (IOException e) 
         {
            e.printStackTrace();
        }
        
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
        public List<Producto> listarTodosBinario()
    {
        File db = new File(ruta);
        ArrayList<Producto> products = new ArrayList<>();
        try 
        {
            //...Read the DB (IMPORTS)...//
            FileInputStream fr = new FileInputStream(db);
            ObjectInputStream bw = new ObjectInputStream(fr);
           while (true) {
             try {
                Producto producta = (Producto) bw.readObject();
                products.add(producta);
             } catch (Exception e) {
                break;
             }
           }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return products;
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
