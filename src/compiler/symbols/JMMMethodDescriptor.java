package compiler.symbols;

import compiler.symbols.FunctionSignature;

public class JMMMethodDescriptor extends JMMCallableDescriptor implements MethodFunction {
  public JMMMethodDescriptor(String name, JMMClassDescriptor parent, TypeDescriptor returnType,
                             FunctionSignature signature, String[] paramNames) {
    super(name, parent, returnType, signature, paramNames);
    assert !parent.hasMethod(name, signature);
    parent.addMethod(this);
  }

  @Override
  public boolean isStatic() {
    return false;
  }
}
