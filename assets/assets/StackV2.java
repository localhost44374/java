import java.util.*;
class MyStackV2<T> {
// A data structure to data
ArrayList<T> data;
int size;
int tos = -1;
// Constructor
MyStackV2(int size) {
this.size = size;
data = new ArrayList<T>(size);
}
// push method
void push(T ele) {
// increment tos
tos++;
if (tos < size) {
// push the element
data.add(tos, ele);
System.out.println("Element Inserted: " + ele);
} else {
System.out.println("Overflow");
}
}
// pop method
T pop() {
tos--;
if (tos >= 0) {
return data.remove(tos);
} else {
System.out.println("Underflow");
return null;
}
}
}
class StackV2 {
public static void main(String[] args) {
MyStackV2<Integer> s1 = new MyStackV2<>(5);
for (int i = 0; i <= 5; i++) {
s1.push(i * 10);
}
System.out.print("\n");
for (int j = 0; j <= 5; j++) {
System.out.println("Popped: " + s1.pop());
}
}
}