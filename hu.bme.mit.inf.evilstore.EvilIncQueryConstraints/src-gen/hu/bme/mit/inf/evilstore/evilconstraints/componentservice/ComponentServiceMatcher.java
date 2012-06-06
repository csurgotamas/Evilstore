package hu.bme.mit.inf.evilstore.evilconstraints.componentservice;

import hu.bme.mit.inf.evilstore.evilconstraints.componentservice.ComponentServiceMatch;
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
 * Generated pattern matcher API of the ComponentService pattern, 
 * providing pattern-specific query methods.
 * 
 * 
 * 
 * pattern ComponentService(C:Component,S:Service)={
 * 	Component.services(C,S);
 * }
 * 
 * @see ComponentServiceMatch
 * @see ComponentServiceMatcherFactory
 * @see ComponentServiceProcessor
 * 
 */
public class ComponentServiceMatcher extends BaseGeneratedMatcher<ComponentServiceMatch> implements IncQueryMatcher<ComponentServiceMatch> {
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
  public ComponentServiceMatcher(final Notifier notifier) throws IncQueryRuntimeException {
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
  public ComponentServiceMatcher(final IncQueryEngine engine) throws IncQueryRuntimeException {
    super(engine, FACTORY);
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param C the fixed value of pattern parameter C, or null if not bound.
   * @param S the fixed value of pattern parameter S, or null if not bound.
   * @return matches represented as a ComponentServiceMatch object.
   * 
   */
  public Collection<ComponentServiceMatch> getAllMatches(final Object pC, final Object pS) {
    return rawGetAllMatches(new Object[]{pC, pS});
    
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param C the fixed value of pattern parameter C, or null if not bound.
   * @param S the fixed value of pattern parameter S, or null if not bound.
   * @return a match represented as a ComponentServiceMatch object, or null if no match is found.
   * 
   */
  public ComponentServiceMatch getOneArbitraryMatch(final Object pC, final Object pS) {
    return rawGetOneArbitraryMatch(new Object[]{pC, pS});
    
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param C the fixed value of pattern parameter C, or null if not bound.
   * @param S the fixed value of pattern parameter S, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Object pC, final Object pS) {
    return rawHasMatch(new Object[]{pC, pS});
    
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param C the fixed value of pattern parameter C, or null if not bound.
   * @param S the fixed value of pattern parameter S, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Object pC, final Object pS) {
    return rawCountMatches(new Object[]{pC, pS});
    
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param C the fixed value of pattern parameter C, or null if not bound.
   * @param S the fixed value of pattern parameter S, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Object pC, final Object pS, final IMatchProcessor<? super ComponentServiceMatch> processor) {
    rawForEachMatch(new Object[]{pC, pS}, processor);
    
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param C the fixed value of pattern parameter C, or null if not bound.
   * @param S the fixed value of pattern parameter S, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Object pC, final Object pS, final IMatchProcessor<? super ComponentServiceMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pC, pS}, processor);
    
  }
  
  @Override
  public ComponentServiceMatch tupleToMatch(final Tuple t) {
    try {
    	return new ComponentServiceMatch((java.lang.Object) t.get(0), (java.lang.Object) t.get(1));	
    } catch(ClassCastException e) {System.err.println("Error when executing tupleToMatch in ComponentServiceMatcher:" + e.getMessage());
    	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  public ComponentServiceMatch arrayToMatch(final Object[] match) {
    try {
    	return new ComponentServiceMatch((java.lang.Object) match[0], (java.lang.Object) match[1]);
    } catch(ClassCastException e) {System.err.println("Error when executing arrayToMatch in ComponentServiceMatcher:" + e.getMessage());
    }
    		//throw new IncQueryRuntimeException(e.getMessage());
    		return null;
    
  }
  
  public final static IMatcherFactory<ComponentServiceMatch,ComponentServiceMatcher> FACTORY =  new ComponentServiceMatcherFactory();
}
