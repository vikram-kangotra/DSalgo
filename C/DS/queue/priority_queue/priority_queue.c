#include "priority_queue.h"
#include <stddef.h>
#include <stdlib.h>
#include <string.h>

#define LEFT(i) (2* i + 1)
#define RIGHT(i) (2* i + 2)

int compareChar(const void* a, const void* b) {
    return *(char*)a - *(char*)b;
}

int compareInt(const void* a, const void* b) {
    return *(int*)a - *(int*)b;
}

int compareString(const void* a, const void* b) {
    return strcmp(*(char**)a, *(char**)b);
}

PriorityQueue createPriorityQueue(size_t data_block_size, int (*compare)(const void*, const void*)) {
    PriorityQueue queue;
    queue.data_block_size = data_block_size;
    queue.capacity = 10;
    queue.size = 0;
    queue.data = malloc(data_block_size* queue.capacity);
    queue.compare = compare;
    return queue;
}

void destroyPriorityQueue(PriorityQueue* queue) {
    free(queue->data);
}

void swap(PriorityQueue* queue, size_t a, size_t b) {
    void* temp = malloc(queue->data_block_size);
    memcpy(temp, queue->data + a* queue->data_block_size, queue->data_block_size);    
    memcpy(queue->data + a* queue->data_block_size, queue->data + b* queue->data_block_size, queue->data_block_size);
    memcpy(queue->data + b* queue->data_block_size, temp, queue->data_block_size);
    free(temp);
}

void heapify(PriorityQueue* queue, size_t i) {
    size_t largest = i;
    size_t leftChild = LEFT(i);
    size_t rightChild = RIGHT(i);
    if (leftChild < queue->size && queue->compare(queue->data + leftChild* queue->data_block_size, queue->data + largest* queue->data_block_size) > 0)
        largest = leftChild;
    if (rightChild < queue->size && queue->compare(queue->data + rightChild* queue->data_block_size, queue->data + largest* queue->data_block_size) > 0)
        largest = rightChild;

    if (largest != i) {
        swap(queue, i, largest);
        heapify(queue, largest);
    }
}

void insert(PriorityQueue* queue, void* data) {
    if (queue->size == queue->capacity) {
        queue->capacity *= 2;
        queue->data = realloc(queue->data, queue->capacity* queue->data_block_size);
    }

    memcpy(queue->data + queue->size* queue->data_block_size, data, queue->data_block_size);
    queue->size++;

    for (int i = queue->size / 2 - 1; i >= 0; --i) {
        heapify(queue, i);
    }
}

void* extractMax(PriorityQueue* queue) {
    if (queue->size == 0) {
        return NULL;
    }

    void* max = malloc(queue->data_block_size);
    memcpy(max, queue->data, queue->data_block_size);

    memcpy(queue->data, queue->data + (queue->size - 1)* queue->data_block_size, queue->data_block_size);
    queue->size--;

    for (int i = queue->size / 2 - 1; i >= 0; --i) {
        heapify(queue, i);
    }

    return max;
}

void* peekMax(PriorityQueue* queue) {
    if (queue->size == 0) {
        return NULL;
    }

    return queue->data;
}
