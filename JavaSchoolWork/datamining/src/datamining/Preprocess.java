package datamining;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NominalToBinary;

public class Preprocess {
	private Instances data;
	private DataSource source;
	
	public Instances loadData(String path) throws Exception {
		source = new DataSource(path);
		data=source.getDataSet();
		if(data.classIndex() ==-1) {
			data.setClassIndex(data.numAttributes()-1);
		}
		return data;
	}
	
	public Instances Nominal2Binary (Instances data) throws Exception {
		NominalToBinary ntb=new NominalToBinary();
		ntb.setTransformAllValues(true);
		ntb.setBinaryAttributesNominal(true);
		
		int classIdx = data.classIndex();
		data.setClassIndex(-1);
		ntb.setInputFormat(data);
		Instances transformed = Filter.useFilter(data, ntb);
		transformed.setClassIndex(classIdx);
		return transformed;
		
	}
	
	
	
	

}
