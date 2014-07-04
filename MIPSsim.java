
// javac MIPSsim.java
// On my honor, I have neither given nor received unauthorized aid on this assignment
//Author Akchay Srivastava 1799-1933

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class MIPSsim
{

	List<String> arraylistIM = new ArrayList<String>();
	List<String> arraylistRead = new ArrayList<String>();
	List<String> arraylistIBUP = new ArrayList<String>();
	List<String> arraylistIBDOWN = new ArrayList<String>();
	List<String> arraylistSBUP = new ArrayList<String>();
	List<String> arraylistSBDOWN = new ArrayList<String>();
	List<String> arraylistMBUP = new ArrayList<String>();
	List<String> arraylistMBDOWN = new ArrayList<String>();
	List<String> arraylistPBUP = new ArrayList<String>();
	List<String> arraylistPBDOWN = new ArrayList<String>();
	List<String> arraylistRBUP = new ArrayList<String>();
	List<String> arraylistRBDOWN = new ArrayList<String>();
	HashMap<String, String> map = new HashMap<String, String>();
	StringBuilder output = new StringBuilder();
	void readfiles(String args, String args2) throws IOException
	{
		
	
    BufferedReader in = new BufferedReader(new FileReader(args2));
    String line = "";
    String key="";
  
    int x=0;
    int temp=0;
    String newkey="";
    String a1="";
    String a2="";
    
    while ((line = in.readLine())!= null) 
    {
        
    	for(int i=0; i<line.length(); i++)
    	{
    		if (line.charAt(i)=='<')
    			x=i+1;
    		if (line.charAt(i)==',')
    			{
    			key= line.substring(x,i);
    			x=i+1;
    			}
    		if (line.charAt(i)=='>')
    		  {
    			a1= line.substring(x,i);
    			i+=1;
    			map.put(key, a1);
    		  }
}
	
} in.close();

	    String sCurrentLine;
	    String sCurrentLine1;
	    Scanner s = new Scanner(new File(args));
	    while (s.hasNext()){
	        arraylistIM.add(s.next());
	    }
	    s.close();
	  
	    

	}
	   void decode()
		{
		   if(arraylistIM.size()>0)
    	   {
    		 
		  String a=new String();
		  int i =0;
			  a=a.concat(arraylistIM.get(i));
			  String[] s = a.split(",");
			  String d1temp = new String(s[0]);
			  String d1=d1temp.substring(1,d1temp.length());
			  String d2 = new String(s[1]);
			  String d3 = new String(s[2]); 
			  String d4temp = new String(s[3]); 
			  String d4=d4temp.substring(0,d4temp.length()-1);
			  
			  int []g=readreg(d3,d4);
			  
			  if ( g[0]!=-1 && g[1]!=-1)
			  
			  {
				  String str1 = Integer.toString(g[0]);
				  String str2 = Integer.toString(g[1]);
				  String newtoken =new String();
				  newtoken="";
				  String newtoken1=new String();
				  newtoken1=newtoken.concat("<").concat(d1).concat(",").concat(d2).concat(",").concat(str1).concat(",").
						  concat(str2).concat(">");
				  arraylistIBUP.add(newtoken1);
				  arraylistIM.remove(i);
				 
			  }     
		       else
			  {
				 
			  }
			  d1=null; d1temp=null; d2=null; d3=null; d4=null; d4temp=null;
			}
		}
			
	
	  int[] readreg (String c1, String c2)
		 
	  {
		 
	        
	        boolean b1 = map.containsKey(c1);
	        boolean b2 = map.containsKey(c2);
	        int[] karray = {0 , 0};
	         if (b1 && b2)
	           {
	           
	           String k = map.get(c1);
	 	       String k1= map.get(c2);
	 	       karray[0]=Integer.parseInt(k);
	 	       karray[1]=Integer.parseInt(k1);
	 	       return karray;
	           }
	         else 
	        	{
	        	karray[0]=-1;
	            karray[1]=-1;	  
	            return karray;
	            }
		     
		 }
  
       void issue1()
       {
    	   if(arraylistIBDOWN.size()>0)
    	   {
    		   
    		   String a=new String();
    			 a=a.concat(arraylistIBDOWN.get(0));
    			 String[] s = a.split(",");
    			 String d1temp = new String(s[0]);
    			 String d1=d1temp.substring(1,d1temp.length());
    			 String d2 = new String(s[1]);
    			 String d3 = new String(s[2]); 
    			 String d4temp = new String(s[3]); 
    			 String d4=d4temp.substring(0,d4temp.length()-1);
    			 if (d1.equals("ADD") || d1.equals("SUB"))
			     {
    					arraylistSBUP.add(arraylistIBDOWN.get(0));
    		        	arraylistIBDOWN.remove(0);
    		        	
			     }  
        	}
    	   
    	   else 
       	{
       	}
       }
        
       void issue2()
      {
	
    	   if(arraylistIBDOWN.size()>0)
    	   {
    		   
    		   String a=new String();
    			 a=a.concat(arraylistIBDOWN.get(0));
    			 String[] s = a.split(",");
    			 String d1temp = new String(s[0]);
    			 String d1=d1temp.substring(1,d1temp.length());
    			 String d2 = new String(s[1]);
    			 String d3 = new String(s[2]); 
    			 String d4temp = new String(s[3]); 
    			 String d4=d4temp.substring(0,d4temp.length()-1);
    			 if (d1.equals("MUL") || d1.equals("DIV"))
			     {
    					arraylistMBUP.add(arraylistIBDOWN.get(0));
    		        	
    		        	arraylistIBDOWN.remove(0);
			     }  
        	}
    	   
    	   else 
       	{
       	}
 
      }
       
       void asu()
       {
    	   if(arraylistSBDOWN.size()>0)
    	   {
    		
    	   int i=0; int result=0;
    	   String as1=new String ();
    	   as1="";
    	   String as2=new String ();
    	   as2= as1.concat(arraylistSBDOWN.get(i));
		   String[] s = as2.split(",");
		   String d1temp= new String(s[0]);
		   String d1= d1temp.substring(1,d1temp.length());
		   String d2= new String(s[1]);
		   String d3 = new String(s[2]); 
		   String d4temp = new String(s[3]); 
		   String d4=d4temp.substring(0,d4temp.length()-1);
		   
		   int op1=Integer.parseInt(d3);
		   int op2=Integer.parseInt(d4);
		   
		   if(d1.equals("ADD"))
		   {
			   result=op1+op2;
			  
		   }
		   else if (d1.equals("SUB"))
		   {
			   result=op1-op2;
			   
		   }
		   
		   String snew= Integer.toString(result);
		   String newtoken1 = new String();
		   newtoken1="";
		   String newtoken2 = new String();
		   newtoken2="";
		   newtoken2=newtoken1.concat("<").concat(d2).concat(",").concat(snew).concat(">");
		   arraylistRBUP.add(newtoken2);
		   arraylistSBDOWN.remove(i);
		}
       }
       
       void mdu1()
       
       {
    	   if(arraylistMBDOWN.size()>0)
    	   {
    	   int i=0; int result=0;
    	   String as1=new String ();
    	   as1="";
    	   String as2=new String ();
    	   as2= as1.concat(arraylistMBDOWN.get(i));
		   String[] s = as2.split(",");
		   String d1temp= new String(s[0]);
		   String d1= d1temp.substring(1,d1temp.length());
		   String d2= new String(s[1]);
		   String d3 = new String(s[2]); 
		   String d4temp = new String(s[3]); 
		   String d4=d4temp.substring(0,d4temp.length()-1);
		 
		   String newtoken1 = new String();
		   newtoken1="";
		   String newtoken2 = new String();
		   newtoken2="";
		   newtoken2=newtoken1.concat("<").concat(d1).concat(",").concat(d2).concat(",").concat(d3).concat(",").concat(d4).concat(">");
		   arraylistPBUP.add(newtoken2);
		   arraylistMBDOWN.remove(i);
    	   }
        }
       
       
       void mdu2()
       
        {
    	   if(arraylistPBDOWN.size()>0)
    	   {
    	   int i=0; int result=0;
    	   String as1=new String ();
    	   as1="";
    	   String as2=new String ();
    	   as2= as1.concat(arraylistPBDOWN.get(i));
		   String[] s = as2.split(",");
		   String d1temp= new String(s[0]);
		   String d1= d1temp.substring(1,d1temp.length());
		   String d2= new String(s[1]);
		   String d3 = new String(s[2]); 
		   String d4temp = new String(s[3]); 
		   String d4=d4temp.substring(0,d4temp.length()-1);
		   
		   int op1=Integer.parseInt(d3);
		   int op2=Integer.parseInt(d4);
		   
		   if(d1.equals("MUL"))
		   {
			   result=op1*op2;
			  
		   }
		   else if (d1.equals("DIV"))
		   {
			   result=op1/op2;
			   
		   }
		   
		   String snew= Integer.toString(result);
		   String newtoken1 = new String();
		   newtoken1="";
		   String newtoken2 = new String();
		   newtoken2="";
		   newtoken2=newtoken1.concat("<").concat(d2).concat(",").concat(snew).concat(">");
		   arraylistRBUP.add(newtoken2);
		   arraylistPBDOWN.remove(i);
    	   }
        }

    	  void movetokens()
    	  {
    		  for (int j=0;j<arraylistIBUP.size();j++)
    		  {
    			  String temp = arraylistIBUP.get(j);
    			  arraylistIBDOWN.add(temp);
    			     		  
    		  }
    		  arraylistIBUP = new ArrayList<String>(); 
    		  for (int j=0;j<arraylistSBUP.size();j++)
    		  {
    			  arraylistSBDOWN.add(arraylistSBUP.get(j));
    			     		  
    		  }
    		  arraylistSBUP = new ArrayList<String>();
    		  for (int j=0;j<arraylistMBUP.size();j++)
    		  {
    			  arraylistMBDOWN.add(arraylistMBUP.get(j));
    			     		  
    		  }
    		  arraylistMBUP = new ArrayList<String>();
    		  for (int j=0;j<arraylistPBUP.size();j++)
    		  {
    			  arraylistPBDOWN.add(arraylistPBUP.get(j));
    			     		  
    		  }
    		  arraylistPBUP = new ArrayList<String>();
    		  for (int j=0;j<arraylistRBUP.size();j++)
    		  {
    			  arraylistRBDOWN.add(arraylistRBUP.get(j));
    			     		  
    		  }
    		  arraylistRBUP = new ArrayList<String>();
    		
    	  }
       
       void write()
       {
    	   if(arraylistRBDOWN.size()>0)
    	   {
    	   int i=0;
    	 
    	   String as1=new String ();
    	   as1="";
    	   String as2=new String ();
    	   as2= as1.concat(arraylistRBDOWN.get(i));
		   String[] s = as2.split(",");
		   String d1temp= new String(s[0]);
		   String d1= d1temp.substring(1,d1temp.length()); 
		   String d2temp = new String(s[1]); 
		   String d2=d2temp.substring(0,d2temp.length()-1);
		   map.put(d1,d2);
    	   arraylistRBDOWN.remove(i);
    	   }
       }
       
  public static void main(String args[])
  {
	  int time = 0;
	  MIPSsim obj=new MIPSsim();
	  try {
		obj.readfiles(args[1],args[3]);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	  while (!( obj.arraylistIM.size()==0 && obj.arraylistIBUP.size()==0   && obj.arraylistSBUP.size()==0 && obj.arraylistSBDOWN.size()==0
			  && obj.arraylistMBUP.size()==0 && obj.arraylistMBDOWN.size()==0 && obj.arraylistPBUP.size()==0 && obj.arraylistPBDOWN.size()==0 &&
			  obj.arraylistRBUP.size()==0 && obj.arraylistRBDOWN.size()==0))
	  {
		  obj.appendOutputFile(time);
		  obj.decode();
		  obj.issue1();
		  obj.issue2();
		  obj.mdu1();
		  obj.mdu2();
		  obj.asu();
		  obj.write();
		  obj.movetokens();
		  time++;
	  }
	  obj.appendOutputFile(time);
	  
	  //System.out.println(obj.output.toString());
	  obj.outputfile(args[5]);
  }
  
private void outputfile(String file) {
	  PrintWriter printWriter = null;
      try {
          // Will overwrite the file if exists or creates new
          printWriter = new PrintWriter(file);
          printWriter.println(output.toString());
      } catch (FileNotFoundException fileNotFoundException) {
          fileNotFoundException.printStackTrace();
      } finally {
          printWriter.close();
      }
	
}
private void appendOutputFile(int time) {
	output.append('\n');
output.append("STEP["+time+"]:"+"\n");

		output.append("IM:");
		String temp = "";
		for(int i =0;i<arraylistIM.size();i++)
		{
			if(i!=0)
			{
				temp =temp.concat(",");
			}
			temp = temp.concat(arraylistIM.get(i));
		}
		output.append(temp);
		output.append('\n');
		
		
		output.append("IB:");
		String temp1 = "";
		for(int i =0;i<arraylistIBDOWN.size();i++)
		{
			if(i!=0)
			{
				temp1 =temp1.concat(",");
			}
			temp1 = temp1.concat(arraylistIBDOWN.get(i));
		}
		output.append(temp1);
		output.append('\n');
		
		output.append("SB:");
		String temp2 = "";
		for(int i =0;i<arraylistSBDOWN.size();i++)
		{
			if(i!=0)
			{
				temp2 =temp2.concat(",");
			}
			temp2 = temp2.concat(arraylistSBDOWN.get(i));
		}
		output.append(temp2);
		output.append('\n');
		
		output.append("MB:");
		String temp3 = "";
		for(int i =0;i<arraylistMBDOWN.size();i++)
		{
			if(i!=0)
			{
				temp3 =temp3.concat(",");
			}
			temp3 = temp3.concat(arraylistMBDOWN.get(i));
		}
		output.append(temp3);
		output.append('\n');
		
		output.append("PB:");
		String temp4 = "";
		for(int i =0;i<arraylistPBDOWN.size();i++)
		{
			if(i!=0)
			{
				temp4 =temp4.concat(",");
			}
			temp4 = temp4.concat(arraylistPBDOWN.get(i));
		}
		output.append(temp4);
		output.append('\n');
		
		output.append("RB:");
		String temp5 = "";
		Boolean flg = false;
		for(int j=0;j<8;j++)
		{
			String reg = "";
			
			reg = reg.concat("R");
			reg = reg.concat(Integer.toString(j));
			for(int i =0;i<arraylistRBDOWN.size();i++)
				{
				if(arraylistRBDOWN.get(i).contains(reg))
				{
					if(flg)
					{
					temp5=	temp5.concat(",");
					}
					flg = true;
					temp5 = temp5.concat(arraylistRBDOWN.get(i));
				}
					
				}
		}
		
		output.append(temp5);
		output.append('\n');
		
		output.append("RF:");
		Boolean flg2 = false;
		String temp6 = "";
		for(int j=0;j<8;j++)
		{
			String reg = "";
			reg = reg.concat("R");
			reg = reg.concat(Integer.toString(j));
			if(map.containsKey(reg))
			{
				if(flg2)
				{
					temp6 =temp6.concat(",");
				}
				flg2 = true;
				temp6 = temp6.concat("<"+reg+","+map.get(reg)+">");
			  
			}
			}
		output.append(temp6);
		
		output.append('\n');
}

}
					
			
			
			

