import java.util.List;

public class UndirectedGraph<V extends Comparable<V>> extends Graph<V> {

	private static final String TYPE = "UndirectedGraph";

	@Override
	public void addEdge(V u, V v) {
		super.addEdge(u, v);
		super.addEdge(v, u);
	}

	@Override
	public boolean removeEdge(V u, V v) {
		boolean res = super.removeEdge(u, v);
		res = res && super.removeEdge(v, u);
		return res;
	}

	@Override
	public String getGraphType() {
		return TYPE;
	}
	
	@Override
	public int numOfEdges() {
        int sum = super.numOfEdges();
        return sum / 2;
    }

}
