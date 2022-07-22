package mercado.TestDePuesto;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

import mercado.Medidor.Medidor;

import mercado.Puesto.CaracteristicaPuesto;
import mercado.Puesto.DimensionPuesto;
import mercado.Puesto.Puesto;

public class PuestoTest {

    @Test

    public void calcularPrecioDePuesto() {

        Medidor medidor = new Medidor(10, LocalDate.parse("2020-05-23"));
        CaracteristicaPuesto caracteristicaPuesto = new CaracteristicaPuesto(true, false, "Puesto Techado");
        DimensionPuesto dimensionPuesto = new DimensionPuesto(new BigDecimal(7.5), new BigDecimal(2.0), ".");
        Puesto puesto = new Puesto(medidor, caracteristicaPuesto, 001, 0.10, 0.10, new BigDecimal(100),
                dimensionPuesto);

        BigDecimal resultado = puesto.precioDePuesto();

        assertEquals(new BigDecimal(1650), resultado);

    }

}
