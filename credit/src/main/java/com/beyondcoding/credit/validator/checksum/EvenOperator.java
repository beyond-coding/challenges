package com.beyondcoding.credit.validator.checksum;

class EvenOperator extends Operator {

    @Override
    public int operate(int digit) {
        int transformed = digit * 2;
        return merge(transformed);
    }

    private int merge(int digit) {
        if (digit < 10) {
            return digit;
        }
        int docens = digit / 10;
        int units = digit % 10;
        return docens + units;
    }

}