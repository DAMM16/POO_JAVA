
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MapaMinado {
    int[][] mapa;
    int[][] cantidadMinas;
    int i;
    int j;

    public MapaMinado(int i, int j, int mapSize,int minas) {
        this.i = i;
        this.j = j;
        
        mapa = generateRandomMatrix(mapSize, mapSize, minas);
        while(mapa[i][j]==1){
            mapa = generateRandomMatrix(mapSize, mapSize, minas);
        }
        
        cantidadMinas = new int[mapSize][mapSize];

        for (int ii = 0; ii < mapSize; ii++) {
            for (int jj = 0; jj < mapSize; jj++) {
                cantidadMinas[ii][jj]=0;
                if (mapa[ii][jj]==0) {
                    for (int k = -1; k <=1; k++) {
                        for (int l = -1; l <= 1; l++) {
                            if(0 <= ii+k && ii+k < mapSize && 0 <= jj+l && jj+l < mapSize){
                                cantidadMinas[ii][jj]+=mapa[ii+k][jj+l];
                            }
                        }
                    }
                }
                else{
                    cantidadMinas[ii][jj]=-1;
                }
            }
        }        
    }


    
    public static int[][] generateRandomMatrix(int rows, int cols, int minas) {
        List<Integer> listMapa = new ArrayList<>();
        for (int i = 0; i < rows*cols; i++) {
            if(i<minas){
                listMapa.add(1);
            }else{
                listMapa.add(0);
            }
        }
        // Barajar la lista
        Collections.shuffle(listMapa, new Random());        
        Random random = new Random();
        int[][] matrix = new int[rows][cols];
        int c=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = listMapa.get(c);
                c++;
            }
        }
        return matrix;
    }

}
