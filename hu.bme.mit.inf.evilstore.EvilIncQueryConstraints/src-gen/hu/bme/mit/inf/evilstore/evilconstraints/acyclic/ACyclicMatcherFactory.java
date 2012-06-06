package hu.bme.mit.inf.evilstore.evilconstraints.acyclic;

import hu.bme.mit.inf.evilstore.evilconstraints.acyclic.ACyclicMatch;
import hu.bme.mit.inf.evilstore.evilconstraints.acyclic.ACyclicMatcher;
import org.eclipse.viatra2.emf.incquery.runtime.api.IncQueryEngine;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.viatra2.emf.incquery.runtime.exception.IncQueryRuntimeException;

/**
 * A pattern-specific matcher factory that can instantiate ACyclicMatcher in a type-safe way.
 * 
 * @see ACyclicMatcher
 * @see ACyclicMatch
 * 
 */
public class ACyclicMatcherFactory extends BaseGeneratedMatcherFactory<ACyclicMatch,ACyclicMatcher> {
  @Override
  protected ACyclicMatcher instantiate(final IncQueryEngine engine) throws IncQueryRuntimeException {
    return new ACyclicMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.evilstore.EvilIncQueryConstraints";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.evilstore.evilconstraints.ACyclic";
    
  }
}
