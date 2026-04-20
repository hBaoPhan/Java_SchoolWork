package datamining;

import weka.associations.Apriori;
import weka.core.Instances;

public class AssociationRule {
	Apriori apriorAR;
	
	public void findAR_Apriori(Instances ins, double minsup, double mincof,int numrules ) throws Exception {
		apriorAR= new Apriori();
		
		apriorAR.setLowerBoundMinSupport(minsup);
		apriorAR.setMinMetric(mincof);
		apriorAR.setNumRules(numrules);
		
		apriorAR.buildAssociations(ins);
		
		
		System.out.println(apriorAR.toString());
		
		
	}
	
}
