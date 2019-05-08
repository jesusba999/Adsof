package P5;

import java.util.List;

/**
 * Contiene la clase de un agente basico que implementa la interfaz IBasicAgent
 *
 * @author Jesus Blanco y Daniel Calonge
 */
public class Entorno extends Matrix<List<IBasicAgent>>{

    public Entorno(Integer nRows, Integer nCols) {
        super(nRows, nCols);
    }
}
