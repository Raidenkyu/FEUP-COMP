package compiler.symbols;

import compiler.FunctionSignature;

public abstract class JavaMethodDescriptor
    extends JavaCallableDescriptor implements MethodFunction {
  protected JavaMethodDescriptor(String name, ClassDescriptor parent, TypeDescriptor returnType,
                                 FunctionSignature signature) {
    super(name, parent, returnType, signature);
  }

  @Override
  public boolean isStatic() {
    return false;
  }
}