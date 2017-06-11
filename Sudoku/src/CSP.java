import java.util.*;

import javax.swing.SpringLayout.Constraints;


public class CSP  {
	List<Constraint> constraints;
	List<SumConstraint> sumconstraints;
	Map<Integer,List<Constraint>> depends;
	public CSP() {
	
		constraints=new LinkedList<Constraint>();
		sumconstraints=new LinkedList<SumConstraint>();
		depends= new HashMap<Integer,List<Constraint>>();
		
		for(int row=0;row<9;row++){
			List<Integer> l=new LinkedList<Integer>();
			for(int col=0;col<9;col++){
				l.add((row*9)+col);
			}
			Constraint cs=new DiffConstraint(l);
			
			constraints.add(cs);
		}
		
		for(int col=0;col<9;col++){
			List<Integer> l=new LinkedList<Integer>();
			for(int row=0;row<9;row++){
				l.add((row*9)+col);
			}
			Constraint cs=new DiffConstraint(l);
			
			constraints.add(cs);
		}
		
		  for (int gridRow=0;gridRow<3;gridRow++) {
		        for (int gridCol=0;gridCol<3;gridCol++) {
		        	List<Integer> l=new LinkedList<Integer>();
		          for (int row=0;row<3;row++) {
		            for (int col=0;col<3;col++) {
		              l.add((gridRow*3+row)*9 + gridCol*3+col);
		            }
		          }
		          constraints.add(new DiffConstraint(l));
		        }
		      }
		  
		  
		  
		  // sum constraits 
		  
		  List<Integer> l=new LinkedList<Integer>();
		  l.add(21);
		  l.add(22);
		  l.add(13);
		  SumConstraint sumc=new SumConstraint(l,11);
		  constraints.add(sumc);
		  sumconstraints.add(sumc);
		  
		  //-/----------
		  
		  l=new LinkedList<Integer>();
		  l.add(0);
		  l.add(9);
		  l.add(18);
		  l.add(10);
		  sumc=new SumConstraint(l,19);
		  constraints.add(sumc);
		  sumconstraints.add(sumc);
		  
		  
 //-/----------
		  
		  l=new LinkedList<Integer>();
		  l.add(1);
		  l.add(2);
		  l.add(3);
		  l.add(4);
		  sumc=new SumConstraint(l,17);
		  constraints.add(sumc);
		  sumconstraints.add(sumc);
		  
 //-/----------
		  
		  l=new LinkedList<Integer>();

		  l.add(19);
		  l.add(27);
		  l.add(28);
		  sumc=new SumConstraint(l,12);
		  constraints.add(sumc);
		  sumconstraints.add(sumc);
		  
 //-/----------
		  
		  l=new LinkedList<Integer>();
		  l.add(11);
		  l.add(12);
		  l.add(20);
		  sumc=new SumConstraint(l,21);
		  constraints.add(sumc);
		  sumconstraints.add(sumc);
		  
		  
 //-/----------
		  
		  l=new LinkedList<Integer>();
		  l.add(6);
		  l.add(7);
		  l.add(8);
		  l.add(5);
		  sumc=new SumConstraint(l,21);
		  constraints.add(sumc);
		  sumconstraints.add(sumc);
		  
 //-/----------
		  
		  l=new LinkedList<Integer>();
		  l.add(14);
		  l.add(15);
		 
		  sumc=new SumConstraint(l,16);
		  constraints.add(sumc);
		  sumconstraints.add(sumc);
		  
 //-/----------
		  
		  l=new LinkedList<Integer>();
		  l.add(23);
		  l.add(24);
		  l.add(32);
		
		  sumc=new SumConstraint(l,11);
		  constraints.add(sumc);
		  sumconstraints.add(sumc);
		  
		  
 //-/----------
		  
		  l=new LinkedList<Integer>();
		  l.add(16);
		  l.add(17);
		 
		  sumc=new SumConstraint(l,5);
		  constraints.add(sumc);
		  sumconstraints.add(sumc);
		  
 //-/----------
		  
		  l=new LinkedList<Integer>();
		  l.add(25);
		  l.add(34);
		  l.add(33);
		  sumc=new SumConstraint(l,17);
		  constraints.add(sumc);
		  sumconstraints.add(sumc);

		  
		  l=new LinkedList<Integer>();
		  l.add(26);
		  l.add(35);
		  l.add(44);
		  l.add(43);
		  sumc=new SumConstraint(l,21);
		  constraints.add(sumc);
		  sumconstraints.add(sumc);
	}
	
	public boolean consisted(State st){
		  if(st.getVaraibles().size()>81) return false;
		  for(Constraint cs: constraints){
			  if(!cs.satisfied(st)) return false;
		  }
		  
		  return true;
	  }
	public boolean controlsum(State st){
		for(SumConstraint sctr:sumconstraints){
			if(!sctr.control(st)) return false;
		}
		return true;
	}
	
	public void inference (State st,int Variable,Integer value) throws IllegalStateException{
		for(Constraint cs: constraints){
			if(cs.isin(Variable)){
				for(int k:cs.getConsVariables()){
					if(st.getDomain().get(k).contains(value) && k!= Variable){
						if(st.getDomain().get(k).size()<1) throw new IllegalStateException("No remaining assignments for variable: "+k);
						st.getDomain().get(k).remove(value);
						//System.out.println("from "+k+" removed"+value);
								}
				}
			}
		}
	}

}
