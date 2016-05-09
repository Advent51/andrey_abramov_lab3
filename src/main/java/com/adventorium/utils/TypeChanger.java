package com.adventorium.utils;

import java.util.ListIterator;
import java.util.logging.Logger;

/**
 * Created by Андрей on 08.05.2016.
 */
/***
 * Класс для преобразование типов
 * @param <T> Тип входной
 * @param <R> Тип выходной
 */
public class TypeChanger<T extends Comparable,R extends Comparable> {
    private static final Logger LOG = Logger.getLogger(TypeChanger.class.getName());

    Class<R> resultType;

    public TypeChanger(Class<R> resultType) {
        this.resultType = resultType;
    }

    public R apply(T input) {
        if (input == null){
            return null;
        }
        try {
            return resultType.getConstructor(String.class).newInstance(input.toString());
        } catch (Exception e) {
            LOG.info("Возникла ошибка при преобразовании типа");
        }
        return null;
    }
}
