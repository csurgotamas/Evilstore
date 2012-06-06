package hu.bme.mit.inf.evilstore.evilconstraints.max1service;

import hu.bme.mit.inf.evilstore.evilconstraints.max1service.Max1ServiceMatch;
import org.eclipse.viatra2.emf.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the Max1Service pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class Max1ServiceProcessor implements IMatchProcessor<Max1ServiceMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param C the value of pattern parameter C in the currently processed match 
   * 
   */
  public abstract void process(final Object C);
  
  @Override
  public void process(final Max1ServiceMatch match) {
    process(match.getC());  				
    
  }
}
