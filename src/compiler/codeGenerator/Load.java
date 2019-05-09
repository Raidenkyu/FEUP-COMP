package compiler.codeGenerator;

import compiler.dag.DAGLocal;
import compiler.symbols.LocalDescriptor;
import java.util.HashMap;

public class Load extends JVMInst {

    public static HashMap<String, String> load = new HashMap<>();
    static{
        load.put("int", "\tiload ?");
        load.put("boolean", "\tiload ?");
    }
    /**
     * 1: index of the variable
     */
    public static String LOADADDRESS = "\taload ?";

    private LocalDescriptor variableDescriptor;
    private Integer variableIndex;

    public Load(Function function, DAGLocal variable)
    {
        super(function);
        this.variableDescriptor = variable.getVariable();
        this.variableIndex = this.function.variablesIndexes.get(variableDescriptor);
    }

    @Override
    public String toString()
    {
        if(variableIndex == null) { // class field
            return "";
        }
        String variableType = variableDescriptor.getType().toString();
        String regexLoad = Load.load.get(variableType);
        if(regexLoad == null)
            regexLoad = Load.LOADADDRESS;
        return subst(regexLoad, String.valueOf(variableIndex+1)) + "\n";
    }
    
}