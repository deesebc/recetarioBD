package es.home.recetario.dto;

// Generated 19-nov-2011 18:20:01 by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Ingrediente generated by hbm2java
 */
@Entity
@Table(name = "ingrediente", catalog = "cocina")
public class IngredienteDTO implements java.io.Serializable {

    private static final long serialVersionUID = 3465130524916899813L;

    private Integer idIngrediente;

    private String nombre;
    private Set<RelRectIngDTO> relRectIngs = new HashSet<RelRectIngDTO>(0);

    public IngredienteDTO(){
	super();
    }


    public IngredienteDTO(final String nombre) {
	this.nombre = nombre;
    }

    public IngredienteDTO(final String nombre, final Set<RelRectIngDTO> relRectIngs) {
	this.nombre = nombre;
	this.relRectIngs = relRectIngs;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_ingrediente", unique = true, nullable = false)
    public Integer getIdIngrediente() {
	return this.idIngrediente;
    }

    @Column(name = "nombre", nullable = false, length = 45)
    public String getNombre() {
	return this.nombre;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ingrediente", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<RelRectIngDTO> getRelRectIngs() {
	return this.relRectIngs;
    }

    public void setIdIngrediente(final Integer idIngrediente) {
	this.idIngrediente = idIngrediente;
    }

    public void setNombre(final String nombre) {
	this.nombre = nombre;
    }

    public void setRelRectIngs(final Set<RelRectIngDTO> relRectIngs) {
	this.relRectIngs = relRectIngs;
    }

}