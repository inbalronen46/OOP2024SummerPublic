import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public abstract class Graph<V extends Comparable<V>> implements IGraph<V> {


	private SortedMap<V, List<V>> vertices;

	public Graph() {
		vertices = new TreeMap<V, List<V>>();
	}

	@Override
	public void addVertex(V v) {
		List<V> incidences = vertices.get(v);
		if (incidences == null)
			vertices.put(v, new ArrayList<V>());
		return;
	}

	@Override
    public void addEdge(V u, V v) {
        assert (u != null && v != null);
        if (!containsVertex(u))
            addVertex(u);
        if (!containsVertex(v))
            addVertex(v);

        // Check for duplicates before adding 'v' to the adjacency list of 'u'
        if (!vertices.get(u).contains(v)) {
            vertices.get(u).add(v);
        }
    }

	@Override
	public boolean containsVertex(V v) {
		return vertices.containsKey(v);
	}

	@Override
	public List<V> removeVertex(V v) {
		List<V> incidences = vertices.remove(v);
		if (incidences == null)
			return null;

		// Remove every incident edge from the incidence list of the opposite endpoint
		for (V u : incidences) {
			vertices.get(u).remove(v);
		}
		return incidences;
	}

	@Override
	public boolean removeEdge(V u, V v) {
		if (!containsEdge(u, v))
			return false;
		boolean res = vertices.get(u).remove(v);
		return res;
	}

	@Override
	public boolean containsEdge(V u, V v) {
		if (u == null || v == null)
			return false;
		if (u == null || v == null)
			return false;
		List<V> incidences = vertices.get(u);
		if (incidences == null)
			return false;
		for (V x : incidences) {
			if (x.equals(v))
				return true;
		}
		return false;
	}

	public int numOfVertices() {
		return vertices.size();
	}

	public int numOfEdges() {
        int sum = 0;
        for (List<V> adjList : vertices.values()) {
            sum += adjList.size();
        }
        return sum;
    }

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder(getGraphType() + "\t");
		boolean first = true;
		for (V v : vertices.keySet()) {
			if (!first) {
				sb.append(" ");
			}
			first = false;
			sb.append(toStringExtended(v));
		}
		return sb.toString();
	}

	private String toStringExtended(V v) {
		List<V> incidences = vertices.get(v);
		StringBuilder sb = new StringBuilder(v + ":");
		boolean first = true;
		for (V u : incidences) {
			if (!first) {
				sb.append("->");
			}
			first = false;
			sb.append(u);
		}
		//sb.append("}");
		return sb.toString();
	}

}
