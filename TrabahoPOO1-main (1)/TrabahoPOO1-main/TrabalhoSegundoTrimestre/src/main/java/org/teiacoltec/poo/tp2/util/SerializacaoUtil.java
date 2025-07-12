package org.teiacoltec.poo.tp2.util;

import java.io.*;
import java.util.List;

public class SerializacaoUtil {
    public static <T> void salvarLista(List<T> lista, String arquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(lista);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> carregarLista(String arquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<T>) ois.readObject();
        }
    }
} 