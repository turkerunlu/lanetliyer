
public class Backtrack {
 State intial;
 CSP csp;

public Backtrack(State intial) {
	this.intial = intial;
	csp=new CSP();
}
public State getsolved(){
	return Solve(intial);
}
public State Solve(State st){
	if(csp.consisted(st) || st.getVaraibles().size()==81) return st;
	if(!csp.controlsum(st))  return null;
	Integer newvar=getVariable(st);
	
	
	
	if(st.getDomain().get(newvar).size()==0) return null;
	for(Integer val:st.getDomain().get(newvar)){
	
		State newst=new State(st);
		newst.add(newvar,val);
		
		try{
		csp.inference(newst, newvar, val);
		
		}
		catch (IllegalStateException e) {
		
	        continue;
	      }
		newst=Solve(newst);
		
		if(newst!=null) return newst;
	}

	return null;
	
}
public Integer MRV(State st){
	Integer least=0;
	for(Integer i=1;i<81;i++){
		if(st.getDomain().get(least).size()>(st.getDomain().get(least).size())) least=i;
	}
	return least;
	
}
public Integer getVariable(State st){
	for(Integer i=0;i<81;i++){
		if(!st.getVaraibles().containsKey(i)) return i;
	}
	return 0;
}
public void printdomain(State st){
	for(int i=0;i<5;i++){
		System.out.print(i+": ");
		for(int j:st.getDomain().get(i)){
			System.out.print(j+", ");
			
		}
		System.out.println();
	}
}
	
	
}
