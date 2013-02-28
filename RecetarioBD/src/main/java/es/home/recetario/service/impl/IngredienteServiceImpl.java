/**
 * 
 */
package es.home.recetario.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.home.recetario.conversor.IngredienteConversor;
import es.home.recetario.dao.IngredienteDAO;
import es.home.recetario.dto.IngredienteDTO;
import es.home.recetario.service.IngredienteService;
import es.home.recetario.vo.Ingrediente;

/**
 * @author daniel
 * 
 */
@Service("ingredienteServiceImpl")
@Transactional(value = "transactionManagerLocal")
public class IngredienteServiceImpl implements IngredienteService {

    private static final long serialVersionUID = -7932025244770663783L;
    private static final Logger LOGGER = Logger.getLogger(IngredienteServiceImpl.class);

    @Autowired
    @Qualifier("ingredidenteDaoImpl")
    private IngredienteDAO dao;

    public boolean actualizar(final Ingrediente ingrediente) {
        boolean correcto = true;
        try {
            final IngredienteConversor ingConv = new IngredienteConversor();
            final IngredienteDTO dto = ingConv.convert(ingrediente);
            dao.merge(dto);
        } catch (final Exception except) {
            LOGGER.error("Error al actualizar el ingrediente: " + ingrediente.getIdIngrediente(),
                    except);
            correcto = false;
        }
        return correcto;
    }

    public boolean borrar(final Ingrediente ingrediente) {
        boolean correcto = true;
        try {
            final IngredienteConversor ingConv = new IngredienteConversor();
            final IngredienteDTO dto = ingConv.convert(ingrediente);
            dao.remove(dto);
        } catch (final Exception except) {
            LOGGER.error("Error al borrar el ingrediente: " + ingrediente.getIdIngrediente(),
                    except);
            correcto = false;
        }
        return correcto;
    }

    public List<Ingrediente> buscarIngPaginado(final String nombre, final int first,
            final int pageSize) {
        final List<IngredienteDTO> resultado = dao.buscarIngPaginado(nombre, first, pageSize);
        final IngredienteConversor ingConv = new IngredienteConversor();
        return ingConv.convertListaRevert(resultado);
    }

    @Transactional
    public int contarIngredientes() {
        return dao.countAll().intValue();
    }

    public boolean crear(final String nombre) {
        boolean correcto = true;
        try {
            final IngredienteDTO dto = new IngredienteDTO();
            dto.setNombre(nombre);
            dao.persist(dto);
        } catch (final Exception except) {
            LOGGER.error("Error al guardar el ingrediente: " + nombre, except);
            correcto = false;
        }
        return correcto;
    }

    /**
     * @return the dao
     */
    public IngredienteDAO getDao() {
        return dao;
    }

    public Ingrediente obtenerIngrediente(final int idIngrediente) {
        final IngredienteDTO resultado = dao.findById(idIngrediente);
        final IngredienteConversor ingConv = new IngredienteConversor();
        return ingConv.convertRevert(resultado);
    }

    public List<Ingrediente> paginarResultados(final int first, final int pageSize) {
        final List<IngredienteDTO> resultado = dao.findAllPaginate(first, pageSize, "nombre");
        final IngredienteConversor ingConv = new IngredienteConversor();
        return ingConv.convertListaRevert(resultado);
    }

    /**
     * 
     * @param dao
     *            the dao to set
     */
    public void setDao(final IngredienteDAO dao) {
        this.dao = dao;
    }

}
