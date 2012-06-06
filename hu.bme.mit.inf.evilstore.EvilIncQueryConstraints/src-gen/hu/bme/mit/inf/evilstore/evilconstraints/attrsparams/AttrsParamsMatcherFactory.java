package hu.bme.mit.inf.evilstore.evilconstraints.attrsparams;

import hu.bme.mit.inf.evilstore.evilconstraints.attrsparams.AttrsParamsMatch;
import hu.bme.mit.inf.evilstore.evilconstraints.attrsparams.AttrsParamsMatcher;
import org.eclipse.viatra2.emf.incquery.runtime.api.IncQueryEngine;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BaseGeneratedMatcherFactory;
import org.eclipse.viatra2.emf.incquery.runtime.exception.IncQueryRuntimeException;

/**
 * A pattern-specific matcher factory that can instantiate AttrsParamsMatcher in a type-safe way.
 * 
 * @see AttrsParamsMatcher
 * @see AttrsParamsMatch
 * 
 */
public class AttrsParamsMatcherFactory extends BaseGeneratedMatcherFactory<AttrsParamsMatch,AttrsParamsMatcher> {
  @Override
  protected AttrsParamsMatcher instantiate(final IncQueryEngine engine) throws IncQueryRuntimeException {
    return new AttrsParamsMatcher(engine);
    
  }
  
  @Override
  protected String getBundleName() {
    return "hu.bme.mit.inf.evilstore.EvilIncQueryConstraints";
    
  }
  
  @Override
  protected String patternName() {
    return "hu.bme.mit.inf.evilstore.evilconstraints.AttrsParams";
    
  }
}
