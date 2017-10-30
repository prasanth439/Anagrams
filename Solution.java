
import java.util.Scanner;
import java.io.File;
import java.util.Vector;
/*
	compareTo(String s);
	contains(String s);

*/
/*ASCII ORDER
					
        SPACE APOSTRAPHI NUMBER ALPHABET

*/
class NumberStringCarrier{
	public int index;
	public String wellOrder;
	public NumberStringCarrier(int i,String s){
		index = i;
		wellOrder = s;
	}
	public String toString(){
		return index+"="+wellOrder;
	}
}
public class Solution{



	public static String SortIt(String s){
		char[] b = s.toCharArray();
		char temp='c' ;
		int a = s.length();
		for(int i=0;i<a;i++){
			for(int j=0;j<a-1;j++){
				if(b[j]>b[j+1]){
					temp = b[j];
					b[j]=b[j+1];
					b[j+1]=temp;
				}
			}
		}
		return new String(b);
	}

	public static int convert(char s){
		int y = (int)s;
		if(y==39){
			return 1;
		}
		else if(y<=57){
			return (y-48)+2;
		}
		else{
			return y-97+12;
		}
	}
	public static Vector CastIt(Object c){
		return (Vector)c;
	}
	public static void main(String[] args){
		long startTime = System.currentTimeMillis();


		File f = new File(args[0]);
		Object[][] o = new Object[38][13];
		o[0] = null;
		for(int i =1;i<38;i++){
			//o[i]= new Object[13];
			o[i][0] = null;
			for(int j =1;j<4;j++){
				o[i][j] = new Vector<NumberStringCarrier>();
			}
			for(int j=4;j<13;j++){
				o[i][j] = new Object[38];
				((Object[])o[i][j])[0]=null;
				for(int k= 1;k<38;k++){
					((Object[])o[i][j])[k] = new Vector<NumberStringCarrier>();
				}
			}
		}
		Scanner s = null;
		try{
			s=new Scanner(f);
		}
		catch(Exception e){
			System.out.println("Error occurred while scanning file");
		}
		String cargo = null;
		char support ='1';
		int size =0;
		int V = Integer.parseInt(s.nextLine());
		String[] mainVocabulary = new String[V+1];
		String solo = null;
		mainVocabulary[0] = null;
		for(int i = 1;i<= V;i++){
			solo = s.nextLine();
			if(solo.length()<=12)
			mainVocabulary[i] = solo;
			else{
				continue;
			}
			size = mainVocabulary[i].length();
			if(size<=12){
				cargo = SortIt(mainVocabulary[i]);
				if(convert(cargo.charAt(0))==-8){
					//System.out.println(cargo.charAt(0));
					continue;
				}
				if(size<4){
					CastIt(o[convert(cargo.charAt(0))][size]).add(new NumberStringCarrier(i,cargo));
				}
				else{
					CastIt(((Object[])(o[convert(cargo.charAt(0))][size]))[convert(cargo.charAt(size/2))]).add(new NumberStringCarrier(i,cargo));
				}
			}
		}

		File f2 = new File(args[1]);
		Scanner g = null;
		try{
			g = new Scanner(f2);
		}
		catch(Exception e){
			System.out.println("file not found");
		}
		int L = Integer.parseInt(g.nextLine());
		String[] inputArr = new String[L];
		String[] sortedInput = new String[L];
		Vector<NumberStringCarrier> req =null;
		for(int i=0;i<L;i++){
			inputArr[i]=g.nextLine();
			sortedInput[i]=SortIt(inputArr[i]);
			PrintAnagram(sortedInput[i],o,req,mainVocabulary);
		}

long endTime   = System.currentTimeMillis();
long totalTime = endTime - startTime;
System.out.println(totalTime);
	}

	public static void PrintAnagram(String sortedInput,Object[][] o,Vector<NumberStringCarrier> req,String[] mainVocabulary){
		int sizeOf = sortedInput.length();
		char first = sortedInput.charAt(0);
		if(sizeOf>=4)
 req = CastIt(((Object[])(o[convert(first)][sizeOf]))[convert(sortedInput.charAt(sizeOf/2))]);
		else
req = CastIt(o[convert(first)][sizeOf]);
		//System.out.println(sortedInput[0]);
		for(int i =0;i<req.size();i++){
			//System.out.println(mainVocabulary[(req.get(i)).index]);
			if(sortedInput.equals((req.get(i)).wellOrder)){
				System.out.println(mainVocabulary[(req.get(i)).index]);
			}
		}
		System.out.println("-1");		
	}


}