#include "graph.h"
#include <stdlib.h>

void init_graph(Graph *g, int n) {
    g->vertex_count = n;
    g->matrix = (int**) malloc(n * sizeof(int*));
    for (int i = 0; i < n; i++) {
        g->matrix[i] = (int*) malloc(n * sizeof(int));
        for (int j = 0; j < n; j++) {
            g->matrix[i][j] = 0;
        }
    }
}

void graph_add_edge(Graph *g, int u, int v, int w) {
    g->matrix[u][v] = w;
    g->matrix[v][u] = w;
}

void graph_remove_edge(Graph *g, int u, int v) {
    g->matrix[u][v] = 0;
    g->matrix[v][u] = 0;
}

int graph_has_edge(Graph *g, int u, int v) {
    return g->matrix[u][v] != 0;
}

Vector graph_get_edges(Graph *g) {
    Vector list;
    vector_init_with_type(&list, Edge, g->vertex_count * g->vertex_count);
    for (int i = 0; i < g->vertex_count; i++) {
        for (int j = i + 1; j < g->vertex_count; j++) {
            if (graph_has_edge(g, i, j)) {
                Edge edge = {.u = i, .v = j, .w = g->matrix[i][j]};
                vector_push(&list, &edge);
            }
        }
    }
    return list;
}
