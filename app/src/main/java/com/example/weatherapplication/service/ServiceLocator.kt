package com.example.weatherapplication.service

object ServiceLocator {
    val services = mutableMapOf<String, Any>()


    inline fun <reified T>registerService(service:Any){
        T::class.qualifiedName?.let{
            services.put(it, service)
        }
    }

    // So this is weird syntax related to kotlin generics and how it handles it
    //in example reified means that the type will try to be resolced in runtime instead of compile time
    inline fun <reified T> getService() :T= services[T::class.qualifiedName] as T


}