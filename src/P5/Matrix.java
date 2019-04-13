package P5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Matrix implements IMatrix {

    private Integer nRows;
    private Integer nCols;
    private HashMap<Integer, HashMap<Integer, IMatrixElement>> matrix = new HashMap<>();

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
    public void addElement(IMatrixElement element) throws IllegalPositionException {
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
}
