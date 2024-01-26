import java.util.*;
class CharacterFrequency {
public static void printFreq(String s) {
Map<Character, Integer> m1 = new HashMap<>();
for (int i = 0; i < s.length(); i++) {
char c = s.charAt(i);
if (m1.containsKey(c)) {
int val = m1.get(c);
val = val + 1;
m1.put(c, val);
} else {
m1.put(c, 1);
}
}
System.out.println(m1);
}
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print("Enter String: ");
String s = sc.nextLine();
printFreq(s);
}
}