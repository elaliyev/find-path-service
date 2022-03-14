package com.example.service.test;

import com.example.dto.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class TConst {

    public static Graph createGraphRequest(int verticesCount, Map<Integer, List<Integer>> edges, int fromPath, int toPath) {
        Graph graph = new Graph();
        List<Integer>[] adjacency = new ArrayList[verticesCount];
        IntStream.range(0, verticesCount)
                .forEach(i -> adjacency[i] = new ArrayList<>());

        graph.setAdjacencyList(adjacency);
        graph.setVertices(verticesCount);
        edges.keySet().stream()
                .forEach(key -> graph.getAdjacencyList()[key]
                        .addAll(edges.get(key)));


        graph.setFromPath(fromPath);
        graph.setToPath(toPath);

        return graph;
    }

    public static List<Integer> createPathList(Graph graph) {
        List<Integer> pathList = new ArrayList<>();
        pathList.add(graph.getFromPath());
        return pathList;
    }
}
