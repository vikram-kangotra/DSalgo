#include "../graph.h"
#include <stdio.h>
#include <stdlib.h>

Vector prim(Graph* graph) {
    Vector list;
    vector_init_with_type(&list, Edge, 1);

    int* visited = (int*) malloc(sizeof(int) * graph->vertex_count);
    for (int i = 0; i < graph->vertex_count; i++) {
        visited[i] = 0;
    }

    visited[0] = 1;

    for (int i = 1; i < graph->vertex_count; ++i) {
        Edge min = {0, 0, 0x7fffffff};
        for (int j = 0; j < graph->vertex_count; ++j) {
            if (visited[j] && graph->matrix[i][j] != 0) {
                if (min.w > graph->matrix[i][j]) {
                    min.u = i;
                    min.v = j;
                    min.w = graph->matrix[i][j];
                }
            }
        }
        visited[min.u] = 1;
        vector_push(&list, &min); 
    }
  
    free(visited);

    return list;
}

int main() {

    Graph graph;
    init_graph(&graph, 5);

    graph_add_edge(&graph, 0, 1, 2);
    graph_add_edge(&graph, 0, 4, 5);
    graph_add_edge(&graph, 1, 2, 6);
    graph_add_edge(&graph, 1, 3, 7);
    graph_add_edge(&graph, 1, 4, 8);
    graph_add_edge(&graph, 2, 4, 10);

    Vector list = prim(&graph);

    for (int i = 0; i < list.size; i++) {
        Edge* e = (Edge*) vector_get(&list, i);
        printf("%d %d %d\n", e->u, e->v, e->w);
    }

    return 0;
}
