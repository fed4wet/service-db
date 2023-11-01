package com.compress.servicedb.controller

import com.compress.servicedb.dto.UserDto
import com.compress.servicedb.repository.UserRepository
import com.compress.servicedb.service.CompressDataService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class CompressedDataController(
    private val repository: UserRepository,
    private val compressDataService: CompressDataService,

    ) {
    @GetMapping("/compressed")
    fun fetchCompressedData(): ByteArray {
        val data: Iterable<UserDto> = repository.findAll()
        return compressDataService.compress(data)
    }
}