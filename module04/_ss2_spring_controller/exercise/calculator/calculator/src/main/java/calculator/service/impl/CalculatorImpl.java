package calculator.service.impl;

import calculator.service.ICalculator;
import org.springframework.stereotype.Service;

@Service
public class CalculatorImpl implements ICalculator {
    @Override
    public double calculator(double num1, double num2, String val) {
        switch (val ){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 !=0) {
                    return num1 / num2;
                }else {
                    throw new ArithmeticException("Divide by zero");
                }
        }
        return 0;
    }
}
