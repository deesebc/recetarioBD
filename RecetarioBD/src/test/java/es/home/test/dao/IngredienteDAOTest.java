/**
 * 
 */
package es.home.test.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import es.home.recetario.dao.IngredienteDAO;
import es.home.recetario.dto.IngredienteDTO;

/**
 * @author dsblanco
 * 
 */
public class IngredienteDAOTest {
	private static final Logger LOGGER = Logger.getLogger(IngredienteDAOTest.class);
	private IngredienteDAO dao;
	private ApplicationContext ctx;

	@After
	public void cleanup() {
		System.out.println("-- FIN --");
	}

	@Test
	public void countAll() {
		long total = dao.countAll();
		System.out.println(total);
		Assert.isTrue(total > 0);
	}

	@Test
	public void findAll() {
		List<IngredienteDTO> lista = dao.findAll();
		System.out.println(lista);
		Assert.isTrue(lista.size() > 0);
	}

	@Before
	public void init() {
		System.out.println("-- INICIO --");
		ctx = new ClassPathXmlApplicationContext(
				"/es/home/recetario/context/appContextRecetaBD.xml");
		dao = (IngredienteDAO) ctx.getBean("ingredidenteDaoImpl");
	}

	@Test
	@Ignore
	public void remove() {
		try {
			IngredienteDTO objeto = dao.findById(1);

			dao.remove(objeto);
		} catch (Exception except) {
			LOGGER.error("error al borrar", except);
		}
	}

}
