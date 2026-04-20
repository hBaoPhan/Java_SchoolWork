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
		
		Instances binaryData = pre.Nominal2Binary(dataTrain);
		ar.findAR_Apriori(binaryData, 0.1, 0.5, 10);
		
		// FPGrowth không hỗ trợ class attribute, cần xóa class index
		Instances dataForFP = new Instances(binaryData);
		dataForFP.setClassIndex(-1);
		ar.findAR_FPGrowth(dataForFP, 0.1, 0.5, 10);
		
		
		
		
		
		
		
		
		
	}

}
