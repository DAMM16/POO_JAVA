


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class VistaCalculadora {
    JTextField txtEntrada;
    JButton[] btnNumeros;
    JButton btnSuma;
    JButton btnResta;
    JButton btnMult;
    JButton btnDiv;
    JButton btnC;
    JButton btnIgual;
    public VistaCalculadora() {
        JFrame frame = new JFrame("Calculadora");
        frame.setSize(225, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        
        // COMPONENTES
        
        JLabel lblTitilo = new JLabel("Calculadora");
        lblTitilo.setBounds(10, 10, 185, 25);
        panel.add(lblTitilo);
        
        txtEntrada = new JTextField("0");
        txtEntrada.setBounds(10, 40, 195, 30);
        panel.add(txtEntrada);
        
        // NUMEROS
        
        btnNumeros =  new JButton[10];
        
        
        for (int i = 0; i < 3; i++) {
            btnNumeros[7+i] = new JButton(Integer.toString(i+7));
            btnNumeros[7+i].setBounds(10+50*i,80,45,45);
            panel.add(btnNumeros[7+i]);
        }
        for (int i = 0; i < 3; i++) {
            btnNumeros[4+i] = new JButton(Integer.toString(i+4));
            btnNumeros[4+i].setBounds(10+50*i,130,45,45);
            panel.add(btnNumeros[4+i]);
        }
        for (int i = 0; i < 3; i++) {
            btnNumeros[1+i] = new JButton(Integer.toString(i+1));
            btnNumeros[1+i].setBounds(10+50*i,180,45,45);
            panel.add(btnNumeros[1+i]);
        }
        btnNumeros[0] = new JButton(Integer.toString(0));
        btnNumeros[0].setBounds(10,230,45,45);
        

        
        
        panel.add(btnNumeros[0]);

        btnSuma = new JButton("+");
        btnSuma.setBounds(160,230,45,45);
        panel.add(btnSuma);
        
        btnC = new JButton("C");
        btnC.setBounds(110,230,45,45);
        btnC.setBackground(Color.red);
        panel.add(btnC);

        btnIgual = new JButton("=");
        btnIgual.setBounds(60,230,45,45);
        panel.add(btnIgual);

        btnResta = new JButton("-");
        btnResta.setBounds(160,180,45,45);
        panel.add(btnResta);

        btnMult = new JButton("X");
        btnMult.setBounds(160,130,45,45);
        panel.add(btnMult);

        btnDiv = new JButton("/");
        btnDiv.setBounds(160,80,45,45);
        panel.add(btnDiv);

        //HACER VISIBLE
        frame.setVisible(true);
        
    }
    void addActionListenerC(ActionListener accion){
        btnC.addActionListener(accion);
    }
    void addActionListenerSuma(ActionListener accion){
        btnSuma.addActionListener(accion);
    }
    void addActionListenerResta(ActionListener accion){
        btnResta.addActionListener(accion);
    }
    void addActionListenerMultiplicar(ActionListener accion){
        btnMult.addActionListener(accion);
    }
    void addActionListenerDividir(ActionListener accion){
        btnDiv.addActionListener(accion);
    }
    void addActionListenerIgual(ActionListener accion){
        btnIgual.addActionListener(accion);
    }
    void addActionListenerbtnNumeros(ActionListener accion){
        for (JButton btn : btnNumeros) {
            btn.addActionListener(accion);
        }    
    }
}
