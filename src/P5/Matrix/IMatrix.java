package P5.Matrix;

/**
 * Contiene la interfaz de la matriz
 *
 * @author Jesus Blanco y Daniel Calonge
 */


import P5.IllegalPositionException;

import java.util.Comparator;
import java.util.List;

public interface IMatrix<T> {

    /**
     * Devuelve el numero máximo de filas de la matriz
     * @return Numero máximo de filas de la matriz
     */
    int getCols();

    /**
     * Devuelve el numero máximo de columnas de la matriz
     * @return Numero máximo de columnas de la matriz
     */
    int getRows();

    /**
     * Devuelve si la posicion que se pasa como argumento es legal
     * @param i Coordenada i
     * @param j Coordenada j
     * @return true si la posicion es legal, false si no lo es
     */
    boolean isLegalPosition(int i, int j);

    /**
     * Añade un elemento
     * @param element elemento a la matriz
     * @throws IllegalPositionException
     */
    void addElement(IMatrixElement<T> element) throws IllegalPositionException;

    /**
     * Devuelve el elemento de la matriz que esta en la posicion que se pasa como argumento
     * @param i Coordenada i
     * @param j Coordenada j
     * @return El elemento si hay uno en esa posicion, null si no lo hay
     * @throws IllegalPositionException
     */
    public IMatrixElement<T> getElementAt(int i, int j) throws IllegalPositionException;

    /**
     * Devuelve los vecinos de la posicion que se pasa como argumento
     * @param i Coordenada i
     * @param j Coordenada j
     * @return Lista con los vecinos
     * @throws IllegalPositionException
     */
    List<IMatrixElement<T>> getNeighboursAt(int i, int j) throws IllegalPositionException;

    /**
     * Devuelve todos los elementos de la matriz en una lista
     * @return Lista con los elementos
     */
    List<IMatrixElement<T>> asList();

    /**
     * Devuelve todos los elementos de la matriz ordenados segun el criterio que se pasa como argumento
     * @param c Criterio de ordenacion
     * @return Lista ordenada
     */
    List<IMatrixElement<T>> asListSortedBy(Comparator<IMatrixElement<T>> c);
}
