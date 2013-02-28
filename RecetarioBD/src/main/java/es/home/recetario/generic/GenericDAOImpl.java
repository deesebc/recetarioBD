/**
 * 
 */
package es.home.recetario.generic;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author dsblanco
 * 
 */
@Repository
@Transactional(value = "transactionManagerLocal")
public abstract class GenericDAOImpl<K, E> implements GenericDAO<K, E> {

    private static final long serialVersionUID = 1503880701647321306L;
    private static final Logger LOGGER = Logger.getLogger(GenericDAOImpl.class);

    protected Class<E> entityClass;

    @PersistenceContext(unitName = "entityManagerFactoryLocal")
    protected EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public GenericDAOImpl() {
	ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
	this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
    }

    public Long countAll() {
	Query query = entityManager.createQuery("SELECT count(*) FROM " + entityClass.getName() + " E");
	return (Long) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public List<E> findAll() {
	Query query = entityManager.createQuery("SELECT E FROM " + entityClass.getName() + " E");
	return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<E> findAllPaginate(final int first, final int pageSize, final String orderBy){
	LOGGER.debug("SELECT E FROM " + entityClass.getName() + " E");
	Query query = entityManager.createQuery("SELECT E FROM " + entityClass.getName() + " E ORDER BY E."+orderBy+" ASC");
	query.setFirstResult(first);
	query.setMaxResults(pageSize);
	return query.getResultList();
    }


    public E findById(final K id) {
	return entityManager.find(entityClass, id);
    }

    public void merge(final E entity) {
	entityManager.merge(entity);
    }

    public void persist(final E entity) {
	entityManager.persist(entity);
    }

    public void refresh(final E entity) {
	entityManager.refresh(entity);
    }

    public void remove(final E entity) {
	E dto = entityManager.merge(entity);
	entityManager.remove(dto);
	//	entityManager.remove(entity);
    }

}
