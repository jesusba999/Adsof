package P4.Recomendacion;

import P4.Recomendacion.Tupla;

import java.util.ArrayList;
import java.util.List;

public class Recomendacion {
    private long Usuario;
    private List<Tupla> recomendaciones = new ArrayList<>();

    public Recomendacion(long usuario) {

        Usuario = usuario;

    }

    public long getUsuario() {
        return Usuario;
    }

    public void setUsuario(long usuario) {
        Usuario = usuario;
    }

    public List<Tupla> getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(List<Tupla> recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public boolean addTupla(Tupla tupla) {
        return recomendaciones.add(tupla);
    }


}
