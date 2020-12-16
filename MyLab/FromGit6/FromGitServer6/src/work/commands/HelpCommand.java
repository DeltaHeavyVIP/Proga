package work.commands;

import work.Commands;

public class HelpCommand extends Commands {
    public static String execute(){
        String answ = "help : вывести справку по доступным командам" + "\n"
                +"info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)" + "\n"
                +"show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении" + "\n"
                +"add {element} : добавить новый элемент в коллекцию" + "\n"
                +"update id {element} : обновить значение элемента коллекции, id которого равен заданному" + "\n"
                +"remove_by_id id : удалить элемент из коллекции по его id" + "\n"
                +"clear : очистить коллекцию" + "\n"
                +"save : сохранить коллекцию в файл" + "\n"
                +"execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме." + "\n"
                +"exit : завершить программу (без сохранения в файл)" + "\n"
                +"remove_at index : удалить элемент, находящийся в заданной позиции коллекции (index)" + "\n"
                +"add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции" + "\n"
                +"reorder : отсортировать коллекцию в порядке, обратном нынешнему" + "\n"
                +"sum_of_age : вывести сумму значений поля age для всех элементов коллекции" + "\n"
                +"filter_contains_name name : вывести элементы, значение поля name которых содержит заданную подстроку" + "\n"
                +"print_field_descending_type type : вывести значения поля type в порядке убывания" + "\n";
        return answ;
    }
}
