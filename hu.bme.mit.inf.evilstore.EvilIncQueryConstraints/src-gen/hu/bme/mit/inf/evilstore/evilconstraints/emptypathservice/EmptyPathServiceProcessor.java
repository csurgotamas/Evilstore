package hu.bme.mit.inf.evilstore.evilconstraints.emptypathservice;

import hu.bme.mit.inf.evilstore.evilconstraints.emptypathservice.EmptyPathServiceMatch;
import org.eclipse.viatra2.emf.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the EmptyPathService pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class EmptyPathServiceProcessor implements IMatchProcessor<EmptyPathServiceMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param S the value of pattern parameter S in the currently processed match 
   * 
   */
  public abstract void process(final Object S);
  
  @Override
  public void process(final EmptyPathServiceMatch match) {
    process(match.getS());  				
    
  }
}
