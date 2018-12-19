package com.example.lintsample

import com.example.annotations.ExternalKotlinAnnotation

class A_KotlinClass {

    @A_JavaAnnotation
    @A_KotlinAnnotation
    @ExternalKotlinAnnotation
    lateinit var field1: String
}