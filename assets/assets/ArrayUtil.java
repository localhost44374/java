class ArrayUtils {
int[] data;
// set the data
public void setData(int[] data) {
this.data = data;
}
public int maxEle() {
int max = data[0];
for (int i = 1; i < data.length; i++) {
if (data[i] > max) {
max = data[i];
}
}
return max;
}
public int minEle() {
int min = data[0];
for (int i = 1; i < data.length; i++) {
if (data[i] < min) {
min = data[i];
}
}
return min;
}
public double mean() {
double sum = 0;
for (int i = 0; i < data.length; i++) {
sum += data[i];
}
double mean = sum / data.length;
return mean;
}
public void display() {
System.out.print("Array: [");
for (int i = 0; i < data.length; i++) {
System.out.print(data[i]);
if (i < data.length - 1) {
System.out.print(", ");
}
}
System.out.println("]");
}
}
class ArrayUtil {
public static void main(String[] args) {
int[] arr1 = { 21, 3, 18, 9, 7 };
ArrayUtils a1 = new ArrayUtils();
a1.setData(arr1);
a1.display();
System.out.println("Max of Array: " + a1.maxEle());
System.out.println("Min of Array: " + a1.minEle());
System.out.println("Mean of Array: " + a1.mean());
}
}