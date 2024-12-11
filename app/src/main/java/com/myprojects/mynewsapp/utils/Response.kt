package com.myprojects.mynewsapp.utils

sealed  class NewsResource<T>(val data:T?=null, val message:String?=null){

    class  Success<T>(data:T?): NewsResource<T>(data = data)

    class Loading<T>(message: String?) : NewsResource<T>()

    class Error<T>(message:String?) : NewsResource<T>(message= message)

}