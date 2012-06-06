package hu.bme.mit.inf.evilstore.evilconstraints.typedref;

import hu.bme.mit.inf.evilstore.evilconstraints.typedref.TypedRefMatch;
import hu.bme.mit.inf.evilstore.evilconstraints.typedref.TypedRefMatcher;
import org.eclipse.viatra2.emf.incquery.runtime.api.IncQueryEngine;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.viatra2.emf.incquery.runtime.exception.IncQueryRuntimeException;

/**
 * A pattern-specific matcher factory that can instantiate TypedRefMatcher in a type-safe way.
 * 
 * @see TypedRefMatcher
 * @see TypedRefMatch
 * 
 */
public class TypedRefMatcherFactory extends BaseGeneratedMatcherFactory<TypedRefMatch,TypedRefMatcher> {
  @Override
  protected TypedRefMatcher instantiate(final IncQueryEngine engine) throws IncQueryRuntimeException {
    return new TypedRefMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.evilstore.EvilIncQueryConstraints";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.evilstore.evilconstraints.TypedRef";
    
  }
}
