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
		System.out.println("CrossRec: Recommender System!");
		loadConfigurations();
		
//		preprocess();
		
		
		
		
//		tenFoldCrossValidation();
		
		
		printAllRatings();
		
		
		
//		extractLibraryThingDataset();
		
//		extractLastFMDataset();
		
//		extractBookCrossingDataset();
		
//		int temp = 2;
//		float avg = (float)2.9999999999995;		
//		if(temp>avg)System.out.println("It is larger");
//		else System.out.println("It is smaller");
		
		
	}
		
	/*Ten-fold cross validation*/
	
	public void getProjectAlternativesWithSimilarAPIs(String inputProject) {
		
		
				
		
		
		return;
	}
	
	
	public void tenFoldCrossValidation() {
		
		numOfProjects = 11692;//BookCrossing
//		numOfProjects = 10325;//Goodbooks	
//		numOfProjects = 1472;//IOT
		
		
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
					
		    engine.ItemBasedRecommendation();
			
						
//			engine.UserBasedRecommendation2();			
			
		}
		
	
	}
	
	
	
	
	/*count the number of occurrence of a library in the whole dataset*/
	
	public int countLibFrequency(String lib) {
		int count = 0;
		DataReader reader = new DataReader();
		Map<Integer, String> projects = new HashMap<Integer, String>();
		String filename = this.srcDir + "projects.txt";
		projects = reader.readProjectList(filename);
		
		Set<Integer> keySet = projects.keySet();
		count = 0;
	
		for(Integer key:keySet) {
			String project = projects.get(key);
			project = project.replaceAll("/", "__");
			project = "dicth_" + project;
			count += reader.readOneProject(this.srcDir + project, lib);
		}		
				
		return count;
	}
	
	
		
	
	
	
	
	
	
	public void extractBookCrossingDataset() {
		
		DataReader reader = new DataReader();		
		String path = this.srcDir; 		
		String fname = "BX-Book-Ratings.csv";				
		reader.parseBookCrossingDataset2(path, fname);
				
		System.out.println("Finish extracting!");		
		
		return;
	}
	
	
	
	
	
	
	public void extractLibraryThingDataset() {
		
		DataReader reader = new DataReader();		
		String path = this.srcDir; 		
		String fname = "ratings.csv";				
		reader.parseLibraryThingDataset(path, fname);
				
		System.out.println("Finish extracting!");		
		
		return;
	}
	
	
	
	
	public void printAllRatings() {
		
		
		DataReader reader = new DataReader();		
		String path = this.srcDir; 		
		String fname = "users.csv";				
		reader.countRatings(path, fname);
				
		System.out.println("Finish counting!");		
		
		
		
		return;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {	
		Runner runner = new Runner();			
		runner.run();				    		    
		return;
	}	
	
}
