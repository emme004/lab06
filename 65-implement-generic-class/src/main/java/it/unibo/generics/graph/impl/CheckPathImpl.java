package it.unibo.generics.graph.impl;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
public class CheckPathImpl<N> {

    private final Map<N, Set<N>> graph;
    private final Map<N, CheckPath<N>> nodeAttribute;

    public CheckPathImpl(final Map<N, Set<N>> graph) {
        if(graph == null){
            throw new IllegalArgumentException("Error!");
        }
        this.graph = new HashMap<>();
        this.nodeAttribute = new HashMap<>();

        //inizialize node's attribute
        for(N node : graph.keySet()){
            this.graph.put(node, new HashSet<>());
            for(N nearNode : graph.get(node)){
                this.graph.get(node).add(nearNode);
            }
            this.nodeAttribute.put(node, new CheckPath<N>(node));
        }
    }

    public List<N> checkingPath(final N source, final N dest) {
        if (!this.graph.containsKey(source) || !this.graph.containsKey(dest)) {
            throw new IllegalArgumentException("The source and / or the destination node don't exist!");
        }

        // Initialize node's attributes and relax all edges
        this.initializeSingleSource(source);

        for (int i = 0; i < this.graph.size() - 1; i++) {
            for (N src: this.graph.keySet()) {
                for (N dst: this.graph.get(src)) {
                    this.relax(src, dst);
                }
            }
        }

        //Calculate the path with the relaxed nodes
        final List<N> path = new ArrayList<N>();

        N node = dest;
        do {
            path.addFirst(node);
            node = this.nodeAttribute.get(node).getFather();
        } while (node != null);
        return path;
    }

    private void initializeSingleSource(N source) {
        for (CheckPath<N> node : this.nodeAttribute.values()) {
            node.setDistance(null);
            node.setFather(null);

            if (node.getOneNode() == source) {
                node.setDistance(0);
            }
        }
    }


    private void relax(final N src, final N dest) {
        final CheckPath<N> source = this.nodeAttribute.get(src);
        final CheckPath<N> destination = this.nodeAttribute.get(dest);

        if (source.getDistance() == null) {
            return;
        }
        if ((destination.getDistance() > source.getDistance() + 1) || (destination.getDistance() == null)) {
            destination.setDistance(source.getDistance() + 1);
            destination.setFather(src);
        }
    }
}   
