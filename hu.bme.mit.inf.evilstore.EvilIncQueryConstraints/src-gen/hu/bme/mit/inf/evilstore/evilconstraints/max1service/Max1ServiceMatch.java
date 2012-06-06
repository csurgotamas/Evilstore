package hu.bme.mit.inf.evilstore.evilconstraints.max1service;

import java.util.Arrays;
import org.eclipse.viatra2.emf.incquery.runtime.api.IPatternMatch;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra2.patternlanguage.core.patternLanguage.Pattern;

/**
 * Pattern-specific match representation of the Max1Service pattern, 
 * to be used in conjunction with Max1ServiceMatcher.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see Max1ServiceMatcher
 * @see Max1ServiceProcessor
 * 
 */
public final class Max1ServiceMatch extends BasePatternMatch implements IPatternMatch {
  private Object fC;
  
  private static String[] parameterNames = {"C"};
  
  public Max1ServiceMatch(final Object pC) {
    this.fC = pC;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("C".equals(parameterName)) return this.fC;
    return null;
    
  }
  
  public Object getC() {
    return this.fC;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if ("C".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fC = (java.lang.Object) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setC(final Object pC) {
    this.fC = pC;
    
  }
  
  @Override
  public String patternName() {
    return "Max1Service";
    
  }
  
  @Override
  public String[] parameterNames() {
    return Max1ServiceMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fC};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"C\"=" + prettyPrintValue(fC) + "\n");
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fC == null) ? 0 : fC.hashCode()); 
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
    if (!Max1ServiceMatch.class.equals(obj.getClass()))
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    				Max1ServiceMatch other = (Max1ServiceMatch) obj;
    				if (fC == null) {if (other.fC != null) return false;}
    				else if (!fC.equals(other.fC)) return false;
    				return true;
    
  }
  
  @Override
  public Pattern pattern() {
    return Max1ServiceMatcher.FACTORY.getPattern();
  }
}
