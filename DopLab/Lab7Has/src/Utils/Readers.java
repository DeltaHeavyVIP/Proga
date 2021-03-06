package Utils;

import Classes.OrganizationType;

import java.util.Arrays;
import java.util.Scanner;

public class Readers {
    public static boolean doesThisOrganizationTypeExist(String organizationType) {
        return Arrays.stream(OrganizationType.values()).anyMatch(organizationType1 -> organizationType1.name().equals(organizationType));
    }

    public static OrganizationType readType(Scanner sc) {
        System.out.println("Выберите тип организации из предложенных: " + Arrays.asList(OrganizationType.values()) + ".");
        String type = sc.nextLine().trim();
        if (!doesThisOrganizationTypeExist(type) || type.equals("")) {
            while (!doesThisOrganizationTypeExist(type)) {
                System.out.println("Попробуйте ещё раз.");
                type = sc.nextLine().trim();
                doesThisOrganizationTypeExist(type);
            }
        }
        return Enum.valueOf(OrganizationType.class, type);
    }

    public static String readName(Scanner sc) {
        System.out.println("Введите имя организации.");
        String name = sc.nextLine().trim();
        while (name.equals("")) {
            System.out.println("Имя не может быть пустым. Попробуйте ещё раз ");
            name = sc.nextLine().trim();
        }
        return name;
    }

    public static Double readCoordinatesX(Scanner sc) {
        System.out.println("Введите координату X организации (не должна превышать 643).");
        String cX_s;
        Double cX;
        while (true) {
            try {
                cX_s = sc.nextLine().trim();
                cX = Double.parseDouble(cX_s);
                if (cX <= 643) {
                    return cX;
                } else {
                    System.out.println("Значение не должно превышать 643. Попробуйте ещё раз.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введённое значение не является числом. Попробуйте еще раз.");
            }
        }
    }

    public static double readCoordinatesY(Scanner sc) {
        System.out.println("Введите координату Y организации.");
        String cY_s;
        Double cY;
        while (true) {
            cY_s = sc.nextLine().trim();
            try {
                cY = Double.parseDouble(cY_s);
                return cY;
            } catch (NumberFormatException e) {
                System.out.println("Введённое значение не является числом. Попробуйте еще раз.");
            }
        }
    }

    public static Double readAnnualTurnover(Scanner sc) {
        System.out.println("Введите годовой оборот компании (должен быть больше 0).");
        String annualTurnover_s;
        Double annualTurnover;
        while (true) {
            annualTurnover_s = sc.nextLine().trim();
            try {
                annualTurnover = Double.parseDouble(annualTurnover_s);
                if (annualTurnover > 0) {
                    return annualTurnover;
                } else {
                    System.out.println("Значение должно быть больше 0. Попробуйте ещё раз.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введённое значение не является числом. Попробуйте еще раз.");
            }
        }
    }

    public static String readStreet(Scanner sc) {
        System.out.println("Введите адрес.");
        String adress = sc.nextLine().trim();
        if (adress.length() > 136) {
            while (adress.length() > 136) {
                System.out.println("Слишком длинный адрес. Попробуйте ещё раз.");
                adress = sc.nextLine().trim();
            }
        }
        return adress;
    }

    public static String readZipCode(Scanner sc) {
        System.out.println("Введите почтовый индекс.");
        String zipCode = sc.nextLine().trim();
        if (zipCode.length() > 26) {
            while (zipCode.length() > 26) {
                System.out.println("Слишком длинный почтовый индекс. Попробуйте ещё раз.");
                zipCode = sc.nextLine().trim();
            }
        }
        if (zipCode.equals("")) {
            while (zipCode.equals("")) {
                System.out.println("Индекс не может быть пустым. Попробуйте ещё раз.");
                zipCode = sc.nextLine().trim();
            }
        }
        return zipCode;
    }

    public static float readLocation(String coordinate, Scanner sc) {
        System.out.println("Введите координату " + coordinate + " города.");
        String l_s;
        Float l;
        while (true) {
            l_s = sc.nextLine().trim();
            try {
                l = Float.parseFloat(l_s);
                return l;
            } catch (NumberFormatException e) {
                System.out.println("Введённое значение не является числом. Попробуйте еще раз.");
            }
        }
    }

    public static String readTownName(Scanner sc) {
        System.out.println("Введите название города.");
        String name = sc.nextLine().trim();
        if (name.equals("")) {
            while (name.equals("")) {
                System.out.println("Имя не может быть пустым. Попробуйте ещё раз.");
                name = sc.nextLine().trim();
            }
        }
        return name;
    }
}