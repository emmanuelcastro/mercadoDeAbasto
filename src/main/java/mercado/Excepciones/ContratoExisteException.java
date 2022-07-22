package mercado.Excepciones;

public class ContratoExisteException extends RuntimeException {

    public ContratoExisteException() {

        super("EL CONTRATO YA EXISTE");

    }

}
