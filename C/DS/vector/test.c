#include "vector.h"
#include <stdio.h>

int main() {

    Vector vector;
    vector_init_with_type(&vector, char*, 10);

    for (char i = 'a'; i <= 'z'; i++) {
        vector_push(&vector, &i);
    }

    for (int i = 0; i < vector_get_size(&vector); i++) {
        printf("%c\n", *(char*)vector_get(&vector, i));
    }

    return 0;
}
