package mx.com.tsis.rest.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * A Empleado.
 */
@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 40)
    @Column(name = "nombre", length = 40, nullable = false)
    private String nombre;
    
    @NotNull
    @Size(max = 40)
    @Column(name = "apellido1", length = 40, nullable = false)
    private String apellido1;
    
    @Size(max = 40)
    @Column(name = "apellido2", length = 40)
    private String apellido2;
    
    @NotNull
    @Column(name = "ingreso", nullable = false)
    private Date ingreso;
    
    @NotNull
    @Column(name = "sueldo", precision=10, scale=2, nullable = false)
    private BigDecimal sueldo;

    public Empleado(){
    	
    }
    
	public Empleado(Long id, String nombre, String apellido1, String apedllido2, Date ingreso, BigDecimal salario ){
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apedllido2;
		this.ingreso = ingreso;
		this.sueldo = salario;
	}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }
    
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }
    
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date getIngreso() {
        return ingreso;
    }
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public void setIngreso(Date ingreso) {
        this.ingreso = ingreso;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }
    
    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Empleado empleado = (Empleado) o;
        if(empleado.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, empleado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Empleado{" +
            "id=" + id +
            ", nombre='" + nombre + "'" +
            ", apellido1='" + apellido1 + "'" +
            ", apellido2='" + apellido2 + "'" +
            ", ingreso='" + ingreso + "'" +
            ", sueldo='" + sueldo + "'" +
            '}';
    }
}