package READERS;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Generic_Number_Extractor {

    private Pattern pattern;
    private ArrayList<Double> numberArray;

    public Generic_Number_Extractor(ArrayList<String> dataArray){

        pattern = Pattern.compile("\\(?-?\\d*([.,]\\d*)*?(\\d*)?\\)?[x%]?");
        numberArray = new ArrayList<>();

        for (String str : dataArray) {
            String[] words = str.split(" ");

            for (String word : words) {
                Double number = 0.0;
                if (pattern.matcher(word).matches()) {
                    if (word.equals("-")){
                        number = 0.0;
                    } else if (word.contains(",")) {
                        word = word.replaceAll("\\,", "");
                        if (word.endsWith(".")) {
                            word = word.substring(0, word.length()-1);
                        }
                        word = negativeNumber(word);
                        number = Double.parseDouble(word);

                    } else {
                        word = negativeNumber(word);
                        if(word.endsWith("x") || word.endsWith("%")) {
                            word = word.replaceAll("x", "" );
                            word = word.replaceAll("%", "" );
                        }
                        if (!word.isEmpty()) {
                            number = Double.parseDouble(word);
                        }

                    }
                    numberArray.add(number);
                }
            }

        }

    }

    private String negativeNumber(String word) {
        if (word.startsWith("(")) {
            word = word.replaceAll("\\(", "");
            word = word.replaceAll("\\)", "" );
            word = "-" + word;
        }
        return word;
    }

    public ArrayList<Double> getNumberArray() {
        return numberArray;
    }
}

