package Libro;

import java.util.Comparator;

public class PrecioMayor implements Comparator<Libro> {
	@Override
	public int compare(Libro l1, Libro l2) {
		if(l1.getPrecio()>l2.getPrecio()) {
			return -1;
		}
		if(l1.getPrecio()<l2.getPrecio()) {
			return 1;
		}
		else {
			return 0;}}

}
