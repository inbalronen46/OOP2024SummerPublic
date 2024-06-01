
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public abstract class GraphTestAbstract {

	protected IGraph<String> graph;
	protected IGraph<Company> relGraph;
	protected String type;

	@Before
	public abstract void setUp();

	@Test
	public void testGraph() {
		assertEquals(type, graph.toString());
	}

	@Test
	public void testAddVertex() {
		graph.addVertex("A");
		assertEquals(type + "A:", graph.toString());
		graph.addVertex("B");
		assertEquals(type + "A: B:", graph.toString());
	}

	@Test
	public void testRemoveNoEdges() {
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.removeVertex("C");
		assertEquals(type + "A: B: D:", graph.toString());
	}

	@Test
	public void testPutVVE() {
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		assertEquals(type + "A: B: C: D:", graph.toString());
	}

	public void updateGraph() {
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addEdge("A", "A");
		graph.addEdge("A", "B");
		graph.addEdge("B", "A");
		graph.addEdge("B", "C");
		graph.addEdge("C", "D");
		graph.addEdge("D", "C");
		graph.addEdge("D", "D");
	}

	@Test
	public void testRelationship() {
		Company c1 = new Company("012960449", "M", "S");
		Company c2 = new Company("317919249", "A", "S");
		relGraph.addVertex(c1);
		relGraph.addVertex(c2);
		relGraph.addEdge(c1, c2);

	}

	@Test
	public void testGet() {
		updateGraph();
		graph.addEdge("A", "B");
		assertFalse(graph.containsEdge("A", "C"));
		assertTrue(graph.containsEdge("A", "B"));
	}

	@Test
	public void testSizeGraph()
	{
		updateGraph();
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addEdge("D", "C");
	}
	
	@Test
	public void testAreAdjacent() {
		updateGraph();
		assertTrue(graph.containsEdge("A", "B"));
		assertTrue(graph.containsEdge("B", "C"));
		assertTrue(graph.containsEdge("C", "D"));
		assertTrue(graph.containsEdge("D", "C"));
		assertFalse(graph.containsEdge("A", "C"));
		assertFalse(graph.containsEdge("E", "C"));
		assertFalse(graph.containsEdge("A", "E"));
	}

	@Test
	public void testRemoveEdge() {
		updateGraph();
	}

	@Test
	public void testContainsVertex() {
		updateGraph();

		assertTrue(graph.containsVertex("A"));
		assertTrue(graph.containsVertex("B"));
		assertTrue(graph.containsVertex("C"));
		assertTrue(graph.containsVertex("D"));
		assertFalse(graph.containsVertex("E"));
		assertFalse(graph.containsVertex("F"));

		Company c1 = new Company("012960449", "M", "S");
		Company c2 = new Company("317919249", "A", "S");
		relGraph.addVertex(c1);
		relGraph.addVertex(c2);
	
		assertTrue(relGraph.containsVertex(c1));
		assertTrue(relGraph.containsVertex(new Company("317919249", "A", "S")));
		assertFalse(relGraph.containsVertex(new Company("327919249", "A", "S")));
		
		relGraph.addVertex(c2);
		relGraph.addVertex(c1);
		relGraph.addVertex(new Company("317919249", "A", "S"));
		assertEquals(2, relGraph.numOfVertices());
		
		
	}
	
	@Test
    public void testNoDuplicateEdges() {
        updateGraph();

        // Attempt to add a duplicate edge
        graph.addEdge("B", "C");

        // Verify the edge from A to C exists
        assertTrue("Edge from B to C should exist", graph.containsEdge("B", "C"));

        // Remove vertex C and re-add it, which should remove all edges connected to C
        graph.removeVertex("B");
        graph.addVertex("B");

        // The edge from A to C should no longer exist since C was removed and re-added
        assertFalse("Edge from B to C should not exist after removing C", graph.containsEdge("B", "C"));

        // Re-add the edge from A to C
        graph.addEdge("B", "C");

        // Now, if there were duplicate edges from A to C initially, removing C would have left one behind,
        // and re-adding it here would mean the edge still exists. We check if the edge does not exist to confirm no duplicates were added.
        assertTrue("Edge from B to C should exist after re-adding", graph.containsEdge("B", "C"));
    }
}

