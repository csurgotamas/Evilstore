package hu.bme.mit.inf.evilstore.evilconstraints.emptynamedobj;

import hu.bme.mit.inf.evilstore.evilconstraints.emptynamedobj.EmptyNamedObjMatch;
import org.eclipse.viatra2.emf.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the EmptyNamedObj pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class EmptyNamedObjProcessor implements IMatchProcessor<EmptyNamedObjMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param NO the value of pattern parameter NO in the currently processed match 
   * 
   */
  public abstract void process(final Object NO);
  
  @Override
  public void process(final EmptyNamedObjMatch match) {
    process(match.getNO());  				
    
  }
}
