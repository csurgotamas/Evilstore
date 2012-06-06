package hu.bme.mit.inf.evilstore.evilconstraints.samename;

import java.util.Arrays;
import org.eclipse.viatra2.emf.incquery.runtime.api.IPatternMatch;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra2.patternlanguage.core.patternLanguage.Pattern;

/**
 * Pattern-specific match representation of the SameName pattern, 
 * to be used in conjunction with SameNameMatcher.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SameNameMatcher
 * @see SameNameProcessor
 * 
 */
public final class SameNameMatch extends BasePatternMatch implements IPatternMatch {
  private Object fNO1;
  
  private Object fNO2;
  
  private static String[] parameterNames = {"NO1", "NO2"};
  
  public SameNameMatch(final Object pNO1, final Object pNO2) {
    this.fNO1 = pNO1;
    this.fNO2 = pNO2;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("NO1".equals(parameterName)) return this.fNO1;
    if ("NO2".equals(parameterName)) return this.fNO2;
    return null;
    
  }
  
  public Object getNO1() {
    return this.fNO1;
    
  }
  
  public Object getNO2() {
    return this.fNO2;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if ("NO1".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fNO1 = (java.lang.Object) newValue;
    	return true;
    }
    if ("NO2".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fNO2 = (java.lang.Object) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setNO1(final Object pNO1) {
    this.fNO1 = pNO1;
    
  }
  
  public void setNO2(final Object pNO2) {
    this.fNO2 = pNO2;
    
  }
  
  @Override
  public String patternName() {
    return "SameName";
    
  }
  
  @Override
  public String[] parameterNames() {
    return SameNameMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fNO1, fNO2};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"NO1\"=" + prettyPrintValue(fNO1) + "\n");
    result.append("\"NO2\"=" + prettyPrintValue(fNO2) + "\n");
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fNO1 == null) ? 0 : fNO1.hashCode()); 
    result = prime * result + ((fNO2 == null) ? 0 : fNO2.hashCode()); 
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
    if (!SameNameMatch.class.equals(obj.getClass()))
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    				SameNameMatch other = (SameNameMatch) obj;
    				if (fNO1 == null) {if (other.fNO1 != null) return false;}
    				else if (!fNO1.equals(other.fNO1)) return false;
    				if (fNO2 == null) {if (other.fNO2 != null) return false;}
    				else if (!fNO2.equals(other.fNO2)) return false;
    				return true;
    
  }
  
  @Override
  public Pattern pattern() {
    return SameNameMatcher.FACTORY.getPattern();
  }
}
