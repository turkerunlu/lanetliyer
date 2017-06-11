import java.util.List;

public class SumConstraint extends Constraint {
	private List<Integer> consVariables;
	int limit;
	@Override
	public List<Integer> getConsVariables() {
		return consVariables;
	}

	public void setConsVariables(List<Integer> consVariables) {
		this.consVariables = consVariables;
	}

	public SumConstraint(List<Integer> consVariables,int limit) {
		this.limit=limit;
		this.consVariables = consVariables;
		
	}
public boolean control(State st){
	int sum=0;
	for(Integer v:consVariables){
		   Integer val = (Integer) st.getVaraibles().get(v);
		   if(val!=null) sum +=val;
		   
		   else return true;
	}
	
if(sum !=limit)	return false;
else return true;
}
	@Override
	public boolean satisfied(State st) {
		int sum=0;
		for(Integer v:consVariables){
			   Integer val = (Integer) st.getVaraibles().get(v);
			   if(val!=null) sum +=val;
		}
		
	if(sum !=limit)	return false;
	else return true;
	}

	@Override
	public String descrip() {
		String desc = "Constraint on {\n";
	      for (int v : consVariables) {
	        desc += "\t"+v+"\n";
	      }
	      desc +="}";
	      return desc;
	}

	@Override
	public boolean consistent(State st) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Integer> reliesOn() {
		return consVariables;
	}
	@Override
	public boolean isin(int i){
		return consVariables.contains(i);
	}
	
	public void restrictdomain(State s,int Variable,int Value){
		int sum=0;
		for(Integer v:consVariables){
			   Integer val = (Integer) s.getVaraibles().get(v);
			   if(val!=null) sum +=val;
		}
		if(limit-sum>8) return;
		for(int i:consVariables)
			{
			for(int j=sum-limit+1;j<10;j++){
				if(s.getDomain().get(i).contains(j)) s.getDomain().get(i).remove(j);
			}
			}
	}
	
	

}
