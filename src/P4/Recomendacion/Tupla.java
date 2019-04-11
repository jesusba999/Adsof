package P4.Recomendacion;

/**
 * Implementa la clase tupla
 *
 * @author Jesus Blanco y Daniel Calonge
 */
public class Tupla implements Comparable<Tupla>{
    /**
     * Id del usuario o item
     */
    private Long id;

    /**
     * Puntuacion del usuario o item
     */
    private Double score;

    /**
     * Constructor de tupla
     * @param id Id del usuario o item
     * @param score Puntuacion del usuario o item
     */
    public Tupla(Long id, Double score) {
        this.id = id;
        this.score = score;
    }

    /**
     * Devuelve el id del usuario o item
     * @return Id del usuario o item
     */
    public long getId() {
        return id;
    }

    /**
     * Modifica el id del usuario o item
     * @param id Id del usuario o item
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve la puntuacion del usuario o item
     * @return Puntuacion del usuario o item
     */
    public Double getScore() {
        return score;
    }

    /**
     * Modifica la puntuacion del usuario o item
     * @param score
     */
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * Metodo para comparar dos tuplas, se compara la puntuacion de ambas
     * @param t tupla a comparar
     * @return resultado de la comparacion
     */
    public int compareTo(Tupla t) {
        return  (-1) * this.score.compareTo(t.score);
    }

    /**
     * Metodo que convierte la tupla a un string
     * @return String
     */
    @Override
    public String toString() {
        return "Tupla{" +
                "id=" + id +
                ", score=" + score +
                '}';
    }
}
