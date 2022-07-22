package mercado.Facturacion;

import java.util.Comparator;

import mercado.Facturacion.Factura;

public class ComparatorFactura implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        Factura factura1 = (Factura) o1;

        Factura factura2 = (Factura) o2;

        return factura1.getFechaDeCierre().compareTo(factura2.getFechaDeCierre());

    }

}
