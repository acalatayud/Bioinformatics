package ar.edu.itba.bio;

import java.io.File;

public class Main {

    public static void main(final String[] args) {

        String exercise = System.getProperty("exercise");
        String input = System.getProperty("input");
        String output = System.getProperty("output");
        String pattern = System.getProperty("pattern");

        if (input == null || input.isEmpty() || output == null || output.isEmpty()) {
            System.err.println("Missing input or output files");
            System.exit(1);
        }

        File inputFile = new File(input);

        if (!inputFile.exists()) {
            System.err.println("Missing input file");
            System.exit(1);
        }

        if (pattern == null) {
            pattern = "";
        }

        try {
            switch (exercise) {
                case "1":
                    GenBankTranslator.translate(inputFile, output);
                    break;
                case "2":
                    BlastReporter.execute(inputFile, output);
                    break;
                case "4":
                    BlastHitParser.getHits(inputFile, pattern, false);
                    break;
                default:
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error running exercise");
            System.exit(1);
        }
    }

}
