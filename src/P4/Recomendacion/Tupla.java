package P4.Recomendacion;

public class Tupla {
    private long id;
    private double score;

    public Tupla(long id, double score) {
        id = id;
        score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        score = score;
    }

    public int compareTo(Tupla t) {
        return this.score.compareTo(t.score);
    }

}
