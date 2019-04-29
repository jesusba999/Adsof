package P5;

import java.util.*;
import java.util.Comparator;


public class Matrix implements IMatrix {

    private Integer nRows;
    private Integer nCols;
    private HashMap<Integer, HashMap<Integer, IMatrixElement<T>>> matrix = new HashMap<>();

    public Matrix(Integer nRows, Integer nCols) {
        this.nRows = nRows;
        this.nCols = nCols;
    }

    @Override
    public int getCols() {
        return nCols;
    }

    @Override
    public int getRows() {
        return nRows;
    }

    @Override
    public boolean isLegalPosition(int i, int j) {
        if( i < nRows && j < nCols) {
            return true;
        }
        return false;
    }

    @Override
    public void addElement(IMatrixElement<T> element) throws IllegalPositionException {
        int i = element.getI();
        int j = element.getJ();

        if(isLegalPosition(i, j) == false) {
            throw new IllegalPositionException();
        }

        HashMap<Integer, IMatrixElement> col = new HashMap<>();

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

    @Override
    public List<IMatrixElement> getNeighboursAt(int i, int j) throws IllegalPositionException {
        if(isLegalPosition(i, j)) {
            throw new IllegalPositionException();
        }

        return List.of(getElementAt(i - 1, j), getElementAt(i + 1, j), getElementAt(i, j + 1), getElementAt(i, j - 1));
    }

    @Override
    public List<IMatrixElement> asList() {
        List<IMatrixElement> list = new ArrayList<>();

        for(Integer i : matrix.keySet()) {
            for(Integer j : matrix.get(i).keySet()) {
                list.add(matrix.get(i).get(j));
            }
        }

        return list;
    }


    public List<IMatrixElement<T>> asListSortedBy(Comparator<IMatrixElement<T>> c) {


        return null;
    }

    public boolean equals(IMatrix m) {
        int i;

        if(m == null) {
            return false;
        }

        List<IMatrixElement> l1 = asList();
        List<IMatrixElement> l2 = m.asList();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix1 = (Matrix) o;
        return Objects.equals(nRows, matrix1.nRows) &&
                Objects.equals(nCols, matrix1.nCols) &&
                Objects.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nRows, nCols, matrix);
    }
//hashCode?
}
