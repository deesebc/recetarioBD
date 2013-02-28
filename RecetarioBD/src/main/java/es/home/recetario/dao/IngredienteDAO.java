/**
 * 
 */
package es.home.recetario.dao;

import java.util.List;

import es.home.recetario.dto.IngredienteDTO;
import es.home.recetario.generic.JpaDAO;

/**
 * @author daniel
 *
 */
public interface IngredienteDAO extends JpaDAO<Integer, IngredienteDTO>{

    List<IngredienteDTO> buscarIngPaginado(final String nombre, final int first, final int pageSize);
}
