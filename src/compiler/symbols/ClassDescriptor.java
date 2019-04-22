package compiler.symbols;

/**
 * The base class of any Java class descriptor. This class has a non fully
 * qualified class name and can resolve both instance and static names from
 * among its (static and non-static) data members.
 */
public abstract class ClassDescriptor extends TypeDescriptor {
  public ClassDescriptor(String name) {
    super(name);
  }

  public String getClassName() {
    return getName();
  }

  public abstract Descriptor resolve(String name);

  public abstract Descriptor resolveStatic(String name);

  @Override
  public String toString() {
    return "class " + getClassName();
  }
}