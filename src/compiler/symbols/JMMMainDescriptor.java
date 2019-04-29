package compiler.symbols;

import java.util.Objects;

/**
 * A descriptor for a JMM class's main method.
 */
public class JMMMainDescriptor
    extends BaseFunctionDescriptor implements JMMFunction, StaticFunction {
  protected final String paramName;

  /**
   * Creates a new main static method descriptor for a JMM class.
   *
   * The parameter name of String[] is just a dummy.
   *
   * @param parent    The JMM class
   * @param paramName The name of the String[] parameter
   */
  public JMMMainDescriptor(JMMClassDescriptor parent, String paramName) {
    super("main", parent);
    assert paramName != null && !parent.hasMain();
    this.paramName = paramName;
    parent.setMain(this);
  }

  /**
   * @return The name assigned to the parameter with type String[]
   */
  public String getParameterName() {
    return paramName;
  }

  @Override
  public JMMClassDescriptor getParentClass() {
    return (JMMClassDescriptor) classDescriptor;
  }

  @Override
  public boolean isStatic() {
    return true;
  }

  @Override
  public boolean isJMM() {
    return true;
  }

  @Override
  public boolean hasParameters() {
    return true;
  }

  @Override
  public int getNumParameters() {
    return 1;
  }

  @Override
  public VoidDescriptor getReturnType() {
    return TypeDescriptor.voidDescriptor;
  }

  @Override
  public boolean hasParameter(String name) {
    return false;
  }

  @Override
  public ParameterDescriptor getParameter(String name) {
    return null;
  }

  @Override
  public TypeDescriptor getParameterType(String name) {
    return null;
  }

  @Override
  public VariableDescriptor resolve(String name) {
    return getParentClass().resolveStatic(name);
  }

  @Override
  public String toString() {
    return "main(String[] " + paramName + ")";
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + Objects.hash(paramName);
    return result;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!super.equals(obj)) return false;
    if (!(obj instanceof JMMMainDescriptor)) return false;
    JMMMainDescriptor other = (JMMMainDescriptor) obj;
    return Objects.equals(paramName, other.paramName);
  }

  @Override
  public ParameterDescriptor[] getParameters()
  {
    //TODO?
    return null;
  }

}
