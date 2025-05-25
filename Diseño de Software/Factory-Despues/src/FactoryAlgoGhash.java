public class FactoryAlgoGhash extends FactoryAlgoEncriptamiento {

	@Override
	public AlgoEncriptamiento createInstance() {
		GHash algo = new GHash();
		algo.config();
		return algo;
	}

}
