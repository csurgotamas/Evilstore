package hu.bme.mit.inf.evilstore.evilconstraints.isvalidname;

import hu.bme.mit.inf.evilstore.evilconstraints.isvalidname.IsValidNameMatch;
import hu.bme.mit.inf.evilstore.evilconstraints.isvalidname.IsValidNameMatcher;
import org.eclipse.viatra2.emf.incquery.runtime.api.IncQueryEngine;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.viatra2.emf.incquery.runtime.exception.IncQueryRuntimeException;

/**
 * A pattern-specific matcher factory that can instantiate IsValidNameMatcher in a type-safe way.
 * 
 * @see IsValidNameMatcher
 * @see IsValidNameMatch
 * 
 */
public class IsValidNameMatcherFactory extends BaseGeneratedMatcherFactory<IsValidNameMatch,IsValidNameMatcher> {
  @Override
  protected IsValidNameMatcher instantiate(final IncQueryEngine engine) throws IncQueryRuntimeException {
    return new IsValidNameMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.evilstore.EvilIncQueryConstraints";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.evilstore.evilconstraints.IsValidName";
    
  }
}
