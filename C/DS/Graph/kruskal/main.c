#include <stdio.h>
#include <stdlib.h>

#include "../graph.h"

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

EdgeList graph_get_edges(Graph *g) {
    EdgeList list;
    list.count = 0;
    for (int i = 0; i < g->vertex_count; i++) {
        for (int j = i + 1; j < g->vertex_count; j++) {
            if (graph_has_edge(g, i, j)) {
                list.edge[list.count].u = i;
                list.edge[list.count].v = j;
                list.edge[list.count].w = g->matrix[i][j];
                list.count++;
            }
        }
    }
    return list;
}

int compare(const void* a, const void* b) {
    Edge* e1 = (Edge*) a;
    Edge* e2 = (Edge*) b;
    return e1->w - e2->w;
}

EdgeList kurskal(Graph* g) {
    EdgeList list = graph_get_edges(g);
    qsort(list.edge, list.count, sizeof(Edge), compare);

    EdgeList result;

    int parent[MAX];
    for (int i = 0; i < g->vertex_count; i++) {
        parent[i] = i;
    }

    result.count = 0;
    for (int i = 0; i < list.count; i++) {
        Edge e = list.edge[i];
        if (parent[e.u] != parent[e.v]) {
            result.edge[result.count] = e;
            result.count++;
            int old_parent = parent[e.u];
            int new_parent = parent[e.v];
            for (int j = 0; j < g->vertex_count; j++) {
                if (parent[j] == old_parent) {
                    parent[j] = new_parent;
                }
            }
        }
    }

    return result;
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

    EdgeList list = kurskal(&graph);

    for (int i = 0; i < list.count; i++) {
        printf("%d %d %d\n", list.edge[i].u, list.edge[i].v, list.edge[i].w);
    }

    return 0;
}
