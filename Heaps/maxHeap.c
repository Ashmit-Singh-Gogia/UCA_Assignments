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
  if (heap[get_parent(index)] < heap[index]) {
    swap(heap, get_parent(index), index);
    heapUp(heap, get_parent(index));
  }
}

void heapDown(int heap[], int index) {
  int max = index;
  int left = getLeft(max), right = getRight(max);
  if (left < size && heap[left] > heap[max]) {
    max = left;
  }
  if (right < size && heap[right] > heap[max]) {
    max = right;
  }
  if (max != index) {
    swap(heap, max, index);
    heapDown(heap, max);
  }
}

int pop(int heap[]) {
  if (size_of() == 0) {
    perror("empty heap");
    exit(-1);
  }
  int maxValue = heap[0];
  heap[0] = heap[size - 1];
  size--;
  heapDown(heap, 0);

  return maxValue;
}

void push(int heap[], int value) {
  heap[size++] = value;
  heapUp(heap, size - 1);
}

int getmax(int heap[]) {
  if (size_of() == 0) {
    perror("empty heap");
    exit(-1);
  }
  return heap[0];
}

int main() {
  printf("max Heap Implementation\n");
  int heap[100];
  push(heap, 10);
  push(heap, 32);
  push(heap, 11);
  push(heap, 2);
  printf("Calling getmax %d\n", getmax(heap));
  printf("Calling pop %d\n", pop(heap));
  printf("Calling getmax %d\n", getmax(heap));
  printf("Calling pop %d\n", pop(heap));
  push(heap, -8);
  printf("Calling getmax %d\n", getmax(heap));
  printf("Calling pop %d\n", pop(heap));
  printf("Heap is empty ? %d\n", isEmpty());
  printf("Calling pop %d\n", pop(heap));
  printf("Calling pop %d\n", pop(heap));
  printf("Heap is empty ? %d\n", isEmpty());
}