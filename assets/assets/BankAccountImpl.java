class BankAccount {
// Instance Variables
private String acName;
private int acNo;
private double acBalance;
// Setters and Getters
public void setAcName(String acName) {
this.acName = acName;
}
public void setAcNo(int acNo) {
this.acNo = acNo;
}
public void setAcBalance(double acBalance) {
this.acBalance = acBalance;
}
public String getAcName() {
return this.acName;
}
public int getAcNo() {
return this.acNo;
}
public double getAcBalance() {
return this.acBalance;
}
// Utility Methods
public void deposit(double amount) {
this.acBalance += amount;
}
boolean withdraw(double amount) {
if (this.acBalance - amount >= 0) {
// Withdrawl is Possible
this.acBalance -= amount;
return true;
} else {
return false;
}
}
}
class BankAccountImpl {
public static void main(String[] args) {
BankAccount b1 = new BankAccount();
b1.setAcName("Jaimik");
b1.setAcNo(1422);
b1.setAcBalance(5000);
System.out.println("Ac Name: " + b1.getAcName());
System.out.println("Ac Number: " + b1.getAcNo());
System.out.println("Ac Balance: " + b1.getAcBalance());
b1.deposit(500);
System.out.println("\nAccount Balance after Deposit: " + 
b1.getAcBalance());
if (b1.withdraw(200)) {
System.out.println("Successful!!");
System.out.println("Updated Balance: " + b1.getAcBalance());
} else {
System.out.println("\nInsufficient Funds!!");
System.out.println("Current Account Balance: " + b1.getAcBalance());
}
}
}
