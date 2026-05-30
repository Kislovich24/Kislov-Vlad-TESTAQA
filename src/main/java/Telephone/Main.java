package Telephone;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== ТЕСТ ТЕЛЕФОННОГО СПРАВОЧНИКА ===");


        PhoneDirectory phoneBook = new PhoneDirectory();

        // Наполняем справочник данными
        phoneBook.add("Иванов", "+7-999-111-22-33");
        phoneBook.add("Петров", "+7-999-444-55-66");
        phoneBook.add("Иванов", "+7-900-777-88-99"); // Второй номер для Иванова
        phoneBook.add("Сидоров", "+7-912-000-11-22");


        String searchSurname = "Иванов";
        List<String> ivanovPhones = phoneBook.get(searchSurname);
        System.out.println("Номера телефонов для фамилии " + searchSurname + ": " + ivanovPhones);

        System.out.println("Номера телефонов для фамилии Петров: " + phoneBook.get("Петров"));

        System.out.println("Номера телефонов для фамилии Смирнов: " + phoneBook.get("Смирнов"));
    }
}