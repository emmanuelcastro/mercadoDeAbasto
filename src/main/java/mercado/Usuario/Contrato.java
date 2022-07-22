package mercado.Usuario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import mercado.Facturacion.ICobrable;
import mercado.Puesto.Puesto;

public class Contrato implements ICobrable {

    private LocalDate fechaInicioContrato;
    private LocalDate fechaFinContrato;
    private LocalDate fechaCancelacion;

    private Integer numeroDeContrato;
    private Puesto puesto;
    private ArrayList<Cliente> clientes;

    public Contrato(LocalDate fechaInicioContrato, LocalDate fechaFinContrato, LocalDate fechaCancelacion,
            Integer numeroDeContrato, Puesto puesto) {

        this.fechaInicioContrato = fechaInicioContrato;
        this.fechaFinContrato = fechaFinContrato;
        this.fechaCancelacion = fechaCancelacion;
        this.numeroDeContrato = numeroDeContrato;
        this.puesto = puesto;
        clientes = new ArrayList<Cliente>();

    }

    public BigDecimal getPrecioDeAlquiler() {

        BigDecimal mesescontrato = new BigDecimal(
                ChronoUnit.MONTHS.between(fechaInicioContrato.withDayOfMonth(1), fechaFinContrato.withDayOfMonth(12)));
        BigDecimal precioDeAlquiler = puesto.precioDePuesto().multiply(mesescontrato);
        return precioDeAlquiler;

    }

    public Integer getNumeroDeContrato() {
        return numeroDeContrato;
    }

    public void setNumeroDeContrato(Integer numeroDeContrato) {
        this.numeroDeContrato = numeroDeContrato;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public ArrayList<Cliente> getCliente() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public LocalDate getFechaInicioContrato() {
        return fechaInicioContrato;
    }

    public void setFechaInicioContrato(LocalDate fechaInicioContrato) {
        this.fechaInicioContrato = fechaInicioContrato;
    }

    public LocalDate getFechaFinContrato() {
        return fechaFinContrato;
    }

    public void setFechaFinContrato(LocalDate fechaFinContrato) {
        this.fechaFinContrato = fechaFinContrato;
    }

    public LocalDate getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(LocalDate fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    @Override
    public BigDecimal getCobro() {

        BigDecimal importePorMes = getPuesto().precioDePuesto();

        return importePorMes;

    }

    @Override
    public String getCodigo() {

        return "C".concat(Integer.toString(numeroDeContrato));

    }

}