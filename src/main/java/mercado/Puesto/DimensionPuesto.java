package mercado.Puesto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DimensionPuesto {

    private BigDecimal largo;
    private BigDecimal ancho;
    private String nombrePuesto;

    public DimensionPuesto(BigDecimal largo, BigDecimal ancho, String nombrePuesto) {
        this.largo = largo;
        this.ancho = ancho;
        this.nombrePuesto = nombrePuesto;
    }

    public BigDecimal getLargo() {
        return largo;
    }

    public void setLargo(BigDecimal largo) {
        this.largo = largo;
    }

    public BigDecimal getAncho() {
        return ancho;
    }

    public void setAncho(BigDecimal ancho) {
        this.ancho = ancho;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public BigDecimal calcularDimension() { // Metodo para calcular la Dimension del Puesto

        return largo.multiply(ancho).setScale(0, RoundingMode.HALF_UP);

    }

}
