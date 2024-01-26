class FizzBuzzModel {
// instance variable
private int number;
// setter and getter
public void setNumber(int number) {
this.number = number;
}
public int getNumber() {
return this.number;
}
// Utility method
public String printFizzBuzz() {
String result = "";
if (this.number % 3 == 0) {
result = "Fizz";
}
if (this.number % 5 == 0) {
result += "Buzz";
}
if (result == "") {
result = "" + this.number;
}
return result;
}
}
class FizzBuzz{
public static void main(String[] args) {
FizzBuzzModel b1 = new FizzBuzzModel();
for (int i = 1; i <= 100; i++) {
b1.setNumber(i);
System.out.println("" + b1.printFizzBuzz());
}
}
}
