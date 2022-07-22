package mercado.TestDeMedidor;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

import mercado.Excepciones.LecturaExisteException;
import mercado.Excepciones.LecturaNoExisteException;
import mercado.Medidor.LecturaMedidor;
import mercado.Medidor.Medidor;

public class MedidorTest {

    @Test

    public void agregarLecturaMedidor() {

        LecturaMedidor lecturaMedidor = new LecturaMedidor(LocalDate.parse("1999-01-01"), new BigDecimal(200),
                new BigDecimal(20));
        Medidor medidor = new Medidor(1, LocalDate.parse("1999-01-01"));

        medidor.agregarLecturaMedidor(lecturaMedidor);

        assertEquals((Integer) 1, medidor.cantidadLecturas());

    }

    @Test(expected = LecturaExisteException.class)
    public void agregarLecturaExistente() {

        LecturaMedidor lecturaMedidor = new LecturaMedidor(LocalDate.parse("1999-01-01"), new BigDecimal(200),
                new BigDecimal(20));
        Medidor medidor = new Medidor(1, LocalDate.parse("1999-01-01"));

        medidor.agregarLecturaMedidor(lecturaMedidor);
        medidor.agregarLecturaMedidor(lecturaMedidor);

    }

    @Test(expected = LecturaNoExisteException.class)
    public void buscarLecturaNoExistente() {

        LecturaMedidor lecturaMedidor = new LecturaMedidor(LocalDate.parse("2000-01-01"), new BigDecimal(200),
                new BigDecimal(20));
        Medidor medidor = new Medidor(1, LocalDate.parse("1999-01-05"));
        medidor.agregarLecturaMedidor(lecturaMedidor);

        LecturaMedidor lectura = medidor.buscarLectura(LocalDate.parse("1999-01-04"), LocalDate.parse("1999-01-04"));

    }

}
