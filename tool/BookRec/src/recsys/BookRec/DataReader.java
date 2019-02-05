package recsys.BookRec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class DataReader {

	
	
	public DataReader() {		
		
	}
	
	public Map<Integer, String> readProjectList(String filename, int startPos, int endPos){		
		Map<Integer,String> ret = new HashMap<Integer,String>();
		String[] vals = null;		
		String line="",repo="";
		int count=1;
		int id=startPos;
		
		try {					
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			
			while (count< startPos) {
				line = reader.readLine();
				count++;
			}
			
			while (((line = reader.readLine()) != null)) {
				line = line.trim();		
//				repo=line;
				
				vals = line.split(",");					
				repo=vals[0].trim();			
				
				ret.put(id,repo);				
				id++;
				count++;
				if(count>endPos)break;
			}						
				
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		return ret;				
	}
	
	
	
	/*read all the projects*/
	
	public Map<Integer, String> readProjectList(String filename){		
		Map<Integer,String> ret = new HashMap<Integer,String>();
		String line="",repo="";
		int id=1;		
		try {					
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			while (((line = reader.readLine()) != null)) {
				line = line.trim();		
				repo=line;			
				ret.put(id,repo);				
				id++;
			}						
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return ret;				
	}
	
	
	public int readOneProject(String filename, String library){		
		int count = 0;
		String line="",dependency="";	
		String[] parts = null;
		try {					
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			while (((line = reader.readLine()) != null)) {
				 
				if(line.contains("#DEP#")) {
					parts = line.split("\t");
					dependency = parts[1].trim();
					dependency = dependency.replace("#DEP#", "");
//					System.out.println(dependency + "\t" + library);
					if(dependency.equals(library))count++;
				}
			}						
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return count;				
	}
		
	
	
	
	
	
	
	
		
	
	
	
	
		
		
	
	public Map<String, Integer> readDictionary(String filename) {							
		Map<String, Integer> vector = new HashMap<String, Integer>();		
		String line = null;		
		String[] vals = null;		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
						
			while ((line = reader.readLine()) != null) {
										
				vals = line.split("\t");
			
				int ID = Integer.parseInt(vals[0].trim());
				
				String URI = vals[1].trim();
		
				vector.put(URI, ID);							
			}
			
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
						
		return vector;		
	}
	
	
	public Map<Integer, String> readDictionary2(String filename) {							
		Map<Integer, String> vector = new HashMap<Integer, String>();		
		String line = null;		
		String[] vals = null;		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
						
			while ((line = reader.readLine()) != null) {										
				vals = line.split("\t");			
				int ID = Integer.parseInt(vals[0].trim());				
				String URI = vals[1].trim();		
				vector.put(ID, URI);							
			}
			
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
						
		return vector;		
	}
	
	
	public Map<String, String> readDictionary3(String filename) {							
		Map<String, String> vector = new HashMap<String, String>();		
		String line = null;		
		String[] vals = null;		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
						
			while ((line = reader.readLine()) != null) {
										
				vals = line.split("\t");			
				String ID = vals[0].trim();				
				String URI = vals[1].trim();		
				vector.put(ID, URI);							
			}
			
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
						
		return vector;		
	}
		
	
	
	/*Read dictionary, get only liraries and the first line*/
	
	public Map<Integer, String> readDictionary4(String filename) {							
		Map<Integer, String> vector = new HashMap<Integer, String>();		
		String line = null;		
		String[] vals = null;		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
						
			while ((line = reader.readLine()) != null) {										
				vals = line.split("\t");			
				int ID = Integer.parseInt(vals[0].trim());				
				String artifact = vals[1].trim();				
				if(ID==1 || artifact.contains("#DEP#"))vector.put(ID, artifact);				
			}
			
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
						
		return vector;		
	}
	
	
	
	
	
	/*Read dictionary, get only liraries and the first line*/
	
	public Map<Integer, String> readDictionary5(String filename) {							
		Map<Integer, String> vector = new HashMap<Integer, String>();		
		String line = null;		
		String[] vals = null;		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
						
			while ((line = reader.readLine()) != null) {										
				vals = line.split("\t");			
				int ID = Integer.parseInt(vals[0].trim());				
				String artifact = vals[1].trim();		
				
				if(ID==1 || artifact.contains("#DEP#")) {					
					String[] temp = artifact.split("%");				
					vector.put(ID, temp[0].trim());					
				}
			}
			
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
						
		return vector;		
	}
	
	
	public Map<Integer, String> extractHalfDictionary(String filename, String groundTruthPath, boolean getAlsoUsers) {							
		Map<Integer, String> dict = new HashMap<Integer, String>();
		Map<Integer, String> ret = new HashMap<Integer, String>();
		String line = null;		
		String[] vals = null;
		int half=0;
		int libCount = 0;
		
//		System.out.println(filename);
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));						
			while ((line = reader.readLine()) != null) {				
				vals = line.split("\t");			
//				System.out.println(vals[0]);
				int ID = Integer.parseInt(vals[0].trim());				
				String artifact = vals[1].trim();				
				dict.put(ID, artifact);
				if(artifact.contains("#DEP#"))libCount++;
			}	
//			System.out.println("libCount " + libCount);
			reader.close();
			int size = libCount;
			
			Set<Integer> keySet = dict.keySet();			
			half = Math.round(size/2);			
								
			boolean enoughLib = false;
			libCount = 0;			
				
			int pos = filename.lastIndexOf("/");				
			String fname = filename.substring(pos+1,filename.length());		
			fname = fname.replace("dict_", "");
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(groundTruthPath + fname));
					
			/*Read a half of the dictionary and all users, the other half is put into the ground-truth data*/
			
			for(Integer key:keySet) {					
				String artifact = dict.get(key);
				if(libCount==half)enoughLib=true;							
				if(artifact.contains("#DEP#")) {					
					if(!enoughLib) {
						
//						if(filename.contains("ostrich_2_9_29_1_"))System.out.println(artifact);
						
						ret.put(key, artifact);
					}
					else {						
						String content = key + "\t" + artifact;					
						writer.append(content);							
						writer.newLine();
						writer.flush();						
					}
					libCount++;				
				} else {
					/*put users into the dictionary*/
					
//					if(getAlsoUsers || artifact.contains("git://github.com/"))ret.put(key, artifact);
					if(getAlsoUsers || !artifact.contains("#DEP#"))ret.put(key, artifact);
				}									
			}
			
			writer.close();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}						
		return ret;		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*read only the first half of the libraries*/
	
	
	public Set<String> getHalfOfLibraries(String filename) {							
		Map<Integer, String> dict = new HashMap<Integer, String>();
		Set<String> ret = new HashSet<String>();
		String line = null;		
		String[] vals = null;
		int libCount = 0, half=0;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));						
			while ((line = reader.readLine()) != null) {				
				vals = line.split("\t");			
				int ID = Integer.parseInt(vals[0].trim());				
				String artifact = vals[1].trim();				
				dict.put(ID, artifact);			
				if(artifact.contains("#DEP#"))libCount++;
			}		
			reader.close();
			
			int size = libCount;
			Set<Integer> keySet = dict.keySet();			
			half = Math.round(size/2);		
			libCount=0;			
			for(Integer key:keySet) {					
				String artifact = dict.get(key);							
				if(artifact.contains("#DEP#")) {					
					ret.add(artifact);
					libCount++;				
				}
				if(libCount==half)break;
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}						
		return ret;		
	}
	
	
	
	/*read only the first half of the libraries*/
		
	public HashMap<String,Byte> getHalfOfItems(String filename) {							
		Map<Integer, String> dict = new HashMap<Integer, String>();
		
		
		HashMap<String,Byte> ret = new HashMap<String,Byte>();
		String line = null;		
		String[] vals = null;
		int libCount = 0, half=0;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));						
			while ((line = reader.readLine()) != null) {				
				vals = line.split("\t");			
				int ID = Integer.parseInt(vals[0].trim());				
				String artifact = vals[1].trim();				
				dict.put(ID, artifact);			
				if(artifact.contains("#DEP#"))libCount++;
			}		
			reader.close();
			
			int size = libCount;
			Set<Integer> keySet = dict.keySet();			
			half = Math.round(size/2);		
			libCount=0;			
			
			
			for(Integer key:keySet) {					
				String artifact = dict.get(key);		
				byte rating = 0;
				String item = "";				
				if(artifact.contains("#DEP#")) {					
					vals = artifact.split("%");
					item = vals[0].trim();
					rating = Byte.parseByte(vals[1].trim());					
					ret.put(item, rating);
					libCount++;				
				}
				if(libCount==half)break;
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}						
		return ret;		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void getProjectDetails(String filename, Map<String,Set<String>> methodInvocations) {		
		Set<String> vector = null;				
		String line = null;		
		String[] vals = null;		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));						
			while ((line = reader.readLine()) != null) {				
				vals = line.split("\t");								
				String artifact = vals[1].trim();											
				if(artifact.contains("MI_")) {				
					String[] parts = artifact.split("#");					
					String md = parts[0].trim().replace("MI_", "");
					String mi = parts[1].trim();					
					if(methodInvocations.containsKey(md))vector=methodInvocations.get(md);
					else vector = new HashSet<String>();
					vector.add(mi);
					methodInvocations.put(md, vector);					
				}
			}			
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return;
	}
	
	
	
	
	
	/*get the list of libraries for one project*/
		
	public Set<String> getLibraries(String filename) {							
		Set<String> vector = new HashSet<String>();		
		String line = null;		
		String[] vals = null;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));						
			while ((line = reader.readLine()) != null) {				
				vals = line.split("\t");								
				String library = vals[1].trim();
				if(library.contains("#DEP#"))vector.add(library);		
			}			
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}						
		return vector;		
	}
	
	
	
	
	
	
	/*get the list of items for one user, not their ranking*/
	
	public Set<String> getOnlyItems(String filename) {							
		Set<String> vector = new HashSet<String>();		
		String line = null;		
		String[] vals = null;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));						
			while ((line = reader.readLine()) != null) {				
				vals = line.split("\t");								
				String itemRanking = vals[1].trim();
				
				if(itemRanking.contains("#DEP#")) {
					String[] temp = itemRanking.split("%");
					String item = temp[0].trim();
					vector.add(item);		
				}
			}			
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}						
		return vector;		
	}
	
	
	
	
	
	
	/*get the list of libraries for one project*/
	
	public Map<String,Byte> getItems(String filename) {
		
		Map<String,Byte> ret = new HashMap<String,Byte>();		
		String line = null;		
		String[] vals = null;
		String[] tmp = null;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));						
			while ((line = reader.readLine()) != null) {				
				vals = line.split("\t");
								
				if(vals[1].trim().contains("#DEP#")) {					
					tmp = vals[1].trim().split("%");				
					String item = tmp[0].trim();
					Byte rating = Byte.parseByte(tmp[1].trim());
					ret.put(item, rating);
				}					
			}			
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}						
		return ret;		
	}
	
	
	
	
	
	
	
	/*read the whole file*/
	
	public Map<Integer,String> readRecommendationFile(String filename) {							
		Map<Integer,String> ret = new HashMap<Integer,String>();	
		String line = null;		
		String[] vals = null;
		int id=1;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));					
			while ((line = reader.readLine()) != null) {										
				vals = line.split("\t");			
				String library = vals[0].trim();			
				ret.put(id, library);
				id++;
			}			
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
						
		return ret;		
	}
	
	
	
	
	
	/*read a specific number of lines from the file*/
	
	public Set<String> readRecommendationFile(String filename, int size) {							
		Set<String> ret = new HashSet<String>();	
		String line = null;		
		String[] vals = null;
		int count=0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));					
			while ((line = reader.readLine()) != null) {										
				vals = line.split("\t");			
				String library = vals[0].trim();					
				ret.add(library);
				count++;
				if(count==size)break;
			}			
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
						
		return ret;		
	}
	
	
	public Set<String> readGroundTruthFile(String filename) {							
		Set<String> ret = new HashSet<String>();	
		String line = null;		
		String[] vals = null;		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));					
			while ((line = reader.readLine()) != null) {										
				vals = line.split("\t");			
				String library = vals[1].trim();					
				ret.add(library);								
			}			
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}						
		return ret;		
	}
		
	
	public Map<Integer, String> getMostSimilarProjects(String filename, int size) {							
		Map<Integer, String> projects = new HashMap<Integer, String>();		
		String line = null;		
		String[] vals = null;		
		int count=0;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));						
			while ((line = reader.readLine()) != null) {										
				vals = line.split("\t");							
				String URI = vals[1].trim();		
				projects.put(count, URI);
				count++;
				if(count==size)break;
			}			
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
						
		return projects;		
	}
		
	
	public Map<Integer, Double> getSimilarityMatrix(String filename, int size) {							
		Map<Integer, Double> sim = new HashMap<Integer, Double>();		
		String line = null;		
		String[] vals = null;		
		int count=0;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));						
			while ((line = reader.readLine()) != null) {										
				vals = line.split("\t");			
				Double val = Double.parseDouble(vals[2].trim());
				sim.put(count, val);
				count++;
				if(count==size)break;
			}			
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
						
		return sim;		
	}

	
	
	public void parseBookCrossingDataset(String path, String fname) {
		
		String line="";
		String[] parts=null;		
		String filename = path + fname;		
		
		Map<String,Map<String,Integer>> bookRatings = new HashMap<String,Map<String,Integer>>();
		
		Map<String,Set<String>> newBookRatings = new HashMap<String,Set<String>>();
		
		Map<String,Integer> ratings;
		
		try {
			
			
			Set<String> Users = new HashSet<String>();
			Set<String> Items = new HashSet<String>();
			
			
			BufferedReader reader = new BufferedReader(new FileReader(filename));			
			while ((line = reader.readLine()) != null) {				
				line = line.trim();
				parts = line.split(";");				
				String userID = parts[0].trim();
				String bookID = parts[1].trim();
				int rating = Integer.parseInt(parts[2].trim());
				
				Users.add(userID);
				Items.add(bookID);
												
				if(bookRatings.containsKey(userID)) {
					ratings = bookRatings.get(userID);										
				} else {
					ratings = new HashMap<String,Integer>();			
				}				
				ratings.put(bookID, rating);				
				bookRatings.put(userID, ratings);
			}					
			System.out.println("number of users: " + bookRatings.size() );			
			reader.close();
			
			Set<String> keySet = bookRatings.keySet();
			
			
			
			
			
			Set<String> newRatings;
			
			for(String key:keySet){
				
				newRatings = new HashSet<String>();
				ratings = bookRatings.get(key);
				float total = 0;
				float avg = 0;
				
				int size = ratings.size();
										
				
				if(size>10) {					
					for(int r:ratings.values()){
						total+=r;
					}
					
					avg = (float)total/size;								
					if(avg>0) {						
						Set<String> keySet2 = ratings.keySet();						
						for(String key2:keySet2) {
							int r = ratings.get(key2);							
							if(r>avg) {
								newRatings.add(key2);								
							}						
						}						
						newBookRatings.put(key, newRatings);					
					}	
				}			
			}
			
						
			
			
			
			keySet = newBookRatings.keySet();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		return;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void parseBookCrossingDataset2(String path, String fname) {
		
		String line="";
		String[] parts=null;		
		String filename = path + fname;		
		
		Map<String,Map<String,Integer>> bookRatings = new HashMap<String,Map<String,Integer>>();
		
		Map<String,Integer> ratings;
		
		try {
			
			
			Set<String> Users = new HashSet<String>();
			Set<String> Items = new HashSet<String>();
			
			
			BufferedReader reader = new BufferedReader(new FileReader(filename));			
			while ((line = reader.readLine()) != null) {				
				line = line.trim();
				parts = line.split(";");				
				String userID = parts[0].trim();
				String bookID = parts[1].trim();
				int rating = Integer.parseInt(parts[2].trim());
				
				Users.add(userID);
				Items.add(bookID);
												
				if(bookRatings.containsKey(userID)) {
					ratings = bookRatings.get(userID);										
				} else {
					ratings = new HashMap<String,Integer>();			
				}				
				ratings.put(bookID, rating);				
				bookRatings.put(userID, ratings);
			}					
			System.out.println("number of users: " + bookRatings.size() );			
			reader.close();
			
			
			Set<String> keySet = bookRatings.keySet();
			
			Set<String> users = new HashSet<String>();
			
			
			
//			System.out.println("The number of users: " + Users.size());			
//			System.out.println("The number of items: " + Items.size());	
			
			
			
			
			
			for(String key:keySet){			
				ratings = bookRatings.get(key);
				float total = 0;
				float avg = 0;
				
				int size = ratings.size();										
				
				if(size>10) {					
					for(int r:ratings.values()){
						total+=r;
					}
					
					avg = (float)total/size;								
					if(avg>0) {						
						users.add(key);						
					}	
				}			
			}
			
			
			
			
			
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(path+"users.csv"));
			
			for(String user:users) {					
								
				ratings = bookRatings.get(user);			
				
				Set<String> books = ratings.keySet();
										
				writer.append(user);							
				writer.newLine();
				writer.flush();
				
				int index = 1;

				BufferedWriter writer2 = new BufferedWriter(new FileWriter(path+"dict_"+user));								
				String content = Integer.toString(index) + "\t" + user;								
				writer2.append(content);							
				writer2.newLine();
				writer2.flush();					
				
				BufferedWriter writer3 = new BufferedWriter(new FileWriter(path+"graph_"+user));
							
				int index2 = 2;
									
				for(String bookID:books) {
					
					String rating = Integer.toString(ratings.get(bookID));
										
					content = Integer.toString(index2) + "\t" + "#DEP#"+bookID+"%"+rating;
					
					writer2.append(content);							
					writer2.newLine();
					writer2.flush();
					
					content =  "1#" + Integer.toString(index2);										
					
					writer3.append(content);							
					writer3.newLine();
					writer3.flush();
					
					index2++;	
				}
				writer2.close();				
				writer3.close();							
			}
			
			
			
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		return;
	}
	
	
	
	
	
	
	
	
	
	
	
	public void parseGoodbooksDataset(String path, String fname) {
		
		String line="";
		String[] parts=null;		
		String filename = path + fname;		
		
		Map<String,Map<String,Integer>> bookRatings = new HashMap<String,Map<String,Integer>>();
		
		Map<String,Set<String>> newBookRatings = new HashMap<String,Set<String>>();
		
		Map<String,Integer> ratings;
		
		try {
			
			Set<String> Users = new HashSet<String>();
			Set<String> Items = new HashSet<String>();
			
			BufferedReader reader = new BufferedReader(new FileReader(filename));			
			while ((line = reader.readLine()) != null) {				
				line = line.trim();
				parts = line.split(",");				
				String userID = parts[0].trim();
				String bookID = parts[1].trim();
				int rating = Integer.parseInt(parts[2].trim());
				
				Users.add(userID);
				Items.add(bookID);
												
				if(bookRatings.containsKey(userID)) {
					ratings = bookRatings.get(userID);										
				} else {
					ratings = new HashMap<String,Integer>();			
				}				
				ratings.put(bookID, rating);				
				bookRatings.put(userID, ratings);
			}					
			System.out.println("number of users: " + bookRatings.size() );			
			reader.close();
			
			Set<String> keySet = bookRatings.keySet();
			
			
			
			
			
			
			
			
			Set<String> newRatings;
			
			for(String key:keySet){
				
				newRatings = new HashSet<String>();
				ratings = bookRatings.get(key);
				float total = 0;
				float avg = 0;
				
				int size = ratings.size();
										
				
				if(size>30) {					
					for(int r:ratings.values()){
						total+=r;
					}
					
					avg = (float)total/size;								
					if(avg>0) {						
						Set<String> keySet2 = ratings.keySet();						
						for(String key2:keySet2) {
							int r = ratings.get(key2);							
							if(r>avg) {
								newRatings.add(key2);								
							}						
						}
						if(newRatings.size()>80)newBookRatings.put(key, newRatings);					
					}	
				}			
			}
		
			
			
			System.out.println("The new size is: " + newBookRatings.size());			
			keySet = newBookRatings.keySet();
			reader.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		return;
	}
	
	
	
	public void countRatings(String path, String fname) {
		
		
		String filename = path + fname;		
		String line = "";
		String[] parts = null;
		
		Map<String,Integer> ratings = new HashMap<String,Integer>();
		
		
		try {
						
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			
			Set<String> users = new HashSet<String>();
			
			while ((line = reader.readLine()) != null) {
				line = line.trim();
				users.add(line);
			}
			reader.close();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(path+"ratings2.csv"));
			
			reader = new BufferedReader(new FileReader(path + "ratings.csv"));
			
//			writer.append("Score,System");
			
			while ((line = reader.readLine()) != null) {
				line = line.trim();
				parts = line.split(",");
								
				String userID = parts[0].trim();
				String rating = parts[2].trim();
				
				int count = 0;
				if(ratings.containsKey(rating))count = ratings.get(rating) + 1;
				else count = 1;
				
				ratings.put(rating, count);
				
				
			}

			Set<String> keySet = ratings.keySet();
			
			for(String key:keySet) {
				String content = key + "\t" + ratings.get(key);
				writer.append(content);							
				writer.newLine();
				writer.flush();				
			}
			reader.close();			
			writer.close();		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		return;		
	}
	
}