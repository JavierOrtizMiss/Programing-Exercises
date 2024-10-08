public class EmpleadoBaseMasComision extends EmpleadoPorComision {
    private double baseSalary;

    public EmpleadoBaseMasComision(String firstName, String flastName, String mlastName, String nss, double grossSales, double commissionRates, double baseSalary) {
        super(firstName, flastName, mlastName, nss, grossSales, commissionRates);
        this.baseSalary = baseSalary;
    }

    @Override
    public double ingresos() {
        return baseSalary + super.ingresos();
    }

    @Override
    public String toString() {
        return String.format("%s\nSalario base: $%.2f", 
            super.toString(), baseSalary);
    }
}
