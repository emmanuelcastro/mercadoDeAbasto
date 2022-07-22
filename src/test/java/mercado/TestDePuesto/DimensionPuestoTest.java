package mercado.TestDePuesto;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Test;
import mercado.Puesto.DimensionPuesto;

public class DimensionPuestoTest {

    @Test
    public void calcularMetrosCuadrados() {

        DimensionPuesto dimension = new DimensionPuesto(new BigDecimal(7.5), new BigDecimal(2.0), "Mercadito");
        BigDecimal resultado = dimension.calcularDimension();

        assertEquals(new BigDecimal(15), resultado);

    }

}
