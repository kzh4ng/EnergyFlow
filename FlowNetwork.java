package com.company;

public class FlowNetwork {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private Bag<FlowEdge>[] adj;
    private String cityNames[];
    /**
     * Initializes an empty flow network with <tt>V</tt> vertices and 0 edges.
     * param V the number of vertices
     * @throws java.lang.IllegalArgumentException if <tt>V</tt> < 0
     */
    public FlowNetwork(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices in a Graph must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (Bag<FlowEdge>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<FlowEdge>();
        cityNames = new String[V];
    }

    public void setCityNames(int i, String name){
        cityNames[i] = name;
    }


    /**
     * Returns the number of vertices in the edge-weighted graph.
     * @return the number of vertices in the edge-weighted graph
     */
    public int V() {
        return V;
    }

    /**
     * Returns the number of edges in the edge-weighted graph.
     * @return the number of edges in the edge-weighted graph
     */
    public int E() {
        return E;
    }

    // throw an IndexOutOfBoundsException unless 0 <= v < V
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
    }

    /**
     * Adds the edge <tt>e</tt> to the network.
     * @param e the edge
     * @throws java.lang.IndexOutOfBoundsException unless endpoints of edge are between 0 and V-1
     */
    public void addEdge(FlowEdge e) {
        int v = e.from();
        int w = e.to();
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    /**
     * Returns the edges incident on vertex <tt>v</tt> (includes both edges pointing to
     * and from <tt>v</tt>).
     * @param v the vertex
     * @return the edges incident on vertex <tt>v</tt> as an Iterable
     * @throws java.lang.IndexOutOfBoundsException unless 0 <= v < V
     */
    public Iterable<FlowEdge> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    // return list of all edges - excludes self loops
    public Iterable<FlowEdge> edges() {
        Bag<FlowEdge> list = new Bag<FlowEdge>();
        for (int v = 0; v < V; v++)
            for (FlowEdge e : adj(v)) {
                if (e.to() != v)
                    list.add(e);
            }
        return list;
    }


    /**
     * Returns a string representation of the flow network.
     * This method takes time proportional to <em>E</em> + <em>V</em>.
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     *    followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ":  ");
            for (FlowEdge e : adj[v]) {
                if (e.to() != v) s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }


}
