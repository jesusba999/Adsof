package P4.Recomendacion;


public class Tupla implements Comparable<Tupla>{
    private Long id;
    private Double score;

    public Tupla(Long id, Double score) {
        this.id = id;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }


    public int compareTo(Tupla t) {
        return  (-1) * this.score.compareTo(t.score);
    }

    @Override
    public String toString() {
        return "Tupla{" +
                "id=" + id +
                ", score=" + score +
                '}';
    }
}
