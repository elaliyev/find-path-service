package com.example.service.impl;

import com.example.service.GraphService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GraphServiceImpl implements GraphService {

    public void findAllPath(List<Integer>[] adjacency, Integer fromEdge, Integer toEdge,
                            boolean[] isVisited,
                            List<Integer> path, List<Set<Integer>> result) {


        if (fromEdge.equals(toEdge)) {
            collectResult(path, result);
        }

        markVisited(isVisited, fromEdge);

        for (Integer i : adjacency[fromEdge]) {
            if (!isVisited[i]) {
                path.add(i);
                findAllPath(adjacency, i, toEdge, isVisited, path, result);

                path.remove(i);
            }
        }

        markUnvisited(isVisited, fromEdge);


    }

    private void markUnvisited(boolean[] isVisited, Integer fromEdge) {
        isVisited[fromEdge] = false;
    }

    private void markVisited(boolean[] isVisited, Integer fromEdge) {
        isVisited[fromEdge] = true;
    }

    private void collectResult(List<Integer> localPathList, List<Set<Integer>> result) {
        Set<Integer> set = new LinkedHashSet<>();
        set.addAll(localPathList);
        result.add(set);
    }
}
