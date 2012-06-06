package hu.bme.mit.inf.evilstore.evilconstraints.typesnotused;

import hu.bme.mit.inf.evilstore.evilconstraints.typesnotused.TypesNotUsedMatch;
import hu.bme.mit.inf.evilstore.evilconstraints.typesnotused.TypesNotUsedMatcher;
import org.eclipse.viatra2.emf.incquery.runtime.api.IncQueryEngine;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.viatra2.emf.incquery.runtime.exception.IncQueryRuntimeException;

/**
 * A pattern-specific matcher factory that can instantiate TypesNotUsedMatcher in a type-safe way.
 * 
 * @see TypesNotUsedMatcher
 * @see TypesNotUsedMatch
 * 
 */
public class TypesNotUsedMatcherFactory extends BaseGeneratedMatcherFactory<TypesNotUsedMatch,TypesNotUsedMatcher> {
  @Override
  protected TypesNotUsedMatcher instantiate(final IncQueryEngine engine) throws IncQueryRuntimeException {
    return new TypesNotUsedMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.evilstore.EvilIncQueryConstraints";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.evilstore.evilconstraints.TypesNotUsed";
    
  }
}
