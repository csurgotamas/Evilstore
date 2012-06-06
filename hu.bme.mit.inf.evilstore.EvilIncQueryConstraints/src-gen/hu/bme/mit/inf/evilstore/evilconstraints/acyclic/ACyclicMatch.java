package hu.bme.mit.inf.evilstore.evilconstraints.acyclic;

import java.util.Arrays;
import org.eclipse.viatra2.emf.incquery.runtime.api.IPatternMatch;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra2.patternlanguage.core.patternLanguage.Pattern;

/**
 * Pattern-specific match representation of the ACyclic pattern, 
 * to be used in conjunction with ACyclicMatcher.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ACyclicMatcher
 * @see ACyclicProcessor
 * 
 */
public final class ACyclicMatch extends BasePatternMatch implements IPatternMatch {
  private Object fE;
  
  private static String[] parameterNames = {"E"};
  
  public ACyclicMatch(final Object pE) {
    this.fE = pE;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("E".equals(parameterName)) return this.fE;
    return null;
    
  }
  
  public Object getE() {
    return this.fE;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if ("E".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fE = (java.lang.Object) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setE(final Object pE) {
    this.fE = pE;
    
  }
  
  @Override
  public String patternName() {
    return "ACyclic";
    
  }
  
  @Override
  public String[] parameterNames() {
    return ACyclicMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fE};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"E\"=" + prettyPrintValue(fE) + "\n");
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fE == null) ? 0 : fE.hashCode()); 
    return result; 
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (obj == null)
    	return false;
    if (!(obj instanceof IPatternMatch))
    	return false;
    IPatternMatch otherSig  = (IPatternMatch) obj;
    if (!pattern().equals(otherSig.pattern()))
    	return false;
    if (!ACyclicMatch.class.equals(obj.getClass()))
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    				ACyclicMatch other = (ACyclicMatch) obj;
    				if (fE == null) {if (other.fE != null) return false;}
    				else if (!fE.equals(other.fE)) return false;
    				return true;
    
  }
  
  @Override
  public Pattern pattern() {
    return ACyclicMatcher.FACTORY.getPattern();
  }
}
