package P4;


import P4.Exceptions.RecomendacionInvalida;
import P4.ModeloDatos.ModeloDatosClass;
import P4.Recomendadores.RecomendadorAleatorio;
import P4.Recomendadores.RecomendadorDeVecinos;
import P4.Recomendadores.RecomendadorPopularidad;

import java.io.IOException;

public class Test {
    public static void main(String ...args) throws IOException {
        ModeloDatosClass test = new ModeloDatosClass();
        test.leeFicheroPreferencias("src/P4/PruebaTraining.txt");

        RecomendadorDeVecinos r1 = new RecomendadorDeVecinos(test, 2);
        RecomendadorPopularidad r2 = new RecomendadorPopularidad(test);
        RecomendadorAleatorio r3 = new RecomendadorAleatorio(test);

        try {
            System.out.println(r1.recomienda((long) 190, 100));
        } catch (RecomendacionInvalida e) {

        }
    }

}
