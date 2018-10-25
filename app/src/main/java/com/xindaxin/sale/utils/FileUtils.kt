package com.xindaxin.sale.utils

import java.io.File

/**
 * 创建者：王统根
 * 时间：2018-07-22
 * 描述：文件的工具类
 */
object FileUtils {
    /**
     * 获取文件
     */
    fun getFileByPath(filePath: String): File {
        return File(filePath)
    }

    /**
     * 判断文件是否存在
     */
    fun isFileExists(filePath: String): Boolean {
        return isFileExists(getFileByPath(filePath))
    }

    /**
     * 判断文件是否存在
     */
    fun isFileExists(file: File): Boolean {
        return file.exists()
    }

    /**
     * 文件重命名
     */
    fun rename(filePath: String, newName: String): Boolean {
        return rename(getFileByPath(filePath), newName)
    }

    /**
     * 文件重命名
     */
    fun rename(file: File, newName: String): Boolean {
        // file is null then return false
//        if (file == null) return false
        // file doesn't exist then return false
        if (!file.exists()) return false
        // the new name equals old name then return true
        if (newName == file.name) return true
        val newFile = File(file.parent + File.separator + newName)
        // the new name of file exists then return false
        return !newFile.exists() && file.renameTo(newFile)
    }

    /**
     * 判断是否是文件夹
     */
    fun isDir(dirPath: String): Boolean {
        return isDir(getFileByPath(dirPath))
    }

    /**
     * 判断是否是文件夹
     */
    fun isDir(file: File): Boolean{
        return file.exists() && file.isDirectory
    }

    /**
     * 是否是文件
     */
    fun isFile(filePath: String): Boolean {
        return isFile(getFileByPath(filePath))
    }

    /**
     * 是否是文件
     */
    fun isFile(file: File): Boolean {
        return file.exists() && file.isFile
    }

    /**
     * 创建文件
     */
    fun createFile(filePath: String): Boolean {
        return createFile(getFileByPath(filePath))
    }

    /**
     * 创建文件
     */
    fun createFile(file: File): Boolean {
        return if (file.exists()) false else file.createNewFile()
    }

    /**
     * 创建文件夹
     */
    fun creataDir(filePath: String): Boolean {
        return createDir(getFileByPath(filePath))
    }

    /**
     * 创建文件夹
     */
    fun createDir(file: File): Boolean {
        return if (file.exists()) false else file.mkdirs()
    }
}