import java.util.*;
class SamActivity{
	String pass = "samPayu@2510";
	int intillegnce;
	int anger_level;
	boolean personisGoodOrBad;
	int loyalty;
	String lovesWho;
	SamActivity(int i,int al,boolean pgb,int l,String lw)
	{
		this.intillegnce = i;
		this.anger_level = al;
		this.personisGoodOrBad = pgb;
		this.loyalty = l;
		this.lovesWho = lw;
	}
	public String[] get_samDetails(String passWord){
		if(pass.equals(passWord))
		{
			String arr[] = new String[5];
			arr[0] = intillegnce+"";
			arr[1] = anger_level+"";
			arr[2] = personisGoodOrBad+"";
			arr[3] = loyalty+"";
			arr[4] = lovesWho;
			return arr;
		}else{
			return new String[]{};
		}
	} 
}
class SamWifesActivity extends SamActivity{
  Map<String,String> SamWifeInfo = new HashMap<>();
  String swpass = "Pasam@143";
  SamWifesActivity(int i,int al,boolean pgb,int l,String pw, Map<String,String>samWifeInfom)
  {
  	super(i,al,pgb,l,pw);
  	this.SamWifeInfo = samWifeInfom; 
  }
  public Map<String,String> get_samwifeDetails(String pas)
  {
  	if(pas.equals(swpass))
  	{
  		return SamWifeInfo;
  	}
  	else{
  		return new HashMap<String,String>();
  	}
  }
}
class SamChild extends SamWifesActivity{
	String scpass= "Pasam@son";
	Map<String,String> scinfo = new HashMap<>();
	SamChild(int i,int al,boolean pgb,int l,String pw, Map<String,String>samWifeInfom,Map<String,String> scinf)
	{
		super(i,al,pgb,l,pw,samWifeInfom);
		this.scinfo = scinf;
	}

  public Map<String,String> get_samChildDetails(String pas)
  {
  	if(pas.equals(scpass))
  	{
  		return scinfo;
  	}
  	else{
  		return new HashMap<String,String>();
  	}
  }
}

class SamsFamily{
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         String va[] = {"intillegnce","anger_level","personisGoodOrBad","loyalty","loves"};
         Map<String,String> swi = new HashMap<>();
         System.out.println("Enter the task for wife");
         for(int i = 0;i<5;i++){
         	String t = sc.next();
         	String v = sc.next();
         	swi.put(t,v);
         }
         Map<String,String> sci = new HashMap<>();
         System.out.println("Enter the task for child");
         for(int i = 0;i<5;i++){
         	String t = sc.next();
         	String v = sc.next();
         	sci.put(t,v);
         }
         System.out.println("Enter the task for sam");
     	 int intillegnce = sc.nextInt();
		 int anger_level = sc.nextInt();
		 boolean personisGoodOrBad = sc.nextBoolean();
		 int loyalty=sc.nextInt();
		 String lovesWho = sc.next();
		 SamChild sch = new SamChild(intillegnce,anger_level,personisGoodOrBad,loyalty,lovesWho,swi,sci);
		 for (int j = 0;j < 3 ;j++ ) {
			 System.out.println("Get Info of :");
			 System.out.println("1.sam\n2.wife\n3.child");
			 int ch = sc.nextInt();
			 switch(ch)
			 {
		 	 case 1 :
		 	        System.out.println("Enter the sam password");
		 	        String sp = sc.next();     
		 	        String[]sda = sch.get_samDetails(sp);
		 	        for(int i= 0;i<5;i++)
		 	        {
		 	          System.out.println("Sam is having "+va[i]+":"+sda[0]);	
		 	        }
		 	        break;
		 	 case 2 :
		 	        System.out.println("Enter the wife password");
		 	        String sp1 = sc.next();     
		 	        Map<String,String>swd = sch.get_samwifeDetails(sp1);
		 	        if(swd.size() == 0)
		 	        {
		 	        	System.out.println("No data Found/Incorrect Password");
		 	        	break;
		 	        }
		 	        for ( String k : swd.keySet()) {
		 	        	System.out.println("Sam Wife having " + k +" :" + swd.get(k));
		 	        }
		 	        break;     
		 	 case 3: 
		 	        System.out.println("Enter the child password");
		 	        String sp2 = sc.next();     
		 	        Map<String,String>scd = sch.get_samChildDetails(sp2);
		 	        if(scd.size() == 0)
		 	        {
		 	        	System.out.println("No data Found/Incorrect Password");
		 	        	break;
		 	        }
		 	        for ( String k : scd.keySet()) {
		 	        	System.out.println("Sam child having " + k +" :" + scd.get(k));
		 	        }
		 	        break;  

		 	 default: System.out.println("wrong choice");
		 	          break;  
		 }
		 	
		 }
		 
     }
}