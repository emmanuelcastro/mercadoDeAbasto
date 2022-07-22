package mercado.TestDeFacturacion;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.Test;
import mercado.Facturacion.AdministradorFactura;
import mercado.Facturacion.Factura;
import mercado.Medidor.Medidor;
import mercado.Mercado.Sector;
import mercado.Puesto.CaracteristicaPuesto;
import mercado.Puesto.DimensionPuesto;
import mercado.Puesto.Puesto;
import mercado.Usuario.Contrato;
import mercado.Usuario.Empresa;

public class AdministradorFacturaTest {

        @Test
        public void agregarFactura() {

                Empresa empresa = new Empresa(002, "Arcor", "Santiago del Estero", "Santiago del Estero",
                                "arcor@gmail.com");
                Factura factura = new Factura(001, LocalDate.parse("2010-05-23"), LocalDate.parse("2010-05-28"),
                                "Descripcion", empresa);
                AdministradorFactura administradorFactura = new AdministradorFactura();

                administradorFactura.agregarFactura(factura);

                administradorFactura.getCantidadFacturas();

                assertEquals((Integer) 1, administradorFactura.getCantidadFacturas());

        }

        @Test
        public void encontrarFactura() {

                Empresa empresa = new Empresa(002, "Milkaut", "Santiago del Estero", "Santiago del Estero",
                                "arcor@gmail.com");
                Factura factura = new Factura(10, LocalDate.parse("2010-05-23"), LocalDate.parse("2010-05-28"),
                                "Descripcion", empresa);
                AdministradorFactura administradorFactura = new AdministradorFactura();

                administradorFactura.agregarFactura(factura);
                administradorFactura.encontrarFactura(10);

                assertEquals((Integer) 10, factura.getNumeroDeFactura());

        }

        @Test
        public void eliminarFactura() {

                Empresa empresa = new Empresa(002, "Sancor", "Santiago del Estero", "Santiago del Estero",
                                "arcor@gmail.com");
                Factura factura = new Factura(001, LocalDate.parse("2010-05-23"), LocalDate.parse("1974-05-28"),
                                "Descripcion", empresa);
                AdministradorFactura administradorFactura = new AdministradorFactura();

                administradorFactura.agregarFactura(factura);
                administradorFactura.encontrarFactura(1);
                administradorFactura.eliminarFactura(1);

                assertEquals((Integer) 0, administradorFactura.getCantidadFacturas());

        }

        @Test

        public void modificarFactura() {

                Empresa empresa = new Empresa(002, "Sancor", "Santiago del Estero", "Santiago del Estero",
                                "arcor@gmail.com");
                Factura factura = new Factura(001, LocalDate.parse("2010-05-23"), LocalDate.parse("1974-05-28"),
                                "Descripcion", empresa);
                AdministradorFactura administradorFactura = new AdministradorFactura();

                administradorFactura.agregarFactura(factura);
                administradorFactura.encontrarFactura(001);
                administradorFactura.modificarFactura(factura, factura);

                assertEquals((Integer) 001, factura.getNumeroDeFactura());

        }

        @Test
        public void totalFacturaPorPeriodo() {

                Empresa empresa = new Empresa(001, "Felfort", "Tucuman", "San Miguel de Tucuman", "luisito@gmail.com");
                Factura factura = new Factura(001, LocalDate.parse("2010-05-23"), LocalDate.parse("2010-05-28"),
                                "Descripcion", empresa);
                Factura factura2 = new Factura(001, LocalDate.parse("2020-05-10"), LocalDate.parse("2020-05-20"),
                                "Descripcion", empresa);
                AdministradorFactura administradorFactura = new AdministradorFactura();

                administradorFactura.agregarFactura(factura);
                administradorFactura.agregarFactura(factura2);
                administradorFactura.totalFacturaPorPeriodo(LocalDate.parse("2010-05-23"),
                                LocalDate.parse("2010-05-28"));
                administradorFactura.totalFacturaPorPeriodo(LocalDate.parse("2020-05-10"),
                                LocalDate.parse("2020-05-20"));

                assertEquals((Integer) 2, administradorFactura.getCantidadFacturas());

        }

        @Test
        public void importeMensual() {

                Empresa empresa = new Empresa(001, "Felfort", "Tucuman", "San Miguel de Tucuman", "felfort@gmail.com");
                Factura factura = new Factura(001, LocalDate.parse("2010-05-23"), LocalDate.parse("2010-05-28"),
                                "Descripcion", empresa);
                AdministradorFactura administradorFactura = new AdministradorFactura();
                DimensionPuesto dimensionPuesto = new DimensionPuesto(new BigDecimal(7.5), new BigDecimal(2), ".");
                Medidor medidor = new Medidor(001, LocalDate.parse("2020-05-28"));
                CaracteristicaPuesto caracteristicaPuesto = new CaracteristicaPuesto(false, false, "Puesto Basico");
                Puesto puesto = new Puesto(medidor, caracteristicaPuesto, 001, 0, 0, new BigDecimal(100),
                                dimensionPuesto);
                Sector sector = new Sector(001, "Sector A", "Sector Hogar");
                Contrato contrato = new Contrato(LocalDate.parse("2010-05-23"), LocalDate.parse("2010-05-28"), null,
                                001, puesto);

                factura.agregarCobros(contrato);
                sector.agregarPuesto(puesto);
                administradorFactura.agregarFactura(factura);
                BigDecimal resultado = administradorFactura.importeMensual(LocalDate.parse("2010-05-23"),
                                LocalDate.parse("2010-05-28"));

                assertEquals(new BigDecimal(3000), resultado);

        }

}
