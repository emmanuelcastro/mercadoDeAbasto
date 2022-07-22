package mercado.Facturacion;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import mercado.Excepciones.FacturaExisteException;
import mercado.Excepciones.FacturaNoExisteException;

public class AdministradorFactura {

    private ArrayList<Factura> facturas;

    public AdministradorFactura() {

        facturas = new ArrayList<Factura>();

    }

    public ArrayList<Factura> getFacturas() {

        return facturas;

    }

    public void setFacturas(ArrayList<Factura> facturas) {

        this.facturas = facturas;

    }

    public Integer getCantidadFacturas() {

        Integer cantidadDeFacturas = facturas.size();
        return cantidadDeFacturas;

    }

    public void agregarFactura(Factura factura) {

        for (Factura i : facturas) {

            if (i.equals(factura)) {

                throw new FacturaExisteException();

            }

        }

        this.facturas.add(factura);

    }

    public Factura encontrarFactura(Integer numeroFactura) {

        Factura facturaEncontrada = null;

        for (Factura auxiliar : facturas) {

            if (auxiliar.getNumeroDeFactura() == numeroFactura) {
                facturaEncontrada = auxiliar;
                break;
            }
        }

        if (facturaEncontrada == null) {

            throw new FacturaNoExisteException();
        }

        return facturaEncontrada;

    }

    public void eliminarFactura(Integer numeroFactura) {

        Factura facturaEliminada = encontrarFactura(numeroFactura);

        facturas.remove(facturaEliminada);

    }

    public void modificarFactura(Factura factura, Factura nuevaFactura) {

        Factura facturaModificada = encontrarFactura(factura.getNumeroDeFactura());

        eliminarFactura(facturaModificada.getNumeroDeFactura());

        agregarFactura(nuevaFactura);

    }

    public ArrayList<Factura> totalFacturaPorPeriodo(LocalDate fechaDeinicio, LocalDate fechaDeCierre) {

        ArrayList<Factura> busqueda = new ArrayList<Factura>();

        for (Factura aux : facturas) {

            if (aux.getFechaDeInicio().equals(fechaDeinicio)) {

                busqueda.add(aux);

            }

            if (aux.getFechaDeInicio().isAfter(fechaDeinicio) && (aux.getFechaDeInicio().isBefore(fechaDeCierre))) {

                busqueda.add(aux);

            }

            if (aux.getFechaDeInicio().equals(fechaDeinicio)) {

                busqueda.add(aux);

            }

        }

        if (busqueda.size() == 0) {

            throw new FacturaNoExisteException();

        }

        return busqueda;

    }

    public void ordenPorNumeroDeFactura() {

        Collections.sort(facturas);

    }

    public void ordenPorFecha() { // Debe devolver algo

        Collections.sort(facturas, new ComparatorFactura());

    }

    public BigDecimal importeMensual(LocalDate fechaDeinicio, LocalDate fechaDeCierre) { // En este metodo se devuelve
                                                                                         // el valor de las Facturas
                                                                                         // dado un intervalo de tiempo
                                                                                         // especifico.

        BigDecimal importe = new BigDecimal(0);

        ArrayList<Factura> busqueda = totalFacturaPorPeriodo(fechaDeinicio, fechaDeCierre);

        for (Factura aux : busqueda) {

            importe = importe.add(aux.getPagoTotal());
        }

        return importe;

    }

}
