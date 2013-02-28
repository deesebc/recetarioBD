package es.home.recetario.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.home.recetario.dao.RecetaDAO;
import es.home.recetario.dto.RecetaDTO;
import es.home.recetario.generic.JpaDAOImpl;

@Repository("recetaDaoImpl")
@Transactional(value = "transactionManagerLocal")
public class RecetaDAOImpl extends JpaDAOImpl<Integer, RecetaDTO> implements RecetaDAO{

    @Autowired
    EntityManagerFactory entityManagerFactoryLocal;

    private static final long serialVersionUID = 6287801657971944454L;

    @SuppressWarnings("unchecked")
    public List<RecetaDTO> buscarRecetaPaginada(final String nomRec, final String nomIng, final int first, final int pageSize) {
	StringBuilder sql = new StringBuilder();
	sql.append("SELECT distinct E FROM ").append(entityClass.getName()).append(" E ");
	sql.append("LEFT JOIN E.relRectIngs R ");
	boolean where = false;
	if(StringUtils.isNotBlank(nomRec)){
	    sql.append("WHERE E.nombre LIKE '%").append(nomRec).append("%' ");
	    where = true;
	}
	if(StringUtils.isNotBlank(nomIng)){
	    if(where){
		sql.append("AND ");
	    }else{
		sql.append("WHERE ");
	    }
	    sql.append("R.ingrediente.nombre LIKE '%").append(nomIng).append("%' ");
	}

	Query query = getJpaTemplate().getEntityManager().createQuery(sql.toString());
	query.setFirstResult(first);
	query.setMaxResults(pageSize);
	return query.getResultList();
    }

    @PostConstruct
    public void init() {
	super.setEntityManagerFactory(entityManagerFactoryLocal);
    }

}
