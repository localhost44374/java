class MyStackV1 {
int[] data;
int size;
int tos = -1;
MyStackV1(int size) {
this.size = size;
data = new int[size];
}
void push(int ele) {
if (tos < (size - 1)) {
data[++tos] = ele;
System.out.println("Element Inserted: " + ele);
} else {
System.out.println("Overflow");
}
}
void pop() {
if (tos >= 0) {
System.out.println("Popped: " + data[tos--]);
} else {
System.out.println("Underflow");
}
}
}
class StackV1 {
public static void main(String[] args) {
MyStackV1 s1 = new MyStackV1(5);
for (int i = 0; i < 6; i++) {
s1.push(i * 10);
}
System.out.print("\n");
s1.pop();
s1.pop();
s1.pop();
s1.pop();
s1.pop();
s1.pop();
}
}
