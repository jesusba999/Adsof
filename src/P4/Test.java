package P4;


import java.io.IOException;

public class Test {
    public static void main(String ...args) throws IOException {
        ModeloDatosClass test = new ModeloDatosClass();

        test.leeFicheroPreferencias("src/PruebaTraining.txt");
    }
}
