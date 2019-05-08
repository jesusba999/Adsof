package P5;

public class TestBasicSimulator {
    public static void main (String args[]){
        BasicSimulator s = new BasicSimulator(10,10);
        BasicAgent random = new BasicAgent("random");
        BasicAgent outer = new BasicAgent("outer");
        try {
            s.create(random, 10, 5, 5); // Crea 10 agentes de tipo random en la posición (5,5)
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }
        try {
            s.create(outer, 10, 7, 7); // Crea 10 agentes de tipo outer en la posición
        } catch (IllegalPositionException e) {
            e.printStackTrace();
        }
        s.run(2);
    }
}
