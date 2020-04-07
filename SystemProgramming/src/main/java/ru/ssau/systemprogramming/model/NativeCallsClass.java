package ru.ssau.systemprogramming.model;

public class NativeCallsClass {

    static
    {
        System.load("/home/eugene/IdeaProjects/SystemProgramming/bin/nativecall.so");
    }
    native public static int inputInt(int firstOperand,int secondOperand);

}
