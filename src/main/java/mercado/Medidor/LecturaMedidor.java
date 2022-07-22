package mercado.Medidor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

import mercado.Facturacion.ICobrable;

public class LecturaMedidor implements ICobrable {

    private LocalDate periodoLectura;
    private BigDecimal consumo;
    private BigDecimal precioKwhPorHora;

    public LecturaMedidor(LocalDate periodoLectura, BigDecimal consumo, BigDecimal precioKwhPorHora) {

        this.periodoLectura = periodoLectura;
        this.consumo = consumo;
        this.precioKwhPorHora = precioKwhPorHora;

    }

    public LocalDate getPeriodoLectura() {
        return periodoLectura;
    }

    public void setPeriodoLectura(LocalDate periodoLectura) {
        this.periodoLectura = periodoLectura;
    }

    public BigDecimal getConsumo() {
        return consumo;
    }

    public void setConsumo(BigDecimal consumo) {
        this.consumo = consumo;
    }

    public BigDecimal getPrecioKwhPorHora() {
        return precioKwhPorHora;
    }

    public void setpPecioKwhPorHora(BigDecimal precioKwhPorHora) {
        this.precioKwhPorHora = precioKwhPorHora;
    }

    @Override

    public BigDecimal getCobro() {

        BigDecimal importe = precioKwhPorHora.multiply(consumo);

        return importe;

    }

    @Override

    public String getCodigo() {

        return "L" + (YearMonth.of(periodoLectura.getYear(), periodoLectura.getMonthValue()));

    }

}