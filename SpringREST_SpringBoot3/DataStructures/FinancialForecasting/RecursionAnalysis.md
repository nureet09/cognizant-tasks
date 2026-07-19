# Exercise 7: Financial Forecasting via Recursion

## 1. Understanding Recursive Algorithms
Recursion is a programming technique where a method solves a problem by calling a smaller instance of itself until it reaches a defined **base case**. 

It simplifies complex problems by breaking down global multi-year computation dependencies into simple, self-similar steps. For example, predicting a value for year $t$ becomes trivial if you assume you already know the value for year $t-1$.

---

## 2. Time Complexity Analysis
* **Time Complexity:** $O(t)$, where $t$ is the number of years. Since the method decreases the year parameter by exactly $1$ on each call, it creates a single call stack line of depth $t$.
* **Space Complexity:** $O(t)$ due to the recursive call stack space accumulating memory footprints on the host system until hitting the base case.

---

## 3. Optimization Techniques
If a model scales up to handle varying cyclic growth rates over intervals, redundant branches appear within the execution tree. Two primary methods resolve excessive computation:

1. **Memoization (Top-Down):** Storing intermediate recursive step evaluations inside a data structure (like a `HashMap`) so that repeat time-interval indices are immediately retrieved rather than recalculated.
2. **Iterative Transformation (Bottom-Up):** Converting the method into a basic standard `for` loop iteration. This transitions space requirements from $O(t)$ down to $O(1)$ by eliminating call stack frames.