public class EmpleadoPorHoras extends Empleado {
    private double hourlyWage;
    private int hoursWorked;

    public EmpleadoPorHoras(String firstName, String flastName, String mlastName, String nss, double hourlyWage, int hoursWorked) {
        super(firstName, flastName, mlastName, nss);
        this.hourlyWage = hourlyWage;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double ingresos() {
        if (hoursWorked <= 40) {
            return hourlyWage * hoursWorked;
        } else {
            return 40 * hourlyWage + (hoursWorked - 40) * hourlyWage * 1.5;
        }
    }

    @Override
    public String toString() {
        return String.format("%s\nEmpleado por horas\nSueldo por hora: $%.2f\nHoras trabajadas: %d", 
            super.toString(), hourlyWage, hoursWorked);
    }
}
