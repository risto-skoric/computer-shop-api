package risto.computer.shop.api.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomError {

    private int errorCode;
    private String errorMessage;

    public static CustomError emptyFiledError(String filedName) {
        return new CustomError(100, filedName + " can not be empty!");
    }
    public static CustomError noCustomers() {
        return new CustomError(101, "No customers found!");
    }

    public static CustomError customerNotFound () {
        return new CustomError(102,"Customer not found!");
    }
}