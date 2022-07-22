package mercado.Mercado;

import mercado.Excepciones.*;
import java.util.ArrayList;
import mercado.Puesto.Puesto;

public class Sector {

    private Integer identificacion;
    private String nombreSector;
    private String descripcion;
    private ArrayList<Puesto> puestos;

    public Sector(Integer identificacion, String nombreSector, String descripcion) {
        this.identificacion = identificacion;
        this.nombreSector = nombreSector;
        this.descripcion = descripcion;
        puestos = new ArrayList<Puesto>();

    }

    public void setDescripcion(String vdescripcion) {

        this.descripcion = vdescripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombreSector() {
        return nombreSector;
    }

    public void setNombreSector(String nombreSector) {
        this.nombreSector = nombreSector;
    }

    public ArrayList<Puesto> getPuestos() {
        return puestos;
    }

    public void setPuestos(ArrayList<Puesto> puestos) {
        this.puestos = puestos;
    }

    public Integer getCantidadDePuestos() {

        Integer cantidad = puestos.size();

        return cantidad;

    }

    public void agregarPuesto(Puesto puesto) { // Metodo para agregar Puesto

        for (Puesto i : puestos) {

            if (i.equals(puesto)) {

                throw new PuestoExisteException();

            }

        }

        puestos.add(puesto);

    }

    public Puesto encontrarPuesto(long numeroDePuesto) { // Metodo para encontrar Puesto

        Puesto puestoEncontrado = null;

        for (Puesto aux : puestos) {

            if (aux.getNumeroDePuesto() == numeroDePuesto) {

                puestoEncontrado = aux;

                break;

            }

        }

        if (puestoEncontrado == null) {

            throw new PuestoNoExisteException();

        }

        return puestoEncontrado;

    }

    public void modificarPuesto(Puesto puesto, long numeroDePuesto) { // Metodo para modificar Puesto

        Puesto puestoAEncontrar = null;

        puestoAEncontrar = encontrarPuesto(numeroDePuesto);

        puestos.remove(puestoAEncontrar);

        this.puestos.add(puestoAEncontrar);

        if (puestoAEncontrar == null) {

            throw new PuestoExisteException();

        }

    }

    public void eliminarPuesto(long numeroDePuesto) { // Metodo para eliminar Puesto

        Puesto puestoParaEliminar = encontrarPuesto(numeroDePuesto);

        puestos.remove(puestoParaEliminar);

    }

}