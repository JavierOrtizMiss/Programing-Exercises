public class Cliente {
	Articulo art;
	Publicacion pub;	
	FactoryPublicacionArticulo factPubArticulo;
	public Cliente( String autor, String tituloArticulo,
			String tituloRevista,FactoryPublicacionArticulo _factPubArticulo) {
		
		this.factPubArticulo = _factPubArticulo;
		art = factPubArticulo.createArticulo();
		pub = factPubArticulo.createPublicacion();
		
		art.setAutor(autor);
		art.setTitulo(tituloArticulo);
		
		pub.setNombre(tituloRevista);
				
	}
	
	public static void main(String args[]) {
		new Cliente("woods",
				"Foreign Forever","Journal Migration",
				new FactoryCientifico());
	}

}
