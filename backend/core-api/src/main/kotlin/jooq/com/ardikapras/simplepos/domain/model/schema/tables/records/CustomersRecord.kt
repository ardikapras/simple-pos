/*
 * This file is generated by jOOQ.
 */
package com.ardikapras.simplepos.domain.model.schema.tables.records


import com.ardikapras.simplepos.domain.model.schema.tables.Customers
import com.ardikapras.simplepos.domain.model.schema.tables.pojos.CustomersPojo

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

import java.time.LocalDateTime

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record8
import org.jooq.Row8
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
@Entity
@Table(
    name = "customers",
    schema = "public"
)
open class CustomersRecord() : UpdatableRecordImpl<CustomersRecord>(Customers.CUSTOMERS), Record8<Int?, String?, String?, String?, String?, String?, LocalDateTime?, LocalDateTime?> {

    @get:Id
    @get:GeneratedValue(strategy = GenerationType.IDENTITY)
    @get:Column(name = "customer_id", nullable = false, precision = 32)
    open var customerId: Int?
        set(value): Unit = set(0, value)
        get(): Int? = get(0) as Int?

    @get:Column(name = "first_name", nullable = false, length = 50)
    @get:NotNull
    @get:Size(max = 50)
    open var firstName: String?
        set(value): Unit = set(1, value)
        get(): String? = get(1) as String?

    @get:Column(name = "last_name", nullable = false, length = 50)
    @get:NotNull
    @get:Size(max = 50)
    open var lastName: String?
        set(value): Unit = set(2, value)
        get(): String? = get(2) as String?

    @get:Column(name = "email", length = 100)
    @get:Size(max = 100)
    open var email: String?
        set(value): Unit = set(3, value)
        get(): String? = get(3) as String?

    @get:Column(name = "phone", length = 20)
    @get:Size(max = 20)
    open var phone: String?
        set(value): Unit = set(4, value)
        get(): String? = get(4) as String?

    @get:Column(name = "address")
    open var address: String?
        set(value): Unit = set(5, value)
        get(): String? = get(5) as String?

    @get:Column(name = "created_at", precision = 6)
    open var createdAt: LocalDateTime?
        set(value): Unit = set(6, value)
        get(): LocalDateTime? = get(6) as LocalDateTime?

    @get:Column(name = "updated_at", precision = 6)
    open var updatedAt: LocalDateTime?
        set(value): Unit = set(7, value)
        get(): LocalDateTime? = get(7) as LocalDateTime?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row8<Int?, String?, String?, String?, String?, String?, LocalDateTime?, LocalDateTime?> = super.fieldsRow() as Row8<Int?, String?, String?, String?, String?, String?, LocalDateTime?, LocalDateTime?>
    override fun valuesRow(): Row8<Int?, String?, String?, String?, String?, String?, LocalDateTime?, LocalDateTime?> = super.valuesRow() as Row8<Int?, String?, String?, String?, String?, String?, LocalDateTime?, LocalDateTime?>
    override fun field1(): Field<Int?> = Customers.CUSTOMERS.CUSTOMER_ID
    override fun field2(): Field<String?> = Customers.CUSTOMERS.FIRST_NAME
    override fun field3(): Field<String?> = Customers.CUSTOMERS.LAST_NAME
    override fun field4(): Field<String?> = Customers.CUSTOMERS.EMAIL
    override fun field5(): Field<String?> = Customers.CUSTOMERS.PHONE
    override fun field6(): Field<String?> = Customers.CUSTOMERS.ADDRESS
    override fun field7(): Field<LocalDateTime?> = Customers.CUSTOMERS.CREATED_AT
    override fun field8(): Field<LocalDateTime?> = Customers.CUSTOMERS.UPDATED_AT
    override fun component1(): Int? = customerId
    override fun component2(): String? = firstName
    override fun component3(): String? = lastName
    override fun component4(): String? = email
    override fun component5(): String? = phone
    override fun component6(): String? = address
    override fun component7(): LocalDateTime? = createdAt
    override fun component8(): LocalDateTime? = updatedAt
    override fun value1(): Int? = customerId
    override fun value2(): String? = firstName
    override fun value3(): String? = lastName
    override fun value4(): String? = email
    override fun value5(): String? = phone
    override fun value6(): String? = address
    override fun value7(): LocalDateTime? = createdAt
    override fun value8(): LocalDateTime? = updatedAt

    override fun value1(value: Int?): CustomersRecord {
        this.customerId = value
        return this
    }

    override fun value2(value: String?): CustomersRecord {
        this.firstName = value
        return this
    }

    override fun value3(value: String?): CustomersRecord {
        this.lastName = value
        return this
    }

    override fun value4(value: String?): CustomersRecord {
        this.email = value
        return this
    }

    override fun value5(value: String?): CustomersRecord {
        this.phone = value
        return this
    }

    override fun value6(value: String?): CustomersRecord {
        this.address = value
        return this
    }

    override fun value7(value: LocalDateTime?): CustomersRecord {
        this.createdAt = value
        return this
    }

    override fun value8(value: LocalDateTime?): CustomersRecord {
        this.updatedAt = value
        return this
    }

    override fun values(value1: Int?, value2: String?, value3: String?, value4: String?, value5: String?, value6: String?, value7: LocalDateTime?, value8: LocalDateTime?): CustomersRecord {
        this.value1(value1)
        this.value2(value2)
        this.value3(value3)
        this.value4(value4)
        this.value5(value5)
        this.value6(value6)
        this.value7(value7)
        this.value8(value8)
        return this
    }

    /**
     * Create a detached, initialised CustomersRecord
     */
    constructor(customerId: Int? = null, firstName: String? = null, lastName: String? = null, email: String? = null, phone: String? = null, address: String? = null, createdAt: LocalDateTime? = null, updatedAt: LocalDateTime? = null): this() {
        this.customerId = customerId
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
        this.phone = phone
        this.address = address
        this.createdAt = createdAt
        this.updatedAt = updatedAt
    }

    /**
     * Create a detached, initialised CustomersRecord
     */
    constructor(value: CustomersPojo?): this() {
        if (value != null) {
            this.customerId = value.customerId
            this.firstName = value.firstName
            this.lastName = value.lastName
            this.email = value.email
            this.phone = value.phone
            this.address = value.address
            this.createdAt = value.createdAt
            this.updatedAt = value.updatedAt
        }
    }
}
