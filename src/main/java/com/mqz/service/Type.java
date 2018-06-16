package com.mqz.service;

import com.mqz.pojo.TypeEntity;

import java.util.List;

public interface Type {
    int typeDelete(int typeid);

    int typeUpdate(TypeEntity type);

    int typeAdd(TypeEntity type);

    List<TypeEntity> getAllType();

    TypeEntity getType(String typename);
}
