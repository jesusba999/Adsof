package P5;

public interface IMatrixElement<T> {
    int getI();
    int getJ();
    T getElement();
    void setElement(T element);
    String toString();
    boolean equals(Object obj);
}
