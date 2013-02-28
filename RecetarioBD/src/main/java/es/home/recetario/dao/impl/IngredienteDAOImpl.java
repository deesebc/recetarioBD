package es.home.recetario.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.home.recetario.dao.IngredienteDAO;
import es.home.recetario.dto.IngredienteDTO;
import es.home.recetario.generic.JpaDAOImpl;

@Repository("ingredidenteDaoImpl")
@Transactional(value = "transactionManagerLocal")
public class IngredienteDAOImpl extends JpaDAOImpl<Integer, IngredienteDTO> implements
        IngredienteDAO {

    @Autowired
    EntityManagerFactory entityManagerFactoryLocal;

    private static final long serialVersionUID = 6287801657971944454L;

    @SuppressWarnings("unchecked")
    public List<IngredienteDTO> buscarIngPaginado(final String nombre, final int first,
            final int pageSize) {
        final StringBuilder sql = new StringBuilder();
        sql.append("SELECT E FROM ").append(entityClass.getName()).append(" E ");
        if (StringUtils.isNotBlank(nombre)) {
            sql.append("WHERE E.nombre LIKE '%").append(nombre).append("%' ");
        }
        sql.append("ORDER BY E.nombre asc");
        final Query query = getJpaTemplate().getEntityManager().createQuery(sql.toString());
        query.setFirstResult(first);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    @PostConstruct
    public void init() {
        super.setEntityManagerFactory(entityManagerFactoryLocal);
    }

}
