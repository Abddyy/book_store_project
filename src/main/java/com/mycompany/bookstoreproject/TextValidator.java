package com.mycompany.bookstoreproject;

public class TextValidator implements Validator {

    @Override
    public boolean validate(String check) {
        return check.length() != 0;
    }

}
