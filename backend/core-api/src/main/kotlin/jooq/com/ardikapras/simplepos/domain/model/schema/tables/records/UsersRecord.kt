/*
 * This file is generated by jOOQ.
 */
package com.ardikapras.simplepos.domain.model.schema.tables.records


import com.ardikapras.simplepos.domain.model.schema.tables.Users
import com.ardikapras.simplepos.domain.model.schema.tables.pojos.UsersPojo

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record4
import org.jooq.Row4
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
@Entity
@Table(
    name = "users",
    schema = "public"
)
open class UsersRecord() : UpdatableRecordImpl<UsersRecord>(Users.USERS), Record4<Int?, String?, String?, String?> {

    @get:Id
    @get:GeneratedValue(strategy = GenerationType.IDENTITY)
    @get:Column(name = "user_id", nullable = false, precision = 32)
    open var userId: Int?
        set(value): Unit = set(0, value)
        get(): Int? = get(0) as Int?

    @get:Column(name = "username", nullable = false, length = 50)
    @get:NotNull
    @get:Size(max = 50)
    open var username: String?
        set(value): Unit = set(1, value)
        get(): String? = get(1) as String?

    @get:Column(name = "password", nullable = false, length = 255)
    @get:NotNull
    @get:Size(max = 255)
    open var password: String?
        set(value): Unit = set(2, value)
        get(): String? = get(2) as String?

    @get:Column(name = "role", nullable = false, length = 20)
    @get:NotNull
    @get:Size(max = 20)
    open var role: String?
        set(value): Unit = set(3, value)
        get(): String? = get(3) as String?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row4<Int?, String?, String?, String?> = super.fieldsRow() as Row4<Int?, String?, String?, String?>
    override fun valuesRow(): Row4<Int?, String?, String?, String?> = super.valuesRow() as Row4<Int?, String?, String?, String?>
    override fun field1(): Field<Int?> = Users.USERS.USER_ID
    override fun field2(): Field<String?> = Users.USERS.USERNAME
    override fun field3(): Field<String?> = Users.USERS.PASSWORD
    override fun field4(): Field<String?> = Users.USERS.ROLE
    override fun component1(): Int? = userId
    override fun component2(): String? = username
    override fun component3(): String? = password
    override fun component4(): String? = role
    override fun value1(): Int? = userId
    override fun value2(): String? = username
    override fun value3(): String? = password
    override fun value4(): String? = role

    override fun value1(value: Int?): UsersRecord {
        this.userId = value
        return this
    }

    override fun value2(value: String?): UsersRecord {
        this.username = value
        return this
    }

    override fun value3(value: String?): UsersRecord {
        this.password = value
        return this
    }

    override fun value4(value: String?): UsersRecord {
        this.role = value
        return this
    }

    override fun values(value1: Int?, value2: String?, value3: String?, value4: String?): UsersRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        return this
    }

    /**
     * Create a detached, initialised UsersRecord
     */
    constructor(userId: Int? = null, username: String? = null, password: String? = null, role: String? = null): this() {
        this.userId = userId
        this.username = username
        this.password = password
        this.role = role
    }

    /**
     * Create a detached, initialised UsersRecord
     */
    constructor(value: UsersPojo?): this() {
        if (value != null) {
            this.userId = value.userId
            this.username = value.username
            this.password = value.password
            this.role = value.role
        }
    }
}