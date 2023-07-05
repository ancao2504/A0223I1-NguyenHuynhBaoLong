package ss10;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class DemoSet {
    public static void main(String[] args) {
        Set<String> strings = new TreeSet<>();
        strings.add("Hai");
        strings.add("Abd");
        strings.add("Hoa");
        strings.add("XYZ");
        strings.add("Hoang");
        strings.add("Hai");
        for (String str: strings) {
            System.out.println(str);
        }
    }
}
