/**
 * 
 */
package es.home.recetario.generic;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

/**
 * @author cristina
 * 
 */
public abstract class GenericConversorDozer<B, D> {

    protected final Mapper mapper;

    protected final Class<B> entityClassUno;
    protected final Class<D> entityClassDos;

    @SuppressWarnings("unchecked")
    public GenericConversorDozer() {
	ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
	this.entityClassUno = (Class<B>) genericSuperclass.getActualTypeArguments()[0];
	this.entityClassDos = (Class<D>) genericSuperclass.getActualTypeArguments()[1];
	// CONFIGURACION DOZER
	List<String> config = new ArrayList<String>();
	//config.add("dozer-bean-mapping.xml");
	mapper = new DozerBeanMapper(config);
    }

    public D convert(final B bean) {
	return mapper.map(bean, entityClassDos);
    }

    public List<D> convertLista(final List<B> lista) {
	List<D> resultado = new ArrayList<D>();
	iteraList(lista, resultado);
	return resultado;
    }

    public List<B> convertListaRevert(final List<D> lista) {
	List<B> resultado = new ArrayList<B>();
	iteraListRevert(lista, resultado);
	return resultado;
    }

    public B convertRevert(final D dto) {
	return mapper.map(dto, entityClassUno);
    }

    private void iteraList(final List<B> lista, final List<D> resultado) {
	if (lista != null && !lista.isEmpty()) {
	    for (B bean : lista) {
		resultado.add(convert(bean));
	    }
	}
    }

    private void iteraListRevert(final List<D> lista, final List<B> resultado) {
	if (lista != null && !lista.isEmpty()) {
	    for (D dto : lista) {
		resultado.add(convertRevert(dto));
	    }
	}
    }

}
