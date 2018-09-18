package utn.frsf.ofa.cusojava.rrhh.web.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    String nombre;
    String descripcion;
    Double presupuestoMaximo;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(name = "PROYECTO_EMPLEADO", joinColumns = @JoinColumn(name = "ID_PROYECTO"),
               inverseJoinColumns = @JoinColumn(name = "ID_EMPLEADO"))
    private List<Empleado> empleados;

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

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setPresupuestoMaximo(Double presupuestoMaximo) {
        this.presupuestoMaximo = presupuestoMaximo;
    }

    public Double getPresupuestoMaximo() {
        return presupuestoMaximo;
    }

    public Proyecto() {
        super();
    }

    public String toString() {
        return this.getId() + " - " + this.getNombre() + ": " + this.getDescripcion() + " (Presupuesto Máximo: " +
               this.getPresupuestoMaximo() + ")";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Proyecto)) {
            return false;
        }
        return true;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
}
