package hu.bme.mit.inf.evilstore.evilconstraints.reachable;

import hu.bme.mit.inf.evilstore.evilconstraints.reachable.ReachAbleMatch;
import hu.bme.mit.inf.evilstore.evilconstraints.reachable.ReachAbleMatcher;
import org.eclipse.viatra2.emf.incquery.runtime.api.IncQueryEngine;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.viatra2.emf.incquery.runtime.exception.IncQueryRuntimeException;

/**
 * A pattern-specific matcher factory that can instantiate ReachAbleMatcher in a type-safe way.
 * 
 * @see ReachAbleMatcher
 * @see ReachAbleMatch
 * 
 */
public class ReachAbleMatcherFactory extends BaseGeneratedMatcherFactory<ReachAbleMatch,ReachAbleMatcher> {
  @Override
  protected ReachAbleMatcher instantiate(final IncQueryEngine engine) throws IncQueryRuntimeException {
    return new ReachAbleMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.evilstore.EvilIncQueryConstraints";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.evilstore.evilconstraints.ReachAble";
    
  }
}
