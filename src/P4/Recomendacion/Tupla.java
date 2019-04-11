package P4.Recomendacion;


public class Tupla {
    private long id;
    private Double score;

    public Tupla(long id, double score) {
        this.id = id;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }


    public int compareTo(Tupla t) {
        return this.score.compareTo(t.score);
    }

}
