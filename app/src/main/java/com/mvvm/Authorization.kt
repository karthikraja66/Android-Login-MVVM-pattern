package com.mvvm

enum class Authorization(val userName: String, val password: String) {
    TEST_USER("test@gmail.com", "Welcome123"),
    SAMPLE_USER("sample@gmail.com", "abcd1234"),
    KARTHIK_USER("karthik@gmail.com", "123456789")
}