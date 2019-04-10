package P4.Recomendadores;

import P4.Exceptions.RecomendacionInvalida;
import P4.Recomendacion.Recomendacion;

public interface Recomendador {
    public Recomendacion recomienda(Long u, int longitudRecomendacion) throws RecomendacionInvalida;
}
