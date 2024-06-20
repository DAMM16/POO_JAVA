/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author diego
 */
public class ModeloCalculadora {
    final static int SIN_OPERACION = -1;
    final static int SUMA = 0;
    final static int RESTA = 1;
    final static int MULTIPLICACION = 2;
    final static int DIVISION = 3;
    float memoria;
    int operacion=-1;
    void sumar(float nuevoNum){
        memoria = memoria+nuevoNum;
    }
    void restar(float nuevoNum){
        memoria = memoria-nuevoNum;
    }
    void multiplicar(float nuevoNum){
        memoria = memoria*nuevoNum;
    }
    void dividir(float nuevoNum){
        memoria = memoria/nuevoNum;
    }
    void reicinciar(){
        memoria = 0;
        operacion=-1;
    }
    
}
