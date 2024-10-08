public class EmpleadoPorComision extends Empleado {
    private double grossSales;
    private double commissionRates;

    public EmpleadoPorComision(String firstName, String flastName, String mlastName, String nss, double grossSales, double commissionRates) {
        super(firstName, flastName, mlastName, nss);
        this.grossSales = grossSales;
        this.commissionRates = commissionRates;
    }

    public double getGrossSales() {
        return this.grossSales;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    public double getCommissionRates() {
        return this.commissionRates;
    }

    public void setCommissionRates(double commissionRates) {
        this.commissionRates = commissionRates;
    }

    @Override
    public double ingresos() {
        return commissionRates * grossSales;
    }

    @Override
    public String toString() {
        return String.format("%s\nEmpleado por comisión\nVentas brutas: $%.2f\nTasa de comisión: %.2f", 
            super.toString(), grossSales, commissionRates);
    }
}
