package P4;


import P4.Exceptions.RecomendacionInvalida;
import P4.ModeloDatos.ModeloDatosClass;
import P4.Recomendadores.RecomendadorDeVecinos;

import java.io.IOException;

public class Test {
    public static void main(String ...args) throws IOException {
        ModeloDatosClass test = new ModeloDatosClass();
        test.leeFicheroPreferencias("src/P4/PruebaTraining.txt");

        RecomendadorDeVecinos r = new RecomendadorDeVecinos(test);

        try {
            System.out.println(r.recomienda((long) 190, 0));
        } catch (RecomendacionInvalida e) {

        }


    }
}
