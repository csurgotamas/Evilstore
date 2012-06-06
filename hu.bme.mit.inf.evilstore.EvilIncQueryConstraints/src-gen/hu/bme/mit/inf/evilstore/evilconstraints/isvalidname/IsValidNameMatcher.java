package hu.bme.mit.inf.evilstore.evilconstraints.isvalidname;

import hu.bme.mit.inf.evilstore.evilconstraints.isvalidname.IsValidNameMatch;
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
 * Generated pattern matcher API of the IsValidName pattern, 
 * providing pattern-specific query methods.
 * 
 * 
 * 
 * // Név validáció (generated with notepad)
 * @Constraint(message = \"Az alábbi nevû objektum nem valid: $NO.name$\", severity=\"error\", location=\"NO\")
 * pattern IsValidName(NO:NamedObject)={
 * 	 NamedObject.name(NO,\"abstract\");  } or { NamedObject.name(NO,\"continue\"); 
 * 	} or { NamedObject.name(NO,\"for\");  } or { NamedObject.name(NO,\"new\"); 
 * 	} or { NamedObject.name(NO,\"switch\");  } or { NamedObject.name(NO,\"assert\"); 
 * 	} or { NamedObject.name(NO,\"default\");  } or { NamedObject.name(NO,\"goto\"); 
 * 	} or { NamedObject.name(NO,\"package\");  } or { NamedObject.name(NO,\"synchronized\");  
 * 	} or { NamedObject.name(NO,\"boolean\");  } or { NamedObject.name(NO,\"do\");  
 * 	} or { NamedObject.name(NO,\"if\");  } or { NamedObject.name(NO,\"private\");  
 * 	} or { NamedObject.name(NO,\"this\");  } or { NamedObject.name(NO,\"break\");  
 * 	} or { NamedObject.name(NO,\"double\");  } or { NamedObject.name(NO,\"implements\");  
 * 	} or { NamedObject.name(NO,\"protected\");  } or { NamedObject.name(NO,\"throw\");  
 * 	} or { NamedObject.name(NO,\"byte\");  } or { NamedObject.name(NO,\"else\");  
 * 	} or { NamedObject.name(NO,\"import\");  } or { NamedObject.name(NO,\"public\");  
 * 	} or { NamedObject.name(NO,\"throws\");  } or { NamedObject.name(NO,\"case\");  
 * 	} or { NamedObject.name(NO,\"enum\");  } or { NamedObject.name(NO,\"instanceof\");  
 * 	} or { NamedObject.name(NO,\"return\");  } or { NamedObject.name(NO,\"transient\");  
 * 	} or { NamedObject.name(NO,\"catch\");  } or { NamedObject.name(NO,\"extends\");  
 * 	} or { NamedObject.name(NO,\"int\");  } or { NamedObject.name(NO,\"short\");  
 * 	} or { NamedObject.name(NO,\"try\");  } or { NamedObject.name(NO,\"char\");  
 * 	} or { NamedObject.name(NO,\"final\");  } or { NamedObject.name(NO,\"interface\");  
 * 	} or { NamedObject.name(NO,\"static\");  } or { NamedObject.name(NO,\"void\");  
 * 	} or { NamedObject.name(NO,\"class\");  } or { NamedObject.name(NO,\"finally\");  
 * 	} or { NamedObject.name(NO,\"long\");  } or { NamedObject.name(NO,\"strictfp\");  
 * 	} or { NamedObject.name(NO,\"volatile\");  } or { NamedObject.name(NO,\"const\");  
 * 	} or { NamedObject.name(NO,\"float\");  } or { NamedObject.name(NO,\"native\");  
 * 	} or { NamedObject.name(NO,\"super\");  } or { NamedObject.name(NO,\"while\");
 * }
 * 
 * @see IsValidNameMatch
 * @see IsValidNameMatcherFactory
 * @see IsValidNameProcessor
 * 
 */
public class IsValidNameMatcher extends BaseGeneratedMatcher<IsValidNameMatch> implements IncQueryMatcher<IsValidNameMatch> {
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
  public IsValidNameMatcher(final Notifier notifier) throws IncQueryRuntimeException {
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
  public IsValidNameMatcher(final IncQueryEngine engine) throws IncQueryRuntimeException {
    super(engine, FACTORY);
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param NO the fixed value of pattern parameter NO, or null if not bound.
   * @return matches represented as a IsValidNameMatch object.
   * 
   */
  public Collection<IsValidNameMatch> getAllMatches(final Object pNO) {
    return rawGetAllMatches(new Object[]{pNO});
    
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param NO the fixed value of pattern parameter NO, or null if not bound.
   * @return a match represented as a IsValidNameMatch object, or null if no match is found.
   * 
   */
  public IsValidNameMatch getOneArbitraryMatch(final Object pNO) {
    return rawGetOneArbitraryMatch(new Object[]{pNO});
    
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param NO the fixed value of pattern parameter NO, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Object pNO) {
    return rawHasMatch(new Object[]{pNO});
    
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param NO the fixed value of pattern parameter NO, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Object pNO) {
    return rawCountMatches(new Object[]{pNO});
    
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param NO the fixed value of pattern parameter NO, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Object pNO, final IMatchProcessor<? super IsValidNameMatch> processor) {
    rawForEachMatch(new Object[]{pNO}, processor);
    
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.  
   * Neither determinism nor randomness of selection is guaranteed.
   * @param NO the fixed value of pattern parameter NO, or null if not bound.
   * @param processor the action that will process the selected match. 
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Object pNO, final IMatchProcessor<? super IsValidNameMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pNO}, processor);
    
  }
  
  @Override
  public IsValidNameMatch tupleToMatch(final Tuple t) {
    try {
    	return new IsValidNameMatch((java.lang.Object) t.get(0));	
    } catch(ClassCastException e) {System.err.println("Error when executing tupleToMatch in IsValidNameMatcher:" + e.getMessage());
    	//throw new IncQueryRuntimeException(e.getMessage());
    	return null;
    }
    
  }
  
  @Override
  public IsValidNameMatch arrayToMatch(final Object[] match) {
    try {
    	return new IsValidNameMatch((java.lang.Object) match[0]);
    } catch(ClassCastException e) {System.err.println("Error when executing arrayToMatch in IsValidNameMatcher:" + e.getMessage());
    }
    		//throw new IncQueryRuntimeException(e.getMessage());
    		return null;
    
  }
  
  public final static IMatcherFactory<IsValidNameMatch,IsValidNameMatcher> FACTORY =  new IsValidNameMatcherFactory();
}
