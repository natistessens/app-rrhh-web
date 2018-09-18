package utn.frsf.ofa.cusojava.rrhh.web;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import utn.frsf.ofa.cusojava.rrhh.web.service.ClienteResource;

@ApplicationPath("/api")
public class AplicacionRRHH extends Application {
    public AplicacionRRHH() {
        super();
    }
    
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(ClienteResource.class);
        return classes;
    }
}
