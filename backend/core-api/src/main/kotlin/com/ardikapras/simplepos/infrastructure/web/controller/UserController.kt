package com.ardikapras.simplepos.infrastructure.web.controller

import com.ardikapras.simplepos.application.UserService
import com.ardikapras.simplepos.domain.model.User
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getAllUsers(): List<User> = userService.getAllUsers()

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): User? = userService.getUserById(id)

    @PostMapping
    fun createUser(@RequestBody user: User): User = userService.createUser(user)

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody user: User): User {
        require(id == user.id) { "ID in the path and body must match." }
        return userService.updateUser(user)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) = userService.deleteUser(id)
}
