#pragma once

#include <stddef.h>

typedef struct {
    void* data;
    size_t size;
    size_t capacity;
    size_t data_block_size;
    int (*compare)(const void*, const void*);
} PriorityQueue;

PriorityQueue createPriorityQueue(size_t data_block_size, int (*compare)(const void*, const void*));

int compareInt(const void* a, const void* b);
int compareChar(const void* a, const void* b);
int compareString(const void* a, const void* b);

#define createPriorityQueueInt() createPriorityQueue(sizeof(int), compareInt)
#define createPriorityQueueChar() createPriorityQueue(sizeof(char), compareChar)
#define createPriorityQueueString() createPriorityQueue(sizeof(char*), compareString)
#define createPriorityQueueGeneric(type, compare) createPriorityQueue(sizeof(type), compare)

void destroyPriorityQueue(PriorityQueue* queue);

void insert(PriorityQueue* queue, void* data);

#define insertChar(queue, data) insert(queue, &(char){data})
#define insertInt(queue, data) insert(queue, &(int){data})
#define insertString(queue, data) insert(queue, &(char*){data})
#define insertGeneric(queue, data, type) insert(queue, &(type){data})

void* extractMax(PriorityQueue* queue);

#define extractMaxChar(queue) *(char*)extractMax(queue)
#define extractMaxInt(queue) *(int*)extractMax(queue)
#define extractMaxString(queue) *(char**)extractMax(queue)
#define extractMaxGeneric(queue, type) *(type*)extractMax(queue)

void* peekMax(PriorityQueue* queue);

#define peekMaxChar(queue) *(char*)peekMax(queue)
#define peekMaxInt(queue) *(int*)peekMax(queue)
#define peekMaxString(queue) *(char**)peekMax(queue)
#define peekMaxGeneric(queue, type) *(type*)peekMax(queue)
