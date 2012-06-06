package hu.bme.mit.inf.evilstore.evilconstraints.emptypathservice;

import hu.bme.mit.inf.evilstore.evilconstraints.emptypathservice.EmptyPathServiceMatch;
import hu.bme.mit.inf.evilstore.evilconstraints.emptypathservice.EmptyPathServiceMatcher;
import org.eclipse.viatra2.emf.incquery.runtime.api.IncQueryEngine;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.viatra2.emf.incquery.runtime.exception.IncQueryRuntimeException;

/**
 * A pattern-specific matcher factory that can instantiate EmptyPathServiceMatcher in a type-safe way.
 * 
 * @see EmptyPathServiceMatcher
 * @see EmptyPathServiceMatch
 * 
 */
public class EmptyPathServiceMatcherFactory extends BaseGeneratedMatcherFactory<EmptyPathServiceMatch,EmptyPathServiceMatcher> {
  @Override
  protected EmptyPathServiceMatcher instantiate(final IncQueryEngine engine) throws IncQueryRuntimeException {
    return new EmptyPathServiceMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.evilstore.EvilIncQueryConstraints";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.evilstore.evilconstraints.EmptyPathService";
    
  }
}
