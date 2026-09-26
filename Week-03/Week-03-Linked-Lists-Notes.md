# Week 03: Linked Lists - Complete Study Notes & Java Implementations

Comprehensive guide on **Linked Lists** covering Singly, Doubly, and Circular Linked Lists, operations (insertion, deletion, traversal, search, reversing), array vs. linked list comparative analysis, and stack/queue implementations.

---

## 📑 Table of Contents
1. [Introduction & Core Concepts](#1-introduction--core-concepts)
2. [Advantages & Disadvantages](#2-advantages--disadvantages)
3. [Arrays vs. Linked Lists Comparison](#3-arrays-vs-linked-lists-comparison)
4. [Types of Linked Lists](#4-types-of-linked-lists)
   - [Singly Linked List](#a-singly-linked-list)
   - [Doubly Linked List](#b-doubly-linked-list)
   - [Circular Linked List](#c-circular-linked-list)
5. [Core Operations & Time Complexities](#5-core-operations--time-complexities)
6. [Complete Java Implementation: SinglyLinkedList](#6-complete-java-implementation-singlylinkedlist)
7. [Advanced Operations](#7-advanced-operations)
   - [Reversing a Singly Linked List](#a-reversing-a-singly-linked-list)
   - [Merging Two Sorted Linked Lists](#b-merging-two-sorted-linked-lists)
8. [Stack and Queue Implementations Using Linked Lists](#8-stack-and-queue-implementations-using-linked-lists)
9. [NPTEL Exam Focus & Key Takeaways](#9-nptel-exam-focus--key-takeaways)

---

## 1. Introduction & Core Concepts

A **Linked List** is a fundamental linear data structure consisting of a sequence of discrete objects called **nodes**. 

Unlike contiguous arrays:
* Each node stores its own **data payload** and one or more **references (pointers)** to adjacent nodes.
* Nodes are allocated dynamically in heap memory and do not need to reside in consecutive physical memory addresses.
* The starting node of the list is tracked by a special reference called `head`. If the list is empty, `head == null`.
* The last node in a standard linear list points to `null`.

```
[HEAD] ──► ┌──────┬──────┐    ┌──────┬──────┐    ┌──────┬──────┐
           │ Data │ Next ├───►│ Data │ Next ├───►│ Data │ NULL │
           └──────┴──────┘    └──────┴──────┘    └──────┴──────┘
```

---

## 2. Advantages & Disadvantages

### Advantages
* **Dynamic Sizing:** Memory is allocated on demand at runtime; no need to pre-allocate fixed capacity.
* **Efficient Insertions & Deletions:** Adding or removing nodes at a known location requires updating node references ($O(1)$) rather than shifting elements.
* **Flexible Memory Utilization:** Utilizes non-contiguous heap space efficiently.
* **Ideal Building Block:** Serves as the foundation for Stacks, Queues, Graphs (Adjacency Lists), and Hash Table chaining.

### Disadvantages
* **No Random Access:** Elements cannot be accessed directly by index ($O(1)$); reaching the $k^{\text{th}}$ element requires sequential $O(N)$ traversal from `head`.
* **Memory Overhead:** Extra memory is consumed per node for storing `next` (and `prev`) object references.
* **Cache Unfriendliness:** Scattered node allocations degrade CPU cache locality compared to contiguous arrays.
* **Reverse Traversal Difficulty:** Reversing or backward traversal is inefficient in a Singly Linked List without extra pointers or recursive call stacks.

---

## 3. Arrays vs. Linked Lists Comparison

| Parameter | Arrays | Linked Lists |
| :--- | :--- | :--- |
| **Memory Allocation** | Static / Contiguous allocation on heap/stack | Dynamic / Non-contiguous heap allocation |
| **Random Access** | $O(1)$ constant time via index arithmetic | $O(N)$ sequential traversal from `head` |
| **Insertion / Deletion** | $O(N)$ due to element shifting | $O(1)$ at head/known pointer; $O(N)$ if searching location |
| **Memory Overhead** | Minimal (stores only data elements) | Extra pointer per node (`next` / `prev` references) |
| **Cache Locality** | High (sequential physical storage) | Low (scattered memory references) |
| **Size Flexibility** | Fixed capacity (requires reallocation to grow) | Grows and shrinks dynamically at runtime |

---

## 4. Types of Linked Lists

### A. Singly Linked List
Each node contains a data element and a single reference pointer `next` pointing to the subsequent node.

```java
class Node<E> {
    E data;
    Node<E> next;

    Node(E data) {
        this.data = data;
        this.next = null;
    }
}
```

### B. Doubly Linked List
Each node contains a data element and two reference pointers: `next` pointing to the subsequent node, and `prev` pointing to the preceding node.

```java
class DoublyNode<E> {
    E data;
    DoublyNode<E> prev;
    DoublyNode<E> next;

    DoublyNode(E data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
```
* **Benefit:** Supports bidirectional traversal (forward and backward) and $O(1)$ node deletion when given a direct reference to the node.

### C. Circular Linked List
In a Circular Singly Linked List, the `next` pointer of the final node references the `head` node instead of `null`, forming a closed loop.
* **Property:** No node contains `null`. Traversal continues until the starting node is revisited.

---

## 5. Core Operations & Time Complexities

| Operation | Time Complexity (Singly) | Time Complexity (Doubly) | Description |
| :--- | :--- | :--- | :--- |
| **Prepend (`addFirst`)** | $O(1)$ | $O(1)$ | Insert new node as the new `head` |
| **Append (`addLast`)** | $O(1)$ with `tail` / $O(N)$ without | $O(1)$ with `tail` | Insert new node after the last node |
| **Insert at Index** | $O(N)$ | $O(N)$ | Traverse to position $(i-1)$ and adjust pointers |
| **Delete Head (`removeFirst`)** | $O(1)$ | $O(1)$ | Shift `head = head.next` |
| **Delete Tail (`removeLast`)** | $O(N)$ (requires second-last node) | $O(1)$ with `tail.prev` | Remove final node |
| **Search by Value** | $O(N)$ | $O(N)$ | Linear inspection from `head` |

---

## 6. Complete Java Implementation: SinglyLinkedList

```java
import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // O(1) Insertion at Beginning
    public void addFirst(E value) {
        Node<E> newNode = new Node<>(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // O(1) Insertion at End using Tail Pointer
    public void addLast(E value) {
        Node<E> newNode = new Node<>(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // O(1) Deletion at Head
    public E removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        E removedData = head.data;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return removedData;
    }

    // O(N) Search
    public int indexOf(E value) {
        Node<E> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(value)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    // Traversal Display
    public void display() {
        Node<E> current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print("[" + current.data + "] -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
}
```

---

## 7. Advanced Operations

### A. Reversing a Singly Linked List
Iteratively re-orient node pointers using three pointer references (`prev`, `current`, `next`).

```java
public void reverse() {
    Node<E> prev = null;
    Node<E> current = head;
    Node<E> next = null;

    tail = head; // Original head becomes tail

    while (current != null) {
        next = current.next; // 1. Save next node
        current.next = prev; // 2. Reverse current link
        prev = current;      // 3. Move prev forward
        current = next;      // 4. Move current forward
    }
    head = prev; // Update head to new front
}
```
* **Time Complexity:** $O(N)$
* **Space Complexity:** $O(1)$ auxiliary space

### B. Merging Two Sorted Linked Lists
Combines two sorted singly linked lists into a single sorted list by updating pointer links without creating new node objects.

```java
public static Node<Integer> mergeSorted(Node<Integer> head1, Node<Integer> head2) {
    if (head1 == null) return head2;
    if (head2 == null) return head1;

    Node<Integer> dummy = new Node<>(0);
    Node<Integer> tail = dummy;

    while (head1 != null && head2 != null) {
        if (head1.data <= head2.data) {
            tail.next = head1;
            head1 = head1.next;
        } else {
            tail.next = head2;
            head2 = head2.next;
        }
        tail = tail.next;
    }

    if (head1 != null) tail.next = head1;
    if (head2 != null) tail.next = head2;

    return dummy.next;
}
```

---

## 8. Stack and Queue Implementations Using Linked Lists

### A. Stack (LIFO) via Singly Linked List
Operations map directly to head insertions and head removals:
* **`push(val)`**: `addFirst(val)` — $O(1)$
* **`pop()`**: `removeFirst()` — $O(1)$
* **`peek()`**: Return `head.data` — $O(1)$

### B. Queue (FIFO) via Singly Linked List with Tail Pointer
* **`enqueue(val)`**: `addLast(val)` — $O(1)$
* **`dequeue()`**: `removeFirst()` — $O(1)$
* **`peek()`**: Return `head.data` — $O(1)$

---

## 9. NPTEL Exam Focus & Key Takeaways

1. **Pointer Manipulation Logic:** NPTEL MCQs frequently ask for the correct sequence of statements when inserting a node between `temp` and `temp.next`:
   ```java
   newNode.next = temp.next;
   temp.next = newNode;
   ```
2. **Access Complexity:** Accessing element at index $k$ takes $O(N)$ time in a linked list versus $O(1)$ in an array.
3. **Queue Enqueue/Dequeue Time:** Implementing a Queue with a singly linked list requires a `tail` pointer to ensure $O(1)$ `enqueue`. Dequeueing from the `head` is always $O(1)$.
4. **Circular Linked List Termination:** Loop condition is `while (current.next != head)`, not `while (current.next != null)`.
