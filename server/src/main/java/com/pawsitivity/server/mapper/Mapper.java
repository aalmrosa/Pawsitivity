package com.pawsitivity.server.mapper;

public interface Mapper<A, B> {

    B mapToDto(A a);
    
    A mapToEntity(B b);

}
