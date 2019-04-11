package P4.ModeloDatos;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Contiene la interfaz ModeloDatos
 *
 * @author Jesus Blanco y Daniel Calonge
 */
public interface ModeloDatos {

    /**
     * Guarda los datos leidos de un fichero en el modelo de datos
     * @param ruta en la que se encuentra el fichero
     * @throws IOException
     */
    public void leeFicheroPreferencias(String ruta) throws IOException;

    /**
     * Devuelve el map de preferencias del item que se pasa como argumento
     */
    public Map<Long, Double> getPreferenciasUsuario(Long usuario);

    /**
     * Devuelve el map de preferencias del item que se pasa como argumento
     */
    public Map<Long, Double> getPreferenciasItem(Long item);

    /**
     * Devuelve un set con los items unicos que hay en el modelo de datos
     */
    public Set<Long> getUsuariosUnicos();

    /**
     * Devuelve un set con los usuarios unicos que hay en el modelo de datos
     */
    public Set<Long> getItemsUnicos();

}
