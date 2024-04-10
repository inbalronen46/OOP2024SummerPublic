public class DirectedGraph<V extends Comparable<V>> extends Graph<V> {

	private static final String TYPE = "DirectedGraph";

	@Override
	public String getGraphType() {
		return TYPE;
	}

}
