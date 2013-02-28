/**
 * 
 */
package es.home.recetario.dao;

import java.util.List;

import es.home.recetario.dto.RecetaDTO;
import es.home.recetario.generic.JpaDAO;

/**
 * @author daniel
 *
 */
public interface RecetaDAO extends JpaDAO<Integer, RecetaDTO>{

    List<RecetaDTO> buscarRecetaPaginada(final String nomRec, final String nomIng, final int first, final int pageSize );

}
