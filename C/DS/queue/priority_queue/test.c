#include "priority_queue.h"
#include <stdio.h>

int main() {
    
    PriorityQueue pq = createPriorityQueueString();

    insertString(&pq, "rose");
    insertString(&pq, "lily");
    insertString(&pq, "tulip");
    insertString(&pq, "daisy");
    insertString(&pq, "sunflower");
    insertString(&pq, "daffodil");
    insertString(&pq, "dandelion");
    insertString(&pq, "orchid");
    insertString(&pq, "iris");
    insertString(&pq, "jasmine");
    insertString(&pq, "lavender");
    insertString(&pq, "lilac");
    insertString(&pq, "marigold");
    insertString(&pq, "poppy");
    insertString(&pq, "violet");
    insertString(&pq, "carnation");
    insertString(&pq, "chrysanthemum");
    insertString(&pq, "dahlia");
    insertString(&pq, "gardenia");
    insertString(&pq, "hyacinth");
    insertString(&pq, "hydrangea");
    insertString(&pq, "magnolia");
    insertString(&pq, "peony");
    insertString(&pq, "petunia");
    insertString(&pq, "zinnia");

    printf("%s\n", extractMaxString(&pq));
    printf("%s\n", extractMaxString(&pq));
    printf("%s\n", extractMaxString(&pq));
    printf("%s\n", extractMaxString(&pq));
    printf("%s\n", extractMaxString(&pq));

    return 0;
}
