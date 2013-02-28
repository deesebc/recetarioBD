package es.home.recetario.vo;


import java.util.HashSet;
import java.util.Set;

public class Receta implements java.io.Serializable {

    private static final long serialVersionUID = 6210631412420659977L;

    private int idReceta;

    private String nombre;
    private String datos;
    private String cantidades;
    private Set<RelRectIng> relRectIngs = new HashSet<RelRectIng>(0);
    public Receta(){
	super();
    }

    public Receta(final String nombre, final String datos) {
	this.nombre = nombre;
	this.datos = datos;
    }

    public Receta(final String nombre, final String datos, final Set<RelRectIng> relRectIngs) {
	this.nombre = nombre;
	this.datos = datos;
	this.relRectIngs = relRectIngs;
    }

    /**
     * @return the cantidades
     */
    public String getCantidades() {
	return cantidades;
    }

    public String getDatos() {
	return this.datos;
    }

    public int getIdReceta() {
	return this.idReceta;
    }

    public String getNombre() {
	return this.nombre;
    }

    public Set<RelRectIng> getRelRectIngs() {
	return this.relRectIngs;
    }

    /**
     * @param cantidades the cantidades to set
     */
    public void setCantidades(final String cantidades) {
	this.cantidades = cantidades;
    }

    public void setDatos(final String datos) {
	this.datos = datos;
    }

    public void setIdReceta(final int idReceta) {
	this.idReceta = idReceta;
    }

    public void setNombre(final String nombre) {
	this.nombre = nombre;
    }

    public void setRelRectIngs(final Set<RelRectIng> relRectIngs) {
	this.relRectIngs = relRectIngs;
    }

}
