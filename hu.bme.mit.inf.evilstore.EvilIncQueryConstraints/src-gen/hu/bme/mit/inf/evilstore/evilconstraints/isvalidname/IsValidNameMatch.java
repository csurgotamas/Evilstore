package hu.bme.mit.inf.evilstore.evilconstraints.isvalidname;

import java.util.Arrays;
import org.eclipse.viatra2.emf.incquery.runtime.api.IPatternMatch;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra2.patternlanguage.core.patternLanguage.Pattern;

/**
 * Pattern-specific match representation of the IsValidName pattern, 
 * to be used in conjunction with IsValidNameMatcher.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see IsValidNameMatcher
 * @see IsValidNameProcessor
 * 
 */
public final class IsValidNameMatch extends BasePatternMatch implements IPatternMatch {
  private Object fNO;
  
  private static String[] parameterNames = {"NO"};
  
  public IsValidNameMatch(final Object pNO) {
    this.fNO = pNO;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("NO".equals(parameterName)) return this.fNO;
    return null;
    
  }
  
  public Object getNO() {
    return this.fNO;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if ("NO".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fNO = (java.lang.Object) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setNO(final Object pNO) {
    this.fNO = pNO;
    
  }
  
  @Override
  public String patternName() {
    return "IsValidName";
    
  }
  
  @Override
  public String[] parameterNames() {
    return IsValidNameMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fNO};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"NO\"=" + prettyPrintValue(fNO) + "\n");
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fNO == null) ? 0 : fNO.hashCode()); 
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
    if (!IsValidNameMatch.class.equals(obj.getClass()))
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    				IsValidNameMatch other = (IsValidNameMatch) obj;
    				if (fNO == null) {if (other.fNO != null) return false;}
    				else if (!fNO.equals(other.fNO)) return false;
    				return true;
    
  }
  
  @Override
  public Pattern pattern() {
    return IsValidNameMatcher.FACTORY.getPattern();
  }
}
