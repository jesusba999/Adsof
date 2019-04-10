package P4;


import P4.ModeloDatos.ModeloDatosClass;

import java.io.IOException;

public class Test {
    public static void main(String ...args) throws IOException {
        ModeloDatosClass test = new ModeloDatosClass();

        test.leeFicheroPreferencias("src/PruebaTraining.txt");
    }
}
