#pragma once

#include "../vector/vector.h"

typedef struct {
    int u, v, w;
} Edge;

typedef struct {
    int** matrix;
    int vertex_count;
} Graph;

void init_graph(Graph *g, int n);
void graph_add_edge(Graph *g, int u, int v, int w);
void graph_remove_edge(Graph *g, int u, int v);
int graph_has_edge(Graph *g, int u, int v);
Vector graph_get_edges(Graph *g);
