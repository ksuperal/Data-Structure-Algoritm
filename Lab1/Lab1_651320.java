import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
public class Lab1_651320 {
public static void main(String[] args) {
    q1();
    q2();
    q3();
    q4();
    q5();
}
static void q1() { System.out.println("-q1----");
    List<String> listA1 = new ArrayList<>(Arrays.asList("lilly","tulip","daisy"));
    List<String> listB1 = Arrays.asList("pomeranian", "terrier", "jack", "beagle");
    listA1.addAll(listB1);
    System.out.println(listA1); 
    System.out.println(listB1);
}
static void q2() { System.out.println("-q2----");
    ArrayList<String> listA2 = new ArrayList<>(Arrays.asList("pomeranian", "terrier", "jack", "beagle"));
    List<String> listB2= Arrays.asList("lilly","tulip","daisy");
    ArrayList<String> q1List = null;
    q1List = new ArrayList<>(listA2);
    q1List.addAll(listB2);
    System.out.println(listA2);
    System.out.println(listB2);
    System.out.println(q1List);
}
static void q3() {
    System.out.println("-q3----");
    ArrayList<Dog> q3List = new ArrayList<>();
    q3List.add(new Dog("jack")); 
    q3List.add(new Dog("terrier"));
    System.out.println("snapshot 1 " + q3List);
    add(q3List, new Dog("pomeranian"));
    System.out.println("snapshot 2 " + q3List);
    add(q3List,new Dog("jack"));
    System.out.println("snapshot 3 " + q3List);
    add(q3List,new Dog("beagle"));
    System.out.println(q3List);
}
private static void add(
    ArrayList<Dog> list, Dog d) {
        if(!list.contains(d)){
        list.add(d);
        }
}
static void q4() {
    System.out.println("-q4----");
    ArrayList<String> listA3= new ArrayList<>(Arrays.asList("jack","pomeranian", "terrier", "jack", "beagle"));
    ArrayList<String> listB3 = removeDuplicates(listA3);
    listA3 = removeDuplicates(listA3);
    System.out.println(listA3);
    System.out.println(listB3);
}
private static ArrayList<String> removeDuplicates(List<String> list) {
    HashSet<String> list1= new HashSet<String>(list);
    return new ArrayList<>(list1);
}
static void q5() { System.out.println("-q5----");
    List<String> listA = Arrays.asList("pomeranian", "terrier", "jack", "beagle","pomeranian" , "beagle","jack", "beagle");
    HashMap<String,Integer> q5map = new HashMap<>();
    String key;
    for (int i = 0; i < listA.size(); i++) {
        key = listA.get(i);
        q5map.put(key, ((q5map.get(key) == null) ? 1 : (q5map.get(key)+1)));
    }
    System.out.println(q5map);
}
}
class Dog{
    private String breed;
    private int magicValue;

    public Dog(String n){
        breed = n;
        int v = 0;
        for (int i=0; i<n.length(); i++)
            v += n.charAt(i);
        magicValue = v;
    }

    public boolean equals(Object o){
        if (o instanceof Dog){
            Dog d = (Dog) o;
            return breed.equals(d.breed);
        }
        return false;
    }
    @Override
    public String toString(){
        return breed + "(" + magicValue + ")";
    }
    public String getBreed(){
        return breed;
    }
    public int getMagicValue(){
        return magicValue;
    }
}