package P5;

/**
 * Contiene la interfaz de la matriz
 *
 * @author Jesus Blanco y Daniel Calonge
 */


import java.util.Comparator;
import java.util.List;

public interface IMatrix<T> {
    int getCols();
    int getRows();
    boolean isLegalPosition(int i, int j);
    void addElement(IMatrixElement<T> element) throws IllegalPositionException;
    public IMatrixElement<T> getElementAt(int i, int j) throws IllegalPositionException;
    List<IMatrixElement<T>> getNeighboursAt(int i, int j) throws IllegalPositionException;
    List<IMatrixElement<T>> asList();
    List<IMatrixElement<T>> asListSortedBy(Comparator<IMatrixElement<T>> c);
}
