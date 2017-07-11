package com.dqr.kotlin.service

import org.springframework.stereotype.Service

/**
 * Created by dqromney on 7/11/17.
 */
@Service
class HelloService {

    fun getHello(): String {
        return "hello service"
    }
}