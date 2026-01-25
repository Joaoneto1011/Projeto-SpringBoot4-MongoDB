package com.joaoneto.workshopmongo.servicos.excecao;

public class ExcecaoParaObjetoNaoEncontrado extends RuntimeException {

    public ExcecaoParaObjetoNaoEncontrado(String mensagem) {
        super(mensagem);
    }
}
