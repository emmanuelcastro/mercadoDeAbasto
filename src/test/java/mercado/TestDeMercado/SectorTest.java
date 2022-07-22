package mercado.TestDeMercado;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

import mercado.Excepciones.PuestoExisteException;
import mercado.Excepciones.PuestoNoExisteException;
import mercado.Medidor.Medidor;
import mercado.Mercado.Sector;
import mercado.Puesto.Puesto;
import mercado.Puesto.CaracteristicaPuesto;
import mercado.Puesto.DimensionPuesto;

public class SectorTest {

    @Test
    public void agregarPuesto() {

        Sector sector = new Sector(01, "Sector A", "Sector de Verduleria");
        CaracteristicaPuesto caracteristicas = new CaracteristicaPuesto(true, false, "Puesto Semi-Completo");
        Medidor medidor = new Medidor(01, (LocalDate.parse("2010-05-23")));
        DimensionPuesto dimensiones = new DimensionPuesto(new BigDecimal(20), new BigDecimal(20), "puesto6");
        Puesto puesto = new Puesto(medidor, caracteristicas, 022, 0.10, 0.10, new BigDecimal(100), dimensiones);

        sector.agregarPuesto(puesto);

        assertEquals((Integer) 1, sector.getCantidadDePuestos());

    }

    @Test(expected = PuestoExisteException.class)

    public void AgregarPuestoExistente() {

        Sector sector = new Sector(01, "Sector A", "Sector de Verduleria");
        CaracteristicaPuesto caracteristicas = new CaracteristicaPuesto(true, false, "Puesto Semi-Completo");
        Medidor medidor = new Medidor(01, (LocalDate.parse("2010-05-23")));
        DimensionPuesto dimensiones = new DimensionPuesto(new BigDecimal(20), new BigDecimal(20), "puesto6");
        Puesto puesto = new Puesto(medidor, caracteristicas, 022, 0.10, 0.10, new BigDecimal(100), dimensiones);

        sector.agregarPuesto(puesto);
        sector.agregarPuesto(puesto);

    }

    @Test
    public void encontrarPuesto() {

        Sector sector = new Sector(1, "Sector B", "Sector Hogar");
        CaracteristicaPuesto caracteristicas = new CaracteristicaPuesto(true, false, "Puesto Semi-Completo");
        Medidor medidor = new Medidor(01, (LocalDate.parse("2010-05-23")));
        DimensionPuesto dimensiones = new DimensionPuesto(new BigDecimal(20), new BigDecimal(20), "puesto6");

        Puesto puesto = new Puesto(medidor, caracteristicas, 1, 0.10, 0.10, new BigDecimal(100), dimensiones);

        sector.agregarPuesto(puesto);
        sector.encontrarPuesto(1);

        assertEquals((Integer) 1, sector.getIdentificacion());

    }

    @Test(expected = PuestoNoExisteException.class)

    public void PuestoAModificarNoExiste() {

        Sector sector = new Sector(1, "Sector B", "Sector Hogar");
        CaracteristicaPuesto caracteristicas = new CaracteristicaPuesto(true, false, "Puesto Semi-Completo");
        Medidor medidor = new Medidor(01, (LocalDate.parse("2010-05-23")));
        DimensionPuesto dimensiones = new DimensionPuesto(new BigDecimal(20), new BigDecimal(20), "puesto6");
        Puesto puesto = new Puesto(medidor, caracteristicas, 1, 0.10, 0.10, new BigDecimal(100), dimensiones);

        sector.agregarPuesto(puesto);
        sector.encontrarPuesto(1);
        sector.modificarPuesto(puesto, 48);

    }

    @Test
    public void modificarPuesto() {

        Sector sector = new Sector(1, "Sector B", "Sector Hogar");
        CaracteristicaPuesto caracteristicas = new CaracteristicaPuesto(true, false, "Puesto Semi-Completo");
        Medidor medidor = new Medidor(01, (LocalDate.parse("2010-05-23")));
        DimensionPuesto dimensiones = new DimensionPuesto(new BigDecimal(20), new BigDecimal(20), "puesto6");
        Puesto puesto = new Puesto(medidor, caracteristicas, 1, 0.10, 0.10, new BigDecimal(100), dimensiones);

        sector.agregarPuesto(puesto);
        sector.encontrarPuesto(1);
        sector.modificarPuesto(puesto, 1);

        assertEquals((Integer) 1, sector.getIdentificacion());

    }

    @Test
    public void eliminarPuesto() {

        Sector sector = new Sector(01, "Sector B", "Sector Hogar");
        CaracteristicaPuesto caracteristicas = new CaracteristicaPuesto(true, false, "Puesto Semi-Completo");
        Medidor medidor = new Medidor(01, (LocalDate.parse("2010-05-23")));
        DimensionPuesto dimensiones = new DimensionPuesto(new BigDecimal(20), new BigDecimal(20), "puesto6");

        Puesto puesto = new Puesto(medidor, caracteristicas, 1, 0.10, 0.10, new BigDecimal(100), dimensiones);

        sector.agregarPuesto(puesto);
        sector.encontrarPuesto(1);
        sector.eliminarPuesto(1);

        assertEquals((Integer) 0, sector.getCantidadDePuestos());

    }

}
