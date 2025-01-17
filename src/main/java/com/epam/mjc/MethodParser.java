package com.epam.mjc;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import  com.epam.mjc.MethodSignature;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        String accessModifier=null;
        String returnType = null;
        String methodName = null;
        List<String> strList = new ArrayList<>();
        List<MethodSignature.Argument> arguments = new ArrayList<>();
        StringTokenizer st1 = new StringTokenizer(signatureString, "(),");
        while (st1.hasMoreTokens())strList.add(st1.nextToken());
        if(strList.get(0).contains(" ")){
            String[] arr =strList.get(0).split(" ");
            if(arr.length==3){
                accessModifier=arr[0];
                returnType=arr[1];
            }
            if(arr.length==2){
                returnType=arr[0];
            }
            methodName = arr[arr.length-1];
        }else methodName = strList.get(0);

        for(int i = 1;i<strList.size();i++){
            if(i>1)strList.set(i,strList.get(i).trim());
            String[] strArray = strList.get(i).split(" ");
            MethodSignature.Argument arg =new MethodSignature.Argument(strArray[0],strArray[1]);
        arguments.add(arg);
        }
        MethodSignature ms = new MethodSignature(methodName,arguments);
        ms.setAccessModifier(accessModifier);
        ms.setReturnType(returnType);
        return ms;
    }


}
