package mercado.Mercado;

import java.util.ArrayList;
import mercado.Usuario.Cliente;
import mercado.Usuario.Contrato;
import mercado.Excepciones.*;
import mercado.Facturacion.AdministradorFactura;
import mercado.Facturacion.Factura;

public class Mercado {

    private String nombre;
    private String direccion;
    private Integer telefono;
    private AdministradorFactura administradorFacturas;
    private ArrayList<Sector> sectores;
    private ArrayList<Factura> facturas;
    private ArrayList<Cliente> clientes;
    private ArrayList<Contrato> contratos;

    public Mercado(String nombre, String direccion, Integer telefono, AdministradorFactura administradorFactura) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.administradorFacturas = administradorFactura;
        facturas = new ArrayList<Factura>();
        sectores = new ArrayList<Sector>();
        clientes = new ArrayList<Cliente>();
        contratos = new ArrayList<Contrato>();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Sector> getSectores() {
        return sectores;
    }

    public void setSectores(ArrayList<Sector> sectores) {
        this.sectores = sectores;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(ArrayList<Contrato> contratos) {
        this.contratos = contratos;
    }

    public AdministradorFactura getAdministradorFacturas() {
        return administradorFacturas;
    }

    public void setAdministradorFacturas(AdministradorFactura administradorFacturas) {
        this.administradorFacturas = administradorFacturas;
    }

    // CLIENTE//

    public void agregarCliente(Cliente cliente) { // Metodo para Agregar a un Cliente

        for (Cliente i : clientes) {

            if (i.equals(cliente)) {

                throw new ClienteExisteException();

            }

        }

        this.clientes.add(cliente);

    }

    public Integer getCantidadClientes() {

        Integer cantidad = clientes.size();

        return cantidad;

    }

    public Cliente encontrarCliente(Integer numeroDeCliente) { // Metodo para Buscar un Cliente

        Cliente clienteEncontrado = null;

        for (Cliente aux : clientes) {

            if (aux.getNumeroDeCliente() == numeroDeCliente) {

                clienteEncontrado = aux;
                break;
            }

        }
        if (clienteEncontrado == null) {

            throw new ClienteNoExisteException();

        }

        return clienteEncontrado;

    }

    public void eliminarCliente(Integer numeroDeCliente) {

        Cliente clienteParaEliminar = encontrarCliente(numeroDeCliente);

        clientes.remove(clienteParaEliminar);

    }

    public void modificarCliente(Cliente cliente, Integer numeroDeCliente) {

        Cliente clienteAEncontrar = encontrarCliente(numeroDeCliente);

        clientes.remove(clienteAEncontrar);

        this.clientes.add(cliente);

        if (clienteAEncontrar == null) {

            throw new ClienteNoExisteException();

        }

    }

    public Integer getCantidadDeSectores() {

        Integer cantidad = sectores.size();

        return cantidad;

    }

    public void agregarSector(Sector sector) {

        for (Sector i : sectores) {

            if (i.equals(sector)) {

                throw new SectorExisteException();

            }

        }

        this.sectores.add(sector);

    }

    public Sector encontrarSector(Integer identificacion) {

        Sector sectorEncontrado = null;

        for (Sector aux : sectores) {

            if (aux.getIdentificacion() == identificacion) {

                sectorEncontrado = aux;

                break;
            }

        }

        if (sectorEncontrado == null) {

            throw new SectorNoExisteException();
        }

        return sectorEncontrado;
    }

    public void eliminarSector(Integer identificacion) {

        Sector sectorParaEliminar = encontrarSector(identificacion);

        sectores.remove(sectorParaEliminar);

    }

    public void modificarSector(Sector sector, Integer identificacion) {

        Sector sectorAEncontrar = encontrarSector(identificacion);

        sectores.remove(sectorAEncontrar);

        this.sectores.add(sector);

        if (sectorAEncontrar == null) {

            throw new SectorNoExisteException();

        }

    }

    public Cliente obtenerCliente(Integer numeroDeCliente) {

        Cliente clienteEncontrado = null;

        for (Cliente var : clientes) {

            if (var.getNumeroDeCliente().equals(numeroDeCliente)) {

                clienteEncontrado = var;

                break;
            }
        }
        if (clienteEncontrado == null) {

            throw new ClienteNoExisteException();

        }
        return clienteEncontrado;
    }

}