package datamining;

import weka.core.Instances;

public class Test {
	public static void main(String[] args) throws Exception {
		Preprocess pre=new Preprocess();
		Classification classify=new Classification();
		Clustering clus=new Clustering();
		AssociationRule ar=new AssociationRule();
		
	
		Instances dataTrain=pre.loadData("C:\\Program Files\\Weka-3-8-6\\data\\weather.nominal.arff");
		Instances dataTest=pre.loadData("C:\\Program Files\\Weka-3-8-6\\data\\weather.nominal.arff");
//		
//		classify.buildJ48Model(dataTrain,(float) 0.5);
//		classify.evalJ48Model(dataTest);
//		
		
		
//		clus.buildKmeanModel(dataTrain, 3);
//		clus.evalKmeanModel(dataTest);
		ar.findAR_Apriori(pre.Nominal2Binary(dataTrain), 0.1, 0.5, 10);
		
		
		
		
		
		
		
		
		
	}

}
