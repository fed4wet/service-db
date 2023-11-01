package com.compress.servicedb.repository

import com.compress.servicedb.dto.UserDto
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<UserDto, Long>