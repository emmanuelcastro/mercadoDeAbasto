package mercado.Excepciones;

public class ClienteExisteException extends RuntimeException {

    public ClienteExisteException() {

        super(" EL CLIENTE YA EXISTE");

    }

}
