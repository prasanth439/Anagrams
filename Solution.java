
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
	// public static String SelectionSortIt(String s){
	// 	char[] b = s.toCharArray();
	// 	char temp='c' ;
	// 	int a = s.length();
	// 	for(int i=0;i<a;i++){
	// 		for(int j=0;j<i;j++){

	// 		}
	// 	}		
	// }
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
		mainVocabulary[0] = null;
		for(int i = 1;i<= V;i++){
			mainVocabulary[i] = s.nextLine();
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
		//System.out.println(convert("'".charAt(0)));
		//System.out.println(mainVocabulary[V]);
		//System.out.println(SortIt(mainVocabulary[V]));
		System.out.println(CastIt(((Object[])o[19][4])[23]));
		//System.out.println((int)'z'+"-is a"+"\n"+(int)(("'").charAt(0))+" is apostraphi"+"\n"+(int)' '+"-is space "+"\n"+(int)'9'+"-is number 0");
		System.out.println("all words entered");
	}
}