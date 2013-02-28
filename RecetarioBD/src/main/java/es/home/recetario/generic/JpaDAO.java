package es.home.recetario.generic;

import java.util.List;

public interface JpaDAO<K, E> {

    Long countAll();

    List<E> findAll();

    List<E> findAllPaginate(int first, int pageSize, String orderBy);

    E findById(final K id) ;

    E flush(final E entity);

    E merge(final E entity) ;

    void persist(final E entity);

    void refresh(final E entity);

    void remove(final E entity);

    Integer removeAll();
}
