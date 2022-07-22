package mercado.TestDeUsuario;

import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import org.junit.Test;

import mercado.Medidor.Medidor;
import mercado.Puesto.CaracteristicaPuesto;
import mercado.Puesto.DimensionPuesto;
import mercado.Puesto.Puesto;
import mercado.Usuario.Contrato;

public class ContratoTest {

    @Test

    public void calcularPrecioAlquiler() {
        Medidor medidor = new Medidor(01, LocalDate.parse("2010-05-23"));
        CaracteristicaPuesto caracteristicas = new CaracteristicaPuesto(true, true, "Puesto Premium");
        DimensionPuesto dimension = new DimensionPuesto(new BigDecimal(10.0), new BigDecimal(3.0), "puesto1");
        Puesto puesto = new Puesto(medidor, caracteristicas, 002, 0.10, 0.10, new BigDecimal(100), dimension);
        Contrato contrato = new Contrato(LocalDate.parse("2010-05-23"), LocalDate.parse("2010-10-23"), null, 05,
                puesto);

        BigDecimal resultado = contrato.getPrecioDeAlquiler();

        assertEquals(new BigDecimal(18150), resultado);
    }

}
