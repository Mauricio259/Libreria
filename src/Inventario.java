import java.util.ArrayList;
import java.util.Collections;
public class Inventario {
	
	private ArrayList<Libro> libros = new ArrayList<Libro>();
	private ArrayList<Libro> librosCaros;
	double totPrecio;
	
	public void almacenar(Libro libro) {
		libros.add(libro);
	}
	
	public Libro getLibrobyIsbn(String isbn) {
		for(Libro l: libros) {
			if(l.getIsbn().equals(isbn)) {
				return l;
			}
		}
		return null;
	}
	public double getTotalPrecio() {
		return totPrecio;
	}
	
	public void venderLibros(String isbn, int cantidad) {
		totPrecio=0.0;
		if(getLibrobyIsbn(isbn).getCantidad() >= cantidad) {
			this.totPrecio= getLibrobyIsbn(isbn).getPrecio()*cantidad;
			getLibrobyIsbn(isbn).setCantidad(getLibrobyIsbn(isbn).getCantidad()-cantidad);
			
			if(getLibrobyIsbn(isbn).getCantidad()==0) {
				libros.remove(libros.indexOf(getLibrobyIsbn(isbn)));
			}
		}
	}
	
	public void ordenarPrecios() {
		librosCaros = new ArrayList<Libro>();
		
		for(int i=0; i<libros.size(); i++) {
			librosCaros.add(libros.get(i));
		}
		Collections.sort(librosCaros, new PrecioMayor());
	}
	
	public ArrayList<Libro> getlibrosCaros() {
		for(int i=0; i<3; i++) {
			System.out.println(librosCaros.get(i));
		}
		return null;
	}
	
	public String getLibros() {
		for(int i=0; i<libros.size(); i++) {
			System.out.println(libros.get(i));
		}
		return null;
	}
}