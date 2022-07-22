package mercado.Facturacion;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;

import mercado.Excepciones.CobrableExisteException;
import mercado.Excepciones.CobrableNoExisteException;
import mercado.Usuario.Cliente;

public class Factura implements Comparable {

    private Integer numeroDeFactura;
    private LocalDate fechaDeInicio;
    private LocalDate fechaDeCierre;
    private String conceptoDeAlquiler;
    private Cliente cliente;
    private ArrayList<ICobrable> cobrables;

    public Factura(Integer numeroDeFactura, LocalDate fechaDeInicio, LocalDate fechaDeCierre, String conceptoDeAlquiler,
            Cliente cliente) {
        this.numeroDeFactura = numeroDeFactura;
        this.fechaDeInicio = fechaDeInicio;
        this.fechaDeCierre = fechaDeCierre;
        this.conceptoDeAlquiler = conceptoDeAlquiler;
        this.cliente = cliente;
        cobrables = new ArrayList<ICobrable>(); // Cuando se inicia se apunta a una coleccion sin elementos
    }

    public Integer getNumeroDeFactura() {
        return numeroDeFactura;
    }

    public void setNumeroDeFactura(Integer numeroDeFactura) {
        this.numeroDeFactura = numeroDeFactura;
    }

    public LocalDate getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(LocalDate fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public LocalDate getFechaDeCierre() {
        return fechaDeCierre;
    }

    public void setFechaDeCierre(LocalDate fechaDeCierre) {
        this.fechaDeCierre = fechaDeCierre;
    }

    public String getConceptoDeAlquiler() {
        return conceptoDeAlquiler;
    }

    public void setConceptoDeAlquiler(String conceptoDeAlquiler) {
        this.conceptoDeAlquiler = conceptoDeAlquiler;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ICobrable> getCobrables() {
        return cobrables;
    }

    public void setCobrables(ArrayList<ICobrable> cobrables) {
        this.cobrables = cobrables;
    }

    public BigDecimal getPagoTotal() { // Se agrega el Total a Pagar

        BigDecimal total = new BigDecimal(0);

        for (ICobrable var : cobrables) {

            total = total.add(var.getCobro().setScale(0, RoundingMode.HALF_UP));

        }

        return total;

    }

    public Integer getCantidadDeCobros() {

        return cobrables.size();

    }

    public int compareTo(Object o) {

        Factura factura = (Factura) o;

        return this.numeroDeFactura.compareTo(factura.numeroDeFactura);

    }

    public void agregarCobros(ICobrable cobrable) { // Se agrega el Cobro

        for (ICobrable aux : cobrables) {

            if (aux.getCodigo().equals(cobrable.getCodigo())) {

                throw new CobrableExisteException();

            }

        }
        cobrables.add(cobrable);
    }

    public ICobrable getCobro(String codigo) {

        ICobrable encontrado = null;

        for (ICobrable aux : cobrables) {

            if (aux.getCodigo().equals(codigo)) {

                encontrado = aux;
            }

        }
        if (encontrado == null) {

            throw new CobrableNoExisteException();
        }

        return encontrado;

    }

    public void modificarCobro(ICobrable nuevocobrable) {

        ICobrable encontrado;

        encontrado = getCobro(nuevocobrable.getCodigo());
        this.cobrables.remove(encontrado);
        this.agregarCobros(nuevocobrable);

    }

    public void removerCobro(String codigo) {

        ICobrable cobrableAEliminar;

        cobrableAEliminar = getCobro(codigo);

        cobrables.remove(cobrableAEliminar);

    }

    public BigDecimal ImporteTotal() {

        BigDecimal Total = new BigDecimal(0);

        for (ICobrable aux : cobrables) {

            Total.add(aux.getCobro().setScale(0, RoundingMode.HALF_UP));

        }
        return Total;

    }

}