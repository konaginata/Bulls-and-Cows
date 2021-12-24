package bullscows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Generator {
    private Generator() {
    }

    static String getNumber(int length, int range) {
        List<Character> list = getAllCharactersList().subList(0, range);
        Collections.shuffle(list);
        return list.stream().limit(length).map(String::valueOf).collect(Collectors.joining());
    }

    public static List<Character> getAllCharactersList() {
        List<Character> list = new ArrayList<>();
        for (char i = '0'; i <= '9'; i++) {
            list.add(i);
        }
        for (char i = 'a'; i <= 'z'; i++) {
            list.add(i);
        }
        return list;
    }
}