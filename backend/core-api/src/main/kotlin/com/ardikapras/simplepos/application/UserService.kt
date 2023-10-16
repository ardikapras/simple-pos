package com.ardikapras.simplepos.application

import com.ardikapras.simplepos.domain.model.User
import com.ardikapras.simplepos.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun getAllUsers(): List<User> = userRepository.findAll()

    fun getUserById(id: Long): User? = userRepository.findById(id)

    fun createUser(user: User): User = userRepository.save(user)

    fun updateUser(user: User): User = userRepository.update(user)

    fun deleteUser(id: Long) = userRepository.delete(id)
}
