package mercado.TestDeUsuario;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import mercado.Excepciones.*;
import mercado.Medidor.Medidor;
import mercado.Puesto.CaracteristicaPuesto;
import mercado.Puesto.DimensionPuesto;
import mercado.Puesto.Puesto;

import mercado.Usuario.Contrato;
import mercado.Usuario.Empresa;

public class ClienteTest {

    @Test

    public void agregarContrato() {

        Empresa empresa = new Empresa(01, "arcor", "Catamarca", "capital", "arcor@gmail.com");
        Medidor medidor = new Medidor(10, LocalDate.parse("2020-05-23"));
        CaracteristicaPuesto caracteristicaPuesto = new CaracteristicaPuesto(false, false, "Puesto Basico");
        DimensionPuesto dimensionPuesto = new DimensionPuesto(new BigDecimal(7.5), new BigDecimal(2.0), ".");
        Puesto puesto = new Puesto(medidor, caracteristicaPuesto, 001, 0.10, 0.10, new BigDecimal(100),
                dimensionPuesto);
        Contrato contrato = new Contrato(LocalDate.parse("2010-05-23"), LocalDate.parse("1974-05-28"), null, 1, puesto);

        empresa.agregarContrato(contrato);

        assertEquals((Integer) 1, empresa.getCantidadContratos());

    }

    @Test(expected = ContratoExisteException.class)
    public void agregarContratoExistente() {

        Empresa empresa = new Empresa(01, "arcor", "Catamarca", "capital", "arcor@gmail.com");
        Medidor medidor = new Medidor(10, LocalDate.parse("2020-05-23"));
        CaracteristicaPuesto caracteristicaPuesto = new CaracteristicaPuesto(false, false, "Puesto Basico");
        DimensionPuesto dimensionPuesto = new DimensionPuesto(new BigDecimal(7.5), new BigDecimal(2.0), ".");
        Puesto puesto = new Puesto(medidor, caracteristicaPuesto, 001, 0.10, 0.10, new BigDecimal(100),
                dimensionPuesto);
        Contrato contrato = new Contrato(LocalDate.parse("2010-05-23"), LocalDate.parse("1974-05-28"), null, 1, puesto);

        empresa.agregarContrato(contrato);
        empresa.agregarContrato(contrato);

    }

    @Test(expected = ContratoNoExisteException.class)
    public void agregarContratoNoExistente() {

        Empresa empresa = new Empresa(01, "arcor", "Catamarca", "capital", "arcor@gmail.com");
        Medidor medidor = new Medidor(10, LocalDate.parse("2020-05-23"));
        CaracteristicaPuesto caracteristicaPuesto = new CaracteristicaPuesto(false, false, "Puesto Basico");
        DimensionPuesto dimensionPuesto = new DimensionPuesto(new BigDecimal(7.5), new BigDecimal(2.0), ".");
        Puesto puesto = new Puesto(medidor, caracteristicaPuesto, 001, 0.10, 0.10, new BigDecimal(100),
                dimensionPuesto);
        Contrato contrato = new Contrato(LocalDate.parse("2010-05-23"), LocalDate.parse("1974-05-28"), null, 1, puesto);

        empresa.agregarContrato(contrato);

        Contrato clienteModificado = empresa.encontrarContrato(13);

    }

    @Test
    public void encontrarContrato() {
        Empresa empresa = new Empresa(01, "arcor", "Catamarca", "capital", "arcor@gmail.com");
        Medidor medidor = new Medidor(10, LocalDate.parse("2020-05-23"));
        CaracteristicaPuesto caracteristicaPuesto = new CaracteristicaPuesto(false, false, "Puesto Basico");
        DimensionPuesto dimensionPuesto = new DimensionPuesto(new BigDecimal(7.5), new BigDecimal(2.0), ".");
        Puesto puesto = new Puesto(medidor, caracteristicaPuesto, 001, 0.10, 0.10, new BigDecimal(100),
                dimensionPuesto);
        Contrato contrato = new Contrato(LocalDate.parse("2010-05-23"), LocalDate.parse("1974-05-28"), null, 1, puesto);

        empresa.agregarContrato(contrato);
        empresa.encontrarContrato(1);

        assertEquals((Integer) 1, contrato.getNumeroDeContrato());

    }

    @Test
    public void modificarContrato() {

        Empresa empresa = new Empresa(01, "Arcor", "Catamarca", "capital", "arcor@gmail.com");
        Medidor medidor = new Medidor(10, LocalDate.parse("2020-05-23"));
        CaracteristicaPuesto caracteristicaPuesto = new CaracteristicaPuesto(false, false, "Puesto Basico");
        DimensionPuesto dimensionPuesto = new DimensionPuesto(new BigDecimal(7.5), new BigDecimal(2.0), ".");
        Puesto puesto = new Puesto(medidor, caracteristicaPuesto, 001, 0.10, 0.10, new BigDecimal(100),
                dimensionPuesto);
        Contrato contrato = new Contrato(LocalDate.parse("2010-05-23"), LocalDate.parse("1974-05-28"), null, 1, puesto);

        empresa.agregarContrato(contrato);
        empresa.encontrarContrato(01);
        empresa.modificarContrato(contrato, 01);

        assertEquals((Integer) 1, contrato.getNumeroDeContrato());

    }

    @Test
    public void EliminarContrato() {

        Empresa empresa = new Empresa(01, "arcor", "Catamarca", "capital", "arcor@gmail.com");
        Medidor medidor = new Medidor(10, LocalDate.parse("2020-05-23"));
        CaracteristicaPuesto caracteristicaPuesto = new CaracteristicaPuesto(false, false, "Puesto Basico");
        DimensionPuesto dimensionPuesto = new DimensionPuesto(new BigDecimal(7.5), new BigDecimal(2.0), ".");
        Puesto puesto = new Puesto(medidor, caracteristicaPuesto, 001, 0.10, 0.10, new BigDecimal(100),
                dimensionPuesto);
        Contrato contrato = new Contrato(LocalDate.parse("2010-05-23"), LocalDate.parse("1974-05-28"), null, 1, puesto);

        empresa.agregarContrato(contrato);
        empresa.encontrarContrato(1);
        empresa.eliminarCliente(1);

        assertEquals((Integer) 0, empresa.getCantidadContratos());

    }

}
