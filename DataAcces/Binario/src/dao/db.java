package dao;
import  model.Persona;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


public class db  {
    private  String ruta;
    
    
    public db(String ruta) {
        this.ruta = ruta;
    }

    public void GuardarBinario(Persona p)
    {
        File fl = new File(ruta);
        try 
            {
            OutputStream ot = new FileOutputStream(fl);
            ObjectOutputStream writer = new ObjectOutputStream(ot);
            writer.writeObject(p);
            writer.close();
  } catch (Exception e) {
            e.printStackTrace(); // Muestra cualquier error de serialización
        }
    }
    public void leerBinario()
    {
        File fl = new File(ruta);
        try (
            InputStream ip = new FileInputStream(fl);
            ObjectInputStream reader = new ObjectInputStream(ip);
        ){while (true) {
            Object obj = reader.readObject();
            Persona p = (Persona)obj;
            System.out.println(p.getUsuario() + " - " + p.getCorreo()+ " - " + p.getContraseña());
        }
    }
         catch (EOFException e) {
            System.out.println("Binario leido correctamente");
        }
         catch (Exception e) {
            // TODO: handle exception
        }
    }
}
