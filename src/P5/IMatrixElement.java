package P5;

/**
 * Contiene la interfaz de los elemento de la matriz
 *
 * @author Jesus Blanco y Daniel Calonge
 */


public interface IMatrixElement<T> {
    int getI();
    int getJ();
    T getElement();
    void setElement(T element);
    String toString();
    boolean equals(Object obj);
}
