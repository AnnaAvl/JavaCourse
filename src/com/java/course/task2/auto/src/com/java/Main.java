package com.java;

import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.*;

public class Main {

    public static Map<String, Integer> cntOfCars(List<Car> cars) throws ParseException {
        String rules = "< а, А < б, Б < в, В < г, Г < д, Д < е, Е < ё, Ё < ж, Ж < з, З < и, И < й, Й < к, К < л, Л < м, М < н, Н < о, О < п, П < р, Р < с, С < т, Т < у, У < ф, Ф < х, Х < ц, Ц < ч, Ч < ш, Ш < щ, Щ < ъ, Ъ < ы, Ы < ь, Ь < э, Э < ю, Ю < я, Я";
        RuleBasedCollator col = new RuleBasedCollator(rules);
        Map<String, Integer> mapPassenger = new TreeMap<>(col);
        Map<String, Integer> mapTruck = new TreeMap<>(col);
        for (Car c : cars) {
            if (c.getClass().getName().equals("com.java.PassengerCar")) {
                if (!mapPassenger.containsKey((c.model))) {
                    mapPassenger.put(c.model, 1);
                } else {
                    mapPassenger.put(c.model, mapPassenger.get(c.model) + 1);
                }
            }
            if (c.getClass().getName().equals("com.java.Truck")) {
                if (!mapTruck.containsKey((c.model))) {
                    mapTruck.put(c.model, 1);
                } else {
                    mapTruck.put(c.model, mapTruck.get(c.model) + 1);
                }
            }
        }
        Map<String, Integer> mapCars = new LinkedHashMap<>();
        mapTruck.forEach((a, b) -> mapCars.put("грузовик " + a, b));
        mapPassenger.forEach((a, b) -> mapCars.put("легковушка " + a, b));
        return mapCars;
    }

    public static Map<String, Integer> cntOfTrucks(List<Car> cars) throws ParseException {
        String rules = "< а, А < б, Б < в, В < г, Г < д, Д < е, Е < ё, Ё < ж, Ж < з, З < и, И < й, Й < к, К < л, Л < м, М < н, Н < о, О < п, П < р, Р < с, С < т, Т < у, У < ф, Ф < х, Х < ц, Ц < ч, Ч < ш, Ш < щ, Щ < ъ, Ъ < ы, Ы < ь, Ь < э, Э < ю, Ю < я, Я";
        RuleBasedCollator col = new RuleBasedCollator(rules);
        Map<String, Integer> mapTruckType = new TreeMap<>(col);
        for (Car c : cars) {
            if (c.getClass().getName().equals("com.java.Truck")) {
                Truck t = (Truck) c;
                if (!mapTruckType.containsKey((t.getTruckType() + " " + t.model))) {
                    mapTruckType.put(t.getTruckType() + " " + t.model, 1);
                } else {
                    mapTruckType.put(t.getTruckType() + " " + t.model, mapTruckType.get(t.getTruckType() + " " + t.model) + 1);
                }
            }
        }
        return mapTruckType;
    }

    public static void  printCntOfTrucks(List<Car> cars) throws ParseException {
        Map<String, Integer> mapTruckType = cntOfTrucks(cars);
        String type = null;
        int cnt = 0;
        for (String c : mapTruckType.keySet()) {
            if (type == null) {
                System.out.println(c + " - " + mapTruckType.get(c));
                cnt += mapTruckType.get(c);
                type = c.split(" ")[0];
            } else {
                if (c.split(" ")[0].equals(type)) {
                    cnt+=mapTruckType.get(c);
                    System.out.println(c + " - " + mapTruckType.get(c));
                } else {
                    System.out.println("ИТОГО: " + cnt);
                    System.out.println(c + " - " + mapTruckType.get(c));
                    type = c.split(" ")[0];
                    cnt = mapTruckType.get(c);
                }
            }
        }
        System.out.println("ИТОГО: " + cnt);
    }

    public static void main(String[] args) throws ParseException {
        List<Car> cars;
        try {
            cars = new ArrayList<>() {{
                add(new Truck("МАЗ", 120, 3000, "e", "Тягач", 3, 1000));
                add(new PassengerCar("Лада-веста", 150, 2000, "e", 8));
                add(new PassengerCar("Peugeot", 130, 2000, "e", 5));
                add(new Truck("MAN", 130, 4000, "e", "Самосвал", 3, 1500));
                add(new Truck("ГАЗ", 110, 3000, "e", "Тягач", 2, 500));
                add(new PassengerCar("Лада-веста", 150, 2000, "e", 8));
                add(new Truck("Infinity", 130, 4000, "e", "Автоцистерна", 3, 1500));
                add(new Truck("MAN", 130, 4000, "e", "Автоцистерна", 3, 1500));
                add(new PassengerCar("Peugeot", 130, 2000, "e", 5));
                add(new PassengerCar("Peugeot", 130, 2000, "e", 5));
                add(new Truck("МАЗ", 120, 3000, "e", "Тягач", 3, 1000));
                add(new PassengerCar("Лада-веста", 150, 2000, "e", 8));
                add(new Truck("ГАЗ", 110, 3000, "e", "Автоцистерна", 2, 500));
                add(new Truck("ГАЗ", 110, 3000, "e", "Самосвал", 2, 500));
                add(new Truck("ГАЗ", 110, 3000, "e", "Автоцистерна", 2, 500));
                add(new PassengerCar("Peugeot", 130, 2000, "e", 5));
            }};
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return;
        }

        Map<String, Integer> mapCars = cntOfCars(cars);
        mapCars.forEach((a,b)-> System.out.println(a + " - " + b));

        System.out.print("\n");
        printCntOfTrucks(cars);
    }
}
