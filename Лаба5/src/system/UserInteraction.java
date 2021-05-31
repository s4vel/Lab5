package system;

import exeptions.*;
import collection_filler.*;

import java.io.FileNotFoundException;
import java.text.*;

import comands.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

/**
 * Class witch interacts with user and script inputs.
 */
public class UserInteraction {


    /**
     * Gets Worker fields from user inputs.
     *
     * @param scanner scanner of user inputs.
     * @param id      ID of new worker.
     * @return new Worker element.
     */
    public static Worker getElement(Scanner scanner, int id) {
        Worker worker = new Worker();
        worker.setCreationDate(LocalDate.now());
        worker.setId(id);
        while (true) {
            System.out.print("Введите имя: ");
            try {
                String name = scanner.nextLine();
                if (name == "") throw new NotNullExeption();
                worker.setName(name);
                break;
            } catch (NotNullExeption e) {
                System.out.println("Это поле должео быть заполнено");
            }
        }

        Coordinates coordinates = new Coordinates();

        while (true) {
            System.out.print("Введите координату X: ");
            try {
                String strX = scanner.nextLine();
                Long x = Long.parseLong(strX);
                if (x <= -327) throw new LowerThanShouldExeption();
                coordinates.setX(x);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Необходимо ввести целое число");
            } catch (LowerThanShouldExeption e) {
                System.out.println("Координата x должна быть больше -327");
            }
        }

        while (true) {
            System.out.print("Введите координату Y: ");
            try {
                String strY = scanner.nextLine();
                coordinates.setY(Long.parseLong(strY));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Необходимо ввести целое число");
            }
        }
        worker.setCoordinates(coordinates);


        while (true) {
            System.out.print("Введите зарплату: ");
            try {
                String strSalary = scanner.nextLine();
                float salary = Float.parseFloat(strSalary);
                if (salary <= 0) throw new LowerThanShouldExeption();
                worker.setSalary(salary);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Необходимо ввести целое число");
            } catch (LowerThanShouldExeption e) {
                System.out.println("Зарплаьа должна быть больше 0");
            }
        }

        while (true) {
            System.out.print("Введите дату начала в формате [год]/[месяц]/[день]: ");
            try {
                String stringStartDate = scanner.nextLine();
                DateFormat dateFormat = new SimpleDateFormat("y/M/d");
                Date date = dateFormat.parse(stringStartDate);
                worker.setStartDate(date);
                break;

            } catch (ParseException e) {
                System.out.println("необходимо ввести дату в формате [год]/[месяц]/[день] :");
            }
        }

        while (true) {
            System.out.print("Введите время конца в формате [год]-[месяц]-[день]T[часы]:[минуты]:[секунды] :");
            try {
                String stringEndDate = scanner.nextLine();
                LocalDateTime endDate = LocalDateTime.parse(stringEndDate);
                worker.setEndDate(endDate);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("необходимо ввести дату в формате [год]-[месяц]-[день]T[часы]:[минуты]:[секунды] :");
            }
        }

        boolean t = true;
        while (t) {
            System.out.print("Введите должность из списка " + Position.getString());
            String stringPosition = scanner.nextLine().trim();
            switch (stringPosition) {
                case ("LABORER"): {
                    worker.setPosition(Position.LABORER);
                    t = false;
                    break;
                }
                case ("ENGINEER"): {
                    worker.setPosition(Position.ENGINEER);
                    t = false;
                    break;
                }
                case ("HEAD_OF_DIVISION"): {
                    worker.setPosition(Position.HEAD_OF_DIVISION);
                    t = false;
                    break;
                }
                case ("HEAD_OF_DEPARTMENT"): {
                    worker.setPosition(Position.HEAD_OF_DEPARTMENT);
                    t = false;
                    break;
                }
                case ("DEVELOPER"): {
                    worker.setPosition(Position.DEVELOPER);
                    t = false;
                    break;
                }

                default: {
                    System.out.println("Введите название из списка!");
                }

            }
        }

        Organization organization = new Organization();

        while (true) {
            try {
                System.out.print("Введите название организации: ");
                String orgName = scanner.nextLine();
                if (orgName == "") throw new NotNullExeption();
                if (orgName.length() > 1807) throw new ToLongExeption();
                organization.setFullName(orgName);
                break;
            } catch (NotNullExeption e) {
                System.out.println("Это поле должео быть заполнено");

            } catch (ToLongExeption e) {
                System.out.println("В названии оргонизации должно быть меньше 1807");
            }
        }


        t = true;
        while (t) {
            System.out.print("Введите тиа организации из списка " + OrganizationType.getString());
            String stringOrganizationType = scanner.nextLine().trim();
            switch (stringOrganizationType) {
                case ("COMMERCIAL"): {
                    organization.setType(OrganizationType.COMMERCIAL);
                    t = false;
                    break;
                }
                case ("PUBLIC"): {
                    organization.setType(OrganizationType.PUBLIC);
                    t = false;
                    break;
                }
                case ("GOVERNMENT"): {
                    organization.setType(OrganizationType.GOVERNMENT);
                    t = false;
                    break;
                }
                case ("TRUST"): {
                    organization.setType(OrganizationType.TRUST);
                    t = false;
                    break;
                }
                default: {
                    System.out.println("Введите тип из списка!");
                }
            }

        }

        Address address = new Address();
        while (true) {
            try {
                System.out.print("Укажите улицу: ");
                String street = scanner.nextLine();
                if (street == "") throw new NotNullExeption();
                address.setStreet(street);
                break;
            } catch (NotNullExeption e) {
                System.out.println("Это поле должео быть заполнено");
            }
        }

        while (true) {
            System.out.print("Укажите индекс: ");
            try {
                String zip = scanner.nextLine();
                if (zip == "") throw new NotNullExeption();
                address.setZipCode(zip);
                break;
            } catch (NotNullExeption e) {
                System.out.println("Это поле должео быть заполнено");
            }
        }


        organization.setOfficialAddress(address);

        worker.setOrganization(organization);

        return worker;
    }

    /**
     * Gets Worker fields from user script.
     *
     * @param scanner scanner of script inputs.
     * @param id      ID of new worker.
     * @return new Worker element.
     * @throws ElementAddingInScriptExeption
     */
    public static Worker getElementScript(Scanner scanner, int id) throws ElementAddingInScriptExeption {
        Worker worker = new Worker();
        worker.setCreationDate(LocalDate.now());
        worker.setId(id);


        while (true) {

            try {
                String name = scanner.nextLine();
                if (name == "") throw new NotNullExeption();
                worker.setName(name);
                break;
            } catch (NotNullExeption e) {
                System.out.println("Поле имени должео быть заполнено");
                throw new ElementAddingInScriptExeption();
            }
        }

        Coordinates coordinates = new Coordinates();

        while (true) {

            try {
                String strX = scanner.nextLine();
                Long x = Long.parseLong(strX);
                if (x <= -327) throw new LowerThanShouldExeption();
                coordinates.setX(x);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Координата X должна быть целым числом");
                throw new ElementAddingInScriptExeption();
            } catch (LowerThanShouldExeption e) {
                System.out.println("Координата X должна быть больше -327");
                throw new ElementAddingInScriptExeption();
            }
        }

        while (true) {

            try {
                String strY = scanner.nextLine();
                coordinates.setY(Long.parseLong(strY));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Координата Y должна быть целым числом");
                throw new ElementAddingInScriptExeption();
            }
        }
        worker.setCoordinates(coordinates);


        while (true) {

            try {
                String strSalary = scanner.nextLine();
                float salary = Float.parseFloat(strSalary);
                if (salary <= 0) throw new LowerThanShouldExeption();
                worker.setSalary(salary);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Зарлата должа быть целым числом");
                throw new ElementAddingInScriptExeption();
            } catch (LowerThanShouldExeption e) {
                System.out.println("Зарплаьа должна быть больше 0");
                throw new ElementAddingInScriptExeption();
            }
        }

        while (true) {

            try {
                String stringStartDate = scanner.nextLine();
                DateFormat dateFormat = new SimpleDateFormat("y/M/d");
                Date date = dateFormat.parse(stringStartDate);
                worker.setStartDate(date);
                break;

            } catch (ParseException e) {
                System.out.println("Дата должна быть в формате [год]/[месяц]/[день] :");
                throw new ElementAddingInScriptExeption();
            }
        }

        while (true) {

            try {
                String stringEndDate = scanner.nextLine();
                LocalDateTime endDate = LocalDateTime.parse(stringEndDate);
                worker.setEndDate(endDate);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Дату должна быть в формате [год]-[месяц]-[день]T[часы]:[минуты]:[секунды] :");
                throw new ElementAddingInScriptExeption();
            }
        }

        boolean t = true;
        while (t) {

            String stringPosition = scanner.nextLine().trim();
            switch (stringPosition) {
                case ("LABORER"): {
                    worker.setPosition(Position.LABORER);
                    t = false;
                    break;
                }
                case ("ENGINEER"): {
                    worker.setPosition(Position.ENGINEER);
                    t = false;
                    break;
                }
                case ("HEAD_OF_DIVISION"): {
                    worker.setPosition(Position.HEAD_OF_DIVISION);
                    t = false;
                    break;
                }
                case ("HEAD_OF_DEPARTMENT"): {
                    worker.setPosition(Position.HEAD_OF_DEPARTMENT);
                    t = false;
                    break;
                }
                case ("DEVELOPER"): {
                    worker.setPosition(Position.DEVELOPER);
                    t = false;
                    break;
                }

                default: {
                    System.out.println("Введина должность не из списка!");
                    throw new ElementAddingInScriptExeption();
                }

            }
        }

        Organization organization = new Organization();

        while (true) {
            try {

                String orgName = scanner.nextLine();
                if (orgName == "") throw new NotNullExeption();
                if (orgName.length() > 1807) throw new ToLongExeption();
                organization.setFullName(orgName);
                break;
            } catch (NotNullExeption e) {
                System.out.println("У организации должео быть заполнено имя!");
                throw new ElementAddingInScriptExeption();

            } catch (ToLongExeption e) {
                System.out.println("В названии оргонизации должно быть меньше 1807 символов");
                throw new ElementAddingInScriptExeption();
            }
        }


        t = true;
        while (t) {

            String stringOrganizationType = scanner.nextLine().trim();
            switch (stringOrganizationType) {
                case ("COMMERCIAL"): {
                    organization.setType(OrganizationType.COMMERCIAL);
                    t = false;
                    break;
                }
                case ("PUBLIC"): {
                    organization.setType(OrganizationType.PUBLIC);
                    t = false;
                    break;
                }
                case ("GOVERNMENT"): {
                    organization.setType(OrganizationType.GOVERNMENT);
                    t = false;
                    break;
                }
                case ("TRUST"): {
                    organization.setType(OrganizationType.TRUST);
                    t = false;
                    break;
                }
                default: {
                    System.out.println("Введен тип организации не из списка!");
                    throw new ElementAddingInScriptExeption();
                }
            }

        }

        Address address = new Address();
        while (true) {
            try {

                String street = scanner.nextLine();
                if (street == "") throw new NotNullExeption();
                address.setStreet(street);
                break;
            } catch (NotNullExeption e) {
                System.out.println("Название улицы должно быть заполнено");
                throw new ElementAddingInScriptExeption();
            }
        }

        while (true) {

            try {
                String zip = scanner.nextLine();
                if (zip == "") throw new NotNullExeption();
                address.setZipCode(zip);
                break;
            } catch (NotNullExeption e) {
                System.out.println("Индекс должен быть заполнен");
                throw new ElementAddingInScriptExeption();
            }
        }


        organization.setOfficialAddress(address);

        worker.setOrganization(organization);

        return worker;
    }


    /**
     * Gets command from user inputs and starts it's execution.
     *
     * @param scanner    scanner of user inputs.
     * @param collection collection with witch user will operate.
     * @param fillname   name of file in witch collection is stored.
     */
    public static void getComand(Scanner scanner, Coll collection, String fillname) {

        History history = new History();
        boolean tr = true;
        while (tr) {
            String strCom[] = scanner.nextLine().trim().split(" ", 2);
            String comand = strCom[0];
            switch (comand) {

                case ("help"): {
                    history.add(comand);
                    Help.helpcomand();
                    break;
                }

                case ("info"): {
                    history.add(comand);
                    Info.infoComand(collection);
                    break;
                }

                case ("show"): {
                    history.add(comand);
                    Show.show(collection);
                    break;
                }

                case ("add"): {
                    history.add(comand);
                    try {
                        Add.addElement(collection, scanner, false);
                    } catch (ElementAddingInScriptExeption e) {

                    }
                    break;
                }

                case ("update"): {

                    try {
                        history.add(comand);
                        int id = Integer.parseInt(strCom[1].trim());
                        try {
                            UpdateID.updateID(collection, id, scanner, false);
                        } catch (ElementAddingInScriptExeption e) {

                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Необходимо ввести целое число");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("В одной строке с этой командой должнен быть введен ID ");
                    }

                    break;
                }

                case ("remove_by_id"): {
                    try {
                        history.add(comand);
                        int id = Integer.parseInt(strCom[1].trim());
                        ;
                        RemoveByID.removeByID(collection, id);
                    } catch (NumberFormatException e) {
                        System.out.println("Необходимо ввести целое число");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("В одной строке с этой командой должнен быть введен ID ");
                    }
                    break;
                }

                case ("clear"): {
                    history.add(comand);
                    Clear.clear(collection);
                    break;
                }


                case ("save"): {
                    history.add(comand);
                    Save.save(collection, fillname);
                    break;
                }

                case ("execute_script"): {
                    history.add(comand);
                    try {
                        String f = strCom[1];
                        System.out.println("Исполняю скрипт из файла " + f);
                        tr = ExecuteScript.executeScript(f, collection, fillname);
                        System.out.println("Исполнение скрипта из файла " + f + " завершено");
                    } catch (ScriptReqursionExeption e) {
                        System.out.println("Скрипт не может быть рекурсивным!");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("В одной строке с этой командой должно быть введено название файла со скриптом!");
                    } catch (ScriptErrorExeption e) {
                        System.out.println("При исполнении скрипта произошла ошибка!");
                    }
                    ExecuteScript.deleteScripts();
                    break;
                }

                case ("exit"): {
                    history.add(comand);
                    scanner.close();
                    tr = false;
                    break;
                }

                case ("head"): {
                    history.add(comand);
                    Head.head(collection);
                    break;
                }

                case ("remove_lower"): {
                    history.add(comand);
                    try {
                        RemoveLower.RemoveLower(collection, scanner, false);
                    } catch (ElementAddingInScriptExeption e) {

                    }
                    break;
                }

                case ("history"): {
                    String str = history.getStory();
                    history.add(comand);
                    System.out.print(str);
                    break;
                }

                case ("sum_of_salary"): {
                    history.add(comand);
                    SumOfSalary.sumOfSalary(collection);
                    break;
                }

                case ("min_by_id"): {
                    history.add(comand);
                    MinByID.minById(collection);
                    break;
                }

                case ("count_greater_than_position"): {
                    history.add(comand);
                    boolean t = true;
                    Position position = Position.LABORER;
                    while (t) {
                        System.out.println("Введите позицию из списка: " + Position.getString());
                        String stringPosition = scanner.nextLine();
                        switch (stringPosition) {
                            case ("LABORER"): {
                                position = Position.LABORER;
                                t = false;
                                break;
                            }
                            case ("ENGINEER"): {
                                position = Position.ENGINEER;
                                t = false;
                                break;
                            }
                            case ("HEAD_OF_DIVISION"): {
                                position = Position.HEAD_OF_DIVISION;
                                t = false;
                                break;
                            }
                            case ("HEAD_OF_DEPARTMENT"): {
                                position = Position.HEAD_OF_DEPARTMENT;
                                t = false;
                                break;
                            }
                            case ("DEVELOPER"): {
                                position = Position.DEVELOPER;
                                t = false;
                                break;
                            }
                            default:
                                System.out.println("Пзиция должна быть из списка!");
                        }
                    }
                    try {
                        CountGreaterThanPosition.countGreaterThanPosition(collection, position);
                    } catch (CollectioIsEmptyExeption e) {
                        System.out.println("Коллекция пуста!");
                    }

                    break;
                }

                default:
                    System.out.println("такой команды не существует, используйте команду help для получения инормации о существующих командах");
            }

        }


    }

    /**
     * Gets command from user script and starts it's execution.
     *
     * @param scanner    scanner of script inputs.
     * @param collection collection with witch script will operate.
     * @param fillname   name of file in witch collection is stored.
     * @throws ScriptReqursionExeption
     * @throws ScriptErrorExeption
     */
    public static boolean getComandScript(Scanner scanner, Coll collection, String fillname) throws ScriptReqursionExeption, ScriptErrorExeption {
        History history = new History();

        while (scanner.hasNext()) {
            String strCom[] = scanner.nextLine().trim().split(" ", 2);
            String comand = strCom[0];
            switch (comand) {

                case ("help"): {
                    history.add(comand);
                    Help.helpcomand();
                    break;
                }

                case ("info"): {
                    history.add(comand);
                    Info.infoComand(collection);
                    break;
                }

                case ("show"): {
                    history.add(comand);
                    Show.show(collection);
                    break;
                }

                case ("add"): {
                    history.add(comand);
                    try {
                        Add.addElement(collection, scanner, true);
                    } catch (ElementAddingInScriptExeption e) {
                        System.out.println("Во время добавления элемента в коллекцию в скрипте была допущенна ошибка!");
                        throw new ScriptErrorExeption();
                    }
                    break;
                }

                case ("update"): {

                    try {
                        history.add(comand);
                        int id = Integer.parseInt(strCom[1].trim());
                        UpdateID.updateID(collection, id, scanner, true);
                    } catch (ElementAddingInScriptExeption e) {
                        System.out.println("При введении лбновленного элемента в коллекцию в скрипте была допущенна ошибка!");
                        throw new ScriptErrorExeption();
                    } catch (NumberFormatException e) {
                        System.out.println("ID в команде update должно быть целым числом");
                        throw new ScriptErrorExeption();
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("В одной строке с командой update должнен быть введен ID ");
                        throw new ScriptErrorExeption();
                    }

                    break;
                }

                case ("remove_by_id"): {
                    try {
                        history.add(comand);
                        int id = Integer.parseInt(strCom[1].trim());
                        ;
                        RemoveByID.removeByID(collection, id);
                    } catch (NumberFormatException e) {
                        System.out.println("ID в команде remove_by_id должен быть целым числом");
                        throw new ScriptErrorExeption();
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("В одной строке с командой remove_by_id должнен быть введен ID ");
                        throw new ScriptErrorExeption();
                    }
                    break;
                }

                case ("clear"): {
                    history.add(comand);
                    Clear.clear(collection);
                    break;
                }

                case ("save"): {
                    history.add(comand);
                    Save.save(collection, fillname);
                    break;
                }

                case ("execute_script"): {
                    history.add(comand);
                    try {
                        String f = strCom[1];
                        System.out.println("Исполняю скрипт из файла " + f);
                        boolean t = ExecuteScript.executeScript(f, collection, fillname);
                        System.out.println("Исполнение скрипта из файла " + f + " завершено");
                        if (!t) return false;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("В одной строке с командой execute_script должно быть введено название файла со скриптом!");
                        throw new ScriptErrorExeption();
                    } catch (ScriptErrorExeption e) {
                        System.out.println("При исполнении скрипта была допущенна ошибка");
                    }

                    break;
                }

                case ("exit"): {
                    history.add(comand);
                    scanner.close();
                    return false;
                }

                case ("head"): {
                    history.add(comand);
                    Head.head(collection);
                    break;
                }

                case ("remove_lower"): {
                    history.add(comand);
                    try {
                        RemoveLower.RemoveLower(collection, scanner, false);
                    } catch (ElementAddingInScriptExeption e) {
                        System.out.println("Вовремя добавления элемента для сравнения в скрипте была допущенна ошибка!");
                        throw new ScriptErrorExeption();
                    }
                    break;
                }

                case ("history"): {
                    String str = history.getStory();
                    history.add(comand);
                    System.out.print(str);
                    break;
                }

                case ("sum_of_salary"): {
                    history.add(comand);
                    SumOfSalary.sumOfSalary(collection);
                    break;
                }

                case ("min_by_id"): {
                    history.add(comand);
                    MinByID.minById(collection);
                    break;
                }

                case ("count_greater_than_position"): {
                    history.add(comand);
                    boolean t = true;
                    Position position = Position.LABORER;
                    while (t) {
                        String stringPosition = scanner.nextLine();
                        switch (stringPosition) {
                            case ("LABORER"): {
                                position = Position.LABORER;
                                t = false;
                                break;
                            }
                            case ("ENGINEER"): {
                                position = Position.ENGINEER;
                                t = false;
                                break;
                            }
                            case ("HEAD_OF_DIVISION"): {
                                position = Position.HEAD_OF_DIVISION;
                                t = false;
                                break;
                            }
                            case ("HEAD_OF_DEPARTMENT"): {
                                position = Position.HEAD_OF_DEPARTMENT;
                                t = false;
                                break;
                            }
                            case ("DEVELOPER"): {
                                position = Position.DEVELOPER;
                                t = false;
                                break;
                            }
                            default:
                                System.out.println("Пзиция должна быть из списка!");
                        }
                    }
                    try {
                        CountGreaterThanPosition.countGreaterThanPosition(collection, position);
                    } catch (CollectioIsEmptyExeption e) {
                        System.out.println("Коллекция пуста!");
                    }

                    break;
                }

                default:
                    System.out.println("такой команды не существует, используйте команду help для получения инормации о существующих командах");
            }

        }

        return true;
    }


}
