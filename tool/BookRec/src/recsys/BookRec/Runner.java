package recsys.BookRec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


class ValueComparator implements Comparator<String> {

    Map<String, Double> base;
    public ValueComparator(Map<String, Double> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.    
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}



public class Runner {
	
	private String srcDir;	
	private String subFolder;
	private int numOfProjects;
	private int numOfNeighbours;
	private int numOfFolds;
	
	public Runner(){
		
	}
	
	public void loadConfigurations(){		
		Properties prop = new Properties();				
		try {
			prop.load(new FileInputStream("evaluation.properties"));		
			this.srcDir=prop.getProperty("sourceDirectory");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return;
	}
			
	
	public void run(){		
		System.out.println("BookRec: Book Recommender System!");
		loadConfigurations();
				
		tenFoldCrossValidation();
						
//		extractGoodbooksDataset();		
//		extractBookCrossingDataset();		
	}
		
	/*Ten-fold cross validation*/
		
	public void tenFoldCrossValidation() {
		
		numOfProjects = 11692;//BookCrossing
//		numOfProjects = 10325;//Goodbooks	
	
		
		numOfNeighbours = 5;
		numOfFolds = 10;
			
		
		int step = (int)numOfProjects/numOfFolds;								
								
		for(int i=0;i<10;i++) {	
			
			System.out.print("i: " + i);
			int trainingStartPos1 = 1;			
			int trainingEndPos1 = i*step;			
			int trainingStartPos2 = (i+1)*step+1;
			int trainingEndPos2 = numOfProjects;
			int testingStartPos = 1+i*step;
			int testingEndPos =   (i+1)*step;
			
			int k=i+1;
			subFolder = "Round" + Integer.toString(k);			
							
			SimilarityCalculator calculator = new SimilarityCalculator(this.srcDir,this.subFolder,
					trainingStartPos1,
					trainingEndPos1,
					trainingStartPos2,
					trainingEndPos2,
					testingStartPos,
					testingEndPos);
			
			calculator.ComputeWeightCosineSimilarity();
						
			RecommendationEngine engine = new RecommendationEngine(this.srcDir,this.subFolder,numOfNeighbours,testingStartPos,testingEndPos);
					
//		    engine.ItemBasedRecommendation();
									
			engine.UserBasedRecommendation();			
			
		}
		
	
	}
	
	
	
	public void extractBookCrossingDataset() {
		
		DataReader reader = new DataReader();		
		String path = this.srcDir; 		
		String fname = "BX-Book-Ratings.csv";				
		reader.parseBookCrossingDataset(path, fname);
				
		System.out.println("Finish extracting!");		
		
		return;
	}
		
	
	
	
	public void extractGoodbooksDataset() {
		
		DataReader reader = new DataReader();		
		String path = this.srcDir; 		
		String fname = "ratings.csv";				
		reader.parseGoodbooksDataset(path, fname);				
		System.out.println("Finish extracting!");		
		return;
	}
		
	
	
	
	
	public static void main(String[] args) {	
		Runner runner = new Runner();			
		runner.run();				    		    
		return;
	}	
	
}
