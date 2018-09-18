package utn.frsf.ofa.cusojava.rrhh.web.modelo;

import java.util.Date;
import java.util.Deque;
import java.util.List;
import java.util.NavigableMap;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.ManyToMany;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER, name ="TIPO_EMPLEADO" )
public abstract class Empleado{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String nombre;
    String correoElectronico;
    String cuil;
    Date fechaIngreso;
    Integer horasTrabajadas;
    Integer tipo_empleado;
    
    @ManyToMany(mappedBy = "empleados")
    protected List<Proyecto> proyectosAsignados;

    
    public Empleado() {
        super();
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getCuil() {
        return cuil;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setHorasTrabajadas(Integer horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public Integer getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public abstract Double salario();
    
    public abstract boolean esEfectivo();
    
    public abstract boolean esContratado();
    
    
    public static void main(String[] args) {
    }

    public void setTipo_empleado(Integer tipo_empleado) {
        this.tipo_empleado = tipo_empleado;
    }

    public Integer getTipo_empleado() {
        return tipo_empleado;
    }

    public void setProyectosAsignados(List<Proyecto> proyectosAsignados) {
        this.proyectosAsignados = proyectosAsignados;
    }

    public List<Proyecto> getProyectosAsignados() {
        return proyectosAsignados;
    }
}
