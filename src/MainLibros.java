import java.util.Scanner;
public class MainLibros {
	
	public static void main(String[] args) {
		
		Scanner leer;
		Opciones items = new Opciones();
		int id, cantidad;
		String isnb = "", titulo = "";
		double precio = 0.0;
		boolean control = true;
		Inventario inv = new Inventario();
		
		while(control) {
			
			leer = new Scanner(System.in);
			items.menuOpcion();
			id = leer.nextInt();
			Opciones validar = new Opciones(id);
			validar.validarItem();
			
			if(validar.getItem() == 1) {
				leer = new Scanner(System.in);
				System.out.print("\nCodigo ISNB: ");
				isnb = leer.nextLine();
				System.out.print("Titulo del libro: ");
				titulo = leer.nextLine();
				System.out.print("Precio del libro: ");
				precio = leer.nextDouble();
				System.out.print("Cantidades: ");
				cantidad = leer.nextInt();
				Libro libros = new Libro(isnb, titulo, precio, cantidad);
				if(inv.getLibrobyIsbn(isnb) == null) {
					inv.almacenar(libros);
				}
				else {
					System.out.println("\nVuelva a ingresar un isnb diferente");
				}	
			}
			
			if(validar.getItem() == 2) {
				leer = new Scanner(System.in);
				System.out.print("\nBuscar código ISNB: ");
				isnb = leer.nextLine();
				if(inv.getLibrobyIsbn(isnb) == null) {
					System.out.println("\nEl codigo ISNB ingresado no existe\n");
				}
				else {
					System.out.println("\nLibro encontrado\n");
					System.out.println(inv.getLibrobyIsbn(isnb));
				}
			}
			
			if(validar.getItem() == 3) {
				leer = new Scanner(System.in);
				System.out.print("\nCodigo ISNB del libro por vender: ");
				isnb = leer.nextLine();
				System.out.print("Cantidad por vender: ");
				cantidad = leer.nextInt();
				if(inv.getLibrobyIsbn(isnb)== null) {
					System.out.println("\nEl codigo ISNB ingresado no existe\n");
				}
				else
					if(inv.getLibrobyIsbn(isnb).getCantidad()>cantidad) {
						inv.venderLibros(isnb, cantidad);
						System.out.println("Total a pagar: $ "+(double)inv.getTotalPrecio());
				}
					else
						if(inv.getLibrobyIsbn(isnb).getCantidad()<cantidad) {
							System.out.println("Solo hay "+inv.getLibrobyIsbn(isnb).getCantidad()+" de libros");
				}
						else {
							inv.venderLibros(isnb, cantidad);
							System.out.println("Con esta venta se agota el libro");
							System.out.println("Total a pagar: $ "+(double)inv.getTotalPrecio());
						}
			}
			
			if(validar.getItem() == 4) {
				System.out.println("Los 3 libros más caros del inventario");
				inv.ordenarPrecios();
				inv.getlibrosCaros();
			}
			
			if(validar.getItem() == 5) {
				System.out.println("\nLibros mostrados por isnb <> titulo <> cantidad <> precio\n");
				inv.getLibros();
			}
			
			if(validar.getItem() == 6) {
				System.out.println("\nSalió del menú de opciones");
				control = false;
			}
		}
	}
}
