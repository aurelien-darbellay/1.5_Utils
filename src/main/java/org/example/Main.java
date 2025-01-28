package org.example;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        if (args.length == 2 || args.length == 3) {
            ExplorePathContent explorer = new ExplorePathContent(args[0]);
            String options = args[1];
            switch (options) {
                case "ex1":
                    explorer.showOrderedContent();
                    break;
                case "ex2":
                    ExplorePathContent.showEntireTree(explorer.getPATH(), OutputManager.createConsolePrinter());
                    break;
                case "ex3":
                    ExplorePathContent.showEntireTree(explorer.getPATH(), OutputManager.createTxtFilePrinter(Paths.get(args[2])));
                    break;
                case "ex4":
                    ExplorePathContent.showContentFile(explorer.getPATH(), OutputManager.createConsolePrinter());
                    break;
                default:
                    System.out.println("Unknown exercise");// ExplorePathContent.showEntireTree(explorer.getPATH());
            }
        } else {
            System.out.println("Incorrect arguments number. 2 arguments needed, separated by a white space");
        }
    }
}