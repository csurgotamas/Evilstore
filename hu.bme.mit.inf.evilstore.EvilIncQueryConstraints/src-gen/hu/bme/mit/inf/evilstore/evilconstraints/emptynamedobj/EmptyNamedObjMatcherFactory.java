package hu.bme.mit.inf.evilstore.evilconstraints.emptynamedobj;

import hu.bme.mit.inf.evilstore.evilconstraints.emptynamedobj.EmptyNamedObjMatch;
import hu.bme.mit.inf.evilstore.evilconstraints.emptynamedobj.EmptyNamedObjMatcher;
import org.eclipse.viatra2.emf.incquery.runtime.api.IncQueryEngine;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.viatra2.emf.incquery.runtime.exception.IncQueryRuntimeException;

/**
 * A pattern-specific matcher factory that can instantiate EmptyNamedObjMatcher in a type-safe way.
 * 
 * @see EmptyNamedObjMatcher
 * @see EmptyNamedObjMatch
 * 
 */
public class EmptyNamedObjMatcherFactory extends BaseGeneratedMatcherFactory<EmptyNamedObjMatch,EmptyNamedObjMatcher> {
  @Override
  protected EmptyNamedObjMatcher instantiate(final IncQueryEngine engine) throws IncQueryRuntimeException {
    return new EmptyNamedObjMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.evilstore.EvilIncQueryConstraints";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.evilstore.evilconstraints.EmptyNamedObj";
    
  }
}
