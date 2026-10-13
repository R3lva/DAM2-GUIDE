package dao;

import java.util.List;
import  model.Producto;
public interface InterfazProductoDAOBinario{
    void guardarTodosBinario(List<Producto> productos);
    void guardarTodos(List<Producto> productos);
    List<Producto> listarTodos();
    List<Producto> listarTodosBinario();
}
