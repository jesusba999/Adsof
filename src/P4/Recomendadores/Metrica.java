package P4.Recomendadores;

import P4.Recomendacion.Recomendacion;

import java.util.Set;

public interface Metrica {
    public double evalua(Recomendacion rec, int n) throws UsuarioNoRelevante;
    public Set<Long> getItemsRelevantes(Long u);
}
