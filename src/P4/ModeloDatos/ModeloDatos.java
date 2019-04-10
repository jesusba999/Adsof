package P4.ModeloDatos;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public interface ModeloDatos {

    public void leeFicheroPreferencias(String ruta) throws IOException;



    public Map<Long, Double> getPreferenciasUsuario(Long usuario);
    public Map<Long, Double> getPreferenciasItem(Long item);
    public Set<Long> getUsuariosUnicos();
    public Set<Long> getItemsUnicos();

}
