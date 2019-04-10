package P4;

import P4.Exceptions.RecomendacionInvalida;

public interface Recomendador {
    public Recomendacion recomienda(Long u, int longitudRecomendacion) throws RecomendacionInvalida;
}
