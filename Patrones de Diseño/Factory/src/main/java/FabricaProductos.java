/**
 *
 * @author diego
 */
public class FabricaProductos extends FabricaAbstracta{
    @Override
    public IProducto crearProducto(int prodID, String nombre){
        switch (prodID) {
            case 0:
                return new ProductoA(nombre);
            case 1:
                return new ProductoB(nombre);
            default:
                throw new IllegalArgumentException();
        }
        
    }
}
