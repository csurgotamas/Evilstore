package hu.bme.mit.inf.evilstore.evilconstraints.max1service;

import hu.bme.mit.inf.evilstore.evilconstraints.max1service.Max1ServiceMatch;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.viatra2.emf.incquery.runtime.api.EngineManager;
import org.eclipse.viatra2.emf.incquery.runtime.api.IMatchProcessor;
import org.eclipse.viatra2.emf.incquery.runtime.api.IMatcherFactory;
import org.eclipse.viatra2.emf.incquery.runtime.api.IncQueryEngine;
import org.eclipse.viatra2.emf.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BaseGeneratedMatcher;
import org.eclipse.viatra2.emf.incquery.runtime.exception.IncQueryRuntimeException;
import org.eclipse.viatra2.gtasm.patternmatcher.incremental.rete.tuple.Tuple;

/**
 * Generated pattern matcher API of the Max1Service pattern, 
 * providing pattern-specific query methods.
 * 
 * 
 * 
 * // Egy komponenshez maximum egy szolgáltatás tartozhat kényszer
 * @Constraint(message = \"Az alábbi komponensnek egynél több szolgáltatása van: $C.name$\", severity=\"error\", location=\"C\")
 * pattern Max1Service(C:Component)={
 * 	find ComponentService(C,S1);
 * 	find ComponentService(C,S2);
 * 	S1!=S2;
 * }
 * 
 * @see Max1ServiceMatch
 * @see Max1ServiceMatcherFactory
 * @see Max1ServiceProcessor
 * 
 */
public class Max1ServiceMatcher extends BaseGeneratedMatcher<Max1ServiceMatch> implements IncQueryMatcher<Max1ServiceMatch> {
  /**
   * Initializes the pattern matcher over a given EMF model root (recommended: Resource or ResourceSet). 
   * If a pattern matcher is already constructed with the same root, only a lightweight reference is created.
   * The match set will be incrementally refreshed upon updates from the given EMF root and below.
   * <p>Note: if emfRoot is a resourceSet, the scope will include even those resources that are not part of the resourceSet but are referenced. 
   * This is mainly to support nsURI-based instance-level references to registered EPackages.
   * @param emfRoot the root of the EMF tree where the pattern matcher will operate. Recommended: Resource or ResourceSet.
   * @throws IncQueryRuntimeException if an error occurs during pattern matcher creation
   * 
   */
  public Max1ServiceMatcher(final Notifier notifier) throws IncQueryRuntimeException {
    this(EngineManager.getInstance().getIncQueryEngine(notifier));
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine. 
   * If the pattern matcher is already constructed in the engine, only a lightweight reference is created.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryRuntimeException if an error occurs during pattern matcher creation
   * 
   */
  public Max1ServiceMatcher(final IncQueryEngine engine) throws IncQueryRuntimeException {
    super(engine, FACTORY);
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param C the fixed value of pattern parameter C, or null if not bound.
   * @return matches represented as a Max1ServiceMatch object.
   * 
   */
  public Collection<Max1ServiceMatch> getAllMatches(final Object pC) {
    return rawGetAllMatches(new Object[]{pC});
    
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param C the fixed value of pattern parameter C, or null if not bound.
   * @return a match represented as a Max1ServiceMatch object, or null if no match is found.
   * 
   */
  public Max1ServiceMatch getOneArbitraryMatch(final Object pC) {
    return rawGetOneArbitraryMatch(new Object[]{pC});
    
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param C the fixed value of pattern parameter C, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Object pC) {
    return rawHasMatch(new Object[]{pC});
    
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param C the fixed value of pattern parameter C, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Object pC) {
    return rawCountMatches(new Object[]{pC});
    
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param C the fixed value of pattern parameter C, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Object pC, final IMatchProcessor<? super Max1ServiceMatch> processor) {
    rawForEachMatch(new Object[]{pC}, processor);
    
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param C the fixed value of pattern parameter C, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Object pC, final IMatchProcessor<? super Max1ServiceMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pC}, processor);
    
  }
  
  @Override
  public Max1ServiceMatch tupleToMatch(final Tuple t) {
    try {
    	return new Max1ServiceMatch((java.lang.Object) t.get(0));	
    } catch(ClassCastException e) {System.err.println("Error when executing tupleToMatch in Max1ServiceMatcher:" + e.getMessage());
    	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  public Max1ServiceMatch arrayToMatch(final Object[] match) {
    try {
    	return new Max1ServiceMatch((java.lang.Object) match[0]);
    } catch(ClassCastException e) {System.err.println("Error when executing arrayToMatch in Max1ServiceMatcher:" + e.getMessage());
    }
    		//throw new IncQueryRuntimeException(e.getMessage());
    		return null;
    
  }
  
  public final static IMatcherFactory<Max1ServiceMatch,Max1ServiceMatcher> FACTORY =  new Max1ServiceMatcherFactory();
}
