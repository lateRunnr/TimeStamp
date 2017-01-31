package tStamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class timeStampLatest {

    /**
     * @param args the command line arguments
     */
    
     static ArrayList<Integer> finalSet=new ArrayList<Integer>();
     static int maxMin=0;
     public static void main(String[] args) {
        // TODO code application logic here
       ArrayList<Integer> numbers=new ArrayList<Integer>();
       ArrayList<Integer> twoNumbers=new ArrayList<Integer>();
       ArrayList<Integer> oneNumbers=new ArrayList<Integer>();
       ArrayList<Integer> zeroNumbers=new ArrayList<Integer>();
       
        System.out.println("Enter minutes and hrs (hhmm) any format");
        Scanner obj=new Scanner(System.in);
        int n1 =obj.nextInt();
        numbers.add(n1);
        int n2=obj.nextInt();
        numbers.add(n2);
        int n3=obj.nextInt();
        numbers.add(n3);
        int n4=obj.nextInt();
        numbers.add(n4);
        twoNumbers=getCopy(numbers);
        oneNumbers=getCopy(numbers);
        zeroNumbers=getCopy(numbers);
        
        if(twoNumbers.contains(Integer.valueOf(2)))
        {   finalSet.add(Integer.valueOf(2));
            twoNumbers.remove(Integer.valueOf(2));
            String res=getMaxHourStamp(twoNumbers,2);
            if(res=="Valid")
            {
                printstamp();
              
            }
            finalSet.clear();
        }
        if(oneNumbers.contains(Integer.valueOf(1)))
        { 
            finalSet.add(Integer.valueOf(1));
          oneNumbers.remove(Integer.valueOf(1));
            String res=getMaxHourStamp(oneNumbers,1);  
            if(res=="Valid")
            {
                printstamp();
               
            }
            finalSet.clear();
        }
        if (zeroNumbers.contains(Integer.valueOf(0)))
        {   finalSet.add(Integer.valueOf(0));
            zeroNumbers.remove(Integer.valueOf(0));
            String res=getMaxHourStamp(zeroNumbers,0);
            if(res=="Valid")
            {
                printstamp();
               
            }
        }
        if(!numbers.contains(Integer.valueOf(2)) && !numbers.contains(Integer.valueOf(1)) && !numbers.contains(Integer.valueOf(2)))
        {
            System.exit(0);
        }
        
        
        
        
    }

    public static String getMaxHourStamp(ArrayList<Integer> numbers,int i) {
        HashMap<Integer,Integer>hours=new HashMap<Integer,Integer>();
        int num1=(i*10)+numbers.get(0);
        if(num1<24)
        hours.put(0, num1);    
        int num2=(i*10)+numbers.get(1);
        if(num2<24)
        hours.put(1, num2);
        int num3=(i*10)+numbers.get(2);
        if(num3<24)
        hours.put(2, num3);
        if(num1>=24 && num2>=24 && num3>=24)
        {   // invalid
            return("Invalid");
        }
        int maxValueInMap=(Collections.max(hours.values()));
        int h2=(int) getKeyFromValue(maxValueInMap,hours);
        finalSet.add(numbers.get(h2));
        numbers.remove(h2);
        String result=getMaxMinuteStamp(numbers);   
        return result;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static String getMaxMinuteStamp(ArrayList<Integer> numbers) {
        int min1=(numbers.get(0)*10)+(numbers.get(1));
        int min2=(numbers.get(1)*10)+(numbers.get(0));
        
        if(min1<60 && min2<60)
        {
            maxMin=Math.max(min1,min2);
        }
        else if(min1<60)
        {
            maxMin=min1;
        }
        else if(min2<60)
        {
            maxMin=min2;
        }
        else
        { System.out.println("Invalid");
          return("Invalid");
        }
        return("Valid");
       
        
        
        
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static Object getKeyFromValue(Object value_temp,HashMap<Integer,Integer>map) {
      for (Object o : map.keySet()) {
      if (map.get(o).equals(value_temp)) {
        return o;
      }
    }
    return null;
  }

    public static void printstamp() {
        String m1,m2,m;
        String h1=String.valueOf(finalSet.get(0));
        String h2=String.valueOf(finalSet.get(1));
        String h=h1.concat(h2);
        if(maxMin>=0 && maxMin <10)
        {   m1="0";
            m2=String.valueOf(maxMin);
            m=m1.concat(m2);
        }
        else
        { 
          m=String.valueOf(maxMin);
        }
        String maxTimeStamp=h.concat(m);
        System.out.println("Time Stamp "+maxTimeStamp);
        System.exit(0);
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static ArrayList<Integer> getCopy(ArrayList<Integer> numbers) {
      
        ArrayList <Integer> temp=new ArrayList<Integer>();
        for(int i=0;i<numbers.size();i++)
       {
           temp.add(numbers.get(i));
       }
        return temp;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
