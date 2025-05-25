public class Cliente {
	
	public Cliente() {
				
	}
	
	public String encriptar(String texto, FactoryAlgoEncriptamiento factory) {
		AlgoEncriptamiento algo = factory.createInstance();
		return algo.encriptar(texto);	
	}
	
	public static void main (String args[]) {
		String cadenaEncriptada;
		cadenaEncriptada = new Cliente().encriptar("Hola", new FactoryAlgoGhash());
		System.out.println(cadenaEncriptada);
		cadenaEncriptada = new Cliente().encriptar("Hola", new FactoryAlgoKhash());
		System.out.println(cadenaEncriptada);
	}

}
