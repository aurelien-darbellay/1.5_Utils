package org.example;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        if (args.length == 2 || args.length == 3 || args.length == 4) {
            ExplorePathContent explorer = new ExplorePathContent(args[1]);
            String options = args[0];
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
                case "ex5":
                    ObjectStreamManager.serializeObject(new String[]{args[1], args[2], args[3]});
                    ObjectStreamManager.retrieveSerializedObject("../../assets/serialized.ser");
                    break;
                default:
                    System.out.println("Unknown exercise");// ExplorePathContent.showEntireTree(explorer.getPATH());
            }
        } else {
            System.out.println("Incorrect arguments number. 2 or 3 arguments needed, separated by a white space");
        }
    }
}