package P5;

import P5.Matrix.Matrix;

import java.util.List;



/**
 * Contiene la clase de un agente basico que implementa la interfaz IBasicAgent
 *
 * @author Jesus Blanco y Daniel Calonge
 */
public class Entorno extends Matrix<List<IBasicAgent>> {
    /**
     * Constructor de entorno
     * @param nRows numero de filas
     * @param nCols numero de columnas
     */
    public Entorno(Integer nRows, Integer nCols) {
        super(nRows, nCols);
    }

    /**
     * Convierte el entorno en un string para poder imprimirlo
     * @return String
     */
    public String toString() {
        int i, j;
        String cadena = "  ";

        for(i = 0; i < this.getRows(); i++){
            for(j = 0; j < this.getCols(); j++){
                try {
                    if (this.getElementAt(i, j) == null) {
                        cadena += "· |  ";
                    }
                    else {
                        cadena += String.format("%3s",((List)  this.getElementAt(i,j).getElement()).size() + "|  ");
                    }
                } catch (IllegalPositionException e) {
                    e.printStackTrace();
                }
            }
            cadena += "\n  ";
        }
        return cadena;
    }
}
