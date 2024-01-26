class Box<T> {
T item;
void setItem(T item) {
this.item = item;
}
T getItem() {
return this.item;
}
}
class BoxImpl {
public static void main(String[] args) {
Box<String> b1 = new Box<>();
Box<Integer> b2 = new Box<>();
b1.setItem("XYZ");
b2.setItem(100);
System.out.println("Box of String: " + b1.getItem());
System.out.println("Box of Integer: " + b2.getItem());
}
}