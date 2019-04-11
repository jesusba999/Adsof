package P4.Metricas;

import P4.Exceptions.UsuarioNoRelevante;
import P4.Recomendacion.Recomendacion;

import java.util.Set;

public interface Metrica {
    public double evalua(Recomendacion rec, int n) throws UsuarioNoRelevante;
    public Set<Long> getItemsRelevantes(Long u);
}
