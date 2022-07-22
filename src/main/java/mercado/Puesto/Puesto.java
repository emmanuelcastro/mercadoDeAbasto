
package mercado.Puesto;

import java.math.BigDecimal;
import java.math.RoundingMode;

import mercado.Medidor.Medidor;

public class Puesto {

    private Medidor medidor;
    private CaracteristicaPuesto caracteristicaPuesto;
    private DimensionPuesto dimensionPuesto;
    private Integer numeroDePuesto;
    private double interesPorRefrigeracion;
    private double interesPorTechado;
    private BigDecimal precioM2;

    public Puesto(Medidor medidor, CaracteristicaPuesto caracteristicaPuesto, Integer numeroDePuesto,
            double interesPorRefrigeracion, double interesPorTechado, BigDecimal precioM2,
            DimensionPuesto dimensionPuesto) {
        this.medidor = medidor;
        this.caracteristicaPuesto = caracteristicaPuesto;
        this.numeroDePuesto = numeroDePuesto;
        this.interesPorRefrigeracion = interesPorRefrigeracion;
        this.interesPorTechado = interesPorTechado;
        this.precioM2 = precioM2;
        this.dimensionPuesto = dimensionPuesto;

    }

    public Medidor getMedidor() {
        return medidor;
    }

    public void setMedidor(Medidor medidor) {
        this.medidor = medidor;
    }

    public CaracteristicaPuesto getCaracteristicaPuesto() {
        return caracteristicaPuesto;
    }

    public void setCaracteristicaPuesto(CaracteristicaPuesto caracteristicaPuesto) {
        this.caracteristicaPuesto = caracteristicaPuesto;
    }

    public Integer getNumeroDePuesto() {
        return numeroDePuesto;
    }

    public void setNumeroDePuesto(Integer numeroDePuesto) {
        this.numeroDePuesto = numeroDePuesto;
    }

    public double getInteresPorRefrigeracion() {
        return interesPorRefrigeracion;
    }

    public void setInteresPorRefrigeracion(double interesPorRefrigeracion) {
        this.interesPorRefrigeracion = interesPorRefrigeracion;
    }

    public double getInteresPorTechado() {
        return interesPorTechado;
    }

    public void setInteresPorTechado(double interesPorTechado) {
        this.interesPorTechado = interesPorTechado;
    }

    public BigDecimal getPrecioM2() {
        return precioM2;
    }

    public void setPrecioM2(BigDecimal precioM2) {
        this.precioM2 = precioM2;
    }

    public DimensionPuesto getDimensionPuesto() {
        return dimensionPuesto;
    }

    public void setDimensionPuesto(DimensionPuesto dimensionPuesto) {
        this.dimensionPuesto = dimensionPuesto;
    }

    public BigDecimal precioDePuesto() {

        BigDecimal precioPuesto = new BigDecimal(0);

        BigDecimal precioDimension = new BigDecimal(0);

        precioDimension = precioDimension.add(precioM2.multiply(dimensionPuesto.calcularDimension()));

        precioPuesto = precioDimension;

        if (caracteristicaPuesto.getTecho() == true) {

            precioPuesto = precioPuesto.add(
                    precioPuesto.multiply(new BigDecimal(getInteresPorTechado())).setScale(0, RoundingMode.HALF_UP));

        }

        if (caracteristicaPuesto.getCamaraDeRefrigeracion() == true) {

            precioPuesto = precioPuesto.add(precioPuesto.multiply(new BigDecimal(getInteresPorRefrigeracion()))
                    .setScale(0, RoundingMode.HALF_UP));

        }

        return precioPuesto.setScale(0, RoundingMode.HALF_UP);

    }

}
