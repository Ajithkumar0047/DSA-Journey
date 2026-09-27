# Week 3 - Arrays

## What I Learned

This week, I learned the fundamentals of **arrays** and how they are used to store and process multiple values efficiently.

### 1. What is an Array?

An array is a collection of elements of the same data type stored under a single variable name.

```java
int[] a={10,20,30,40,50};
```

Each element can be accessed using its index.

### 2. Array Indexing

Java arrays use **zero-based indexing**.

```text
Value:  10  20  30  40  50
Index:   0   1   2   3   4
```

The first element is at index `0`, and the last element is at index `a.length-1`.

### 3. Array Traversal

I learned how to visit every element of an array using a loop.

```java
for(int i=0;i<a.length;i++){
    System.out.println(a[i]);
}
```

### 4. Finding the Maximum Element

I learned how to find the largest element by keeping track of the current maximum.

```java
int max=a[0];

for(int i=1;i<a.length;i++){
    if(a[i]>max){
        max=a[i];
    }
}
```

Time Complexity: `O(n)`

Space Complexity: `O(1)`

### 5. Two-Dimensional Arrays

I learned that a two-dimensional array stores data in rows and columns.

```java
int[][] a={
    {1,2,3},
    {4,5,6},
    {7,8,9}
};
```

An element can be accessed using:

```java
a[row][column]
```

### 6. Main Diagonal

For a square matrix, the main diagonal contains elements where the row index and column index are equal.

```java
int sum=0;

for(int i=0;i<a.length;i++){
    sum+=a[i][i];
}
```

Time Complexity: `O(n)`

### 7. In-Place Array Reversal

I learned how to reverse an array without creating another array.

```java
for(int i=0;i<a.length/2;i++){
    int temp=a[i];
    a[i]=a[a.length-1-i];
    a[a.length-1-i]=temp;
}
```

Time Complexity: `O(n)`

Space Complexity: `O(1)`

## Key Concepts Learned

* Arrays
* Indexing
* Array traversal
* One-dimensional arrays
* Two-dimensional arrays
* Matrices
* Main diagonal
* Maximum element
* Swapping
* In-place operations
* Time complexity
* Space complexity

## Learning Resource

### YouTube Video

[Arrays - YouTube](https://www.youtube.com/watch?v=sMI4pXjQBRU)

## Learning Summary

This week helped me understand how arrays work at a fundamental level. I practiced accessing elements, traversing arrays, finding the maximum element, working with matrices, calculating diagonal sums, and reversing arrays in-place. These concepts form an important foundation for solving more advanced DSA problems.
