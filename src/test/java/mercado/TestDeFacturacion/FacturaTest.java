package mercado.TestDeFacturacion;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

import mercado.Excepciones.CobrableExisteException;
import mercado.Excepciones.CobrableNoExisteException;
import mercado.Facturacion.Factura;

import mercado.Medidor.LecturaMedidor;
import mercado.Medidor.Medidor;
import mercado.Puesto.CaracteristicaPuesto;
import mercado.Puesto.DimensionPuesto;
import mercado.Puesto.Puesto;
import mercado.Usuario.Contrato;
import mercado.Usuario.Quintero;

public class FacturaTest {

        @Test

        public void agregarCobros() {

                Quintero quintero = new Quintero(002, "Bonanza", "Salta", "Salta", "bonanza@gmail.com");
                Factura factura = new Factura(001, LocalDate.parse("2010-05-23"), LocalDate.parse("1974-05-28"),
                                "Descripcion", quintero);
                Medidor medidor = new Medidor(001, LocalDate.parse("2010-05-28"));
                CaracteristicaPuesto caracteristicaPuesto = new CaracteristicaPuesto(false, false, "Puesto Basico");
                DimensionPuesto dimensionPuesto = new DimensionPuesto(new BigDecimal(7.5), new BigDecimal(2.0),
                                "Lo de Paco");
                Puesto puesto = new Puesto(medidor, caracteristicaPuesto, 001, 0.10, 0.10, new BigDecimal(10),
                                dimensionPuesto);
                Contrato contrato = new Contrato(LocalDate.parse("2010-05-23"), LocalDate.parse("1974-05-28"), null, 1,
                                puesto);
                LecturaMedidor lectura = new LecturaMedidor(LocalDate.now(), new BigDecimal(10), new BigDecimal(20));

                factura.agregarCobros(contrato);
                factura.agregarCobros(lectura);

                assertEquals((Integer) 2, factura.getCantidadDeCobros());

        }

        @Test(expected = CobrableExisteException.class)

        public void agregarCobroExistente() {

                Quintero quintero = new Quintero(002, "Bonanza", "Salta", "Salta", "bonanza@gmail.com");
                Factura factura = new Factura(001, LocalDate.parse("2010-05-23"), LocalDate.parse("1974-05-28"),
                                "Descripcion", quintero);
                Medidor medidor = new Medidor(001, LocalDate.parse("2010-05-28"));
                CaracteristicaPuesto caracteristicaPuesto = new CaracteristicaPuesto(false, false, "Puesto Basico");
                DimensionPuesto dimensionPuesto = new DimensionPuesto(new BigDecimal(7.5), new BigDecimal(2.0),
                                "Lo de Paco");
                Puesto puesto = new Puesto(medidor, caracteristicaPuesto, 001, 0.10, 0.10, new BigDecimal(10),
                                dimensionPuesto);
                Contrato contrato = new Contrato(LocalDate.parse("2010-05-23"), LocalDate.parse("1974-05-28"), null, 1,
                                puesto);
                LecturaMedidor lectura = new LecturaMedidor(LocalDate.now(), new BigDecimal(10), new BigDecimal(20));

                factura.agregarCobros(contrato);
                factura.agregarCobros(lectura);
                factura.agregarCobros(contrato);
                factura.agregarCobros(lectura);

        }

        @Test

        public void modificarCobro() {

                Quintero quintero = new Quintero(002, "Bonanza", "Salta", "Salta", "bonanza@gmail.com");
                Factura factura = new Factura(001, LocalDate.parse("2010-05-23"), LocalDate.parse("1974-05-28"),
                                "Descripcion", quintero);
                Medidor medidor = new Medidor(001, LocalDate.parse("2010-05-28"));
                CaracteristicaPuesto caracteristicaPuesto = new CaracteristicaPuesto(false, false, "Puesto Basico");
                DimensionPuesto dimensionPuesto = new DimensionPuesto(new BigDecimal(7.5), new BigDecimal(2.0),
                                "Lo de Paco");
                Puesto puesto = new Puesto(medidor, caracteristicaPuesto, 001, 0.10, 0.10, new BigDecimal(10),
                                dimensionPuesto);

                Contrato contrato = new Contrato(LocalDate.parse("2020-05-23"), LocalDate.parse("2020-07-28"), null, 22,
                                puesto);

                factura.agregarCobros(contrato);

                Contrato contrato2 = new Contrato(LocalDate.parse("2010-05-25"), LocalDate.parse("1974-07-18"), null,
                                22, puesto);

                factura.modificarCobro(contrato2);

                assertEquals(contrato2, factura.getCobro("C22"));

        }

        @Test(expected = CobrableNoExisteException.class)

        public void modificarCobroNoExistente() {
                Quintero quintero = new Quintero(002, "Bonanza", "Salta", "Salta", "bonanza@gmail.com");
                Factura factura = new Factura(001, LocalDate.parse("2010-05-23"), LocalDate.parse("1974-05-28"),
                                "Descripcion", quintero);
                Medidor medidor = new Medidor(001, LocalDate.parse("2010-05-28"));
                CaracteristicaPuesto caracteristicaPuesto = new CaracteristicaPuesto(false, false, "Puesto Basico");
                DimensionPuesto dimensionPuesto = new DimensionPuesto(new BigDecimal(7.5), new BigDecimal(2.0),
                                "Lo de Paco");
                Puesto puesto = new Puesto(medidor, caracteristicaPuesto, 001, 0.10, 0.10, new BigDecimal(10),
                                dimensionPuesto);

                Contrato contrato = new Contrato(LocalDate.parse("2020-05-23"), LocalDate.parse("2020-07-28"), null, 22,
                                puesto);

                factura.agregarCobros(contrato);

                Contrato contrato2 = new Contrato(LocalDate.parse("2010-05-25"), LocalDate.parse("1974-07-18"), null,
                                24, puesto);

                factura.modificarCobro(contrato2);

        }

        @Test
        public void removerCobro() {

                LecturaMedidor lectura = new LecturaMedidor(LocalDate.now(), new BigDecimal(10), new BigDecimal(20));
                Factura factura = new Factura(001, LocalDate.parse("2010-05-23"), LocalDate.parse("1974-05-28"),
                                "Descripcion", null);

                factura.agregarCobros(lectura);

                factura.removerCobro("L2020-11");

                assertEquals((Integer) 0, factura.getCantidadDeCobros());

        }

}
