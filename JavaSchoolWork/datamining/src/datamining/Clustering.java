package datamining;

import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.core.ManhattanDistance;

public class Clustering {
	SimpleKMeans kmeanModel;
	
	public void buildKmeanModel(Instances dataTrain,int k) throws Exception {
		
		ManhattanDistance mht=new ManhattanDistance();
		mht.setInstances(dataTrain);
		
		kmeanModel=new SimpleKMeans();
		kmeanModel.setDistanceFunction(mht);
		kmeanModel.setNumClusters(k);
		kmeanModel.buildClusterer(dataTrain);
		
		// Print the built model summary so the program shows output when run
		System.out.println(kmeanModel.toString());
		
		
		
	}
	
	public void evalKmeanModel(Instances dataTest) throws Exception {
		for(int i=0;i<dataTest.numInstances();i++) {
			int cluster=kmeanModel.clusterInstance(dataTest.instance(i));
			System.out.println("Instance "+i+" is in cluster "+cluster);
		}
	}

}