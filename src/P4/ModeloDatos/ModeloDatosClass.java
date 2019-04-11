package P4.ModeloDatos;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Implementa la interfaz ModeloDatos mediante la clase ModeloDatosClass
 *
 * @author Jesus Blanco y Daniel Calonge
 */
public class ModeloDatosClass implements ModeloDatos {
    /**
     * Datos ordenados segun el usuario
     */
    private  Map<Long, Map<Long, Double>>  preferenciasUsuario = new HashMap<>();

    /**
     * Datos ordenados segun el item
     */
    private  Map<Long, Map<Long, Double>>  preferenciasItem = new HashMap<>();

    /**
     * Guarda los datos leidos de un fichero en el modelo de datos
     * @param ruta en la que se encuentra el fichero
     * @throws IOException
     */
    public void leeFicheroPreferencias(String ruta) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(ruta)));
        String linea;
        String split [];


        while((linea = buffer.readLine()) != null){
            split = linea.split("\\s+");

            if(preferenciasUsuario.containsKey(Long.parseLong(split[0]))){
                preferenciasUsuario.get(Long.parseLong(split[0])).put(Long.parseLong(split[1]),Double.parseDouble(split[2]));
            }else{
                HashMap<Long, Double> Usuario = new HashMap<>();
                Usuario.put(Long.parseLong(split[1]),Double.parseDouble(split[2]));
                preferenciasUsuario.put(Long.parseLong(split[0]), Usuario);
            }

            if(preferenciasItem.containsKey(Long.parseLong(split[1]))){
                preferenciasItem.get(Long.parseLong(split[1])).put(Long.parseLong(split[0]),Double.parseDouble(split[2]));
            }else{
                HashMap<Long, Double> Item = new HashMap<>();
                Item.put(Long.parseLong(split[0]),Double.parseDouble(split[2]));
                preferenciasItem.put(Long.parseLong(split[1]), Item);
            }



        }
        buffer.close();
    }

    /**
     * Devuelve el map de preferencias del item que se pasa como argumento
     */
    @Override
    public Map<Long, Double> getPreferenciasItem(Long item) {
        Map<Long, Double> Preferencias = preferenciasItem.get(item);
        return Collections.unmodifiableMap(Preferencias);
    }

    /**
     * Devuelve el map de preferencias del usuario que se pasa como argumento
     */
    @Override

    public Map<Long, Double> getPreferenciasUsuario(Long usuario) {
        Map<Long, Double> Preferencias = preferenciasUsuario.get(usuario);
        return Collections.unmodifiableMap(Preferencias);
    }

    /**
     * Devuelve un set con los items unicos que hay en el modelo de datos
     */
    @Override
    public Set<Long> getItemsUnicos() {
        return preferenciasItem.keySet();
    }

    /**
     * Devuelve un set con los usuarios unicos que hay en el modelo de datos
     */
    @Override
    public Set<Long> getUsuariosUnicos() {
        return preferenciasUsuario.keySet();
    }
}
