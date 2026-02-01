package com.joaoneto.workshopmongo.recursos.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {

    public static String decodificarParametro(String texto) throws UnsupportedEncodingException {
        return URLDecoder.decode(texto, "UTF-8");
    }

    public static Date dataDeConversao(String textoData, Date dataPadrao) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(textoData);
        } catch (ParseException e) {
            return dataPadrao;
        }
    }

}
