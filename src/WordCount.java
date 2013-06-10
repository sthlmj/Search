/* 
 * WordCount
 * Labb 4 Uppgift 7
 *  
 */

 import java.io.*;  
 import java.util.*;  
 class WordCount {  
   public static void main(String[] unused) {  
     Scanner in = new Scanner(System.in); // scanner object.   
      int awords=0,uwords=0;   
      try{  
           System.out.println("Enter your file name");  
           File inputfile = new File(in.nextLine());  
           Scanner words = new Scanner(inputfile);   
           words.useDelimiter("[^A-Za-z]+");  
           HashMap<String,Integer> words_fre = new HashMap<String,Integer>();  
           while(words.hasNext())  
                {  
                     String s = words.next().toString();   
                     awords++; // words count   
                     if(words_fre.containsKey(s))  
                          {  
                               int a = words_fre.get(s);  
                               words_fre.put(s,a+1);             
                          }  
                     else {  
                          words_fre.put(s,1);  
                          uwords++; // unique words count   
                        }  
                }  
       Object[] key =   words_fre.keySet().toArray();   
       Arrays.sort(key);  
       for (int i = 0; i < key.length; i++) {  
      System.out.println(key[i]+"= "+words_fre.get(key[i]));  
      }  
           /*//words_fre = getSortedMap(words_fre);  
           Set<String> keys = words_fre.keySet();  
           Iterator list = keys.iterator();   
           while(list.hasNext())  
           {  
                String ss = list.next().toString();   
                System.out.println(ss+" = "+words_fre.get(ss));  
           }*/  
           System.out.println("Total Words = "+awords);  
           System.out.println("Unique Words = "+words_fre.size());  
        }catch(IOException e)  
           {  
                System.out.println(e);  
           }  
   }
 }