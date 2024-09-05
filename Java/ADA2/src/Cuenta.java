import java.util.ArrayList;
import java.util.Scanner;

public class Cuenta {
    // Atributos
    private Double saldo;
    private int numCuenta;
    private String descripcion;

    // Constructor
    public Cuenta(Double saldo, int numCuenta, String descripcion) {
        this.saldo = saldo;
        this.numCuenta = numCuenta;
        this.descripcion = descripcion;
    }

    // Métodos getter
    public Double getSaldo() {
        return saldo;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Métodos
    public void ingreso(Double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Ingreso realizado. Su saldo es de: " + saldo);
        } else {
            System.out.println("Por favor, ingrese un monto válido");
        }
    }

    public void retiro(Double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            System.out.println("Retiro realizado. Su saldo es de: " + saldo);
        } else {
            System.out.println("Saldo insuficiente o monto no válido. Por favor introduzca un monto válido de acuerdo a su saldo.");
        }
    }

    public void transferencia(Cuenta destino, double monto) {
        if (monto > 0 && saldo >= monto) {
            this.retiro(monto);
            destino.ingreso(monto);
            System.out.println("Transferencia realizada a la cuenta: " + destino.getNumCuenta());
        } else {
            System.out.println("No se puede realizar la transferencia.");
        }
    }

    //Método toString

    @Override
    public String toString() {
        return "Cuenta número: " + numCuenta + "\nDescripción: " + descripcion + "\nSaldo: " + saldo;
    }
}
