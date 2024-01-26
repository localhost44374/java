import java.util.*;
class Collection {
 public static void main(String[] args) {
 // List example
 List<String> l1 = new ArrayList<>();
 l1.add("Java");
 l1.add("Python");
 l1.add("C++");
 l1.add("JavaScript");
 System.out.println("List Example:");
 for (String i : l1) {
 System.out.println(i);
 }
 System.out.println("\n");
 // Map example
 Map<String, Integer> m1 = new HashMap<>();
 m1.put("Akshay", 20);
 m1.put("Sarvesh", 16);
 m1.put("Aditi", 12);
 System.out.println("Map Example:");
 for (Map.Entry<String, Integer> j : m1.entrySet()) {
 System.out.println(j.getKey() + ": " + j.getValue());
}
 System.out.println("\n");
 // Set example
 Set<String> s1 = new HashSet<>();
 s1.add("Akshay");
 s1.add("Sarvesh");
 s1.add("Aditi");
 System.out.println("Set Example:");
 for (String k : s1) {
 System.out.println(k);
 }
 }
}
