package hu.bme.mit.inf.evilstore.evilconstraints.attrsparams;

import java.util.Arrays;
import org.eclipse.viatra2.emf.incquery.runtime.api.IPatternMatch;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra2.patternlanguage.core.patternLanguage.Pattern;

/**
 * Pattern-specific match representation of the AttrsParams pattern, 
 * to be used in conjunction with AttrsParamsMatcher.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see AttrsParamsMatcher
 * @see AttrsParamsProcessor
 * 
 */
public final class AttrsParamsMatch extends BasePatternMatch implements IPatternMatch {
  private Object fAP;
  
  private static String[] parameterNames = {"AP"};
  
  public AttrsParamsMatch(final Object pAP) {
    this.fAP = pAP;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("AP".equals(parameterName)) return this.fAP;
    return null;
    
  }
  
  public Object getAP() {
    return this.fAP;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if ("AP".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fAP = (java.lang.Object) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setAP(final Object pAP) {
    this.fAP = pAP;
    
  }
  
  @Override
  public String patternName() {
    return "AttrsParams";
    
  }
  
  @Override
  public String[] parameterNames() {
    return AttrsParamsMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fAP};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"AP\"=" + prettyPrintValue(fAP) + "\n");
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fAP == null) ? 0 : fAP.hashCode()); 
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
    if (!AttrsParamsMatch.class.equals(obj.getClass()))
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    				AttrsParamsMatch other = (AttrsParamsMatch) obj;
    				if (fAP == null) {if (other.fAP != null) return false;}
    				else if (!fAP.equals(other.fAP)) return false;
    				return true;
    
  }
  
  @Override
  public Pattern pattern() {
    return AttrsParamsMatcher.FACTORY.getPattern();
  }
}
