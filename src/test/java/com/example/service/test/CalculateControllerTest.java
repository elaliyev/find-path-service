package com.example.service.test;

import com.example.dto.Graph;
import com.example.util.ApiPath;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static com.example.service.test.TConst.createGraphRequest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@ExtendWith(SpringExtension.class)
@Import({TestConfig.class})
class CalculateControllerTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private MockMvc mvc;

    @Test
    void givenGraph_whenFindAllPathRestAPI_thenReturnResponse2Paths() throws Exception {

        Map<Integer, List<Integer>> edges =
                Map.of(
                        0, Arrays.asList(1, 2),
                        2, Arrays.asList(0, 1),
                        1, Arrays.asList(3)
                );
        Graph graph = createGraphRequest(4, edges, 2, 3);

        List<Set<Integer>> expected = new ArrayList<>();
        expected.add(0, Set.of(2, 0, 1, 3));
        expected.add(1, Set.of(2, 1, 3));

        mvc.perform(post(ApiPath.FIND_ALL_PATH)
                        .content(objectMapper.writeValueAsString(graph))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expected)));
    }

    @Test
    void givenGraph_whenFindAllPathRestAPI_thenReturnResponse3Paths() throws Exception {

        Map<Integer, List<Integer>> edges =
                Map.of(
                        0, Arrays.asList(1, 2, 3),
                        2, Arrays.asList(0, 1),
                        1, Arrays.asList(3)
                );
        Graph graph = createGraphRequest(4, edges, 2, 3);

        List<Set<Integer>> expected = new ArrayList<>();
        expected.add(0, Set.of(2, 0, 1, 3));
        expected.add(1, Set.of(2, 0, 3));
        expected.add(2, Set.of(2, 1, 3));

        mvc.perform(post(ApiPath.FIND_ALL_PATH)
                        .content(objectMapper.writeValueAsString(graph))
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expected)));
    }


}
