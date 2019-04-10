package P4.Recomendadores;

import P4.Exceptions.RecomendacionInvalida;
import P4.Recomendacion.Recomendacion;

public class RecomendadorAleatorio implements Recomendador {


    @Override
    public Recomendacion recomienda(Long u, int longitudRecomendacion) throws RecomendacionInvalida {
        Recomendacion recomendacion = new Recomendacion(u);

        return null;
    }
}
