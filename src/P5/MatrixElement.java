package P5;

public class MatrixElement<T> implements IMatrixElement<T> {
    private int i;
    private int j;
    private T element;

    public int getI(){
        return i;
    }

    public int getJ(){
        return j;
    }

    public T getElement(){
        return element;
    }

    public void setElement(T element){
        this.element = element;
    }

    public String toString(){
        return "";
    }

    public boolean equals(Object obj){

    }

}
