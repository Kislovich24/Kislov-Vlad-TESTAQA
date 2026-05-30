package Telephone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory {
    // Карта, где ключ — Фамилия (String), а значение — список телефонов (List<String>)
    private Map<String, List<String>> directory = new HashMap<>();

    // Метод добавления записи в справочник
    public void add(String surname, String phoneNumber) {
        // Если такой фамилии еще нет, создаем для нее новый пустой список номеров
        if (!directory.containsKey(surname)) {
            directory.put(surname, new ArrayList<>());
        }
        // Добавляем номер телефона в список этой фамилии
        directory.get(surname).add(phoneNumber);
    }

    // Метод поиска номеров по фамилии
    public List<String> get(String surname) {
        // Если фамилия найдена, возвращаем список номеров. Если нет — возвращаем пустой список.
        return directory.getOrDefault(surname, new ArrayList<>());
    }
}