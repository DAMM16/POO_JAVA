/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author diego
 */
public class CalculadoraMVC {

    public static void main(String[] args) {
        VistaCalculadora v1 = new VistaCalculadora();
        ModeloCalculadora m1 = new ModeloCalculadora();
        Controlador c1 = new Controlador(m1, v1);
    }
}
