package hu.bme.mit.inf.evilstore.evilconstraints.typedref;

import hu.bme.mit.inf.evilstore.evilconstraints.typedref.TypedRefMatch;
import org.eclipse.viatra2.emf.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the TypedRef pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class TypedRefProcessor implements IMatchProcessor<TypedRefMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param T the value of pattern parameter T in the currently processed match 
   * 
   */
  public abstract void process(final Object T);
  
  @Override
  public void process(final TypedRefMatch match) {
    process(match.getT());  				
    
  }
}
