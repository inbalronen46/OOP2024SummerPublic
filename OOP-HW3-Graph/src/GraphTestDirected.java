import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public  class GraphTestDirected extends GraphTestAbstract{

	@Override
	public void setUp() {
		graph = new DirectedGraph<String>();
		relGraph  = new DirectedGraph<Company>();
		type = "DirectedGraph:\t";
	}
	
	@Test
	public void testSizeGraph()
	{
		super.testSizeGraph();
		assertEquals(4,graph.numOfVertices());
		assertEquals(7,graph.numOfEdges());
	} 
	
	@Test
	public void testRemoveEdge() {
		super.testRemoveEdge();
		
		assertEquals(type + "A:A->B B:A->C C:D D:C->D", graph.toString());
		assertTrue(graph.removeEdge("B", "C"));
		assertEquals(type + "A:A->B B:A C:D D:C->D", graph.toString());
		assertFalse(graph.removeEdge("A", "E"));
		assertEquals(type + "A:A->B B:A C:D D:C->D", graph.toString());
		assertFalse(graph.removeEdge("E", "A"));
		assertFalse(graph.removeEdge("A", "D"));
		assertEquals(type + "A:A->B B:A C:D D:C->D", graph.toString());
		
	}
	
	@Test
	public void testAreAdjacent() {
		super.testAreAdjacent();
		assertFalse(graph.containsEdge("C", "B"));
	}
	
	@Test
	public void testPutVVE() {
		super.testPutVVE();
		graph.addEdge("A", "B");
		assertEquals(type + "A:B B: C: D:", graph.toString());
		graph.addEdge("B", "C");
		graph.addEdge("C", "D");
		assertEquals(type + "A:B B:C C:D D:", graph.toString());
	}
	
	@Test
	public void testRelationship() {
		super.testRelationship();
		assertEquals(type
				+ "Company [012960449 M S]:Company [317919249 A S] Company [317919249 A S]:",
				relGraph.toString());
	}

}