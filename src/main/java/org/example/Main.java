package org.example;

public class Main {
    public static void main(String[] args) {
        if (args.length == 2) {
            ExplorePathContent explorer = new ExplorePathContent(args[0]);
            String options = args[1];
            switch (options) {
                case "ex1":
                    explorer.showOrderedContent();
                    break;
                case "ex2":
                    ExplorePathContent.showEntireTree(explorer.getPATH());
                    break;
                default:
                    System.out.println("Unknown exercise");// ExplorePathContent.showEntireTree(explorer.getPATH());
            }
        } else {
            System.out.println("Incorrect arguments number. 2 arguments needed, separated by a white space");
        }
    }
}