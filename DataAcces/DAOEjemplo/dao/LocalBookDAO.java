package DataAcces.DAOEjemplo.dao;

import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class LocalBookDAO {
	String ruta;
    List <Book> libros;

	public LocalBookDAO(String ruta)
	{
		this.ruta = ruta;
		libros = cargarDatos();
	}
	public  List<Book> cargarDatos()
	{
		File arch = new File(this.ruta);
		FileReader fr = new FileReader(arch);
		BufferedReader br = new BufferedReader(fr);

		String line;
		while ((line = br.readLine()) != null ) {
			Book libronuevo = new Book("isbn","datoetc");
			libros.add(libronuevo);
		}

	 br.close();
	}
	public  void guardarDatos()
	{
		File arch = new File(this.ruta);
		FileReader fr = new FileReader(arch);
		BufferedWriter br = new BufferedWriter(fr);

		String line;
		br.close();

	}

	public void saveBook(Book libro)
	{
		this.libros.add(libro);
	}
	/*public void updatebook(String isbn, String Nuevonombre)
	{
		for (Book libro : this.libros)
			{
				if (libro.getIsbn().equals(isbn))
					{
						libro.setName(Nuevonombre);
						break;
					}
			}
	}*/

    public  List<Book> getAllBooks()
    {
		return  this.libros;
    } 
}
