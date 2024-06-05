
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * Buscaminas
 * 
 * Implementación del juego Buscaminas.
 * 
 */

/**
 *
 * @author Diego (https://github.com/DAMM16)
 */
public class GUIBuscaMinas {
    public static int mapSize=10;
    public static MapaMinado map;
    public static boolean iniciado = false;
    public static int minas=10;

    public static void main(String[] args) {
        while (true) {            
            try {
                mapSize = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del mapa de juego:"));
                minas = (int)(0.15*mapSize*mapSize);
                break;
            } catch (NumberFormatException e) {
            }    
        }
        JFrame frame = new JFrame("Buscaminas");
        frame.setSize(30+mapSize*30,120+mapSize*30);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Definimos un panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        // añadimos componentes

        ponerBotones(panel);

        // Hacemos todo visible
        frame.setVisible(true);       
        
    }
    public static void ponerBotones(JPanel panel) {
        // Label de minas
        JLabel cantMinasLbl = new JLabel(""+minas);
        cantMinasLbl.setBounds(5, 0, 25, 25);
        cantMinasLbl.setForeground(Color.red);
        JPanel fondoMinas = new JPanel();
        fondoMinas.setBounds(10, 10, 25, 25);
        fondoMinas.setBackground(Color.black);
        fondoMinas.setLayout(null);
        fondoMinas.add(cantMinasLbl);
        panel.add(fondoMinas);
 
        // Boton reiniciar
        JButton reiniciarBtn = new JButton("=)");
        reiniciarBtn.setBounds(5+mapSize*15,5,50,50);
        panel.add(reiniciarBtn);
        
        // Botones de las minas
        CreadorCeldaBtn creadorCeldas = new CreadorCeldaBtn(30);
        JButton[][] botones = new JButton[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                botones[i][j] = creadorCeldas.createButton(i,j);
                panel.add(botones[i][j]);
            }
        }
        ActionListener accionCuadricula = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                int[] coordinates = findButtonCoordinates(botones,btn);
                int ci = coordinates[0];
                int cj = coordinates[1];
                
                if (btn.getText().equals("")){
                    if(!iniciado){
                        map= new MapaMinado(ci,cj,mapSize,minas);
                        iniciado=true;
                    }
                    // si tiene minas en los vecinos debe mostrar cuantos hay
                    if(map.cantidadMinas[ci][cj]>0){
                        btn.setText(""+map.cantidadMinas[ci][cj]);
                        btn.setEnabled(false);
                    }
                    // si no tiene minas en los vecinos, debe liberar la casilla y ver los vecimos
                    if(map.cantidadMinas[ci][cj]==0){
                        probarVecinos(botones,ci,cj);
                    }
                    // Si hay una mina debe mostrar la posición de todas las minas
                    if(map.cantidadMinas[ci][cj]==-1){
                        btn.setText("*");
                        for (int i = 0; i < mapSize; i++) {
                           for (int j = 0; j < mapSize; j++) {
                               if(map.cantidadMinas[i][j]==-1){
                                   botones[i][j].setText("*");
                               }
                           }
                       }                       
                    }
                }
            }
        };
        
        // Accion reiniciar
        ActionListener accionReiniciar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciado=false; 
                for (int i = 0; i < mapSize; i++) {
                   for (int j = 0; j < mapSize; j++) {
                       botones[i][j].setText("");
                       botones[i][j].setEnabled(true);
                   }
               }                
            }
        };
        
        // añadir aciones a los botones
        reiniciarBtn.addActionListener(accionReiniciar);
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                botones[i][j].addActionListener(accionCuadricula);
            }
        }        
    }
    // Método para buscar las coordenadas de un elemento en la matriz
    public static int[] findButtonCoordinates(JButton[][] matrix, JButton element) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == element) {
                    return new int[] {i, j}; // retornar las coordenadas
                }
            }
        }
        return null; // retornar null si el elemento no se encuentra
    }
    // Método para ver los vecinos de una celda sin minas vecinas
    public static void probarVecinos(JButton[][] botones,int ci, int cj){
        JButton btn = botones[ci][cj];
        if(map.cantidadMinas[ci][cj]>0){
            btn.setText(""+map.cantidadMinas[ci][cj]);
            btn.setEnabled(false);
        }
        // si no tiene minas en los vecinos, debe liberar la casilla y ver los vecinos

        if(map.cantidadMinas[ci][cj]==0 && btn.isEnabled()){
            btn.setEnabled(false);
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if(0<=ci+i && ci+i <mapSize && 0<=cj+j && cj+j <mapSize){
                        probarVecinos(botones,ci+i,cj+j);
                    }
                }

            }
        }        
    }
    
}
