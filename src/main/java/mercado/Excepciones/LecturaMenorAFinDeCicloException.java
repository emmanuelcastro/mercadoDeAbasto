package mercado.Excepciones;

public class LecturaMenorAFinDeCicloException extends RuntimeException {

    public LecturaMenorAFinDeCicloException() {

        super("LA LECTURA ES MENOR AL FIN DE CICLO ESTABLECIDO");

    }

}
