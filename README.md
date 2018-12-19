This sample demonstrates a behavior change in Android Lint API between Android Gradle Plugin versions `3.3.0-alpha03` and `3.3.0-alpha04`

# Modules

* `:annotations` - a module which contains custom annotation class
* `:compile_annotations` - a module which declares a `compile` dependency on `:annotations`
* `:a` - Android app module which depends on `:compile_annotations`
* `:b` - Android app module with a `implementation` dependency on `:annotations`

# Issues with 3.3.0-alpha04 and above

The output for `lintDebug` task with plugin `3.3.0-alpha03` is:

```
A_KotlinClass
 * field1
   - org.jetbrains.annotations.NotNull
   - com.example.lintsample.A_JavaAnnotation
   - com.example.lintsample.A_KotlinAnnotation
   - com.example.annotations.ExternalKotlinAnnotation

A_JavaClass
 * field1
   - com.example.lintsample.A_JavaAnnotation
   - com.example.lintsample.A_KotlinAnnotation
   - com.example.annotations.ExternalKotlinAnnotation

B_JavaClass
 * field1
   - com.example.lintsample.B_JavaAnnotation
   - com.example.lintsample.B_KotlinAnnotation
   - com.example.annotations.ExternalKotlinAnnotation

B_KotlinClass
 * field1
   - org.jetbrains.annotations.NotNull
   - com.example.lintsample.B_JavaAnnotation
   - com.example.lintsample.B_KotlinAnnotation
   - com.example.annotations.ExternalKotlinAnnotation
```

Note the qualified names of annotations, e.g.: `com.example.annotations.ExternalKotlinAnnotation`.

But with `3.3.0-alpha04` the behavior is different:

```
A_KotlinClass
 * field1
   - org.jetbrains.annotations.NotNull
   - com.example.lintsample.A_JavaAnnotation
   - com.example.lintsample.A_KotlinAnnotation
   - com.example.annotations.ExternalKotlinAnnotation

A_JavaClass
 * field1
   - com.example.lintsample.A_JavaAnnotation
   - com.example.lintsample.A_KotlinAnnotation
   - com.example.annotations.ExternalKotlinAnnotation

B_JavaClass
 * field1
   - com.example.lintsample.B_JavaAnnotation
   - com.example.lintsample.B_KotlinAnnotation
   - ExternalKotlinAnnotation

B_KotlinClass
 * field1
   - org.jetbrains.annotations.NotNull
   - com.example.lintsample.B_JavaAnnotation
   - com.example.lintsample.B_KotlinAnnotation
   - null
```

For `B_JavaClass`, `ExternalKotlinAnnotation` has a qualified name `ExternalKotlinAnnotation`, and for kotlin one it is simply `null`.