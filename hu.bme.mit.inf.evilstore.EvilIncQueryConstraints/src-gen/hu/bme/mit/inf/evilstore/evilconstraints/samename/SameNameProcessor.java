package hu.bme.mit.inf.evilstore.evilconstraints.samename;

import hu.bme.mit.inf.evilstore.evilconstraints.samename.SameNameMatch;
import org.eclipse.viatra2.emf.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the SameName pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class SameNameProcessor implements IMatchProcessor<SameNameMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param NO1 the value of pattern parameter NO1 in the currently processed match 
   * @param NO2 the value of pattern parameter NO2 in the currently processed match 
   * 
   */
  public abstract void process(final Object NO1, final Object NO2);
  
  @Override
  public void process(final SameNameMatch match) {
    process(match.getNO1(), match.getNO2());  				
    
  }
}
