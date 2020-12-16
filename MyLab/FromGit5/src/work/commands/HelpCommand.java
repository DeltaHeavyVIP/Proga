package work.commands;

import work.Commands;

public class HelpCommand extends Commands {
    public static void execute(){
        System.out.println("help : вывести справку по доступным командам");
        System.out.println("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        System.out.println("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        System.out.println("add {element} : добавить новый элемент в коллекцию");
        System.out.println("update id {element} : обновить значение элемента коллекции, id которого равен заданному");
        System.out.println("remove_by_id id : удалить элемент из коллекции по его id");
        System.out.println("clear : очистить коллекцию");
        System.out.println("save : сохранить коллекцию в файл");
        System.out.println("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        System.out.println("exit : завершить программу (без сохранения в файл)");
        System.out.println("remove_at index : удалить элемент, находящийся в заданной позиции коллекции (index)");
        System.out.println("add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
        System.out.println("reorder : отсортировать коллекцию в порядке, обратном нынешнему");
        System.out.println("sum_of_age : вывести сумму значений поля age для всех элементов коллекции");
        System.out.println("filter_contains_name name : вывести элементы, значение поля name которых содержит заданную подстроку");
        System.out.println("print_field_descending_type type : вывести значения поля type в порядке убывания");
    }
}
