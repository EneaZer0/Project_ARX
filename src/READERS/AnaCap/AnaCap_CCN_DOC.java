package READERS.AnaCap;

import READERS.Generic_Process_DOC;

import java.nio.file.Path;
import java.util.ArrayList;

public class AnaCap_CCN_DOC extends Generic_Process_DOC {

    private Double AggregateCapitalCommitment;
    private Double RemainingCapitalCommitment_Beginning_Quarter, RemainingCapitalCommitment_Beginning_SI;
    private Double CapitalContributions_Quarter, CapitalContributions_SI;
    private Double RecallableDistribuitions_Quarter, RecallableDistribuitions_SI;
    private Double RemainingCapitalCommitment_End_Quarter, RemainingCapitalCommitment_End_SI;
    private Double NetAssetsAttributabletoPartner_Quarter, NetAssetsAttributabletoPartner_SI;

    public AnaCap_CCN_DOC(Path path){
        super();
        generalProcess(path);
    }


    @Override
    public void generalProcess(Path path) {
        super.generalProcess(path);
    }

    @Override
    public void value_Assigner(ArrayList<Double> numbersArray) {
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

    }

    @Override
    public void print_all_info(ArrayList<Double> numbersArray) {

        System.out.println("\n");

        System.out.println("Aggregate Capital Commitment: " + AggregateCapitalCommitment);

        System.out.println("\n");

        System.out.println("Remaining Capital Commitment (Beginning) - Quarter: " + RemainingCapitalCommitment_Beginning_Quarter);
        System.out.println("Remaining Capital Commitment (Beginning) - Since Inception: " + RemainingCapitalCommitment_Beginning_SI);

        System.out.println("\n");

        System.out.println("Capital Contributions - Quarter: " + CapitalContributions_Quarter);
        System.out.println("Capital Contributions - Since Inception: " + CapitalContributions_SI);

        System.out.println("\n");

        System.out.println("Recallable Distributions - Quarter: " + RecallableDistribuitions_Quarter);
        System.out.println("Recallable Distributions - Since Inception: " + RecallableDistribuitions_SI);

        System.out.println("\n");

        System.out.println("Remaining Capital Commitment at the end of the period - Quarter: " + RemainingCapitalCommitment_End_Quarter);
        System.out.println("Remaining Capital Commitment at the end of the period - Since Inception: " + RemainingCapitalCommitment_End_SI);

        System.out.println("\n");

        System.out.println("Net assets attributable to the Partner  - Quarter: " + NetAssetsAttributabletoPartner_Quarter);
        System.out.println("Net assets attributable to the Partner  - Since Inception: " + NetAssetsAttributabletoPartner_SI);

        System.out.println("\n");

    }
}
