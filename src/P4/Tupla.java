package P4;

public class Tupla {
    private long Id;
    private double Score;

    public Tupla(long id, double score) {
        Id = id;
        Score = score;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public double getScore() {
        return Score;
    }

    public void setScore(double score) {
        Score = score;
    }
}
