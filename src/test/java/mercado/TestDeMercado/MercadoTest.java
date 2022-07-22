package mercado.TestDeMercado;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import mercado.Excepciones.ClienteNoExisteException;
import mercado.Excepciones.SectorExisteException;
import mercado.Excepciones.*;
import mercado.Excepciones.ClienteExisteException;
import mercado.Facturacion.AdministradorFactura;
import mercado.Mercado.Mercado;
import mercado.Mercado.Sector;
import mercado.Usuario.Cliente;
import mercado.Usuario.Empresa;

public class MercadoTest {

    @Test
    public void agregarSector() {

        Sector sector = new Sector(1, "Sector A", "Sector de Verduleria");
        AdministradorFactura administrador = new AdministradorFactura();
        Mercado mercado = new Mercado("Mercadito", "avenida san martin", 01111, administrador);

        mercado.agregarSector(sector);

        assertEquals((Integer) 1, mercado.getCantidadDeSectores());

    }

    @Test(expected = SectorExisteException.class)

    public void agregarSectorExistente() {

        Sector sector = new Sector(1, "Sector A", "Sector de Verduleria");
        AdministradorFactura administrador = new AdministradorFactura();
        Mercado mercado = new Mercado("Mercadito", "avenida san martin", 01111, administrador);

        mercado.agregarSector(sector);

        mercado.agregarSector(sector);

    }

    @Test
    public void encontrarSector() {

        Sector sector = new Sector(1, "Sector A", "Sector de Verduleria");
        AdministradorFactura administrador = new AdministradorFactura();
        Mercado mercado = new Mercado("Mercadito", "avenida san martin", 01111, administrador);

        mercado.agregarSector(sector);
        mercado.encontrarSector(1);

        assertEquals((Integer) 1, sector.getIdentificacion());

    }

    @Test

    public void modificarSector() {

        Sector sector = new Sector(1, "Sector A", "Sector de Verduleria");
        Sector sector2 = new Sector(2, "Sector B", "Sector de Carniceria");
        AdministradorFactura administrador = new AdministradorFactura();
        Mercado mercado = new Mercado("Mercadito", "avenida san martin", 01111, administrador);

        mercado.agregarSector(sector);
        mercado.encontrarSector(1);
        mercado.modificarSector(sector2, 1);

        assertEquals((Integer) 1, sector.getIdentificacion());

    }

    @Test(expected = SectorNoExisteException.class)

    public void modificarSectorNoExistente() {

        Sector sector = new Sector(1, "Sector A", "Sector de Verduleria");
        Sector sector2 = new Sector(2, "Sector B", "Sector de Carniceria");
        AdministradorFactura administrador = new AdministradorFactura();
        Mercado mercado = new Mercado("Mercadito", "avenida san martin", 01111, administrador);

        mercado.agregarSector(sector);
        mercado.encontrarSector(1);
        mercado.modificarSector(sector2, 8);

    }

    @Test
    public void eliminarSector() {

        Sector sector = new Sector(1, "Sector A", "Sector de Verduleria");
        AdministradorFactura administrador = new AdministradorFactura();
        Mercado mercado = new Mercado("Mercadito", "avenida san martin", 01111, administrador);

        mercado.agregarSector(sector);
        mercado.encontrarSector(1);
        mercado.eliminarSector(1);

        assertEquals((Integer) 0, mercado.getCantidadDeSectores());

    }

    @Test
    public void agregarCliente() {

        Empresa empresa = new Empresa(3, "Via Bana", "Catamarca", "San Fernando del Valle de Catamarca",
                "viabana@gmail.com");
        AdministradorFactura administrador = new AdministradorFactura();
        Mercado mercado = new Mercado("Mercadito", "avenida san martin", 01111, administrador);

        mercado.agregarCliente(empresa);

        assertEquals((Integer) 1, mercado.getCantidadClientes());

    }

    @Test
    public void encontrarCliente() {

        Empresa empresa = new Empresa(3, "Via Bana", "Catamarca", "San Fernando del Valle de Catamarca",
                "viabana@gmail.com");
        AdministradorFactura administrador = new AdministradorFactura();
        Mercado mercado = new Mercado("Mercadito", "avenida san martin", 01111, administrador);

        mercado.agregarCliente(empresa);
        mercado.encontrarCliente(3);

        assertEquals((Integer) 3, empresa.getNumeroDeCliente());

    }

    @Test
    public void modificarCliente() {

        Empresa empresa = new Empresa(001, "Ferrari", "Rio Negro", "Viedma", "ferrari@gmail.com");
        AdministradorFactura administrador = new AdministradorFactura();
        Mercado mercado = new Mercado("Mercadito", "avenida san martin", 01111, administrador);

        mercado.agregarCliente(empresa);
        mercado.encontrarCliente(001);
        mercado.modificarCliente(empresa, 001);

        assertEquals((Integer) 001, empresa.getNumeroDeCliente());

    }

    @Test

    public void eliminarCliente() {

        Empresa empresa = new Empresa(001, "Ferrari", "Rio Negro", "Viedma", "ferrari@gmail.com");
        AdministradorFactura administrador = new AdministradorFactura();
        Mercado mercado = new Mercado("Mercadito", "avenida san martin", 01111, administrador);

        mercado.agregarCliente(empresa);
        mercado.encontrarCliente(001);
        mercado.eliminarCliente(001);

        assertEquals((Integer) 0, mercado.getCantidadClientes());

    }

    @Test(expected = ClienteNoExisteException.class)

    public void modificarClienteNoExistente() {

        Empresa empresa = new Empresa(33, "Via Bana", "Catamarca", "San Fernando del Valle de Catamarca",
                "viabana@gmail.com");
        AdministradorFactura administrador = new AdministradorFactura();
        Mercado mercado = new Mercado("Mercadito", "avenida san martin", 01111, administrador);

        mercado.modificarCliente(empresa, 33);

        Cliente clienteAgregado = mercado.obtenerCliente(3);

    }

    @Test(expected = ClienteExisteException.class)

    public void agregarClienteExistente() throws ClienteExisteException {

        Empresa empresa = new Empresa(1, "Via Bana", "Catamarca", "San Fernando del Valle de Catamarca",
                "viabana@gmail.com");

        AdministradorFactura administrador = new AdministradorFactura();
        Mercado mercado = new Mercado("Mercadito", "avenida san martin", 01111, administrador);

        mercado.agregarCliente(empresa);
        mercado.agregarCliente(empresa);

    }

}
