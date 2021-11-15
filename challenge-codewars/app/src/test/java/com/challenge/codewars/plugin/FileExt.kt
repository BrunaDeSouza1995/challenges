package com.challenge.codewars.plugin

import com.google.gson.Gson
import com.google.gson.internal.Primitives
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

object FileExt {

    fun <T : Any> getDataFromJsonFile(testClass: Class<*>, clazz: Class<T>, testPath: String): T {
        val readerPath = getFile(testClass, testPath).path
        val bufferedReader = BufferedReader(FileReader(readerPath))
        val `object`: Any = Gson().fromJson(bufferedReader, clazz)
        return Primitives.wrap(clazz).cast(`object`)!!
    }

    private fun getFile(testClass: Class<*>, testPath: String): File {
        val classLoader = testClass.classLoader
        val resource = classLoader?.getResource(testPath)
        return File(resource!!.path)
    }
}