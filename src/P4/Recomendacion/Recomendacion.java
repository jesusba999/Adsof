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
}
