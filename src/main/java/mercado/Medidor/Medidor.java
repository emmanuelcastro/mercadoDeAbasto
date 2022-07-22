package mercado.Medidor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import mercado.Excepciones.*;

public class Medidor {
    private LocalDate finDePeriodo;
    private Integer identificacion;
    private ArrayList<LecturaMedidor> lecturas;

    public Medidor(Integer identificacion, LocalDate finDePeriodo) {

        this.identificacion = identificacion;
        this.finDePeriodo = finDePeriodo;

        lecturas = new ArrayList<LecturaMedidor>();

    }

    public ArrayList<LecturaMedidor> getLecturas() {
        return lecturas;
    }

    public void setLecturas(ArrayList<LecturaMedidor> lecturas) {
        this.lecturas = lecturas;
    }

    public LocalDate getFinDePeriodo() {
        return finDePeriodo;
    }

    public void setFinDePeriodo(LocalDate finDePeriodo) {
        this.finDePeriodo = finDePeriodo;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public void agregarLecturaMedidor(LecturaMedidor lectura) {

        LecturaMedidor lecturaPrecedente = new LecturaMedidor(LocalDate.parse("1999-01-01"), new BigDecimal(0),
                new BigDecimal(0));

        for (LecturaMedidor aux : lecturas) {

            if (aux.getPeriodoLectura().equals(lectura.getPeriodoLectura())) {

                throw new LecturaExisteException();

            }

            lecturaPrecedente = lecturas.get(lecturas.size() - 1);

        }

        if (finDePeriodo.isBefore(lectura.getPeriodoLectura()) == true
                || finDePeriodo.isEqual(lectura.getPeriodoLectura()) == true) {

            if (lectura.getPeriodoLectura().isAfter(lecturaPrecedente.getPeriodoLectura().plusMonths(1)) == true
                    || lectura.getPeriodoLectura().isEqual(lecturaPrecedente.getPeriodoLectura()) == true) {

                if (lectura.getConsumo().compareTo(lecturaPrecedente.getConsumo()) >= 0) {

                    this.lecturas.add(lectura);

                } else {

                    throw new LecturaAntecedenteException();
                }
            } else {

                throw new DiferenciaDeLecturaException();
            }
        }

        else {

            throw new LecturaMenorAFinDeCicloException();
        }

    }

    public Integer cantidadLecturas() {

        return lecturas.size();

    }

    public LecturaMedidor buscarLectura(LocalDate inicioPeriodo, LocalDate finPeriodo) { // Se debe considerar el mes y
                                                                                         // // el año

        LecturaMedidor lecturaMedidor = null;

        for (LecturaMedidor aux : lecturas) {

            if (aux.getPeriodoLectura() == finPeriodo) {

                lecturaMedidor = aux;
                break;
            }

            if (lecturaMedidor == null) {

                throw new LecturaNoExisteException();
            }

        }

        return lecturaMedidor;
    }

}
