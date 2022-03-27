package course2.homework3;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Words {

    public static void main(String[] args) {
        List<String> words = new ArrayList<String>();
        words.add("worm");
        words.add("grind");
        words.add("able");
        words.add("pilot");
        words.add("exempt");
        words.add("grudge");
        words.add("reform");
        words.add("treat");
        words.add("fine");
        words.add("mercy");
        words.add("pier");
        words.add("clerk");
        words.add("fine");
        words.add("rent");
        words.add("exempt");
        words.add("treat");
        words.add("bench");
        words.add("bullet");
        words.add("choice");
        words.add("pilot");
        System.out.println(words);
        Set<String> unique = new HashSet<>(words);
        System.out.println(unique);
        System.out.println(countWords(words));
    }

    public static Map<String, Long> countWords(List<String> inputList) {
        return inputList.stream().collect(Collectors.toMap(Function.identity(), x -> 1L, Long::sum));
    }
}