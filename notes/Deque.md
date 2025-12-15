# Java Deque Interface - Quick Notes

## What is Deque?
- **Double-Ended Queue** (pronounced "deck")
- Extends `Queue` interface from `java.util` package
- Allows insertion/removal of elements from **both ends**
- Can be used as **Stack (LIFO)** or **Queue (FIFO)**

## Common Implementations
- **ArrayDeque** - Resizable array, fast, not thread-safe (most common)
- **LinkedList** - Doubly-linked list, allows nulls
- **ConcurrentLinkedDeque** - Thread-safe version

## Key Characteristics
- No fixed capacity limits (in most implementations)
- Most implementations **don't allow null** elements (ArrayDeque throws `NullPointerException`)
- Not thread-safe by default
- Dynamically grows as needed

---

## Essential Operations Summary

### Two Types of Methods:
1. **Throws Exception** if operation fails
2. **Returns Special Value** (`false` or `null`) if operation fails

| Operation | First Element (Head) | Last Element (Tail) |
|-----------|---------------------|---------------------|
| **Insert** | `addFirst(e)` / `offerFirst(e)` | `addLast(e)` / `offerLast(e)` |
| **Remove** | `removeFirst()` / `pollFirst()` | `removeLast()` / `pollLast()` |
| **Examine** | `getFirst()` / `peekFirst()` | `getLast()` / `peekLast()` |

---

## Important Methods

### Adding Elements
```java
addFirst(E e)    // Add at head, throws exception if fails
addLast(E e)     // Add at tail, throws exception if fails
offerFirst(E e)  // Add at head, returns false if fails
offerLast(E e)   // Add at tail, returns false if fails
add(E e)         // Same as addLast()
offer(E e)       // Same as offerLast()
```

### Removing Elements
```java
removeFirst()    // Remove from head, throws exception if empty
removeLast()     // Remove from tail, throws exception if empty
pollFirst()      // Remove from head, returns null if empty
pollLast()       // Remove from tail, returns null if empty
poll()           // Same as pollFirst()
remove()         // Same as removeFirst()
```

### Peeking (without removing)
```java
getFirst()       // Get head, throws exception if empty
getLast()        // Get tail, throws exception if empty
peekFirst()      // Get head, returns null if empty
peekLast()       // Get tail, returns null if empty
peek()           // Same as peekFirst()
element()        // Same as getFirst()
```

### Stack Operations
```java
push(E e)        // Add at head (same as addFirst)
pop()            // Remove from head (same as removeFirst)
```

### Other Methods
```java
size()           // Number of elements
contains(Object o) // Check if element exists
iterator()       // Forward iterator (head to tail)
descendingIterator() // Reverse iterator (tail to head)
removeFirstOccurrence(Object o)
removeLastOccurrence(Object o)
```

---

## Queue vs Stack Equivalents

### As a Queue (FIFO)
| Queue Method | Deque Equivalent |
|--------------|------------------|
| `add(e)` | `addLast(e)` |
| `offer(e)` | `offerLast(e)` |
| `remove()` | `removeFirst()` |
| `poll()` | `pollFirst()` |
| `element()` | `getFirst()` |
| `peek()` | `peekFirst()` |

### As a Stack (LIFO)
| Stack Method | Deque Equivalent |
|--------------|------------------|
| `push(e)` | `addFirst(e)` |
| `pop()` | `removeFirst()` |
| `peek()` | `peekFirst()` |

---

## Usage Examples

```java
// Creating a Deque
Deque<String> deque = new ArrayDeque<>();

// Adding elements
deque.addFirst("A");      // [A]
deque.addLast("B");       // [A, B]
deque.offerFirst("C");    // [C, A, B]

// Removing elements
String first = deque.removeFirst();  // C, deque = [A, B]
String last = deque.pollLast();      // B, deque = [A]

// Peeking
String head = deque.peekFirst();     // A (not removed)

// Iterating
for (String s : deque) {
    System.out.println(s);
}

// Reverse iteration
Iterator<String> it = deque.descendingIterator();
while (it.hasNext()) {
    System.out.println(it.next());
}
```

---

## Key Points to Remember

1. **Use `offer` methods with capacity-restricted deques** (safer than `add`)
2. **Use `poll/peek` methods** when deque might be empty (avoids exceptions)
3. **ArrayDeque is preferred over LinkedList** for deque operations (better performance)
4. **Don't use `null` elements** - many implementations prohibit it
5. **Deque > Stack class** - Deque is preferred for stack operations
6. **Not thread-safe** - Use `ConcurrentLinkedDeque` for concurrent access
7. **`descendingIterator()`** allows reverse traversal

---

## Common Use Cases
- **Undo/Redo functionality** (stack operations)
- **Browser history** (back/forward)
- **Sliding window problems** (remove from both ends)
- **BFS/DFS in graphs** (queue/stack operations)
- **Job scheduling** (priority at both ends)
