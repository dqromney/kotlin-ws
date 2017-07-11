package com.dqr.kotlinws

import com.dqr.kotlinws.utils.XForwardHostHandlingHttp11NioProtocol
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory
import org.springframework.context.annotation.Bean
import javax.transaction.Transactional

@SpringBootApplication
open class Main {

    @Bean
    @Transactional
    open fun demo() {

    }

    companion object {
        /**
         * This functional must be in the companion object and annotated with `@JvmStatic` for maven to know the main
         * method to run.
         */
        @JvmStatic fun main(args: Array<String>) {
//            if (Encryptor.initialize("my-kotlin-ws").run(*args)) {
//                return
//            }
            SpringApplication.run(Main::class.java, *args)
        }

        @Bean
        fun embeddedServletContainerCustomizer(): EmbeddedServletContainerCustomizer {
            return EmbeddedServletContainerCustomizer { factory ->
                (factory as TomcatEmbeddedServletContainerFactory).setProtocol(XForwardHostHandlingHttp11NioProtocol::class.java.name)
            }
        }
    }
}
