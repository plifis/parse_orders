package ru.pliris.parser;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Grabber {


    public static void main(String[] args) throws IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        Parse parse = new CSParser();
        Args arg = new Args(args);
        Operations operations = new OperationsMoney(parse.list(arg.getArgument()));
        Viewer viewer = new CMDViewer(operations);
            viewer.viewTotalPrepayment();
            viewer.viewTotalAmountSupplier();
            viewer.viewTotalAmountDialer();
            viewer.viewTotal();
            viewer.viewTotalIncome();
         while (!sc.next().equals("exit")) {
            Thread.currentThread().interrupt();
        }
    }
}
