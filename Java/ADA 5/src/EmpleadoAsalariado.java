public class EmpleadoAsalariado extends Empleado {
    private double weeklySalary;

    public EmpleadoAsalariado(String firstName, String flastName, String mlastName, String nss, double weeklySalary) {
        super(firstName, flastName, mlastName, nss);
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return this.weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double ingresos() {
        return weeklySalary;
    }

    @Override
    public String toString() {
        return String.format("%s\nEmpleado asalariado\nSalario semanal: $%.2f", 
            super.toString(), weeklySalary);
    }
}
