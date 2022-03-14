package com.example.rest;

import com.example.dto.Graph;
import com.example.service.GraphService;
import com.example.util.ApiPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
public class CalculateController {


    private final GraphService graphService;

    public CalculateController(GraphService graphService) {
        this.graphService = graphService;
    }


    @PostMapping(ApiPath.FIND_ALL_PATH)
    public List<Set<Integer>> findPath(@RequestBody Graph graph) {
        boolean[] isVisited = new boolean[graph.getVertices()];
        List<Integer> pathList = new ArrayList<>();
        pathList.add(graph.getFromPath());

        List<Set<Integer>> result = new ArrayList<>();
        graphService.findAllPath(graph.getAdjacencyList(), graph.getFromPath(), graph.getToPath(), isVisited, pathList, result);
        return result;
    }


}
