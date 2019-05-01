package P5;

/**
 * Contiene la clase de los elemento de la matriz
 *
 * @author Jesus Blanco y Daniel Calonge
 */


public class MatrixElement<T> implements IMatrixElement<T> {

    /**
     * Coordenada i en la matriz(Numero de  la fila, comenzando en el 0)
     */
    private int i;

    /**
     * Coordenada j en la matriz(Numero de  la columna, comenzando en el 0)
     */
    private int j;

    /**
     * Elemento almacenado
     */
    private T element;

    /**
     * Devuelve la coordenada i
     * @return Coordenada i
     */
    public int getI(){
        return i;
    }

    /**
     * Devuleve la coordenada j
     * @return Coordenada j
     */
    public int getJ(){
        return j;
    }

    /**
     * Devuelve el elemento almacenado
     * @return Elemento
     */
    public T getElement(){
        return element;
    }

    /**
     * Modifica el elemento almacenado
     * @param element Elemento
     */
    public void setElement(T element){
        this.element = element;
    }

    /**
     * Convierte la clase a una cadena de caracteres
     * @return Cadena
     */
    public String toString(){
        return "";
    }

    /**
     * Funcion que compara dos objetos de tipo IMatrixElement
     * @param obj Objeto con el que queremos comparar
     * @return True si son iguales, false si no lo son
     */
    public boolean equals(Object obj){
        if(getI() == ((MatrixElement<T>)obj).getI() && getJ() == ((MatrixElement<T>)obj).getJ() && element.equals(((MatrixElement<T>)obj).getElement())) {
            return true;
        } else {
            return false;
        }
    }

}
