
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class GraphsHandler {
	private static final String PATH = "./src/";

	private static List<IGraph<String>> listGraphs = new LinkedList<IGraph<String>>();
	private static SortedSet<IGraph<String>> setGraphs = new TreeSet<IGraph<String>>(getEdgesComparator());
	private static SortedMap<String, SortedSet<IGraph<String>>> mapGraphs = new
	 TreeMap<String, SortedSet<IGraph<String>>>();
	private static List<String> errorsLists = new LinkedList<String>();

	public static void main(String[] args) throws IOException {
		fillContainers(args[0]);
		outPutCollections("");
		outPutErrorLines("");
	}

	private static void fillContainers(String fileName) throws FileNotFoundException {
		String line = "";
		int lineNum = 1;
		Scanner linesScan = new Scanner(new File(fileName));
		try {
			while (linesScan.hasNextLine()) {
				try {
					line = linesScan.nextLine();
					IGraph<String> graph = GraphUtils.constructGraph(line);
					updateContainers(graph);
				} catch (Exception e) {
					updateErrors(line, lineNum, e);
				} finally {
					lineNum++;
				}
			}
		} finally {
			linesScan.close();

		}
	}

	private static void updateErrors(String line, int lineNum, Exception e) {
		errorsLists.add("line number=" + lineNum + ", input line=" + line + ", Error message = " + e.getMessage());

	}

	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>> void updateContainers(IGraph<T> graph) {
		updateContainers(listGraphs, mapGraphs, ((IGraph<String>) graph));
	}

	private static <T extends Comparable<T>> void updateContainers(List<IGraph<T>> listGraphs, Map<String, SortedSet<IGraph<T>>> mapGraphs,
			IGraph<T> graph) {
		listGraphs.add(0, graph); // add the graph at the head of the list
		if (!mapGraphs.containsKey(graph.getGraphType())) {
			mapGraphs.put(graph.getGraphType(), new TreeSet<IGraph<T>>(getEdgesComparator()));
		}
		SortedSet<IGraph<T>> graphs = mapGraphs.get(graph.getGraphType());
		graphs.add(graph);
	}

	private static void outPutCollections(String fileName) throws IOException {
		Writer wr = getWriter(fileName + "GraphsOutList.txt");
		outPutCollection(listGraphs, wr);
		closeWriter(wr);

		wr = getWriter(fileName + "GraphsSortOutSet.txt");
		outPutCollection(setGraphs, wr);
		closeWriter(wr);

		wr = getWriter(fileName + "GraphsSortOutMap.txt");
		outPutMap(mapGraphs, wr);
		closeWriter(wr);

		wr = getWriter(fileName + "GraphsSortOutList.txt");
		Collections.sort(listGraphs, getEdgesComparator());
		outPutCollection(listGraphs, wr);
		closeWriter(wr);
	}

	private static void outPutErrorLines(String fileName) throws IOException {
		Writer wr = new FileWriter(fileName + "errorsGraphs.txt");
		outPutCollection(errorsLists, wr);
		closeWriter(wr);
	}

	private static void closeWriter(Writer wr) throws IOException {
		wr.flush();
		wr.close();
	}

	private static Writer getWriter(String fileName) throws IOException {
		// Writer wr = new FileWriter(PATH + fileName);
		Writer wr = new FileWriter(fileName);
		return wr;
	}

	private static <T> void outPutCollection(Collection<T> collection, Writer wr) throws IOException {
		Iterator<T> iterator = collection.iterator();
		printIterator(wr, iterator);
	}

	private static <T> void outPutMap(SortedMap<String, SortedSet<T>> mapGraphs2, Writer wr) throws IOException {
		Iterator<T> iterator = null;
		Iterator<String> typeIterator = mapGraphs2.keySet().iterator();
		while (typeIterator.hasNext()) {
			iterator = mapGraphs2.get(typeIterator.next()).iterator();
			printIterator(wr, iterator);
			if (typeIterator.hasNext())
				wr.write("\n");
		}
		
	}

	private static <T> void printIterator(Writer wr, Iterator<T> iterator) throws IOException {
		while (iterator.hasNext()) {
			T p = iterator.next();
			wr.write(p.toString());
			if (iterator.hasNext())
				wr.write("\n");
		}
	}

	private static <T> void outPutSet(Set<T> set, Writer wr) throws IOException {
		Iterator<T> iterator = set.iterator();
		while (iterator.hasNext()) {
			T p = iterator.next();
			wr.write(p.toString());
			if (iterator.hasNext())
				wr.write("\n");
		}
	}

	// This comparator imposes orderings according to number of vertices in the
	// graph (ascending order).
//	private static <T extends Comparable<T>> Comparator<IGraph<T>> getVerticesComparator() {
//		Comparator<IGraph<T>> comp = new Comparator<IGraph<T>>() {
//			@Override
//			public int compare(IGraph<T> o1, IGraph<T> o2) {
//				if ((o1 == null) && (o2 == null))
//					return 0;
//				if (o1 == null)
//					return -1;
//				if (o2 == null)
//					return 1;
//
//				int n1 = o1.numOfVertices();
//				int n2 = o2.numOfVertices();
//
//				if (n1 < n2)
//					return -1;
//				if (n1 > n2)
//					return 1;
//				if (o1.equals(o2))
//					return 0;
//				return -1;
//			}
//		};
//		return comp;
//	}

	// This comparator imposes orderings according to number of vertices in the
	// graph (ascending order).
//	private static <T extends Comparable<T>> Comparator<IGraph<T>> getEdgesComparator() {
//		Comparator<IGraph<T>> comp = new Comparator<IGraph<T>>() {
//			@Override
//			public int compare(IGraph<T> o1, IGraph<T> o2) {
//				if ((o1 == null) && (o2 == null))
//					return 0;
//				if (o1 == null)
//					return -1;
//				if (o2 == null)
//					return 1;
//
//				int n1 = o1.numOfEdges();
//				int n2 = o2.numOfEdges();
//
//				if (n1 < n2)
//					return -1;
//				if (n1 > n2)
//					return 1;
//				return 0;
//			}
//		};
//		return comp;
//	}
//	
	private static <T extends Comparable<T>> Comparator<IGraph<T>> getEdgesComparator() {
	Comparator<IGraph<T>> comp = new Comparator<IGraph<T>>() {
		@Override
		public int compare(IGraph<T> o1, IGraph<T> o2) {
			if ((o1 == null) && (o2 == null))
				return 0;
			if (o1 == null)
				return -1;
			if (o2 == null)
				return 1;

			int n1 = o1.numOfEdges(); 
			int n2 = o2.numOfEdges();

			if (n1 < n2)
				return -1;
			if (n1 > n2)
				return 1;
			if (o1.equals(o2))
				return 0;
			return -1;
		}
	};
	return comp;
}

}
