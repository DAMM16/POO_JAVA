/**
 *
 * @author diego
 */
public class ProductoB implements IProducto{
    String nombre;
    
    public ProductoB(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void metodo() {
        System.out.println("Soy "+this.nombre+" y soy un producto B.");
    }    
}
