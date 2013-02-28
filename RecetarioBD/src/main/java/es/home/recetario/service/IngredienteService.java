/**
 * 
 */
package es.home.recetario.service;

import java.io.Serializable;
import java.util.List;

import es.home.recetario.vo.Ingrediente;

/**
 * @author daniel
 *
 */
public interface IngredienteService extends Serializable {

    boolean actualizar(final Ingrediente ingrediente);

    boolean borrar(final Ingrediente ingrediente);

    List<Ingrediente> buscarIngPaginado(final String nombre, final int first, final int pageSize);

    int contarIngredientes();

    boolean crear(final String nombre);

    Ingrediente obtenerIngrediente(final int idIngrediente);

    List<Ingrediente> paginarResultados(final int first, final int pageSize);
}
