package P4;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ModeloDatosClass implements ModeloDatos {
    private static Map<Long, Map<Long, Double>>  PreferenciasUsuario = new HashMap<>();
    private static Map<Long, Map<Long, Double>>  PreferenciasItem = new HashMap<>();

    public void leeFicheroPreferencias(String ruta) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(ruta)));
        String linea;
        String split [];


        while((linea = buffer.readLine()) != null){
            split = linea.split("\\s+");

            if(PreferenciasUsuario.containsKey(Long.parseLong(split[0]))){
                PreferenciasUsuario.get(Long.parseLong(split[0])).put(Long.parseLong(split[1]),Double.parseDouble(split[2]));
            }else{
                HashMap<Long, Double> Usuario = new HashMap<>();
                Usuario.put(Long.parseLong(split[1]),Double.parseDouble(split[2]));
                PreferenciasUsuario.put(Long.parseLong(split[0]), Usuario);
            }

            if(PreferenciasItem.containsKey(Long.parseLong(split[1]))){
                PreferenciasItem.get(Long.parseLong(split[1])).put(Long.parseLong(split[0]),Double.parseDouble(split[2]));
            }else{
                HashMap<Long, Double> Item = new HashMap<>();
                Item.put(Long.parseLong(split[0]),Double.parseDouble(split[2]));
                PreferenciasItem.put(Long.parseLong(split[1]), Item);
            }



        }
        buffer.close();

        System.out.println(PreferenciasUsuario);
        System.out.println(PreferenciasItem);
    }

    @Override
    public Map<Long, Double> getPreferenciasItem(Long item) {
        Map<Long, Double> Preferencias = PreferenciasItem.get(item);
        return Collections.unmodifiableMap(Preferencias);
    }

    @Override
    public Map<Long, Double> getPreferenciasUsuario(Long usuario) {
        Map<Long, Double> Preferencias = PreferenciasUsuario.get(usuario);
        return Collections.unmodifiableMap(Preferencias);
    }

    @Override
    public Set<Long> getItemsUnicos() {
        return PreferenciasItem.keySet();
    }

    @Override
    public Set<Long> getUsuariosUnicos() {
        return PreferenciasUsuario.keySet();
    }
}
