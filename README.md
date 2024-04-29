This repository stores the data structures: MyArrayList, MyLinkedList, My Min Heap, Queue and Stack.

The MyList interface is also stored, on the basis of which all the above classes are written, in particular My Min Heap, Queue and Stack, which are subclasses of MyArrayList, MyLinkedList.

Min Heap and Queue are subclasses of MyArrayList, while Stack is a subclass of MyLinkedList; this choice was based on the fact that Stack is easiest to implement on MyLinkedList, unlike the other two subclasses.

Principle of operation:

Stack:
The stack data structure operates on the Last In First Out (LIFO) principle, which means that the last element added will be the first element removed. Basic stack operations:

push(): Adding an element to the top of the stack.
pop(): Removes an element from the top of the stack and returns its value.
peek(): Retrieving the value of the element at the top of the stack without removing it.
empty(): Checks if the stack is empty.

Queue:
Queue is a data structure that operates on a First In First Out (FIFO) basis, which means that elements are added to the end of the queue and removed from the beginning of the queue. Basic queue operations:

enqueue(): Adds an element to the end of the queue.
dequeue(): Removes an element from the head of the queue and returns its value.
peek(): Get the value of the element at the head of the queue without removing it.
empty(): Checks if the queue is empty

MyMinHeap:
MinHeap is a data structure that is a binary tree where each node has a value that is less than or equal to the values of its descendants. In MinHeap, the smallest element is always at the root of the tree.

insert(): A new element is added to the end of the array, then the element is "raised" up the tree until it reaches its correct position to satisfy the MinHeap property.
extraxtMin(): The minimum element is at the root of the tree. When extracting the minimum element, the root is replaced by the last element of the array, and then the element is "lowered" down the tree until it reaches its correct position.
heapify(): To build a MinHeap from an arbitrary array of elements, you must "drop" all elements, starting with the last element that has children, to the root of the tree.
getMin(): The minimum element is always at the root of the tree and is accessible in O(1) time.
