package ru.pliris.parser;

public class Args {
    private String[] args;

    public Args(String[] args) {
        if (validateArgs(args)) {
            this.args = args;
        }
    }

    public boolean validateArgs(String[] args) {
        if (args.length == 0 || (!args[0].equals("page") && !args[0].equals("file"))) {
            throw new IllegalArgumentException("Некорректно указаны аргументы для поиска. Необходимо указывать \"page\" и адрес страницы," +
                    "либо \"file\" и путь к файлу ");
        }
        return true;
    }

    public String getArgument() {
        return this.args[1];
    }
}
