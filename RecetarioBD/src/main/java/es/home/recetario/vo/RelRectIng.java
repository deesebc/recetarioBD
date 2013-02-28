package es.home.recetario.vo;



public class RelRectIng implements java.io.Serializable {

    private static final long serialVersionUID = 4015209316117498519L;

    private int idRectIng;
    private Receta receta;
    private Ingrediente ingrediente;

    public RelRectIng(){
	super();
	receta = new Receta();
	ingrediente = new Ingrediente();
    }


    public RelRectIng(final Receta receta, final Ingrediente ingrediente) {
	this.receta = receta;
	this.ingrediente = ingrediente;
    }

    public int getIdRectIng() {
	return this.idRectIng;
    }

    public Ingrediente getIngrediente() {
	return this.ingrediente;
    }

    public Receta getReceta() {
	return this.receta;
    }

    public void setIdRectIng(final int idRectIng) {
	this.idRectIng = idRectIng;
    }

    public void setIngrediente(final Ingrediente ingrediente) {
	this.ingrediente = ingrediente;
    }

    public void setReceta(final Receta receta) {
	this.receta = receta;
    }

}
