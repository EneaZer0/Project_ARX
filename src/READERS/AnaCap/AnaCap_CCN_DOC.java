package READERS.AnaCap;

import MAINGUI.CONSTANTS.String_Constants;
import READERS.Generic_Process_DOC;

import java.nio.file.Path;
import java.util.ArrayList;

public class AnaCap_CCN_DOC extends Generic_Process_DOC {

    private Double AggregateCapitalCommitment;
    private Double RemainingCapitalCommitment_Beginning_Quarter, RemainingCapitalCommitment_Beginning_YTD,RemainingCapitalCommitment_Beginning_SI;
    private Double CapitalContributions_Quarter, CapitalContributions_YTD, CapitalContributions_SI;
    private Double RecallableDistribuitions_Quarter, RecallableDistribuitions_YTD, RecallableDistribuitions_SI;
    private Double RemainingCapitalCommitment_End_Quarter, RemainingCapitalCommitment_End_YTD, RemainingCapitalCommitment_End_SI;
    private Double NetAssetsAttributabletoPartner_Quarter, NetAssetsAttributabletoPartner_YTD, NetAssetsAttributabletoPartner_SI;
    private String_Constants string;

    public AnaCap_CCN_DOC(Path path, String_Constants string){
        super();
        generalProcess(path);
        this.string = string;
    }


    @Override
    public void generalProcess(Path path) {
        super.generalProcess(path);
    }

    @Override
    public void value_Assigner(ArrayList<Double> numbersArray) {

        if (numbersArray.size() == 53) {
            AggregateCapitalCommitment = numbersArray.get(5);

            RemainingCapitalCommitment_Beginning_Quarter = numbersArray.get(6);
            RemainingCapitalCommitment_Beginning_SI = numbersArray.get(7);

            CapitalContributions_Quarter = numbersArray.get(8);
            CapitalContributions_SI = numbersArray.get(9);

            RecallableDistribuitions_Quarter = numbersArray.get(10);
            RecallableDistribuitions_SI = numbersArray.get(11);

            RemainingCapitalCommitment_End_Quarter = numbersArray.get(12);
            RemainingCapitalCommitment_End_SI= numbersArray.get(13);

            NetAssetsAttributabletoPartner_Quarter = numbersArray.get(50);
            NetAssetsAttributabletoPartner_SI= numbersArray.get(51);

        } else if (numbersArray.size() == 77) {

            AggregateCapitalCommitment = numbersArray.get(7);

            RemainingCapitalCommitment_Beginning_Quarter = numbersArray.get(8);
            RemainingCapitalCommitment_Beginning_YTD = numbersArray.get(9);
            RemainingCapitalCommitment_Beginning_SI = numbersArray.get(10);

            CapitalContributions_Quarter = numbersArray.get(11);
            CapitalContributions_YTD = numbersArray.get(12);
            CapitalContributions_SI = numbersArray.get(13);

            RecallableDistribuitions_Quarter = numbersArray.get(14);
            RecallableDistribuitions_YTD = numbersArray.get(15);
            RecallableDistribuitions_SI = numbersArray.get(16);

            RemainingCapitalCommitment_End_Quarter = numbersArray.get(17);
            RemainingCapitalCommitment_End_YTD = numbersArray.get(18);
            RemainingCapitalCommitment_End_SI= numbersArray.get(19);

            NetAssetsAttributabletoPartner_Quarter = numbersArray.get(73);
            NetAssetsAttributabletoPartner_YTD = numbersArray.get(74);
            NetAssetsAttributabletoPartner_SI= numbersArray.get(75);

        } else {

            throw new IllegalArgumentException("ERROR: The amount of numbers does not coincide with the supposed model. Revise the document. Probably a new model must be made.");

        }


    }

    @Override
    public void print_all_info(ArrayList<Double> numbersArray) {


        System.out.println("\n");

        System.out.println("Aggregate Capital Commitment: " + AggregateCapitalCommitment);

        System.out.println("\n");

        System.out.println("Remaining Capital Commitment (Beginning) - Quarter: " + RemainingCapitalCommitment_Beginning_Quarter);
        if (RemainingCapitalCommitment_Beginning_YTD != null) {System.out.println("Remaining Capital Commitment (Beginning) - YTD: " + RemainingCapitalCommitment_Beginning_YTD); }
        System.out.println("Remaining Capital Commitment (Beginning) - Since Inception: " + RemainingCapitalCommitment_Beginning_SI);

        System.out.println("\n");

        System.out.println("Capital Contributions - Quarter: " + CapitalContributions_Quarter);
        if (CapitalContributions_YTD != null) {System.out.println("Capital Contributions - YTD: " + CapitalContributions_YTD); }
        System.out.println("Capital Contributions - Since Inception: " + CapitalContributions_SI);

        System.out.println("\n");

        System.out.println("Recallable Distributions - Quarter: " + RecallableDistribuitions_Quarter);
        if (RecallableDistribuitions_YTD != null) {System.out.println("Recallable Distributions - YTD: " + RecallableDistribuitions_YTD); }
        System.out.println("Recallable Distributions - Since Inception: " + RecallableDistribuitions_SI);

        System.out.println("\n");

        System.out.println("Remaining Capital Commitment at the end of the period - Quarter: " + RemainingCapitalCommitment_End_Quarter);
        if (RemainingCapitalCommitment_End_YTD != null) {System.out.println("Remaining Capital Commitment at the end of the period - YTD: " + RemainingCapitalCommitment_End_YTD); }
        System.out.println("Remaining Capital Commitment at the end of the period - Since Inception: " + RemainingCapitalCommitment_End_SI);

        System.out.println("\n");

        System.out.println("Net assets attributable to the Partner - Quarter: " + NetAssetsAttributabletoPartner_Quarter);
        if (NetAssetsAttributabletoPartner_YTD != null) {System.out.println("Net assets attributable to the Partner - YTD: " + NetAssetsAttributabletoPartner_YTD); }
        System.out.println("Net assets attributable to the Partner - Since Inception: " + NetAssetsAttributabletoPartner_SI);

        System.out.println("\n");

    }

    @Override
    public String getString_all_info() {



        String line = "\n";
        String AggregateCapitalCommitmentString = "Aggregate Capital Commitment: " + AggregateCapitalCommitment;
        String RemainingCapitalCommitment_Beginning_Quarter_String = "Remaining Capital Commitment (Beginning) - Quarter: " + RemainingCapitalCommitment_Beginning_Quarter;
        String RemainingCapitalCommitment_Beginning_YTD_String = "Remaining Capital Commitment (Beginning) - YTD: " + RemainingCapitalCommitment_Beginning_YTD;
        String RemainingCapitalCommitment_Beginning_SI_String = "Remaining Capital Commitment (Beginning) - Since Inception: " + RemainingCapitalCommitment_Beginning_SI;
        String CapitalContributions_Quarter_String = "Capital Contributions - Quarter: " + CapitalContributions_Quarter;
        String CapitalContributions_YTD_String = "Capital Contributions - YTD: " + CapitalContributions_YTD;
        String CapitalContributions_SI_Sting =  "Capital Contributions - Since Inception: " + CapitalContributions_SI;
        String RecallableDistribuitions_Quarter_String = "Recallable Distributions - Quarter: " + RecallableDistribuitions_Quarter;
        String RecallableDistribuitions_YTD_String =  "Recallable Distributions - YTD: " + RecallableDistribuitions_YTD;
        String RecallableDistribuitions_SI_String = "Recallable Distributions - Since Inception: " + RecallableDistribuitions_SI;
        String RemainingCapitalCommitment_End_Quarter_String =  "Remaining Capital Commitment at the end of the period - Quarter: " + RemainingCapitalCommitment_End_Quarter;
        String RemainingCapitalCommitment_End_YTD_String = "Remaining Capital Commitment at the end of the period - YTD: " + RemainingCapitalCommitment_End_YTD;
        String RemainingCapitalCommitment_End_SI_String = "Remaining Capital Commitment at the end of the period - Since Inception: " + RemainingCapitalCommitment_End_SI;
        String NetAssetsAttributabletoPartner_Quarter_String = "Net assets attributable to the Partner - Quarter: " + NetAssetsAttributabletoPartner_Quarter;
        String NetAssetsAttributabletoPartner_YTD_String = "Net assets attributable to the Partner - YTD: " + NetAssetsAttributabletoPartner_YTD;
        String NetAssetsAttributabletoPartner_SI_String = "Net assets attributable to the Partner - Since Inception: " + NetAssetsAttributabletoPartner_SI;


        String TOTAL_OUTPUT =

                        string.tab +  AggregateCapitalCommitmentString + line +

                        line +

                        string.tab +  RemainingCapitalCommitment_Beginning_Quarter_String + line;


        if (RemainingCapitalCommitment_Beginning_YTD != null) {
            TOTAL_OUTPUT = TOTAL_OUTPUT + string.tab +  RemainingCapitalCommitment_Beginning_YTD_String + line;
        }

        TOTAL_OUTPUT =
                TOTAL_OUTPUT +
                        string.tab +  RemainingCapitalCommitment_Beginning_SI_String + line +

                        line +

                        string.tab +  CapitalContributions_Quarter_String + line;

        if (CapitalContributions_YTD != null) {
            TOTAL_OUTPUT = TOTAL_OUTPUT + string.tab +  CapitalContributions_YTD_String + line;
        }

        TOTAL_OUTPUT =
                TOTAL_OUTPUT + string.tab +  CapitalContributions_SI_Sting + line +

                        line +

                        string.tab +  RecallableDistribuitions_Quarter_String + line;


        if (RecallableDistribuitions_YTD != null) {
            TOTAL_OUTPUT = TOTAL_OUTPUT + string.tab +  RecallableDistribuitions_YTD_String + line;
        }

        TOTAL_OUTPUT =
                TOTAL_OUTPUT +
                        string.tab +  RecallableDistribuitions_SI_String + line +

                        line +

                        string.tab +  RemainingCapitalCommitment_End_Quarter_String + line;


        if (RemainingCapitalCommitment_End_YTD != null) {
            TOTAL_OUTPUT = TOTAL_OUTPUT + string.tab +  RemainingCapitalCommitment_End_YTD_String + line;
        }

        TOTAL_OUTPUT =
                TOTAL_OUTPUT +
                        string.tab +  RemainingCapitalCommitment_End_SI_String + line +

                        line +

                        string.tab +  NetAssetsAttributabletoPartner_Quarter_String + line;

        if (NetAssetsAttributabletoPartner_YTD != null) {
            TOTAL_OUTPUT = TOTAL_OUTPUT + string.tab +  NetAssetsAttributabletoPartner_YTD_String + line;
        }

        TOTAL_OUTPUT =
                TOTAL_OUTPUT + string.tab +  NetAssetsAttributabletoPartner_SI_String + line;

        return TOTAL_OUTPUT;
    }
}
