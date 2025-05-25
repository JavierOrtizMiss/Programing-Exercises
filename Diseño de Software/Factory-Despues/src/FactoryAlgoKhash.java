public class FactoryAlgoKhash extends FactoryAlgoEncriptamiento {

	@Override
	public AlgoEncriptamiento createInstance() {
		KHash instance =  KHash.getInstance();
		return instance;
	}

}
