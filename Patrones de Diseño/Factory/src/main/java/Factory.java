/*
 * Ejemplo de patrón Factory
 */

/**
 *
 * @author diego
 */
public class Factory {

    public static void main(String[] args) {
        FabricaAbstracta fabrica1 = new FabricaProductos();
        IProducto pA1 = fabrica1.crearProducto(fabrica1.PRODA,"ejemplo1");
        IProducto pB1 = fabrica1.crearProducto(fabrica1.PRODB,"ejemplo2");
        pA1.metodo();
        pB1.metodo();
    }
}
