/**
 *
 * @author diego
 */
public abstract class FabricaAbstracta {
    static int PRODA = 0;
    static int PRODB = 1;
    abstract IProducto crearProducto(int prodID, String nombre);
}
