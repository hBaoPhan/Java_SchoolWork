package datamining;

import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;

public class Classification {
	private J48 j48Model;
	
	
	public void buildJ48Model(Instances data,float conf) throws Exception {
		j48Model=new J48();
		j48Model.setConfidenceFactor(conf);
		j48Model.buildClassifier(data);
		System.out.println(j48Model.toSummaryString());
		
	}
	
	public void evalJ48Model(Instances datatest) throws Exception {
		Evaluation eval=new Evaluation(datatest);
		eval.evaluateModel(j48Model, datatest);
		System.out.println(eval.toSummaryString());
	}

	
	
	
}
