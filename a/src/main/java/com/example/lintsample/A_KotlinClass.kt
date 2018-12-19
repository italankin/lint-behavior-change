package com.example.lintsample

import com.example.annotations.ExternalKotlinAnnotation

class A_KotlinClass {

    @A_JavaAnnotation
    @A_KotlinAnnotation
    @ExternalKotlinAnnotation
    lateinit var field1: String

    @A_JavaAnnotation
    lateinit var field2: String

    @A_KotlinAnnotation
    lateinit var field3: String
}