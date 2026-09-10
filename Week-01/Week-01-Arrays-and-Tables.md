# Week 01: 1D Arrays, Lists, Vectors, 2D Matrices, and Tables of Objects

This repository module covers the fundamental concepts of Data Structures and Algorithms (DSA) in Java for **Week 1**, focusing on data abstraction, entity attributes, tables of objects, 1D arrays, 2D matrices, and dynamic linear lists.

---

## 📑 Table of Contents
1. [Core Concepts: Data, Information, and Entities](#1-core-concepts-data-information-and-entities)
2. [Data Abstraction & Big Data Context](#2-data-abstraction--big-data-context)
3. [One-Dimensional (1D) Arrays](#3-one-dimensional-1d-arrays)
4. [Two-Dimensional (2D) Arrays & Matrices](#4-two-dimensional-2d-arrays--matrices)
5. [Static Arrays vs. Dynamic Lists & Vectors](#5-static-arrays-vs-dynamic-lists--vectors)
6. [Tables of Objects](#6-tables-of-objects)
7. [Java Code Examples](#7-java-code-examples)

---

## 1. Core Concepts: Data, Information, and Entities

* **Data**: Raw, unorganized facts represented in forms such as numbers, strings (e.g., names), or mixed formats (e.g., email IDs, mobile numbers).
* **Entity**: A real-life record or subject (e.g., a student, an employee, or an institution). An entity is characterized by a set of **attributes**:
  * `Name`: String
  * `Age`: Numeric / Integer
  * `Gender`: Boolean / Single character (`M`/`F`)
  * `Salary`: Floating-point number
* **Information**: Meaningful knowledge extracted from raw data by processing it using **algorithms** or programs. For instance, raw milk consumption numbers become actionable information when an algorithm calculates total weekly cost or average protein intake.

---

## 2. Data Abstraction & Big Data Context

* **Primitive Data Types**: Basic types built directly into programming languages (e.g., `int`, `float`, `char`, `boolean`).
* **The Need for Data Abstraction**: Modern applications generate **Big Data** characterized by massive volume, high velocity, and structural variety (text, images, audio, sensor streams).
* **Abstract Data Types (ADTs)**: Allow programmers to define customized data structures tailored to specific application demands, encapsulating data representation and enabling operations beyond simple primitive types.

---

## 3. One-Dimensional (1D) Arrays

A **1D Array** is a linear data structure that stores homogeneous elements at **contiguous memory locations**.

### Characteristics
* **Zero-Based Indexing**: First element is stored at index `0`, and the last element is at index `n - 1` (where `n` is the size).
* **Random Access**: Any element can be directly accessed in $O(1)$ constant time using its index:
  $$\text{Address}(A[i]) = \text{Base Address} + (i \times \text{element size})$$
* **Performance**: Provides fast cache locality and low overhead.

### Syntax in Java
```java
// Declaration
int[] numbers;

// Allocation (allocates space for 10 integers on the heap)
numbers = new int[10];

// Literal Initialization
int[] values = {10, 20, 30, 40, 50};

// Accessing & Updating
int first = values[0]; // Access: O(1)
values[2] = 99;        // Update: O(1)
```

---

## 4. Two-Dimensional (2D) Arrays & Matrices

A **2D Array** is an array of arrays arranged in a grid-like grid structure with rows and columns.

### Characteristics
* **Indexing**: Elements are accessed via row and column indices: `matrix[row_index][column_index]`.
* **Memory Representation**: Stored in contiguous memory as an array of row array references.
* **Use Cases**: Ideal for mathematical matrices, tabular records, game boards, and image pixel processing.

### Syntax in Java
```java
// Declaration and Allocation (2 rows, 3 columns)
int[][] matrix = new int[2][3];

// Literal Initialization
int[][] grid = {
    {10, 20, 30}, // Row 0
    {40, 50, 60}  // Row 1
};

// Accessing Row 1, Column 2 (value: 60)
int val = grid[1][2];
```

---

## 5. Static Arrays vs. Dynamic Lists & Vectors

| Feature | Static Arrays (`int[]`) | Dynamic Lists (`ArrayList` / `Vector`) |
| :--- | :--- | :--- |
| **Size Flexibility** | Fixed size allocated at initialization | Resizable dynamically during runtime |
| **Memory Layout** | Single contiguous block | Internally backed by arrays; resizes when capacity is reached |
| **Element Type** | Supports primitives & objects | Holds Object references (uses wrapper classes for primitives) |
| **Access Time** | $O(1)$ constant time | $O(1)$ constant time |
| **Insertion Overhead** | Shift elements ($O(N)$) | Amortized $O(1)$ at end; $O(N)$ for middle insertions |

---

## 6. Tables of Objects

A collection of records is logically represented as a **Table of Objects**:
* **Rows**: Each row represents an individual entity record (object instance).
* **Columns**: Each column corresponds to a specific attribute shared across all records.

```java
class Employee {
    String name;
    int age;
    char gender;
    double salary;

    public Employee(String name, int age, char gender, double salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }
}

// Table of Employee Objects
Employee[] staffTable = new Employee[3];
staffTable[0] = new Employee("Alice", 30, 'F', 75000.0);
staffTable[1] = new Employee("Bob", 25, 'M', 62000.0);
staffTable[2] = new Employee("Charlie", 35, 'M', 88000.0);
```

---

## 7. Java Code Examples

### A. Find Maximum Element in 1D Array
```java
public class MaxFinder {
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] data = {3, 14, 1, 8, 2};
        System.out.println("Maximum: " + findMax(data)); // Output: 14
    }
}
```

### B. Calculate Sum of Main Diagonal in 2D Square Matrix
```java
public class DiagonalSum {
    public static int mainDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i]; // O(N) time complexity
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Main Diagonal Sum: " + mainDiagonalSum(mat)); // Output: 15
    }
}
```

### C. In-Place Array Reversal
```java
import java.util.Arrays;

public class ArrayReverser {
    public static void reverse(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverse(arr);
        System.out.println("Reversed Array: " + Arrays.toString(arr)); // Output: [5, 4, 3, 2, 1]
    }
}
```
