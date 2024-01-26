class Pair<K, V> {
K key;
V value;
K getKey() {
return this.key;
}
V getValue() {
return this.value;
}
void setKey(K key) {
this.key = key;
}
void setValue(V value) {
this.value = value;
}
void print() {
System.out.println("\nKey: " + this.key + "\nValue: " + this.value);
}
}
class PairImpl {
public static void main(String[] args){
Pair<Integer, String> p1 = new Pair<>();
p1.setKey(101);
p1.setValue("Akshay");
Pair<Integer, String> p2 = new Pair<>();
p2.setKey(102);
p2.setValue("Sarvesh");
p1.print();
p2.print();
}
} 
