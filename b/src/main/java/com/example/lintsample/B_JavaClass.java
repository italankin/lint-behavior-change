package com.example.lintsample;

import com.example.annotations.ExternalKotlinAnnotation;

public class B_JavaClass {

    @B_JavaAnnotation
    @B_KotlinAnnotation
    @ExternalKotlinAnnotation
    public int field1;

    @B_JavaAnnotation
    public int field2;

    @B_KotlinAnnotation
    public int field3;
}
