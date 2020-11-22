package com.securepay.testdata;

import com.github.javafaker.Faker;

public class ContactDetails {

    Faker testData = new Faker();

    public String firstName() {

        return testData.name().firstName();

    }

    public String lastName() {

        return testData.name().lastName();
    }

    public String email() {
        return testData.bothify("????##@test.com");
    }

    public String phone() {
        return testData.phoneNumber().phoneNumber();
    }

    public String cName() {
        return testData.company().name();
    }

    public String url() {
        return testData.company().url();
    }

    public String enqMessage() {
        String enqMsg="SecurePay Code Test";
        return enqMsg;
    }

    public String drpDwnBusinessAmt() {
        String drpDwnBusinessAmt="None, I'm just getting started";
        return drpDwnBusinessAmt;
    }


}
