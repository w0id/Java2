package course2.homework3;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Contacs {

    private static Map<String, String> contacts = new HashMap<String, String>();

    public static Set<String> get(String value) {
        return contacts.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), value))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public static void add(String name, String phone) {
        contacts.put(phone, name);
    }
}
