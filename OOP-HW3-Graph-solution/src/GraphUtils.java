import java.io.File;
import java.io.NotActiveException;
import java.util.Scanner;

import org.junit.experimental.theories.Theories;

public class GraphUtils {
	private static final String DIRECTED_GRAPH = "DirectedGraph";
	private static final String UNDIRECTED_GRAPH = "UndirectedGraph";
	private static double PRECISION = 1.0e-2;

	/**
	 * @param d : double
	 * @return String represents d with 2 places after the decimal point.
	 */
	public static String formatDouble(double d) {
		String res = String.format("%.2f", d);
		if (res.equals("-0.00"))
			res = "0.00";
		return res;
	}

	public static boolean areEqual(double d1, double d2) {
		return Math.abs(d1 - d2) < PRECISION;
	}

	public static IGraph<String> constructGraph(String graph) throws HW3Exception {
		Scanner sc = new Scanner(graph);
		try {
			sc.useDelimiter("\\t");
			String typeGraph = sc.next();
			String graphString = sc.next();
			if (sc.hasNext()) {
				throw new HW3Exception("Too many \"\\t\" in the input line.");
			}
			return constructGraph(typeGraph, graphString);
		} catch (Exception e) {
			throw new HW3Exception(e.getMessage());
		} finally {
			sc.close();
		}

	}

	// A:{A,B} B:{A} C:{D} D:{C,D}
	@SuppressWarnings("resource")
	private static IGraph<String> constructGraph(String typeGraph, String graphStr) throws HW3Exception {
		IGraph<String> graph = null;
		if (typeGraph.equals(DIRECTED_GRAPH)) {
			graph = new DirectedGraph<String>();
		} else if (typeGraph.equals(UNDIRECTED_GRAPH)) {
			graph = new UndirectedGraph<String>();
		}
		else {
			throw new HW3Exception("The graph type is not valid");
		}

		Scanner sc = new Scanner(graphStr);
		sc.useDelimiter(" ");
		int verticesNum = 0;
		while (sc.hasNext()) {
			String vertexAndItsEdges = sc.next();
			Scanner vertexScanner = new Scanner(vertexAndItsEdges);
			vertexScanner.useDelimiter(":");
			String vertex = vertexScanner.next();
			graph.addVertex(vertex);
			verticesNum++;
			//vertex with no edges
			if (!vertexScanner.hasNext())
				continue;
			String adjacents = vertexScanner.next();
//			if ((!adjacents.startsWith("{")) || (!adjacents.endsWith("}")))
//				throw new HW3Exception("Exception in scanning the graph string");
//			adjacents = adjacents.substring(1, adjacents.length() - 1);
			Scanner scAdgacents = new Scanner(adjacents);
			scAdgacents.useDelimiter("->");
			while (scAdgacents.hasNext()) {
				graph.addEdge(vertex, scAdgacents.next());
			}

		}
		if(graph.numOfVertices() != verticesNum) {
			throw new HW3Exception("Exception in scanning the graph string");
		}
		return graph;
	}

}
