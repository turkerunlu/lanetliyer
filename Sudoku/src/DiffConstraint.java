import java.util.List;

public class DiffConstraint extends Constraint {
	private List<Integer> consVariables;
	
	
	@Override
	public List<Integer> getConsVariables() {
		return consVariables;
	}

	public void setConsVariables(List<Integer> consVariables) {
		this.consVariables = consVariables;
	}

	public DiffConstraint(List<Integer> consVariables) {
		super();
		this.consVariables = consVariables;
		
	}

	@Override
	public boolean satisfied(State st) {
		boolean[] seen = new boolean[10];
	      for (Integer v : consVariables) {
	        Integer val = (Integer)st.getVaraibles().get(v);
	        if (val == null || seen[val])  {
	          return false;
	        }
	        seen[val] = true;
	      }
	      return true;
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
		for(int i:consVariables)
			{
			if(i!=Variable && s.getDomain().get(i).contains(Value) )s.getDomain().get(i).remove(Value);}}

}
