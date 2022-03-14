package com.example.dto;

import lombok.Data;

import java.util.List;

@Data
public class Graph {
    private int vertices;

    private List<Integer>[] adjacencyList;
    private Integer fromPath;
    private Integer toPath;

}
