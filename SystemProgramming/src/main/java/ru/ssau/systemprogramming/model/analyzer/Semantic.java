package ru.ssau.systemprogramming.model.analyzer;

public class Semantic {

    private int numberOfExecutions;

    private String firstNumber;

    private String secondNumber;

    private String operandName;

    private String secondOperandName;

    private String thirdOperandName;

    private boolean equalSign;

    private boolean greaterCondition;

    private boolean incrementrCondition;

    private boolean firstNumberInCondition;

    public Semantic() {
        firstNumberInCondition = false;
        equalSign = false;
        greaterCondition = false;
        incrementrCondition = true;
        firstNumber = "";
        secondNumber = "";
        numberOfExecutions = 0;
        operandName = "";
        secondOperandName = "";
        thirdOperandName = "";
    }

    public int getNumberOfExecutions() {

        int first = Integer.parseInt(firstNumber);
        int second = Integer.parseInt(secondNumber);

        if (!isFirstNumberInCondition()) {
            if (isGreaterCondition()) {
                // >
                if (first < second) {
                    return 0;
                } else {
                    if (isIncrementrCondition()) {
                        return -1;
                    } else {
                        return calculate(first, second);
                    }
                }
                // <
            } else {
                if (first > second) {
                    return 0;
                } else {
                    if (isIncrementrCondition()) {
                        return calculate(first, second);
                    } else {
                        return -1;
                    }
                }
            }
        } else {
            // For first number in condition
            if (isGreaterCondition()) {
                // >
                if (first < second) {
                    return 0;
                } else {
                    if (!isIncrementrCondition()) {
                        return -1;
                    } else {
                        return calculate(first, second);
                    }
                }
                // <
            } else {
                if (first < second) {
                    return 0;
                } else {
                    if (!isIncrementrCondition()) {
                        return calculate(first, second);
                    } else {
                        return -1;
                    }
                }
            }
        }
    }

    private int calculate(int firstOperand, int secondOperand) {
        int result = -1;

        if (isIncrementrCondition()) {
            result = secondOperand - firstOperand;
        } else {
            result = firstOperand - secondOperand;
        }

        if (isEqualsign()) {
            result += 1;
        }
        return result;
    }

    public boolean compareMainOperandWithSecond() {
        return operandName.equals(secondOperandName);
    }

    public boolean compareMainOperandWithThird() {
        return operandName.equals(thirdOperandName);
    }

    public void addCharToOperandName(char ch) {
        if (SyntaxClass.isDigit(ch)) {
            operandName = operandName + SyntaxClass.charDigitToInt(ch);
        } else {
            operandName = operandName + ch;
        }
    }

    public void addNumberToFirstNumber(char ch) {
        firstNumber = firstNumber + SyntaxClass.charDigitToInt(ch);
    }

    public void addNumberToSecondNumber(char ch) {
        secondNumber = secondNumber + SyntaxClass.charDigitToInt(ch);
    }

    public void addCharToSecondOperandName(char ch) {
        if (SyntaxClass.isDigit(ch)) {
            secondOperandName = secondOperandName + SyntaxClass.charDigitToInt(ch);
        } else {
            secondOperandName = secondOperandName + ch;
        }
    }

    public void addCharToThirdOperandName(char ch) {
        if (SyntaxClass.isDigit(ch)) {
            thirdOperandName = thirdOperandName + SyntaxClass.charDigitToInt(ch);
        } else {
            thirdOperandName = thirdOperandName + ch;
        }
    }

    public boolean isEqualsign() {
        return equalSign;
    }

    public void setEqualsign(boolean flag) {
        equalSign = flag;
    }

    public String getOperandName() {
        return operandName;
    }

    public String getFirstNumber() {
        return firstNumber;
    }

    public void setGreaterCondition(boolean greaterCondition) {
        this.greaterCondition = greaterCondition;
    }

    public boolean isIncrementrCondition() {
        return incrementrCondition;
    }

    public void setIncrementrCondition(boolean incrementrCondition) {
        this.incrementrCondition = incrementrCondition;
    }

    public boolean isGreaterCondition() {
        return greaterCondition;
    }

    public String getSecondOperandName() {
        return secondOperandName;
    }

    public String getThirdOperandName() {
        return thirdOperandName;
    }

    public String getSecondNumber() {
        return secondNumber;
    }

    public boolean isFirstNumberInCondition() {
        return firstNumberInCondition;
    }

    public void setFirstNumberInCondition(boolean firstNumberInCondition) {
        this.firstNumberInCondition = firstNumberInCondition;
    }
}
