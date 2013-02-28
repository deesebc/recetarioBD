/**
 * 
 */
package es.home.test.service;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import es.home.recetario.service.IngredienteService;
import es.home.recetario.vo.Ingrediente;

/**
 * @author dsblanco
 * 
 */
public class IngredienteServiceTest {
    private IngredienteService service;
    private ApplicationContext ctx;

    @Test
    public void actualizar() {
	Ingrediente ing = service.obtenerIngrediente(1);
	String nombre = "pasta 2";
	ing.setNombre(nombre);
	service.actualizar(ing);
	ing = service.obtenerIngrediente(1);
	System.out.println(ing.getNombre());
	Assert.isTrue(nombre.equals(ing.getNombre()));
    }

    @After
    public void cleanup() {
	System.out.println("-- FIN --");
    }

    @Test
    public void contarIngredientes() {
	long total = service.contarIngredientes();
	System.out.println(total);
	Assert.isTrue(total > 0);
    }

    @Test
    @Ignore
    public void crear() {
	try{
	    String nombre = "pasta 3";
	    service.crear(nombre);
	    Assert.isTrue(true);
	}catch(Exception except){
	    except.printStackTrace();
	    Assert.isTrue(false);
	}
    }

    @Before
    public void init() {
	System.out.println("-- INICIO --");
	ctx = new ClassPathXmlApplicationContext("/es/home/recetario/context/appContextRecetaBD.xml");
	service = (IngredienteService) ctx.getBean("ingredienteServiceImpl");
    }

    @Test
    public void paginarResultados() {
	List<Ingrediente> lista = service.paginarResultados(1, 3);
	System.out.println(lista.size());
	Assert.isTrue(lista.size() > 0);
    }

}
