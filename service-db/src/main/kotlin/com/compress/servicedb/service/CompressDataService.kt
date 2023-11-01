package com.compress.servicedb.service

import com.compress.servicedb.dto.UserDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service
import java.io.ByteArrayOutputStream
import java.nio.charset.StandardCharsets
import java.util.zip.GZIPOutputStream

@Service
class CompressDataService(
    private val objectMapper: ObjectMapper
) {
    fun compress(data: Iterable<UserDto>): ByteArray {
        val jsonString = objectMapper.writeValueAsString(data)
        val byteArrayOutputStream = ByteArrayOutputStream()
        GZIPOutputStream(byteArrayOutputStream).use { gzipOutputStream ->
            val bytes = jsonString.toByteArray(StandardCharsets.UTF_8)
            gzipOutputStream.write(bytes)
        }
        return byteArrayOutputStream.toByteArray()
    }
}