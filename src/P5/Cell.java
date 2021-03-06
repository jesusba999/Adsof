package P5;

import P5.Matrix.MatrixElement;

import java.util.List;

/**
 * Contiene la clase de una celda
 *
 * @author Jesus Blanco y Daniel Calonge
 */


public class Cell extends MatrixElement<List<IBasicAgent>>{

    /**
     * Simulador que utilizamos
     */
    BasicSimulator simulador;

    /**
     * Constructor de la celda
     * @param i fila
     * @param j columna
     * @param element Elemento
     * @param simulador simulador
     */
    public Cell(int i, int j, List<IBasicAgent> element, BasicSimulator simulador) {
        super(i, j, element);
        this.simulador = simulador;
    }

    /**
     * Devuelve el elemento de la celda(Una lista de agentes basicos)
     * @return elemento
     */
    public List<IBasicAgent> getElement() {
        return super.getElement();
    }

    /**
     * Añade una lista de agentes basicos a la celda
     * @param lista lista de agentes
     */
    public void anadirAgentes(List<IBasicAgent> lista){
        getElement().addAll(lista);
    }
}
