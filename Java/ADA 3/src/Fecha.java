public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }


    public static boolean esBisiesto(int anio) {
        if (anio % 400 == 0) {
            return true;
        } else if (anio % 100 == 0) {
            return false;
        } else if (anio % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean validFecha(int dia, int mes, int anio) {
        if (mes < 1 || mes > 12 || dia < 1 || dia > 31) {
            return false;
        } else if (mes == 2) {
            return (esBisiesto(anio) && dia <= 29) || (!esBisiesto(anio) && dia <= 28);
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            return dia <= 30;
        }
        return true; 
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }
}
