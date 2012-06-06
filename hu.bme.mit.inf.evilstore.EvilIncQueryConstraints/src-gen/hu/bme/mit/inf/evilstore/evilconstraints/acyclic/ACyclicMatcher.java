package hu.bme.mit.inf.evilstore.evilconstraints.acyclic;

import hu.bme.mit.inf.evilstore.evilconstraints.acyclic.ACyclicMatch;
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
 * Generated pattern matcher API of the ACyclic pattern, 
 * providing pattern-specific query methods.
 * 
 * 
 * 
 * 
 * // Körmentesség kényszer
 * @Constraint(message = \"Az alábbi entitás kört alkot: $E.name$\", severity = \"error\", location = \"E\")
 * pattern ACyclic(E:Entity)={
 * 	find ReachAble(E,E);
 * 	
 * }
 * 
 * @see ACyclicMatch
 * @see ACyclicMatcherFactory
 * @see ACyclicProcessor
 * 
 */
public class ACyclicMatcher extends BaseGeneratedMatcher<ACyclicMatch> implements IncQueryMatcher<ACyclicMatch> {
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
  public ACyclicMatcher(final Notifier notifier) throws IncQueryRuntimeException {
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
  public ACyclicMatcher(final IncQueryEngine engine) throws IncQueryRuntimeException {
    super(engine, FACTORY);
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param E the fixed value of pattern parameter E, or null if not bound.
   * @return matches represented as a ACyclicMatch object.
   * 
   */
  public Collection<ACyclicMatch> getAllMatches(final Object pE) {
    return rawGetAllMatches(new Object[]{pE});
    
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param E the fixed value of pattern parameter E, or null if not bound.
   * @return a match represented as a ACyclicMatch object, or null if no match is found.
   * 
   */
  public ACyclicMatch getOneArbitraryMatch(final Object pE) {
    return rawGetOneArbitraryMatch(new Object[]{pE});
    
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param E the fixed value of pattern parameter E, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Object pE) {
    return rawHasMatch(new Object[]{pE});
    
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param E the fixed value of pattern parameter E, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Object pE) {
    return rawCountMatches(new Object[]{pE});
    
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param E the fixed value of pattern parameter E, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Object pE, final IMatchProcessor<? super ACyclicMatch> processor) {
    rawForEachMatch(new Object[]{pE}, processor);
    
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param E the fixed value of pattern parameter E, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Object pE, final IMatchProcessor<? super ACyclicMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pE}, processor);
    
  }
  
  @Override
  public ACyclicMatch tupleToMatch(final Tuple t) {
    try {
    	return new ACyclicMatch((java.lang.Object) t.get(0));	
    } catch(ClassCastException e) {System.err.println("Error when executing tupleToMatch in ACyclicMatcher:" + e.getMessage());
    	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  public ACyclicMatch arrayToMatch(final Object[] match) {
    try {
    	return new ACyclicMatch((java.lang.Object) match[0]);
    } catch(ClassCastException e) {System.err.println("Error when executing arrayToMatch in ACyclicMatcher:" + e.getMessage());
    }
    		//throw new IncQueryRuntimeException(e.getMessage());
    		return null;
    
  }
  
  public final static IMatcherFactory<ACyclicMatch,ACyclicMatcher> FACTORY =  new ACyclicMatcherFactory();
}
