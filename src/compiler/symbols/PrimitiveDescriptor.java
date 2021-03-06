package compiler.symbols;

import static compiler.symbols.PrimitiveDescriptor.Type.BOOLEAN;
import static compiler.symbols.PrimitiveDescriptor.Type.INT;
import static compiler.symbols.PrimitiveDescriptor.Type.INTARRAY;

/**
 * Up for refactoring any day. Consider a design with a class for int and boolean,
 * and also a class for array. This would be more appropriate if the language was more complete.
 */
public class PrimitiveDescriptor extends TypeDescriptor {
  public enum Type {
    INT("int"),
    INTARRAY("int[]"),
    BOOLEAN("boolean");

    private final String str;

    Type(String s) {
      this.str = s;
    }

    @Override
    public String toString() {
      return str;
    }
  }

  private final Type primitive;

  // The descriptor of the type "int"
  public static final PrimitiveDescriptor intDescriptor = new PrimitiveDescriptor(INT);

  // The descriptor of the type "int[]"
  public static final PrimitiveDescriptor intArrayDescriptor = new PrimitiveDescriptor(INTARRAY);

  // The descriptor of the type "boolean"
  public static final PrimitiveDescriptor booleanDescriptor = new PrimitiveDescriptor(BOOLEAN);

  /**
   * Constructs a new Primitive type.
   *
   * All instances of this class should be public static fields above.
   */
  private PrimitiveDescriptor(Type primitive) {
    super(primitive.toString());
    this.primitive = primitive;
  }

  @Override
  public boolean isPrimitive() {
    return primitive != Type.INTARRAY;
  }

  @Override
  public boolean isClass() {
    return false;
  }

  @Override
  public boolean isArray() {
    return primitive == Type.INTARRAY;
  }

  @Override
  public String getBytecodeString() {
    switch (primitive) {
    case INT:
      return "I";
    case INTARRAY:
      return "[I";
    case BOOLEAN:
      return "Z";
    }

    // We should never arrive here
    assert false;
    return null;
  }
}
