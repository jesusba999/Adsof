package P5;

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
