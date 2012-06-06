package hu.bme.mit.inf.evilstore.evilconstraints.componentservice;

import java.util.Arrays;
import org.eclipse.viatra2.emf.incquery.runtime.api.IPatternMatch;
import org.eclipse.viatra2.emf.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra2.patternlanguage.core.patternLanguage.Pattern;

/**
 * Pattern-specific match representation of the ComponentService pattern, 
 * to be used in conjunction with ComponentServiceMatcher.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters, 
 * usable to represent a match of the pattern in the result of a query, 
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ComponentServiceMatcher
 * @see ComponentServiceProcessor
 * 
 */
public final class ComponentServiceMatch extends BasePatternMatch implements IPatternMatch {
  private Object fC;
  
  private Object fS;
  
  private static String[] parameterNames = {"C", "S"};
  
  public ComponentServiceMatch(final Object pC, final Object pS) {
    this.fC = pC;
    this.fS = pS;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("C".equals(parameterName)) return this.fC;
    if ("S".equals(parameterName)) return this.fS;
    return null;
    
  }
  
  public Object getC() {
    return this.fC;
    
  }
  
  public Object getS() {
    return this.fS;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if ("C".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fC = (java.lang.Object) newValue;
    	return true;
    }
    if ("S".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fS = (java.lang.Object) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setC(final Object pC) {
    this.fC = pC;
    
  }
  
  public void setS(final Object pS) {
    this.fS = pS;
    
  }
  
  @Override
  public String patternName() {
    return "ComponentService";
    
  }
  
  @Override
  public String[] parameterNames() {
    return ComponentServiceMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fC, fS};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"C\"=" + prettyPrintValue(fC) + "\n");
    result.append("\"S\"=" + prettyPrintValue(fS) + "\n");
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fC == null) ? 0 : fC.hashCode()); 
    result = prime * result + ((fS == null) ? 0 : fS.hashCode()); 
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
    if (!ComponentServiceMatch.class.equals(obj.getClass()))
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    				ComponentServiceMatch other = (ComponentServiceMatch) obj;
    				if (fC == null) {if (other.fC != null) return false;}
    				else if (!fC.equals(other.fC)) return false;
    				if (fS == null) {if (other.fS != null) return false;}
    				else if (!fS.equals(other.fS)) return false;
    				return true;
    
  }
  
  @Override
  public Pattern pattern() {
    return ComponentServiceMatcher.FACTORY.getPattern();
  }
}
