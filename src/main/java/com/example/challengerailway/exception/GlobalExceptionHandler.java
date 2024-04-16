package com.example.challengerailway.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<String> handleUsuarioNaoEncontradoException(UsuarioNaoEncontradoException usuarioNaoEncontradoException){
        var message = usuarioNaoEncontradoException.getMessage();
        logger.error(message);
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CursoNaoEncontradoException.class)
    public ResponseEntity<String> handleCursoNaoEncontradoException(CursoNaoEncontradoException cursoNaoEncontradoException){
        var message = cursoNaoEncontradoException.getMessage();
        logger.error(message);
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CursoExistenteException.class)
    public ResponseEntity<String> handleCursoNaoEncontradoException(CursoExistenteException cursoExistenteException){
        var message = cursoExistenteException.getMessage();
        logger.error(message);
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MatriculaNaoEncontradaException.class)
    public ResponseEntity<String> handleMatriculaNaoEncontradaException(MatriculaNaoEncontradaException matriculaNaoEncontradaException){
        var message = matriculaNaoEncontradaException.getMessage();
        logger.error(message);
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}
