package hu.bme.mit.inf.evilstore.evilconstraints.samename;

import hu.bme.mit.inf.evilstore.evilconstraints.samename.SameNameMatch;
import hu.bme.mit.inf.evilstore.evilconstraints.samename.SameNameMatcher;
import org.eclipse.viatra2.emf.incquery.runtime.api.IncQueryEngine;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.viatra2.emf.incquery.runtime.exception.IncQueryRuntimeException;

/**
 * A pattern-specific matcher factory that can instantiate SameNameMatcher in a type-safe way.
 * 
 * @see SameNameMatcher
 * @see SameNameMatch
 * 
 */
public class SameNameMatcherFactory extends BaseGeneratedMatcherFactory<SameNameMatch,SameNameMatcher> {
  @Override
  protected SameNameMatcher instantiate(final IncQueryEngine engine) throws IncQueryRuntimeException {
    return new SameNameMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.evilstore.EvilIncQueryConstraints";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.evilstore.evilconstraints.SameName";
    
  }
}
