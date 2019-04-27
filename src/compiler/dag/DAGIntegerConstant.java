package compiler.dag;

import compiler.symbols.PrimitiveDescriptor;
import compiler.symbols.TypeDescriptor;

public class DAGIntegerConstant extends DAGExpression {
  protected int constant;

  DAGIntegerConstant(int constant) {
    this.constant = constant;
  }

  public int getValue() {
    return constant;
  }

  @Override
  public TypeDescriptor getType() {
    return PrimitiveDescriptor.intDescriptor;
  }
}
