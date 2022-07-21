package com.excercise.javaEnum.enumPackage.package2;

import static com.excercise.javaEnum.enumPackage.package3.Bank.ICICI;

import com.excercise.javaEnum.enumPackage.package1.Color;

public class EnumImport {
    public static void main(String[] args){

        // printing enum Color constant 
        // accesing enum constant through class name
        System.out.println(Color.Red);

        // accesing enum constant without class name
        System.out.println(ICICI+" "+ICICI.getMarketValue());
    }
}
