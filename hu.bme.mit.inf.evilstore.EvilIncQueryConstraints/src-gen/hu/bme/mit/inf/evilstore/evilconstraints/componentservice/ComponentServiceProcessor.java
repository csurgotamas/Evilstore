package hu.bme.mit.inf.evilstore.evilconstraints.componentservice;

import hu.bme.mit.inf.evilstore.evilconstraints.componentservice.ComponentServiceMatch;
import org.eclipse.viatra2.emf.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the ComponentService pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class ComponentServiceProcessor implements IMatchProcessor<ComponentServiceMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param C the value of pattern parameter C in the currently processed match 
   * @param S the value of pattern parameter S in the currently processed match 
   * 
   */
  public abstract void process(final Object C, final Object S);
  
  @Override
  public void process(final ComponentServiceMatch match) {
    process(match.getC(), match.getS());  				
    
  }
}
