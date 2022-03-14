package com.example.service;

import java.util.List;
import java.util.Set;

public interface GraphService {

    void findAllPath(List<Integer>[] adjlist, Integer fromEdge, Integer toEdge,
                     boolean[] isVisited,
                     List<Integer> localPathList, List<Set<Integer>> result);
}
