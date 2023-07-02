#include "vector.h"

#include <string.h>
#include <stdlib.h>
#include <stdio.h>

void vector_init(Vector* vector, size_t block_size, size_t capacity) {
    vector->block_size = block_size;
    vector->capacity = capacity;
    vector->size = 0;
    vector->data = malloc(block_size * capacity);
}

void vector_free(Vector* vector) {
    free(vector->data);
}

void vector_push(Vector* vector, void* data) {
    if (vector->size == vector->capacity) {
        vector->capacity *= 2;
        vector_reserve(vector, vector->capacity);
    }
    
    memcpy(vector->data + vector->size * vector->block_size, data, vector->block_size);
    vector->size++;
}

void* vector_pop(Vector* vector) {
    if (vector->size == 0) {
        return NULL;
    }
    
    vector->size--;
    return vector->data + vector->size * vector->block_size;
}

void* vector_get(Vector* vector, size_t index) {
    if (index >= vector->size) {
        return NULL;
    }
    
    return vector->data + index * vector->block_size;
}

size_t vector_get_size(Vector* vector) {
    return vector->size;
}

size_t vector_get_capacity(Vector* vector) {
    return vector->capacity;
}

void vector_set(Vector* vector, size_t index, void* data) {
    if (index >= vector->size) {
        return;
    }
    
    memcpy(vector->data + index * vector->block_size, data, vector->block_size);
}

void vector_set_data(Vector* vector, void* data, size_t size) {
    vector->size = size;
    vector->capacity = size;
    vector->data = realloc(vector->data, vector->block_size * vector->capacity);
    memcpy(vector->data, data, vector->block_size * vector->capacity);
}

void vector_clear(Vector* vector) {
    vector->size = 0;
}

void vector_reserve(Vector* vector, size_t capacity) {
    if (capacity < vector->capacity) {
        printf("Warning: vector_reserve called with capacity < vector->capacity\nOperation not allowed");
        return;
    }
    vector->capacity = capacity;
    vector->data = realloc(vector->data, vector->block_size * vector->capacity);
}

void vector_shrink_to_fit(Vector* vector) {
    vector->capacity = vector->size;
    vector->data = realloc(vector->data, vector->block_size * vector->capacity);
}

void vector_sort(Vector* vector, int (*comparator)(const void*, const void*)) {
    qsort(vector->data, vector->size, vector->block_size, comparator);
}
