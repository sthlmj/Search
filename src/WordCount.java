/* 
 * WordCount
 * Labb 4 Uppgift 7
 *  
 *  /Users/joedan/Documents/EclipseWorkspace/Search/src/words.txt
 */

 import java.io.*;  
 import java.util.*;  

 class WordCount {  
	 
   public static void main(String[] unused) {
	   
	   /**
	    *Make scanner object 
	    */
     Scanner in = new Scanner(System.in); // scanner object.   
     int awords=0,uwords=0;   
     
     /**
      * try to read in a file name with exception handling.
      */
      try{  
           System.out.println("Enter your file name");  
           File inputfile = new File(in.nextLine());  //file
           Scanner words = new Scanner(inputfile);   //file to words
           words.useDelimiter("[^A-Za-z]+");  //ignore cases
           HashMap<String,Integer> words_fre = new HashMap<String,Integer>();	//make hash object  
           while(words.hasNext())  //while we have a word
                {  
                     String s = words.next().toString(); 	//words to string  
                     awords++; // word counts   
                     if(words_fre.containsKey(s))	//if duplicates a increment 
                          {  
                               int a = words_fre.get(s);
                               words_fre.put(s,a+1);             
                          }  
                     else {  
                          words_fre.put(s,1);  
                          uwords++; // unique words count   
                        }  
                }  
           /**
            * put word counts to an array and prints unique and duplicated words
            */
       Object[] key =   words_fre.keySet().toArray();
       Arrays.sort(key);  
       for (int i = 0; i < key.length; i++) {  //for print
      System.out.println(key[i]+"= "+words_fre.get(key[i]));  //print words
      }  
           System.out.println("Total Words = "+awords);  
           System.out.println("Unique Words = "+words_fre.size());  
        }catch(IOException e)  
           {  
                System.out.println(e);  
           }  
   }
 }