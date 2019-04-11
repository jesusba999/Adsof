package P4.Recomendacion;

import P4.Recomendacion.Tupla;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementa la clase recomendacion
 *
 * @author Jesus Blanco y Daniel Calonge
 */
public class Recomendacion {

    /**
     * Id del usuario
     */
    private long Usuario;

    /**
     * Array de tuplas con las recomendaciones
     */
    private List<Tupla> recomendaciones = new ArrayList<>();

    /**
     * Constructor de recomendacion
     * @param usuario Id del usuario
     */
    public Recomendacion(long usuario) {

        Usuario = usuario;

    }

    /**
     * Devuelve el id del usuario
     * @return Id del usuario
     */
    public long getUsuario() {
        return Usuario;
    }

    /**
     * Modifica el id del usuario
     * @param usuario
     */
    public void setUsuario(long usuario) {
        Usuario = usuario;
    }

    /**
     * Devuelve el array de tuplas con las recomendaciones
     * @return Array de tuplas con las recomendaciones
     */
    public List<Tupla> getRecomendaciones() {
        return recomendaciones;
    }

    /**
     * Modifica el array de tuplas con las recomendaciones
     * @param recomendaciones  Array de tuplas con las recomendaciones
     */
    public void setRecomendaciones(List<Tupla> recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    /**
     * Añade una tupla al array
     * @param tupla Tupla a añadir
     * @return true si se ha añadido, false si no
     */
    public boolean addTupla(Tupla tupla) {
        return recomendaciones.add(tupla);
    }

    /**
     * Metodo que convierte la recomendacion a un string
     * @return String
     */
    @Override
    public String toString() {
        return "Recomendacion{" +
                "Usuario=" + Usuario +
                ", recomendaciones=" + recomendaciones +
                '}';
    }
}
