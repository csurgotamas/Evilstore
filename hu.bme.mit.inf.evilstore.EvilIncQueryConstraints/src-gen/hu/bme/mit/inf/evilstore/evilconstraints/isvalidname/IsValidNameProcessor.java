package hu.bme.mit.inf.evilstore.evilconstraints.isvalidname;

import hu.bme.mit.inf.evilstore.evilconstraints.isvalidname.IsValidNameMatch;
import org.eclipse.viatra2.emf.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the IsValidName pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class IsValidNameProcessor implements IMatchProcessor<IsValidNameMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param NO the value of pattern parameter NO in the currently processed match 
   * 
   */
  public abstract void process(final Object NO);
  
  @Override
  public void process(final IsValidNameMatch match) {
    process(match.getNO());  				
    
  }
}
