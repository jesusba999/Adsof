package P5.Matrix;

/**
 * Contiene la interfaz de los elemento de la matriz
 *
 * @author Jesus Blanco y Daniel Calonge
 */


public interface IMatrixElement<T> {

    /**
     * Devuelve la coordenada i
     * @return Coordenada i
     */
    int getI();

    /**
     * Devuleve la coordenada j
     * @return Coordenada j
     */
    int getJ();

    /**
     * Devuelve el elemento almacenado
     * @return Elemento
     */
    T getElement();

    /**
     * Modifica el elemento almacenado
     * @param element Elemento
     */
    void setElement(T element);

    /**
     * Convierte la clase a una cadena de caracteres
     * @return Cadena
     */
    String toString();

    /**
     * Funcion que compara dos objetos de tipo IMatrixElement
     * @param obj Objeto con el que queremos comparar
     * @return True si son iguales, false si no lo son
     */
    boolean equals(Object obj);
}
