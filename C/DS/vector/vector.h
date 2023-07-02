#pragma once

#include <stddef.h>

typedef struct {
    void* data;
    size_t size;
    size_t block_size;
    size_t capacity;
} Vector;

void vector_init(Vector* vector, size_t block_size, size_t capacity);

#define vector_init_with_type(vector, type, capacity) \
    vector_init(vector, sizeof(type), capacity)

void vector_free(Vector* vector);
void vector_push(Vector* vector, void* data);
void* vector_pop(Vector* vector);
void* vector_get(Vector* vector, size_t index);
size_t vector_get_size(Vector* vector);
size_t vector_get_capacity(Vector* vector);
void vector_set_data(Vector* vector, void* data, size_t size);
void vector_clear(Vector* vector);
void vector_reserve(Vector* vector, size_t capacity);
void vector_shrink_to_fit(Vector* vector);
