package es.home.recetario.vo;


import java.util.HashSet;
import java.util.Set;

public class Ingrediente implements java.io.Serializable {
    private static final long serialVersionUID = 3465130524916899813L;

    private int idIngrediente;

    private String nombre;

    private Set<RelRectIng> relRectIngs = new HashSet<RelRectIng>(0);

    public Ingrediente(){
	super();
    }
    public Ingrediente(final String nombre) {
	this.nombre = nombre;
    }
    public Ingrediente(final String nombre, final Set<RelRectIng> relRectIngs) {
	this.nombre = nombre;
	this.relRectIngs = relRectIngs;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
	boolean retorno = false;
	if(obj != null && obj instanceof Ingrediente && ((Ingrediente)obj).getIdIngrediente() == this.idIngrediente){
	    retorno = true;
	}
	return retorno;
    }

    public int getIdIngrediente() {
	return this.idIngrediente;
    }

    public String getNombre() {
	return this.nombre;
    }

    public Set<RelRectIng> getRelRectIngs() {
	return this.relRectIngs;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	return idIngrediente * 37 +17;
    }

    public void setIdIngrediente(final int idIngrediente) {
	this.idIngrediente = idIngrediente;
    }

    public void setNombre(final String nombre) {
	this.nombre = nombre;
    }

    public void setRelRectIngs(final Set<RelRectIng> relRectIngs) {
	this.relRectIngs = relRectIngs;
    }

}
