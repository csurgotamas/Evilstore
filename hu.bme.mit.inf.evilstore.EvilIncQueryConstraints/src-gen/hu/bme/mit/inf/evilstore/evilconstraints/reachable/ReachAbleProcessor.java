package hu.bme.mit.inf.evilstore.evilconstraints.reachable;

import hu.bme.mit.inf.evilstore.evilconstraints.reachable.ReachAbleMatch;
import org.eclipse.viatra2.emf.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the ReachAble pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class ReachAbleProcessor implements IMatchProcessor<ReachAbleMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param A the value of pattern parameter A in the currently processed match 
   * @param B the value of pattern parameter B in the currently processed match 
   * 
   */
  public abstract void process(final Object A, final Object B);
  
  @Override
  public void process(final ReachAbleMatch match) {
    process(match.getA(), match.getB());  				
    
  }
}
