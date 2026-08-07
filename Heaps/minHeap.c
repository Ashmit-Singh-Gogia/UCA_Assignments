#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

int size = 0;
int size_of() { return size; }
int get_parent(int index) { return (index - 1) / 2; }
int getLeft(int index) { return index * 2 + 1; }
int getRight(int index) { return index * 2 + 2; }

void swap(int heap[], int left, int right) {
  int temp = heap[left];
  heap[left] = heap[right];
  heap[right] = temp;
}

bool isEmpty() { return size == 0; }

void heapUp(int heap[], int index) {
  if (index == 0) {
    return;
  }
  if (heap[get_parent(index)] > heap[index]) {
    swap(heap, get_parent(index), index);
    heapUp(heap, get_parent(index));
  }
}

void heapDown(int heap[], int index) {
  int min = index;
  int left = getLeft(min), right = getRight(min);
  if (left < size && heap[left] < heap[min]) {
    min = left;
  }
  if (right < size && heap[right] < heap[min]) {
    min = right;
  }
  if (min != index) {
    swap(heap, min, index);
    heapDown(heap, min);
  }
}

int pop(int heap[]) {
  if (size_of() == 0) {
    perror("empty heap");
    exit(-1);
  }
  int minValue = heap[0];
  heap[0] = heap[size - 1];
  size--;
  heapDown(heap, 0);

  return minValue;
}

void push(int heap[], int value) {
  heap[size++] = value;
  heapUp(heap, size - 1);
}

int getMin(int heap[]) {
  if (size_of() == 0) {
    perror("empty heap");
    exit(-1);
  }
  return heap[0];
}

int main() {
  printf("Min Heap Implementation\n");
  int heap[100];
  push(heap, 10);
  push(heap, 32);
  push(heap, 11);
  push(heap, 2);
  printf("Calling getMin %d\n", getMin(heap));
  printf("Calling pop %d\n", pop(heap));
  printf("Calling getMin %d\n", getMin(heap));
  printf("Calling pop %d\n", pop(heap));
  push(heap, -8);
  printf("Calling getMin %d\n", getMin(heap));
  printf("Heap is empty ? %d\n", isEmpty());
  printf("Calling pop %d\n", pop(heap));
  printf("Calling pop %d\n", pop(heap));
  printf("Heap is empty ? %d\n", isEmpty());
}