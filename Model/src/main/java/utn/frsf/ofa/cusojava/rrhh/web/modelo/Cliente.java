package utn.frsf.ofa.cusojava.rrhh.web.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({ @NamedQuery(name = "Cliente.findAll", query = "select c from Cliente c") })
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    String nombre;
    String correo;
    String cuit;
    
    @OneToMany(mappedBy = "cliente")
     private List<Proyecto> proyectos;

    public Cliente() {
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

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getCuit() {
        return cuit;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public List<Proyecto> getProyectos() {
        return proyectos;
    }
}
