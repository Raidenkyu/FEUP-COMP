package compiler.codeGenerator;

import compiler.symbols.TypeDescriptor;

import java.util.HashMap;

// clang-format off
public final class CodeGeneratorConstants {

    public static String DEFAULTSUPER = "java/lang/Object";
    public static String DEFAULTINITIALIZER = "\n.method public <init>()V\n\taload_0\n\tinvokenonvirtual java/lang/Object/<init>()V\n\treturn\n.end method";
    public static String INITIALIZERNAME = "<init>";
    public static HashMap<String, String> types;
    public static HashMap<String, String> store;
    public static HashMap<String, String> load;
    public static HashMap<String, String> binaryOperators;
    public static HashMap<String, String> returnTypes;
    static {
        types = new HashMap<>();
        store = new HashMap<>();
        binaryOperators = new HashMap<>();
        load = new HashMap<>();
        returnTypes = new HashMap<>();
        types.put("int", "I");
        types.put("boolean", "Z");
        types.put("int[]", "[I");
        types.put("void", "V");
        store.put("int", "\n\tistore ?");
        store.put("boolean", "\n\tistore ?");
        binaryOperators.put("+", "\tiadd");
        binaryOperators.put("-", "\tisub");
        binaryOperators.put("*", "\timul");
        binaryOperators.put("/", "\tidiv");
        binaryOperators.put("<", "\tdcmpg");
        binaryOperators.put("&&", "\tiand");
        load.put("int", "\n\tiload ?");
        load.put("boolean", "\n\tiload ?");
        returnTypes.put("int", "?\tireturn");
        returnTypes.put("boolean", "?\tireturn");
        returnTypes.put("int[]", "?\tareturn");
        returnTypes.put("void", "?\treturn");
    }

    /**
     * @return A JVM type descriptor. One of: I, Z, [I, or L<class_name>
     */
    public static String getType(TypeDescriptor typeDescriptor) {
        String typeName = typeDescriptor.getName();
        String jvmType = CodeGeneratorConstants.types.get(typeName);
        return (jvmType != null) ? jvmType : JVMInst.subst(CodeGeneratorConstants.CLASSTYPE, typeName);
    }

    /**
     * 1: name of the class
     */
    public static String CLASSNAME = ".class public ?";
    /**
     * 1: name of the super class
     */
    public static String SUPERNAME = ".super ?";
    /**
     * 1: Locals array size
     */
    public static String LOCALS = "\t.limit locals ?";
    /**
     * 1: Stack size
     */
    public static String STACK = "\t.limit stack ?";
    /**
     * 1: class descriptor
     */
    public static String CLASSTYPE = "L?;";
    /**
     * 1: type descritor of the method's parameters
     */
    public static String METHODDESCRIPTOR = "?";
    /**
     * 1: name of the class to which the method belongs
     * 2: name of the method
     * 3: descriptor of the method
     * 4: return type
     */
    public static String METHODSIGNATURE = "?/?(?)?";
    /**
     * 1: name of the method
     * 2: descriptor of the method
     * 3: return type
     */
    public static String METHODSIGNATURENOCLASS = "?(?)?";
    /**
     * 1: method signature
     * 2: method stack and locals array size
     * 3: method body
     */
    public static String METHOD = "\n.method public ?\n?\n?\n.end method";
    /**
     * 1: index of the variable
     */
    public static String STOREADDRESS = "\n\tastore ?";
    /**
     * 1: index of the variable
     */
    public static String LOADADDRESS = "\taload ?";
    /**
     * 1: number to push to the stack - should be one of: 0,1,2,3,4,5 or m1 (-1)
     */
    public static String PUSHCONST = "\n\ticonst_?";
    public static String ICONST_0 = "\n\ticonst_0";  // false constant
    public static String ICONST_1 = "\n\ticonst_1";  // true constant
    /**
     * 1: number to push to the stack
     */
    public static String PUSHINT = "\tbipush ?";
    /**
     * 1: method signature
     */
    public static String INVOKEVIRTUAL = "\tinvokevirtual ? ";
    /**
     * 1: class name path
     * 2: call variable name
     * 3: type of variable
     */
    public static String GETFIELD = "\n\taload 0\n\tgetfield ?/? ?";

    /**
     * 1: name of label
     */
    public static String LABEL = "?:";

    /**
     * 1: constant to push
     */
    public static String BIPUSH = "\tbipush ?";
    public static String SIPUSH = "\tsipush ?";
    public static String LDC = "\tldc ?";

    /**
     * 1: jump label
     */
    public static String IF_ICMPEQ = "\tif_icmpeq ?";
    public static String IF_ICMPNE = "\tif_icmpne ?";
    public static String IF_ICMPLT = "\tif_icmplt ?";
    public static String IF_ICMPGT = "\tif_icmpgt ?";
    public static String IF_ICMPLE = "\tif_icmple ?";
    public static String IF_ICMPGE = "\tif_icmpge ?";

    /**
     * 1: jump label
     */
    public static String IFEQ = "\tifeq ?";
    public static String IFNE = "\tifne ?";
    public static String IFLT = "\tiflt ?";
    public static String IFGT = "\tifgt ?";
    public static String IFLE = "\tifle ?";
    public static String IFGE = "\tifge ?";

    /**
     * 1: jump label
     */
    public static String GOTO = "\tgoto ?";

    /**
     * 1: class name path
     * 2: call variable name
     * 3: type of variable
     */
    public static String PUTFIELD = "\n\taload 0\n\tswap\n\tputfield ?/? ?";
    /**
     * Main
     */
    public static String MAIN = "\n\n.method public static main([Ljava/lang/String;)V\n?\n?\n?\n.end method";
    public static String DEFAULTMAIN = "\n\n.method public static main([Ljava/lang/String;)V\n\t.limit stack 1\n\t.limit locals 1\n\treturn\n.end method";
}
