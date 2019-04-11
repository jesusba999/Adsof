package P4.ModeloDatos;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ModeloDatosClass implements ModeloDatos {
    private static Map<Long, Map<Long, Double>>  preferenciasUsuario = new HashMap<>();
    private static Map<Long, Map<Long, Double>>  preferenciasItem = new HashMap<>();

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

    @Override
    public Map<Long, Double> getPreferenciasItem(Long item) {
        Map<Long, Double> Preferencias = preferenciasItem.get(item);
        return Collections.unmodifiableMap(Preferencias);
    }

    @Override
    public Map<Long, Double> getPreferenciasUsuario(Long usuario) {
        Map<Long, Double> Preferencias = preferenciasUsuario.get(usuario);
        return Collections.unmodifiableMap(Preferencias);
    }

    @Override
    public Set<Long> getItemsUnicos() {
        return preferenciasItem.keySet();
    }

    @Override
    public Set<Long> getUsuariosUnicos() {
        return preferenciasUsuario.keySet();
    }
}
