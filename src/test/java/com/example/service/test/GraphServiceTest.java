package com.example.service.test;

import com.example.dto.Graph;
import com.example.service.impl.GraphServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static com.example.service.test.TConst.createGraphRequest;
import static com.example.service.test.TConst.createPathList;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotEquals;

@ExtendWith(MockitoExtension.class)
class GraphServiceTest {

    @Autowired
    @InjectMocks
    private GraphServiceImpl graphService;

    @Test
    void givenGraph_whenFindingAllPathService_thenReturn2Paths(){
        Map<Integer, List<Integer>> edges =
                Map.of(
                        0, Arrays.asList(1,2),
                        2, Arrays.asList(0,1),
                        1, Arrays.asList(3)
                );
        Graph graph = createGraphRequest(4, edges, 2, 3);

        boolean[] isVisited = new boolean[graph.getVertices()];

        List<Set<Integer>> result = new ArrayList<>();
        graphService.findAllPath(graph.getAdjacencyList(), graph.getFromPath(), graph.getToPath(), isVisited, createPathList(graph), result);

        List<Set<Integer>> expected = new ArrayList<>();
        expected.add(0, Set.of(2,0,1,3));
        expected.add(1, Set.of(2,1,3));

        assertEquals("Values are not same",expected, result);
    }

    @Test
    void givenGraph_whenFindingAllPathService_thenReturn3Paths(){
        Map<Integer, List<Integer>> edges =
                Map.of(
                        0, Arrays.asList(1,2,3),
                        2, Arrays.asList(0,1),
                        1, Arrays.asList(3)
                );
        Graph graph = createGraphRequest(4, edges, 2, 3);

        boolean[] isVisited = new boolean[graph.getVertices()];

        List<Set<Integer>> result = new ArrayList<>();
        graphService.findAllPath(graph.getAdjacencyList(), graph.getFromPath(), graph.getToPath(), isVisited, createPathList(graph), result);

        List<Set<Integer>> expected = new ArrayList<>();
        expected.add(0, Set.of(2,0,1,3));
        expected.add(1, Set.of(2,0,3));
        expected.add(2, Set.of(2,1,3));

        assertEquals("Values are not same",expected, result);
    }

    @Test
    void givenGraph_whenFindingAllPathService_thenReturnWrongAnswer(){
        Map<Integer, List<Integer>> edges =
                Map.of(
                        0, Arrays.asList(1,2,3),
                        2, Arrays.asList(0,1),
                        1, Arrays.asList(3)
                );
        Graph graph = createGraphRequest(4, edges, 2, 3);

        boolean[] isVisited = new boolean[graph.getVertices()];

        List<Set<Integer>> result = new ArrayList<>();
        graphService.findAllPath(graph.getAdjacencyList(), graph.getFromPath(), graph.getToPath(), isVisited, createPathList(graph), result);

        List<Set<Integer>> expected = new ArrayList<>();
        expected.add(0, Set.of(2,0,1,3));
        expected.add(1, Set.of(2,0,3));
        expected.add(2, Set.of(1,3));

        assertNotEquals("Values are same",expected, result);
    }

}
