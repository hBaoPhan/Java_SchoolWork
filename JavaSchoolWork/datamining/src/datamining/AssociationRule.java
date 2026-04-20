package datamining;

import weka.associations.Apriori;
import weka.associations.FPGrowth;
import weka.core.Instances;

public class AssociationRule {
	Apriori apriorAR;
	FPGrowth fpgrowthAR;
	
	public void findAR_Apriori(Instances ins, double minsup, double mincof,int numrules ) throws Exception {
		apriorAR= new Apriori();
		
		apriorAR.setLowerBoundMinSupport(minsup);
		apriorAR.setMinMetric(mincof);
		apriorAR.setNumRules(numrules);
		
		apriorAR.buildAssociations(ins);
		
		System.out.println("=== APRIORI RESULTS ===");
		System.out.println(apriorAR.toString());
		
	}
	
	public void findAR_FPGrowth(Instances ins, double minsup, double mincof, int numrules) throws Exception {
		fpgrowthAR = new FPGrowth();
		
		fpgrowthAR.setLowerBoundMinSupport(minsup);
		fpgrowthAR.setMinMetric(mincof);
		
		fpgrowthAR.buildAssociations(ins);
		
		System.out.println("\n=== FPGROWTH RESULTS ===");
		System.out.println(fpgrowthAR.toString());
		
	}
	
}
