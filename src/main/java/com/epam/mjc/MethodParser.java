package com.epam.mjc;

import java.util.LinkedList;

import java.util.List;

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

        MethodSignature signature = new MethodSignature();

        String accessModifier = null;

        String returnType = null;

        String methodName = null;

        List<MethodSignature.Argument> arguments = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        String b = null;

        for(int i = 0; i < signatureString.length(); i++) {

            if(signatureString.charAt(i) != '(') {

                sb.append(signatureString.charAt(i));

            } else { break;}

        }

        b = sb.toString();

        String[] c = b.split(" ");

        if(c.length == 3) {

            signature.setAccessModifier(c[0]);

            signature.setReturnType(c[1]);

            signature.setMethodName(c[2]);


        } else if (c.length == 2) {

            signature.setReturnType(c[0]);

            signature.setMethodName(c[1]);


        }


        int check = 0;

        StringBuilder sbb = new StringBuilder();

        for( int i = 0; i < signatureString.length(); i++ ) {

            if(signatureString.charAt(i) == '(') {

                check = 1;


            }

            if(check == 1 && signatureString.charAt(i) != '(' && signatureString.charAt(i) != ')') {

                sbb.append(signatureString.charAt(i));

            }


        }

        String x = sbb.toString();


        String[] d = x.split(", ");


        if(x.length() != 0) {

            for (int i = 0; i < d.length; i++) {

                String[] d1 = d[i].split(" ");

                MethodSignature.Argument argument = new MethodSignature.Argument();

                argument.setType(d1[0]);

                argument.setName(d1[1]);

                arguments.add(argument);

            }

        }

        signature.setArguments(arguments);

        return signature;

    }
}
