package hu.bme.mit.inf.evilstore.evilconstraints.attrsparams;

import hu.bme.mit.inf.evilstore.evilconstraints.attrsparams.AttrsParamsMatch;
import org.eclipse.viatra2.emf.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the AttrsParams pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
public abstract class AttrsParamsProcessor implements IMatchProcessor<AttrsParamsMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param AP the value of pattern parameter AP in the currently processed match 
   * 
   */
  public abstract void process(final Object AP);
  
  @Override
  public void process(final AttrsParamsMatch match) {
    process(match.getAP());  				
    
  }
}
