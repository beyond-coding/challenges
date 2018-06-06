package com.beyondcoding.credit.validator;

import com.beyondcoding.credit.validator.checksum.ChecksumCalculator;

public class ChecksumValidator implements Validator {

    @Override
    public boolean isValid(String number) {
        ChecksumCalculator checksumCalculator = new ChecksumCalculator();
        int checksum = checksumCalculator.calculate(number);
        return checksum % 10 == 0;
    }

}
