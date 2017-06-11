import java.util.*;

/**
 * This class represents an abstract Constraint
 * associated with a CSP Problem.
 */
public abstract class Constraint {

  public abstract boolean satisfied(State st);

  public abstract String descrip();
  public abstract boolean consistent(State st);
  public abstract List<Integer> reliesOn();
  public abstract boolean isin(int i);
  public abstract  List<Integer> getConsVariables();
}
