package com.joaoneto.workshopmongo.recursos.excecao;

import com.joaoneto.workshopmongo.servicos.excecao.ExcecaoParaObjetoNaoEncontrado;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManipuladorDeExcecoes {

    @ExceptionHandler(ExcecaoParaObjetoNaoEncontrado.class)
    public ResponseEntity<ErroPadrao> objetoNaoEncontrado(ExcecaoParaObjetoNaoEncontrado e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroPadrao erro = new ErroPadrao(System.currentTimeMillis(), status.value(), "Nao encontrado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(erro);
    }
}
