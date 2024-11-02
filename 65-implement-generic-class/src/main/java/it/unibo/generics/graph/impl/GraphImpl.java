package it.unibo.generics.graph.impl;

import it.unibo.generics.graph.api.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphImpl<N> implements Graph<N>{

    private Map<N, Set<N>> edges = new HashMap<N, Set<N>>();

    @Override
    public void addNode(final N node) {
        edges.putIfAbsent(node, new HashSet<>());
    }

    @Override
    public void addEdge(final N source, final N target) {
        if(source != null && target != null){
            edges.get(source).add(target);
        }
    }

    @Override
    public Set<N> nodeSet() {
        return new HashSet<>(edges.keySet());
    }

    @Override
    public Set<N> linkedNodes(final N node) {
        return edges.get(node);
    }

    @Override
    public List<N> getPath(final N source, final N target) {
        final CheckPathImpl<N> path = new CheckPathImpl<>(edges);
        return path.checkingPath(source, target);
    }
}
