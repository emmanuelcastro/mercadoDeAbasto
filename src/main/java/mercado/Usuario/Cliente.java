package mercado.Usuario;

import mercado.Excepciones.*;

import java.util.ArrayList;

public abstract class Cliente {

    private Integer numeroDeCliente;
    private String razonSocial;
    private String provincia;
    private String localidad;
    private String direccionDeCorreoElectronico;
    private ArrayList<Contrato> contratos;

    public Cliente(Integer numeroDeCliente, String razonSocial, String provincia, String localidad,
            String direccionDeCorreoElectronico) {

        this.numeroDeCliente = numeroDeCliente;
        this.razonSocial = razonSocial;
        this.provincia = provincia;
        this.localidad = localidad;
        this.direccionDeCorreoElectronico = direccionDeCorreoElectronico;
        contratos = new ArrayList<Contrato>();
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDireccionDeCorreoElectronico() {
        return direccionDeCorreoElectronico;
    }

    public void setDireccionDeCorreoElectronico(String direccionDeCorreoElectronico) {
        this.direccionDeCorreoElectronico = direccionDeCorreoElectronico;
    }

    public Integer getNumeroDeCliente() {
        return numeroDeCliente;
    }

    public void setNumeroDeCliente(Integer numeroDeCliente) {
        this.numeroDeCliente = numeroDeCliente;
    }

    public ArrayList<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(ArrayList<Contrato> contratos) {
        this.contratos = contratos;
    }

    public void agregarContrato(Contrato contrato) { // Metodo para Agregar a un Contrato

        for (Contrato i : contratos) {

            if (i.equals(contrato)) {

                throw new ContratoExisteException();

            }

        }

        this.contratos.add(contrato);

    }

    public Integer getCantidadContratos() {

        Integer cantidad = contratos.size();

        return cantidad;

    }

    public Contrato encontrarContrato(Integer numeroDeContrato) { // Metodo para Buscar un Contrato

        Contrato contratoEncontrado = null;

        for (Contrato aux : contratos) {

            if (aux.getNumeroDeContrato() == numeroDeContrato) {

                contratoEncontrado = aux;
                break;
            }

        }
        if (contratoEncontrado == null) {

            throw new ContratoNoExisteException();

        }

        return contratoEncontrado;

    }

    public void eliminarCliente(Integer numeroDeContrato) {

        Contrato contratoParaEliminar = encontrarContrato(numeroDeContrato);

        contratos.remove(contratoParaEliminar);

    }

    public void modificarContrato(Contrato contrato, Integer numeroDeContrato) {

        Contrato contratoAEncontrar = encontrarContrato(numeroDeContrato);

        contratos.remove(contratoAEncontrar);

        this.contratos.add(contrato);

        if (contratoAEncontrar == null) {

            throw new ContratoNoExisteException();

        }

    }

}