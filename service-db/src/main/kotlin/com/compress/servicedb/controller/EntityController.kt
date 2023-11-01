package com.compress.servicedb.controller

import com.compress.servicedb.dto.UserDto
import com.compress.servicedb.repository.UserRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class EntityController(
    private val repository: UserRepository
) {

    @GetMapping
    fun getAll(): MutableIterable<UserDto> = repository.findAll()

    @PostMapping
    fun create(@RequestBody user: UserDto) = repository.save(user)

    @PostMapping("/bulk")
    fun createBulk(@RequestBody users: List<UserDto>): MutableIterable<UserDto> = repository.saveAll(users)

}