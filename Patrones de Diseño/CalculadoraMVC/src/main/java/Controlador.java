/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author diego
 */
public class Controlador {
    ModeloCalculadora m ;
    VistaCalculadora v ;

    public Controlador(ModeloCalculadora m, VistaCalculadora v) {
        this.m = m;
        this.v = v;
        // BOTONES NUMEROS
        v.addActionListenerbtnNumeros(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    JButton btn = (JButton)ae.getSource();
                    v.txtEntrada.setText(v.txtEntrada.getText()+btn.getText());
                }
            }        
        );
        // BOTON +
        v.addActionListenerSuma(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    try {
                        m.memoria = Float.parseFloat(v.txtEntrada.getText());
                        m.operacion = ModeloCalculadora.SUMA;
                        v.txtEntrada.setText("");
                    } catch (NumberFormatException e) {
                        v.txtEntrada.setText("*** Error de Sintaxis ***");
                    }
                }
            }        
        );
        // BOTON -
        v.addActionListenerResta(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    try {
                        m.memoria = Float.parseFloat(v.txtEntrada.getText());
                        m.operacion = ModeloCalculadora.RESTA;
                        v.txtEntrada.setText("");
                    } catch (NumberFormatException e) {
                        v.txtEntrada.setText("*** Error de Sintaxis ***");
                    }                    

                }
            }        
        );        
        // BOTON X
        v.addActionListenerMultiplicar(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    try {
                        m.memoria = Float.parseFloat(v.txtEntrada.getText());
                        m.operacion = ModeloCalculadora.MULTIPLICACION;
                        v.txtEntrada.setText("");
                    } catch (NumberFormatException e) {
                        v.txtEntrada.setText("*** Error de Sintaxis ***");
                    }                         
                }
            }        
        );
        // BOTON /
        v.addActionListenerDividir(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    try {
                        m.memoria = Float.parseFloat(v.txtEntrada.getText());
                        m.operacion = ModeloCalculadora.DIVISION;
                        v.txtEntrada.setText("");
                    } catch (NumberFormatException e) {
                        v.txtEntrada.setText("*** Error de Sintaxis ***");
                    }  

                }
            }        
        );
        // BOTON C
        v.addActionListenerC(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    m.reicinciar();
                    v.txtEntrada.setText(Float.toString(m.memoria));
                }
            }        
        );
        // BOTON =
        v.addActionListenerIgual(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    switch (m.operacion) {
                        case ModeloCalculadora.SUMA:
                            m.sumar(Float.parseFloat(v.txtEntrada.getText()));
                            v.txtEntrada.setText(Float.toString(m.memoria));
                            break;
                        case ModeloCalculadora.RESTA:
                            m.restar(Float.parseFloat(v.txtEntrada.getText()));
                            v.txtEntrada.setText(Float.toString(m.memoria));
                            break;
                        case ModeloCalculadora.MULTIPLICACION:
                            m.multiplicar(Float.parseFloat(v.txtEntrada.getText()));
                            v.txtEntrada.setText(Float.toString(m.memoria));
                            break;
                        case ModeloCalculadora.DIVISION:
                            float num =Float.parseFloat(v.txtEntrada.getText());
                            System.out.println(num);
                            System.out.println((float)num != (float)0.0);
                            if ((float)num != (float)0.0) {
                                m.dividir(num);
                                v.txtEntrada.setText(Float.toString(m.memoria));
                            }
                            else{
                                m.reicinciar();
                                v.txtEntrada.setText("*** Está dividiento por cero ***");
                            }                            
                            
                            break;
                        default:
                            throw new AssertionError();
                    }
                    
                }
            }          
        );
        
    }
    
}
/*
new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        }
*/
