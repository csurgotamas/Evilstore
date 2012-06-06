package hu.bme.mit.inf.evilstore.evilconstraints.acyclic;

import hu.bme.mit.inf.evilstore.evilconstraints.acyclic.ACyclicMatch;
import org.eclipse.viatra2.emf.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the ACyclic pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class ACyclicProcessor implements IMatchProcessor<ACyclicMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param E the value of pattern parameter E in the currently processed match 
   * 
   */
  public abstract void process(final Object E);
  
  @Override
  public void process(final ACyclicMatch match) {
    process(match.getE());  				
    
  }
}
