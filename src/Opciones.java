
public class Opciones {
	private int item;
	
	public Opciones() {
		
	}
	
	public Opciones(int item) {
		this.item = item;
	}
	
	public int getItem() {
		return this.item;
	}
	
	public void menuOpcion() {
		System.out.println("\n**MENU DE OPCIONES**\n");
		System.out.println("<1> INGRESAR LIBRO\n"+"<2> BUSCAR LIBRO POR ISNB\n"+
		"<3> VENTA DE LIBRO\n"+"<4> MOSTRAR LOS TRES LIBROS MAS CAROS\n"+
		"<5> MOSTRAR TODOS LOS LIBROS\n"+"<6> SALIR DEL MENU");
		System.out.print("\nINGRESE UNA OPCION: ");
	}
	
	public void validarItem() {
		if(this.item >= 1 && this.item <= 6) {
			for(int i= 1; i<=6; i++) {
				if(this.item == i) {
					this.item = i; 
				}
			}
		}
		else {
			System.out.println("INGRESO NO VALIDO\n");
		}
	}
}