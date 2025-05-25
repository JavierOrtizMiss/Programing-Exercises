public class Cliente {
	
	public Cliente() {
		
	}
	
	public void realizarPago(Payment metodo, double monto) {
		metodo.pay(monto);
	}
	
	public static void main(String args[]) {
		Cliente cte = new Cliente();
		cte.realizarPago(new PayPalAdapter(),100.0);
		cte.realizarPago(new CreditCardAdapter(),200.0);
		cte.realizarPago(new DebitCardAdapter(),100.0);
	}

}
