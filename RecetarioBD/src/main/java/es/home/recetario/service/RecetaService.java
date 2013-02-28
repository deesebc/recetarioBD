/**
 * 
 */
package es.home.recetario.service;

import java.io.Serializable;
import java.util.List;

import es.home.recetario.vo.Receta;

/**
 * @author daniel
 *
 */
public interface RecetaService extends Serializable {

    void actualizarReceta(final Receta receta);

    List<Receta> buscarRecetaPaginadas(final String nomRec, final String nomIng, final int first, final int pageSize);

    long contarRecetas();

    void guardarReceta(final Receta receta);

    Receta obtenerReceta(final int idReceta);

    List<Receta> paginarResultados(final int first, final int pageSize);
}
