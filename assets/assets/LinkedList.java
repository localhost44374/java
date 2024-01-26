class Node<T> {
T data;
Node<T> next;
Node(T data) {
this.data = data;
this.next = null;
}
}
class MyLinkedList<T> {
// data members
int size = 0;
Node<T> head;
MyLinkedList() {
head = null;
}
int getSize() {
return size;
}
// a method to add a node at the end
void add(T data) {
Node<T> temp = new Node<T>(data);
if (head == null) // Check whether first node
{
head = temp;
System.out.println("First Node added");
} else // To add any other node in the list
{
// start at the head
Node<T> x = head;
// traverse to the end
while (x.next != null) {
x = x.next;
}
x.next = temp;
System.out.println("Next Node added");
}
size++;
}
}
class LinkedList {
public static void main(String[] args) {
MyLinkedList<Integer> m1 = new MyLinkedList<>();
m1.add(1);
m1.add(2);
System.out.println("Size: " + m1.getSize());
}
}