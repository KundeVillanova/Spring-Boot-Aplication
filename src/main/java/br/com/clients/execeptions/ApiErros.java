package br.com.clients.execeptions;

import lombok.Getter;
import java.util.Arrays;
import java.util.List;

public class ApiErros {
    @Getter
    private List<String> errors;
    public ApiErros(List<String> errors) {
        this.errors = errors;
    }
    public ApiErros(String msg){
        this.errors = Arrays.asList(msg);
    }
}