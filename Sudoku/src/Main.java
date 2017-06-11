
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CSP csp=new CSP();
		State st=new State();
		addvalues(st,csp);
		//st.print();
	//printdomain(st);
	Backtrack b=new Backtrack(st);
	st=b.getsolved();
	st.print();
	}
	
	private static void addvalues(State st,CSP csp){
		st.add(22, 7);
		csp.inference(st,22,7);
		
		st.add(38,6);
		csp.inference(st,38,6);
		
		st.add(40, 3);
		csp.inference(st,40,3);
		
		st.add(42, 9);
		csp.inference(st,42,9);
		
		st.add(58, 2);
		csp.inference(st,58,2);
	}
	
	public static void printdomain(State st){
		for(int i=0;i<5;i++){
			System.out.print(i+": ");
			for(int j:st.getDomain().get(i)){
				System.out.print(j+", ");
				
			}
			System.out.println();
		}
	}
	

}
