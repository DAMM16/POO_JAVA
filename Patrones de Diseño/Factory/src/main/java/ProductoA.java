/**
 *
 * @author diego
 */
public class ProductoA implements IProducto{
    String nombre;

    public ProductoA(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void metodo() {
        System.out.println("Soy "+this.nombre+" y soy un producto A.");
    }
    
    
}
