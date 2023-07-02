#pragma once

#define MAX 30

typedef struct {
    int u, v, w;
} Edge;

typedef struct {
    Edge edge[MAX];
    int count;
} EdgeList;

typedef struct {
    int** matrix;
    int vertex_count;
} Graph;

