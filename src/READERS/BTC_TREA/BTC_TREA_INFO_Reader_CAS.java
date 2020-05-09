package READERS.BTC_TREA;

import READERS.Generic_Number_Extractor;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;


public class BTC_TREA_INFO_Reader_CAS {

    private ArrayList<String> dataArray;
    private ArrayList<Double> numbersArray;


    private Double Investment_Commitment, Total_Fund_Size;
    private Double CC_Quarter, CC_YTD, CC_SI;
    private Double CC_Inside_Investment_Quarter, CC_Inside_Investment_YTD, CC_Inside_Investment_SI;
    private Double G_Distribution_Quarter, G_Distribution_YTD, G_Distribution_SI;
    private Double G_Distribution_Interest_Quarter, G_Distribution_Interest_YTD, G_Distribution_Interest_SI;
    private Double N_Distribution_Quarter, N_Distribution_YTD, N_Distribution_SI;
    private Double N_Distribution_ReCALL_Quarter, N_Distribution_ReCALL_YTD, N_Distribution_ReCALL_SI;
    private Double Unfunded_Commitment_SI;

    private Pattern pattern = Pattern.compile("\\(?-?\\d*([.,]\\d*)*?(\\d*)?\\)?");

    public String All_Process_Extractor(Path path) {
        reader(path);
        number_extraction_from_file();
        value_Assigner();
        print_all_info();
        return all_data_string();

    }

    protected ArrayList<String> reader(Path path) {

        Objects.requireNonNull(path);

        dataArray = new ArrayList<>();

        File document = new File(String.valueOf(path));

        if (document.exists()) {

            try{

                Scanner myReader = new Scanner(document);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    dataArray.add(data);
                    //System.out.println(data);
                }


            } catch (FileNotFoundException e) {
                System.err.println("There was an error: " + e.getMessage());
                e.printStackTrace();
            }

        } else {

            System.err.println("The file does not exist.");

        }
        // System.out.println(dataArray);
        return dataArray;

    }

    private ArrayList<Double> number_extraction_from_file() {

        Objects.requireNonNull(dataArray);

        numbersArray = new ArrayList<>();
        ArrayList<String> data = dataArray;

        Generic_Number_Extractor extractor = new Generic_Number_Extractor(dataArray);
        numbersArray = extractor.getNumberArray();

        return numbersArray;
    }

    private void value_Assigner() {
        Investment_Commitment = numbersArray.get(2);
        Total_Fund_Size = numbersArray.get(3);
        CC_Quarter = numbersArray.get(4);
        CC_YTD = numbersArray.get(5);
        CC_SI = numbersArray.get(6);
        CC_Inside_Investment_Quarter = numbersArray.get(7);
        CC_Inside_Investment_YTD = numbersArray.get(8);
        CC_Inside_Investment_SI = numbersArray.get(9);
        G_Distribution_Quarter = numbersArray.get(10);
        G_Distribution_YTD = numbersArray.get(11);
        G_Distribution_SI = numbersArray.get(12);
        G_Distribution_Interest_Quarter = numbersArray.get(19);
        G_Distribution_Interest_YTD = numbersArray.get(20);
        G_Distribution_Interest_SI = numbersArray.get(21);
        N_Distribution_Quarter = numbersArray.get(28);
        N_Distribution_YTD = numbersArray.get(29);
        N_Distribution_SI = numbersArray.get(30);
        N_Distribution_ReCALL_Quarter = numbersArray.get(31);
        N_Distribution_ReCALL_YTD = numbersArray.get(32);
        N_Distribution_ReCALL_SI = numbersArray.get(33);
        Unfunded_Commitment_SI = numbersArray.get(34);
    }


    private void print_all_info() {

        System.out.println("\n");

        System.out.println("Investment Commitment: " + Investment_Commitment);
        System.out.println("Total Fund Size: " + Total_Fund_Size);

        System.out.println("\n");

        System.out.println("Capital Call - Quarter: " + CC_Quarter);
        System.out.println("Capital Call - YTD: " + CC_YTD);
        System.out.println("Capital Call - Since Inception: " + CC_SI);

        System.out.println("\n");

        System.out.println("Capital Call (Inside Investment) - Quarter: " + CC_Inside_Investment_Quarter);
        System.out.println("Capital Call (Inside Investment) - YTD: " + CC_Inside_Investment_YTD);
        System.out.println("Capital Call (Inside Investment) - Since Inception: " + CC_Inside_Investment_SI);

        System.out.println("\n");

        System.out.println("Gross Distribution - Quarter: " + G_Distribution_Quarter);
        System.out.println("Gross Distribution - YTD: " + G_Distribution_YTD);
        System.out.println("Gross Distribution - Since Inception: " + G_Distribution_SI);

        System.out.println("\n");

        System.out.println("Gross Distribution (Interest) - Quarter: " + G_Distribution_Interest_Quarter);
        System.out.println("Gross Distribution (Interest) - YTD: " + G_Distribution_Interest_YTD);
        System.out.println("Gross Distribution (Interest) - Since Inception: " + G_Distribution_Interest_SI);

        System.out.println("\n");

        System.out.println("Net Distribution - Quarter: " + N_Distribution_Quarter);
        System.out.println("Net Distribution - YTD: " + N_Distribution_YTD);
        System.out.println("Net Distribution - Since Inception: " + N_Distribution_SI);

        System.out.println("\n");

        System.out.println("Net Distribution (Recallable) - Quarter: " + N_Distribution_ReCALL_Quarter);
        System.out.println("Net Distribution (Recallable) - YTD: " + N_Distribution_ReCALL_YTD);
        System.out.println("Net Distribution (Recallable) - Since Inception: " + N_Distribution_ReCALL_SI);

        System.out.println("\n");

        System.out.println("Unfunded Commitment: " + Unfunded_Commitment_SI);

    }

    protected String all_data_string() {
        String data =  String.format("Investment Commitment: %s \n" +
                "Total Fund Size: %s \n\n" +

                "Capital Call - Quarter: %s \n" +
                "Capital Call - YTD: %s \n" +
                "Capital Call - Since Inception: %s \n\n" +

                "Capital Call (Inside Investment) - Quarter: %s \n" +
                "Capital Call (Inside Investment) - YTD: %s \n" +
                "Capital Call (Inside Investment) - Since Inception: %s \n\n" +

                "Gross Distribution - Quarter: %s \n" +
                "Gross Distribution - YTD: %s \n" +
                "Gross Distribution - Since Inception: %s \n\n" +

                "Gross Distribution (Interest) - Quarter: %s \n" +
                "Gross Distribution (Interest) - YTD: %s \n" +
                "Gross Distribution (Interest) - Since Inception: %s \n\n" +

                "Net Distribution - Quarter: %s \n" +
                "Net Distribution - YTD: %s \n" +
                "Net Distribution - Since Inception: %s \n\n" +

                "Net Distribution (Recallable) - Quarter: %s \n" +
                "Net Distribution (Recallable) - YTD: %s \n" +
                "Net Distribution (Recallable) - Since Inception: %s \n\n" +

                "Unfunded Commitment: %s \n\n",
                Investment_Commitment,Total_Fund_Size,
                CC_Quarter, CC_YTD,CC_SI,
                CC_Inside_Investment_Quarter, CC_Inside_Investment_YTD, CC_Inside_Investment_SI,
                G_Distribution_Quarter, G_Distribution_YTD, G_Distribution_SI,
                G_Distribution_Interest_Quarter, G_Distribution_Interest_YTD, G_Distribution_Interest_SI,
                N_Distribution_Quarter, N_Distribution_YTD, N_Distribution_SI,
                N_Distribution_ReCALL_Quarter, N_Distribution_ReCALL_YTD, N_Distribution_ReCALL_SI,
                Unfunded_Commitment_SI);

        return data;
    }

    /*_____________________ GETTER FUNCTIONS _____________________*/

    public String getDate(Path path) {
        ArrayList<String> data = reader(path);
        String[] line = data.get(0).split(" ");
        System.out.println(Arrays.toString(line));

        return "" + line[line.length - 4] + " " + line[line.length - 3] + " " + line[line.length - 2] + " " + line[line.length - 1];
    }

    public ArrayList<String> getDataArray() {
        return dataArray;
    }

    public ArrayList<Double> getNumbersArray() {
        return numbersArray;
    }

    public Double getInvestment_Commitment() {
        return Investment_Commitment;
    }

    public Double getTotal_Fund_Size() {
        return Total_Fund_Size;
    }

    public Double getCC_Quarter() {
        return CC_Quarter;
    }

    public Double getCC_YTD() {
        return CC_YTD;
    }

    public Double getCC_SI() {
        return CC_SI;
    }

    public Double getCC_Inside_Investment_Quarter() {
        return CC_Inside_Investment_Quarter;
    }

    public Double getCC_Inside_Investment_YTD() {
        return CC_Inside_Investment_YTD;
    }

    public Double getCC_Inside_Investment_SI() {
        return CC_Inside_Investment_SI;
    }

    public Double getG_Distribution_Quarter() {
        return G_Distribution_Quarter;
    }

    public Double getG_Distribution_YTD() {
        return G_Distribution_YTD;
    }

    public Double getG_Distribution_SI() {
        return G_Distribution_SI;
    }

    public Double getG_Distribution_Interest_Quarter() {
        return G_Distribution_Interest_Quarter;
    }

    public Double getG_Distribution_Interest_YTD() {
        return G_Distribution_Interest_YTD;
    }

    public Double getG_Distribution_Interest_SI() {
        return G_Distribution_Interest_SI;
    }

    public Double getN_Distribution_Quarter() {
        return N_Distribution_Quarter;
    }

    public Double getN_Distribution_YTD() {
        return N_Distribution_YTD;
    }

    public Double getN_Distribution_SI() {
        return N_Distribution_SI;
    }

    public Double getN_Distribution_ReCALL_Quarter() {
        return N_Distribution_ReCALL_Quarter;
    }

    public Double getN_Distribution_ReCALL_YTD() {
        return N_Distribution_ReCALL_YTD;
    }

    public Double getN_Distribution_ReCALL_SI() {
        return N_Distribution_ReCALL_SI;
    }

    public Double getUnfunded_Commitment_SI() {
        return Unfunded_Commitment_SI;
    }

}
