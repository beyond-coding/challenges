package com.beyondcoding.credit.validator.checksum;

import java.util.*;

public class ChecksumCalculator {

    private Queue<Operator> operators = new LinkedList<>(Arrays.asList(
            new OddOperator(),
            new EvenOperator()
    ));

    public int calculate(String number) {
        List<String> digits = reverse(number);
        return digits.stream()
                .map(Integer::parseInt)
                .map(digit -> operate(digit))
                .reduce(0, (e1, e2) -> e1 + e2);
    }

    List<String> reverse(String number) {
        String[] split = number.split("");
        List<String> digits = Arrays.asList(split);
        Collections.reverse(digits);
        return digits;
    }

    private Integer operate(Integer digit) {
        Operator operator = operators.poll();
        operators.add(operator);
        return operator.operate(digit);
    }
}