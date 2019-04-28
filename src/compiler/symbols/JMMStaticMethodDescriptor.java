package compiler.symbols;

import compiler.FunctionSignature;

public class JMMStaticMethodDescriptor extends JMMCallableDescriptor implements StaticFunction {
  public JMMStaticMethodDescriptor(String name, JMMClassDescriptor parent,
                                   TypeDescriptor returnType, FunctionSignature signature,
                                   String[] paramNames) {
    super(name, parent, returnType, signature, paramNames);
  }

  @Override
  public boolean isStatic() {
    return true;
  }
}
