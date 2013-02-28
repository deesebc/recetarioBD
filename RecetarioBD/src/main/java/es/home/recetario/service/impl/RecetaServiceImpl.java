/**
 * 
 */
package es.home.recetario.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.home.recetario.conversor.RecetaConversor;
import es.home.recetario.dao.RecetaDAO;
import es.home.recetario.dto.RecetaDTO;
import es.home.recetario.service.RecetaService;
import es.home.recetario.vo.Receta;

/**
 * @author daniel
 * 
 */
@Service("recetaServiceImpl")
@Transactional(value = "transactionManagerLocal")
public class RecetaServiceImpl implements RecetaService {


    private static final long serialVersionUID = 1L;

    @Autowired
    @Qualifier("recetaDaoImpl")
    private RecetaDAO dao;

    public void actualizarReceta(final Receta receta) {
	RecetaConversor ingConv = new RecetaConversor();
	RecetaDTO entity = ingConv.convert(receta);
	dao.merge(entity);
    }

    public List<Receta> buscarRecetaPaginadas(final String nomRec, final String nomIng, final int first, final int pageSize) {
	List<RecetaDTO> resultado =  dao.buscarRecetaPaginada(nomRec, nomIng, first, pageSize);
	RecetaConversor ingConv = new RecetaConversor();
	return ingConv.convertListaRevert(resultado);
    }


    public long contarRecetas() {
	return dao.countAll();
    }

    /**
     * @return the dao
     */
    public RecetaDAO getDao() {
	return dao;
    }

    public void guardarReceta(final Receta receta) {
	RecetaConversor convRec = new RecetaConversor();
	RecetaDTO dto = convRec.convert(receta);
	dto.setIdReceta(null);
	dao.persist(dto);
    }

    public Receta obtenerReceta(final int idReceta) {
	RecetaDTO resultado =  dao.findById(idReceta);
	RecetaConversor ingConv = new RecetaConversor();
	return ingConv.convertRevert(resultado);
    }

    /* (non-Javadoc)
     * @see es.home.recetario.service.RecetaService#paginarResultados(int, int)
     */
    public List<Receta> paginarResultados(final int first, final int pageSize) {
	List<RecetaDTO> resultado =  dao.findAllPaginate(first, pageSize, "nombre");
	RecetaConversor ingConv = new RecetaConversor();
	return ingConv.convertListaRevert(resultado);
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(final RecetaDAO dao) {
	this.dao = dao;
    }


}
