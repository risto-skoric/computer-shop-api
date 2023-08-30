package risto.computer.shop.api.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    private Object data;
    private CustomError customError;

    public static <T> Response success (T data) {
        return new Response(data, null);
    }

    public static Response error (CustomError customError) {
        return new Response(null, customError);
    }
}
