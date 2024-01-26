interface Calculator {
double operation(double a, double b);
}
class CalculatorImpl {
public static void main(String[] args) {
// Create an object of interface
Calculator Add = (double a, double b) -> a + b;
Calculator Subtract = (a, b) -> a - b;
Calculator Multiply = (a, b) -> a * b;
Calculator Divide = (double a, double b) -> a / b;
Calculator Modulo = (double a, double b) -> {
return a % b;
};
// Invoke the method
System.out.println("Addition: " + Add.operation(40.0, 8.0));
System.out.println("Subtraction: " + Subtract.operation(60, 8));
System.out.println("Multiplication: " + Multiply.operation(10.0, 6.0));
System.out.println("Division: " + Divide.operation(50, 10));
System.out.println("Modulo: " + Modulo.operation(30.0, 7.0));
}
}