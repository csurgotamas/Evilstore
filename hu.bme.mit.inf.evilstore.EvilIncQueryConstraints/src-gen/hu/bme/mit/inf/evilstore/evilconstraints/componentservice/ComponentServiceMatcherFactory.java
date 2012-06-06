package hu.bme.mit.inf.evilstore.evilconstraints.componentservice;

import hu.bme.mit.inf.evilstore.evilconstraints.componentservice.ComponentServiceMatch;
import hu.bme.mit.inf.evilstore.evilconstraints.componentservice.ComponentServiceMatcher;
import org.eclipse.viatra2.emf.incquery.runtime.api.IncQueryEngine;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.viatra2.emf.incquery.runtime.exception.IncQueryRuntimeException;

/**
 * A pattern-specific matcher factory that can instantiate ComponentServiceMatcher in a type-safe way.
 * 
 * @see ComponentServiceMatcher
 * @see ComponentServiceMatch
 * 
 */
public class ComponentServiceMatcherFactory extends BaseGeneratedMatcherFactory<ComponentServiceMatch,ComponentServiceMatcher> {
  @Override
  protected ComponentServiceMatcher instantiate(final IncQueryEngine engine) throws IncQueryRuntimeException {
    return new ComponentServiceMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.evilstore.EvilIncQueryConstraints";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.evilstore.evilconstraints.ComponentService";
    
  }
}
