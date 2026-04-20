package datamining;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NominalToBinary;
import weka.filters.unsupervised.attribute.NumericToNominal;

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
		// Chuyển numeric thành nominal trước
		NumericToNominal ntn = new NumericToNominal();
		ntn.setInputFormat(data);
		Instances nominalData = Filter.useFilter(data, ntn);
		
		// Chuyển nominal thành binary
		NominalToBinary ntb=new NominalToBinary();
		ntb.setTransformAllValues(true);
		ntb.setBinaryAttributesNominal(true);
		
		int classIdx = nominalData.classIndex();
		nominalData.setClassIndex(-1);
		ntb.setInputFormat(nominalData);
		Instances transformed = Filter.useFilter(nominalData, ntb);
		transformed.setClassIndex(classIdx);
		return transformed;
		
	}
	
	
	
	

}
