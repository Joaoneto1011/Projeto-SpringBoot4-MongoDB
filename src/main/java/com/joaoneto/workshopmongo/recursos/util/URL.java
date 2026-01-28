package com.joaoneto.workshopmongo.recursos.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

    public static String decodificarParametro(String texto) throws UnsupportedEncodingException {
        return URLDecoder.decode(texto, "UTF-8");
    }
}
