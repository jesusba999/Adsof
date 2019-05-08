package P5;

/**
 * Contiene la clase de la matriz
 *
 * @author Jesus Blanco y Daniel Calonge
 */


import java.util.*;
import java.util.Comparator;


public class Matrix<T> implements IMatrix<T> {

    /**
     * Numero máximo de filas de la matriz
     */
    private Integer nRows;

    /**
     * Numero maximo de columas de la matriz
     */
    private Integer nCols;

    /**
     * HashMap donde se almacenan los elementos de la matriz en funcion de su coordenada i y su coordenada j
     */
    private HashMap<Integer, HashMap<Integer, IMatrixElement<T>>> matrix = new HashMap<>();

    /**
     * Constructor de matriz
     * @param nRows Numero máximo de filas de la matriz
     * @param nCols Numero maximo de columas de la matriz
     */
    public Matrix(Integer nRows, Integer nCols) {
        this.nRows = nRows;
        this.nCols = nCols;
    }

    /**
     * Devuelve el numero máximo de filas de la matriz
     * @return Numero máximo de filas de la matriz
     */
    @Override
    public int getCols() {
        return nCols;
    }

    /**
     * Devuelve el numero máximo de columnas de la matriz
     * @return Numero máximo de columnas de la matriz
     */
    @Override
    public int getRows() {
        return nRows;
    }

    /**
     * Devuelve si la posicion que se pasa como argumento es legal
     * @param i Coordenada i
     * @param j Coordenada j
     * @return true si la posicion es legal, false si no lo es
     */
    @Override
    public boolean isLegalPosition(int i, int j) {
        if( i < nRows && j < nCols) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param element Añade un elemento a la matriz
     * @throws IllegalPositionException
     */
    @Override
    public void addElement(IMatrixElement<T> element) throws IllegalPositionException {
        int i = element.getI();
        int j = element.getJ();

        if(isLegalPosition(i, j) == false) {
            throw new IllegalPositionException();
        }

        HashMap<Integer, IMatrixElement<T>> col = new HashMap<>();

        if(matrix.get(i) != null) {

            if(matrix.get(i).get(j) != null) {
                matrix.get(i).get(j).setElement(element.getElement());
            } else {
                matrix.get(i).put(j, element);
            }

        } else {
            col.put(j, element);
            matrix.put(i, col);
        }

        return;

    }

    /**
     * Devuelve el elemento de la matriz que esta en la posicion que se pasa como argumento
     * @param i Coordenada i
     * @param j Coordenada j
     * @return El elemento si hay uno en esa posicion, null si no lo hay
     * @throws IllegalPositionException
     */
    @Override
    public IMatrixElement getElementAt(int i, int j) throws IllegalPositionException {
        if(isLegalPosition(i, j) == false) {
            throw new IllegalPositionException();
        }

        if(matrix.get(i) != null) {
            if(matrix.get(i).get(j) != null) {
                return matrix.get(i).get(j);
            }
        }

        return null;
    }

    /**
     * Devuelve los vecinos de la posicion que se pasa como argumento
     * @param i Coordenada i
     * @param j Coordenada j
     * @return Lista con los vecinos
     * @throws IllegalPositionException
     */
    @Override
    public List<IMatrixElement<T>> getNeighboursAt(int i, int j) throws IllegalPositionException {
        if(isLegalPosition(i, j)) {
            throw new IllegalPositionException();
        }

        return List.of(getElementAt(i - 1, j), getElementAt(i + 1, j), getElementAt(i, j + 1), getElementAt(i, j - 1));
    }

    /**
     * Devuelve todos los elementos de la matriz en una lista
     * @return Lista con los elementos
     */
    @Override
    public List<IMatrixElement<T>> asList() {
        List<IMatrixElement<T>> list = new ArrayList<>();

        for(Integer i : matrix.keySet()) {
            for(Integer j : matrix.get(i).keySet()) {
                list.add(matrix.get(i).get(j));
            }
        }

        return list;
    }

    /**
     * Devuelve todos los elementos de la matriz ordenados segun el criterio que se pasa como argumento
     * @param c Criterio de ordenacion
     * @return Lista ordenada
     */
    public List<IMatrixElement<T>> asListSortedBy(Comparator<IMatrixElement<T>> c) {

        List<IMatrixElement<T>> l = asList();

        Collections.sort(l, c);

        return l;
    }

    /**
     * Funcion que compara dos objetos de tipo IMatrix
     * @param m matriz con la que comparamos
     * @return true si son iguales, false si no lo son
     */
    public boolean equals(Object m) {
        int i;

        if(m == null) {
            return false;
        }

        if(this == m){
            return true;
        }

        List<IMatrixElement<T>> l1 = asList();
        List<IMatrixElement<T>> l2 = ((IMatrix<T>)m).asList();

        if(l1.size() != l2.size()) {
            return false;
        }

        for(i = 0; i < l1.size(); i++) {
            if(l1.get(i).equals(l2.get(i)) == false) {
                return false;
            }
        }

        return true;
    }

    /**
     * Funcion hascode
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(nRows, nCols, matrix);
    }

    /**
     * Comparador por columas
     * @param o1 objeto a comparar
     * @param o2 objeto a comparar
     * @return 0 si son iguales, o distinto de 0 si son diferentes
     */
    public Comparator<IMatrixElement<T>> getColsComparator(Object o1, Object o2){

        Comparator<IMatrixElement<T>> colsComparator = new Comparator<>(){

            @Override
            public int compare(IMatrixElement<T> t1, IMatrixElement<T> t2) {
                if(t1.getJ() != t2.getJ()){
                    return t1.getJ() - t2.getJ();

                }else {
                    return t1.getI() - t2.getI();

                }
            }
        };
        return colsComparator;
    }

    public Comparator<IMatrixElement<T>> getRowsComparator(Object o1, Object o2){

        Comparator<IMatrixElement<T>> rowsComparator = new Comparator<>(){

            @Override
            public int compare(IMatrixElement<T> t1, IMatrixElement<T> t2) {
                if(t1.getI() != t2.getI()){
                    return t1.getI() - t2.getI();

                }else {
                    return t1.getJ() - t2.getJ();

                }
            }
        };
        return rowsComparator;
    }
}
