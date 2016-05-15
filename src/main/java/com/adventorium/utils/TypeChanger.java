package com.adventorium.utils;

import java.util.logging.Logger;

/**
 * Created by Андрей on 08.05.2016.
 */
/***
 * Класс для преобразование типов
 * @param <T1> Тип входной
 * @param <T2> Тип выходной
 */
public abstract class TypeChanger<T1 extends Comparable,T2 extends Comparable> {

    //private static final Logger LOG = Logger.getLogger(TypeChanger.class.getName());

    public abstract T2 apply(T1 input);
}
