package dragon;

import person.Location;
import person.Person;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class DragonBuilder implements Serializable {
    private String nameplus;
    private Long ageplus;
    private Color colorplus;
    private DragonType dragonTypeplus;
    private DragonCharacter dragonCharacterplus;
    private int xplus;
    private Float yplus;
    private String nameKillerPlus;
    private int year;
    private int month;
    private int day;
    private Float height;
    private Double xtown;
    private float ytown;
    private Integer ztown;
    private String nametown;
    private String passportID;
    public static Scanner scanner = new Scanner(System.in);

    public  Dragon plusDragon() {
            Dragon dragonplus = null;
            scanner = new Scanner(System.in);
            String regex = "[0-9]+";
            while (true) {
                System.out.println("Введите имя дракона : ");
                nameplus = scanner.nextLine().trim();
                if (nameplus.isEmpty() || nameplus == null) {
                    System.out.println("Неправильный ввод имени");
                } else {
                    break;
                }
            }
            while (true) {
                System.out.println("Введите его возраст : ");
                String ageplusa = scanner.nextLine().trim();
                if (ageplusa.isEmpty() || ageplusa == null) {
                    System.out.println("Неправильный ввод возраста");
                } else {
                    if (!ageplusa.matches(regex)) {
                        System.out.println("Неправильный ввод возраста");
                    } else {
                        ageplus = Long.parseLong(ageplusa);
                        break;
                    }
                }
            }
            System.out.println("Введите его цвет : RED,GREEN,ORANGE,BROWN -- ");
            switch (scanner.nextLine()) {
                case "RED":
                    colorplus = Color.RED;
                    break;
                case "GREEN":
                    colorplus = Color.GREEN;
                    break;
                case "ORANGE":
                    colorplus = Color.ORANGE;
                    break;
                case "BROWN":
                    colorplus = Color.BROWN;
                    break;
                default:
                    System.out.println("Некорректный ввод цвета! Я задам сам)");
                    colorplus = Color.ORANGE;
            }
            System.out.println("Введите его тип : WATER,UNDERGROUND,AIR,FIRE -- ");
            switch (scanner.nextLine()) {
                case "WATER":
                    dragonTypeplus = DragonType.WATER;
                    break;
                case "UNDERGROUND":
                    dragonTypeplus = DragonType.UNDERGROUND;
                    break;
                case "AIR":
                    dragonTypeplus = DragonType.AIR;
                    break;
                case "FIRE":
                    dragonTypeplus = DragonType.FIRE;
                    break;
                default:
                    System.out.print("Некорректный ввод типа! Я введу сам)");
                    dragonTypeplus = DragonType.FIRE;
            }
            System.out.println("Введите его характер : WISE,GOOD,CHAOTIC_EVIL,FICKLE -- ");
            switch (scanner.nextLine()) {
                case "WISE":
                    dragonCharacterplus = DragonCharacter.WISE;
                    break;
                case "GOOD":
                    dragonCharacterplus = DragonCharacter.GOOD;
                    break;
                case "CHAOTIC_EVIL":
                    dragonCharacterplus = DragonCharacter.CHAOTIC_EVIL;
                    break;
                case "FICKLE":
                    dragonCharacterplus = DragonCharacter.FICKLE;
                    break;
                default:
                    System.out.println("Некорректный ввод характер!Я введу сам)");
                    dragonCharacterplus = DragonCharacter.FICKLE;

            }
            while (true) {
                System.out.println("Введите координату x,в которой находится дракон (0<X<=77): ");
                String xplusa = scanner.nextLine().trim();
                if (xplusa.isEmpty() || xplusa == null) {
                    System.out.println("Неверное значение х");
                } else {
                    if (!xplusa.matches(regex)) {
                        System.out.println("Неверное значение х");
                    } else {
                        xplus = Integer.parseInt(xplusa);
                        if (xplus > 77) {
                            System.out.println("Неверное значение х");
                        } else {
                            break;
                        }
                    }
                }
            }
            while (true) {
                System.out.println("Введите координату y,в которой находится дракон(0<Y<927) : ");
                String yplusa = scanner.nextLine().trim();
                if (yplusa.isEmpty() || yplusa == null) {
                    System.out.println("Неверное значение y");
                } else {
                    if (!yplusa.matches(regex)) {
                        System.out.println("Неверное значение y");
                    } else {
                        yplus = Float.parseFloat(yplusa);
                        if (yplus > 927 || yplus == 0) {
                            System.out.println("Неверное значение y");
                        } else {
                            break;
                        }
                    }
                }
            }
            while (true) {
                System.out.println("Введите имя рыцаря : ");
                nameKillerPlus = scanner.nextLine().trim();
                if (nameKillerPlus == null || nameKillerPlus.isEmpty()) {
                    System.out.println("Неверно введенено имя убийцы");
                } else {
                    break;
                }
            }
            while (true) {
                System.out.println("Введите год его рождения :");
                String yeara = scanner.nextLine().trim();
                if (yeara.isEmpty() || yeara == null) {
                    System.out.println("Неверно введен год");
                } else {
                    if (!yeara.matches(regex)) {
                        System.out.println("Неверно введен год");
                    } else {
                        year = Integer.parseInt(yeara);
                        break;
                    }
                }
            }
            while (true) {
                System.out.println("Введите месяц его рождения(<12) :");
                String montha = scanner.nextLine().trim();
                if (montha.isEmpty() || montha == null) {
                    System.out.println("Неверно введен месяц");
                } else {
                    if (!montha.matches(regex)) {
                        System.out.println("Неверно введен месяц");
                    } else {
                        month = Integer.parseInt(montha);
                        if (month > 12 || month <= 0) {
                            System.out.println("Неверно введен месяц");
                        } else {
                            break;
                        }
                    }
                }
            }
            while (true) {
                System.out.println("Введите день его рождения(<31) : ");
                String daya = scanner.nextLine().trim();
                if (daya.isEmpty() || daya == null) {
                    System.out.println("Неверно введен день");
                } else {
                    if (!daya.matches(regex)) {
                        System.out.println("Неверно введен день");
                    } else {
                        day = Integer.parseInt(daya);
                        if (day > 31 || day <= 0) {
                            System.out.println("Неверно введен день");
                        } else {
                            break;
                        }
                    }
                }
            }
            while (true) {
                System.out.println("Введите рост рыцаря :");
                String heighta = scanner.nextLine().trim();
                if (heighta.isEmpty() || heighta == null) {
                    System.out.println("Неверно введен рост");
                } else {
                    if (!heighta.matches(regex)) {
                        System.out.println("Неверно введен рост");
                    } else {
                        height = Float.parseFloat(heighta);
                        if (height <= 0) {
                            System.out.println("Неверно введен рост");
                        } else {
                            break;
                        }
                    }
                }
            }
            while (true) {
                System.out.println("Введите номер своего паспорта (количесто значений паспорта от 7 до 35): ");
                passportID = scanner.nextLine().trim();
                if (passportID.length() >= 35 || passportID.length() < 7 || passportID == null || passportID.isEmpty()) {
                    System.out.println("Неверно введен ID паспорта");
                } else {
                    break;
                }
            }
            while (true) {
                System.out.println("Введите координату x для города/села, в котором находится рыцарь : ");
                String xtowna = scanner.nextLine().trim();
                if (xtowna.isEmpty() || xtowna == null) {
                    System.out.println("Неверно введена координата х города");
                } else {
                    if (!xtowna.matches(regex)) {
                        System.out.println("Неверно введена координата х города");
                    } else {
                        xtown = Double.parseDouble(xtowna);
                        break;
                    }
                }
            }
            while (true) {
                System.out.println("Введите координату y для города/села, в котором находится рыцарь : ");
                String ytowna = scanner.nextLine().trim();
                if (ytowna.isEmpty() || ytowna == null) {
                    System.out.println("Неверно введена координата y города");
                } else {
                    if (!ytowna.matches(regex)) {
                        System.out.println("Неверно введена координата y города");
                    } else {
                        ytown = Float.parseFloat(ytowna);
                        break;
                    }
                }
            }
            while (true) {
                System.out.println("Введите координату z для города/села, в котором находится рыцарь : ");
                String ztowna = scanner.nextLine().trim();
                if (ztowna.isEmpty() || ztowna == null) {
                    System.out.println("Неверно введена координата z города");
                } else {
                    if (!ztowna.matches(regex)) {
                        System.out.println("Неверно введена координата z города");
                    } else {
                        ztown = Integer.parseInt(ztowna);
                        break;
                    }
                }
            }
            while (true) {
                System.out.println("Введите название города/села, в котором находится рыцарь : ");
                nametown = scanner.next();
                if (nametown == null || nametown.isEmpty()) {
                    System.out.println("Неправильно введено имя города");
                } else {
                    break;
                }
            }
            LocalDate birthday = LocalDate.of(year, month, day);

            Location town = new Location(xtown, ytown, ztown, nametown);

            Person killer = new Person(nameKillerPlus, birthday, height, passportID, town);

            Coordinates coordinates = new Coordinates(xplus, yplus);

            dragonplus = new Dragon(nameplus, coordinates, ageplus, colorplus, dragonTypeplus, dragonCharacterplus, killer);
            return dragonplus;
    }
}