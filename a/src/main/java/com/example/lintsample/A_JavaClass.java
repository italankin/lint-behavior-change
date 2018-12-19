package com.example.lintsample;

import com.example.annotations.ExternalKotlinAnnotation;

public class A_JavaClass {

    @A_JavaAnnotation
    @A_KotlinAnnotation
    @ExternalKotlinAnnotation
    public int field1;

    @A_JavaAnnotation
    public int field2;

    @A_KotlinAnnotation
    public int field3;
}
