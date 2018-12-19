package com.example.lintsample

import com.example.annotations.ExternalKotlinAnnotation

class B_KotlinClass {

    @B_JavaAnnotation
    @B_KotlinAnnotation
    @ExternalKotlinAnnotation
    lateinit var field: String
}