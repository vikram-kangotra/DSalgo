#include <stdio.h>
#include <stdlib.h>

#include "../graph.h"

int compare(const void* a, const void* b) {
    Edge* e1 = (Edge*) a;
    Edge* e2 = (Edge*) b;
    return e1->w - e2->w;
}

Vector kurskal(Graph* g) {
    Vector list = graph_get_edges(g);
    vector_sort(&list, compare);

    Vector result;
    vector_init_with_type(&result, Edge, list.size);

    int parent[list.size];
    for (int i = 0; i < g->vertex_count; i++) {
        parent[i] = i;
    }

    for (int i = 0; i < list.size; i++) {
        Edge* e = (Edge*) vector_get(&list, i);
        if (parent[e->u] != parent[e->v]) {
            vector_push(&result, e);
            int old_parent = parent[e->u];
            int new_parent = parent[e->v];
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

    Vector list = kurskal(&graph);

    for (int i = 0; i < list.size; i++) {
        Edge* e = (Edge*) vector_get(&list, i);
        printf("%d %d %d\n", e->u, e->v, e->w);
    }

    return 0;
}
