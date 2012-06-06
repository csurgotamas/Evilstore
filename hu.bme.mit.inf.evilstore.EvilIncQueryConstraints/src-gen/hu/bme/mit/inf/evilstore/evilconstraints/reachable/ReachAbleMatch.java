package hu.bme.mit.inf.evilstore.evilconstraints.reachable;

import java.util.Arrays;
import org.eclipse.viatra2.emf.incquery.runtime.api.IPatternMatch;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra2.patternlanguage.core.patternLanguage.Pattern;

/**
 * Pattern-specific match representation of the ReachAble pattern, 
 * to be used in conjunction with ReachAbleMatcher.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ReachAbleMatcher
 * @see ReachAbleProcessor
 * 
 */
public final class ReachAbleMatch extends BasePatternMatch implements IPatternMatch {
  private Object fA;
  
  private Object fB;
  
  private static String[] parameterNames = {"A", "B"};
  
  public ReachAbleMatch(final Object pA, final Object pB) {
    this.fA = pA;
    this.fB = pB;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("A".equals(parameterName)) return this.fA;
    if ("B".equals(parameterName)) return this.fB;
    return null;
    
  }
  
  public Object getA() {
    return this.fA;
    
  }
  
  public Object getB() {
    return this.fB;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if ("A".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fA = (java.lang.Object) newValue;
    	return true;
    }
    if ("B".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fB = (java.lang.Object) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setA(final Object pA) {
    this.fA = pA;
    
  }
  
  public void setB(final Object pB) {
    this.fB = pB;
    
  }
  
  @Override
  public String patternName() {
    return "ReachAble";
    
  }
  
  @Override
  public String[] parameterNames() {
    return ReachAbleMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fA, fB};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"A\"=" + prettyPrintValue(fA) + "\n");
    result.append("\"B\"=" + prettyPrintValue(fB) + "\n");
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fA == null) ? 0 : fA.hashCode()); 
    result = prime * result + ((fB == null) ? 0 : fB.hashCode()); 
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
    if (!ReachAbleMatch.class.equals(obj.getClass()))
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    				ReachAbleMatch other = (ReachAbleMatch) obj;
    				if (fA == null) {if (other.fA != null) return false;}
    				else if (!fA.equals(other.fA)) return false;
    				if (fB == null) {if (other.fB != null) return false;}
    				else if (!fB.equals(other.fB)) return false;
    				return true;
    
  }
  
  @Override
  public Pattern pattern() {
    return ReachAbleMatcher.FACTORY.getPattern();
  }
}
