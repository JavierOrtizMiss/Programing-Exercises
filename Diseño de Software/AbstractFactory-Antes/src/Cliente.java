public class Cliente {
	Articulo art;
	Publicacion pub;	
	public Cliente(String tipoArticulo, String autor, String tituloArticulo, String tituloRevista) {
		if(tipoArticulo.equalsIgnoreCase("Cientifico")){
			art = new ArticuloCientifico(autor,tituloArticulo);
			pub = new RevistaCientifica(tituloRevista);	
		}else {
			art = new ArticuloDivulgacion(autor,tituloArticulo);
			pub = new Blog(tituloRevista);			
		}		
	}
	
	public static void main(String args[]) {
		new Cliente("Cientifico", "woods","Foreign Forever","Journal Migration");
	}

}