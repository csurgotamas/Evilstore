package hu.bme.mit.inf.evilstore.evilconstraints.samename;

import hu.bme.mit.inf.evilstore.evilconstraints.samename.SameNameMatch;
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
 * Generated pattern matcher API of the SameName pattern, 
 * providing pattern-specific query methods.
 * 
 * 
 * 
 * // Nincs két ugyanolyan nevû objektum kényszer (Attributumokat és Paremétereket kivéve)
 * @Constraint(message = \"Az alábbi néven több objektum is szerepel: $NO1.name$\",severity=\"error\", location=\"NO1\")
 * pattern SameName(NO1:NamedObject,NO2:NamedObject)={
 * 	NamedObject.name(NO1,Name);
 * 	NamedObject.name(NO2,Name);
 * 	NO1!=NO2;
 * 	neg find AttrsParams(NO1);
 * 	neg find AttrsParams(NO2);
 * }
 * 
 * @see SameNameMatch
 * @see SameNameMatcherFactory
 * @see SameNameProcessor
 * 
 */
public class SameNameMatcher extends BaseGeneratedMatcher<SameNameMatch> implements IncQueryMatcher<SameNameMatch> {
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
  public SameNameMatcher(final Notifier notifier) throws IncQueryRuntimeException {
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
  public SameNameMatcher(final IncQueryEngine engine) throws IncQueryRuntimeException {
    super(engine, FACTORY);
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param NO1 the fixed value of pattern parameter NO1, or null if not bound.
   * @param NO2 the fixed value of pattern parameter NO2, or null if not bound.
   * @return matches represented as a SameNameMatch object.
   * 
   */
  public Collection<SameNameMatch> getAllMatches(final Object pNO1, final Object pNO2) {
    return rawGetAllMatches(new Object[]{pNO1, pNO2});
    
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param NO1 the fixed value of pattern parameter NO1, or null if not bound.
   * @param NO2 the fixed value of pattern parameter NO2, or null if not bound.
   * @return a match represented as a SameNameMatch object, or null if no match is found.
   * 
   */
  public SameNameMatch getOneArbitraryMatch(final Object pNO1, final Object pNO2) {
    return rawGetOneArbitraryMatch(new Object[]{pNO1, pNO2});
    
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param NO1 the fixed value of pattern parameter NO1, or null if not bound.
   * @param NO2 the fixed value of pattern parameter NO2, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Object pNO1, final Object pNO2) {
    return rawHasMatch(new Object[]{pNO1, pNO2});
    
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param NO1 the fixed value of pattern parameter NO1, or null if not bound.
   * @param NO2 the fixed value of pattern parameter NO2, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Object pNO1, final Object pNO2) {
    return rawCountMatches(new Object[]{pNO1, pNO2});
    
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param NO1 the fixed value of pattern parameter NO1, or null if not bound.
   * @param NO2 the fixed value of pattern parameter NO2, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Object pNO1, final Object pNO2, final IMatchProcessor<? super SameNameMatch> processor) {
    rawForEachMatch(new Object[]{pNO1, pNO2}, processor);
    
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param NO1 the fixed value of pattern parameter NO1, or null if not bound.
   * @param NO2 the fixed value of pattern parameter NO2, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Object pNO1, final Object pNO2, final IMatchProcessor<? super SameNameMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pNO1, pNO2}, processor);
    
  }
  
  @Override
  public SameNameMatch tupleToMatch(final Tuple t) {
    try {
    	return new SameNameMatch((java.lang.Object) t.get(0), (java.lang.Object) t.get(1));	
    } catch(ClassCastException e) {System.err.println("Error when executing tupleToMatch in SameNameMatcher:" + e.getMessage());
    	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  public SameNameMatch arrayToMatch(final Object[] match) {
    try {
    	return new SameNameMatch((java.lang.Object) match[0], (java.lang.Object) match[1]);
    } catch(ClassCastException e) {System.err.println("Error when executing arrayToMatch in SameNameMatcher:" + e.getMessage());
    }
    		//throw new IncQueryRuntimeException(e.getMessage());
    		return null;
    
  }
  
  public final static IMatcherFactory<SameNameMatch,SameNameMatcher> FACTORY =  new SameNameMatcherFactory();
}
