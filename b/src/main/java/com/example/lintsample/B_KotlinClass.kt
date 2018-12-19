package com.example.lintsample

import com.example.annotations.ExternalKotlinAnnotation

class B_KotlinClass {

    @B_JavaAnnotation
    @B_KotlinAnnotation
    @ExternalKotlinAnnotation
    lateinit var field1: String

    @B_JavaAnnotation
    lateinit var field2: String

    @B_KotlinAnnotation
    lateinit var field3: String
}