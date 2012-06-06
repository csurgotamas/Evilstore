package hu.bme.mit.inf.evilstore.evilconstraints.max1service;

import hu.bme.mit.inf.evilstore.evilconstraints.max1service.Max1ServiceMatch;
import hu.bme.mit.inf.evilstore.evilconstraints.max1service.Max1ServiceMatcher;
import org.eclipse.viatra2.emf.incquery.runtime.api.IncQueryEngine;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.viatra2.emf.incquery.runtime.exception.IncQueryRuntimeException;

/**
 * A pattern-specific matcher factory that can instantiate Max1ServiceMatcher in a type-safe way.
 * 
 * @see Max1ServiceMatcher
 * @see Max1ServiceMatch
 * 
 */
public class Max1ServiceMatcherFactory extends BaseGeneratedMatcherFactory<Max1ServiceMatch,Max1ServiceMatcher> {
  @Override
  protected Max1ServiceMatcher instantiate(final IncQueryEngine engine) throws IncQueryRuntimeException {
    return new Max1ServiceMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.evilstore.EvilIncQueryConstraints";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.evilstore.evilconstraints.Max1Service";
    
  }
}
