import java.util.* ;

public class State {
	private int []board=new int[82] ;
	private Map<Integer,Integer> varaibles;
	private Map<Integer,List<Integer>> domain;
	public State(int[] board, Map<Integer, Integer> varaibles, Map<Integer, List<Integer>> domain) {
		super();
		System.arraycopy(board,0,this.board,0,81);
		
		this.varaibles = new HashMap<Integer,Integer>(varaibles);
		this.domain = new HashMap<Integer,List<Integer>>(domain);
	}
	public State(State s) {
		super();
		System.arraycopy(s.getBoard(),0,this.board,0,81);
		
		this.varaibles = new HashMap<Integer,Integer>(s.getVaraibles());
		this.domain = new HashMap<Integer,List<Integer>>();
		for(  Integer key:s.getDomain().keySet()){
			List<Integer> ld=new LinkedList<Integer>();
			for(Integer i:s.getDomain().get(key))
			{
				ld.add(Integer.valueOf(i));
			}
			domain.put(Integer.valueOf(key),ld);
		}
	
	}
	public State(State s,int variable,int value) {
		super();
		System.arraycopy(s.getBoard(),0,this.board,0,81);
		this.varaibles = new HashMap<Integer,Integer>(s.getVaraibles());
		this.domain = new HashMap<Integer,List<Integer>>();
		for(  Integer key:s.getDomain().keySet()){
			List<Integer> ld=new LinkedList<Integer>();
			for(Integer i:s.getDomain().get(key))
			{
				ld.add(Integer.valueOf(i));
			}
			domain.put(Integer.valueOf(key),ld);
		}
	
		this.varaibles.put(variable, value);
		board[variable]=value;
	}
	public State() {
		this.varaibles = new HashMap<Integer,Integer>();
		this.domain = new HashMap<Integer,List<Integer>>();
		List<Integer> l=new LinkedList<Integer>();
		for(int i=0;i<9;i++) l.add(i+1);
		for(int i=0;i<81;i++){
			board[i]=0;
			domain.put(i,new LinkedList<Integer>(l));
		}
	}
	public void add(Integer variable,Integer value){
		this.varaibles.put(variable, value);
		board[variable]=value;
	}
	
	public int[] getBoard() {
		return board;
	}
	public void setBoard(int[] board) {
		this.board = board;
	}
	public Map<Integer, Integer> getVaraibles() {
		return varaibles;
	}
	public void setVaraibles(Map<Integer, Integer> varaibles) {
		this.varaibles = varaibles;
	}
	public Map<Integer, List<Integer>> getDomain() {
		return domain;
	}
	public void setDomain(Map<Integer, List<Integer>> domain) {
		this.domain = domain;
	}
 public void print(){
	 System.out.println("*****************************");
	 for(int i=0;i<9;i++) 
		 System.out.print((i+1)+"**\t");
		 System.out.println("\n");
	 for(int i=0;i<81;i++){
		 System.out.print(board[i]+"\t");
		 if((i+1)%9 ==0) System.out.println("    ---"+i/9+"\n");
	 }
	 System.out.println("*****************************");
 }
}
