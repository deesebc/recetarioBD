/**
 * 
 */
package es.home.test.service;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import es.home.recetario.service.IngredienteService;
import es.home.recetario.service.RecetaService;
import es.home.recetario.vo.Ingrediente;
import es.home.recetario.vo.Receta;
import es.home.recetario.vo.RelRectIng;

/**
 * @author dsblanco
 * 
 */
public class RecetaServiceTest {
    private RecetaService service;
    private IngredienteService IngService;
    private ApplicationContext ctx;

    @Test
    public void actualizarReceta() {
	try{
	    Receta receta = service.obtenerReceta(1);
	    receta.getRelRectIngs().clear();
	    Ingrediente ingrediente = IngService.obtenerIngrediente(2);
	    RelRectIng relacion = new RelRectIng();
	    relacion.setIngrediente(ingrediente);
	    relacion.setReceta(receta);
	    receta.getRelRectIngs().add(relacion);
	    receta.setCantidades("q");
	    service.actualizarReceta(receta);
	}catch(Exception except){
	    except.printStackTrace();
	    Assert.isTrue(false);
	}
	Assert.isTrue(true);
    }

    @Test
    public void buscarPaginado() {
	String nomRec = null;
	String nomIng = "cebolla";
	List<Receta> lista = service.buscarRecetaPaginadas(nomRec, nomIng, 0, 3);
	System.out.println(lista.size());
	for(Receta recta : lista){
	    System.out.println(recta.getNombre());
	}
	Assert.isTrue(lista.size() > 0);
    }

    @After
    public void cleanup() {
	System.out.println("-- FIN --");
    }

    @Test
    public void contarRecetas() {
	long total = service.contarRecetas();
	System.out.println(total);
	Assert.isTrue(total > 0);
    }

    @Before
    public void init() {
	System.out.println("-- INICIO --");
	ctx = new ClassPathXmlApplicationContext("/es/home/recetario/context/appContextRecetaBD.xml");
	service = (RecetaService) ctx.getBean("recetaServiceImpl");
	IngService = (IngredienteService) ctx.getBean("ingredienteServiceImpl");;
    }

    @Test
    public void paginarResultados() {
	List<Receta> lista = service.paginarResultados(1, 3);
	System.out.println(lista.size());
	Assert.isTrue(lista.size() > 0);
    }

}
