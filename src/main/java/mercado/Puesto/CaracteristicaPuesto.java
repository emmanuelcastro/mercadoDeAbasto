package mercado.Puesto;

public class CaracteristicaPuesto {

    private Boolean techo;
    private Boolean camaraDeRefrigeracion;
    private String descripcion;

    public CaracteristicaPuesto(Boolean techo, Boolean camaraDeRefrigeracion, String descripcion) {
        this.techo = techo;
        this.camaraDeRefrigeracion = camaraDeRefrigeracion;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getTecho() {
        return techo;
    }

    public Boolean getCamaraDeRefrigeracion() {
        return camaraDeRefrigeracion;
    }

    public void setTecho(Boolean techo) {
        this.techo = techo;
    }

    public void setCamaraDeRefrigeracion(Boolean camaraDeRefrigeracion) {
        this.camaraDeRefrigeracion = camaraDeRefrigeracion;
    }

}