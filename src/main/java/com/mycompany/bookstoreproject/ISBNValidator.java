package com.mycompany.bookstoreproject;

public class ISBNValidator implements Validator {

    @Override
    public boolean validate(String check) {
        return check.length() == 5;
    }

}
