public class Cliente {
	
	public Cliente() {
		
	}
	
	public String encriptar(String texto, String algo) {
		if(algo.equalsIgnoreCase("ghash")) {
			GHash enc = new GHash();
			enc.config();
			return enc.encrypt(texto);
		}
		return KHash.getInstance().encriptar(texto);
	}
	
	public static void main (String args[]) {
		String cadenaEncriptada;
		cadenaEncriptada = new Cliente().encriptar("Hola", "ghash");
		System.out.println(cadenaEncriptada);
	}

}
