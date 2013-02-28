/**
 * 
 */
package es.home.recetario.generic;

import java.io.Serializable;
import java.util.List;

/**
 * @author dsblanco
 * 
 */
public interface GenericDAO<K, E> extends Serializable{

    Long countAll();

    List<E> findAll();

    List<E> findAllPaginate(final int first, final int pageSize, final String orderBy);

    E findById(K id);

    //    void merge(E entity);

    void persist(E entity);

    void refresh(E entity);

    void remove(E entity);
}
