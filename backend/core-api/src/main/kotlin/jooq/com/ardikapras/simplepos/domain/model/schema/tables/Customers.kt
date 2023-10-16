/*
 * This file is generated by jOOQ.
 */
package com.ardikapras.simplepos.domain.model.schema.tables


import com.ardikapras.simplepos.domain.model.schema.Public
import com.ardikapras.simplepos.domain.model.schema.keys.CUSTOMERS_PKEY
import com.ardikapras.simplepos.domain.model.schema.tables.records.CustomersRecord

import java.time.LocalDateTime
import java.util.function.Function

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Records
import org.jooq.Row8
import org.jooq.Schema
import org.jooq.SelectField
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class Customers(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, CustomersRecord>?,
    aliased: Table<CustomersRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<CustomersRecord>(
    alias,
    Public.PUBLIC,
    child,
    path,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table()
) {
    companion object {

        /**
         * The reference instance of <code>public.customers</code>
         */
        val CUSTOMERS: Customers = Customers()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<CustomersRecord> = CustomersRecord::class.java

    /**
     * The column <code>public.customers.customer_id</code>.
     */
    val CUSTOMER_ID: TableField<CustomersRecord, Int?> = createField(DSL.name("customer_id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "")

    /**
     * The column <code>public.customers.first_name</code>.
     */
    val FIRST_NAME: TableField<CustomersRecord, String?> = createField(DSL.name("first_name"), SQLDataType.VARCHAR(50).nullable(false), this, "")

    /**
     * The column <code>public.customers.last_name</code>.
     */
    val LAST_NAME: TableField<CustomersRecord, String?> = createField(DSL.name("last_name"), SQLDataType.VARCHAR(50).nullable(false), this, "")

    /**
     * The column <code>public.customers.email</code>.
     */
    val EMAIL: TableField<CustomersRecord, String?> = createField(DSL.name("email"), SQLDataType.VARCHAR(100), this, "")

    /**
     * The column <code>public.customers.phone</code>.
     */
    val PHONE: TableField<CustomersRecord, String?> = createField(DSL.name("phone"), SQLDataType.VARCHAR(20), this, "")

    /**
     * The column <code>public.customers.address</code>.
     */
    val ADDRESS: TableField<CustomersRecord, String?> = createField(DSL.name("address"), SQLDataType.CLOB, this, "")

    /**
     * The column <code>public.customers.created_at</code>.
     */
    val CREATED_AT: TableField<CustomersRecord, LocalDateTime?> = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "")

    /**
     * The column <code>public.customers.updated_at</code>.
     */
    val UPDATED_AT: TableField<CustomersRecord, LocalDateTime?> = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(6).defaultValue(DSL.field("now()", SQLDataType.LOCALDATETIME)), this, "")

    private constructor(alias: Name, aliased: Table<CustomersRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<CustomersRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>public.customers</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>public.customers</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>public.customers</code> table reference
     */
    constructor(): this(DSL.name("customers"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, CustomersRecord>): this(Internal.createPathAlias(child, key), child, key, CUSTOMERS, null)
    override fun getSchema(): Schema? = if (aliased()) null else Public.PUBLIC
    override fun getIdentity(): Identity<CustomersRecord, Int?> = super.getIdentity() as Identity<CustomersRecord, Int?>
    override fun getPrimaryKey(): UniqueKey<CustomersRecord> = CUSTOMERS_PKEY
    override fun `as`(alias: String): Customers = Customers(DSL.name(alias), this)
    override fun `as`(alias: Name): Customers = Customers(alias, this)
    override fun `as`(alias: Table<*>): Customers = Customers(alias.getQualifiedName(), this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Customers = Customers(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Customers = Customers(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): Customers = Customers(name.getQualifiedName(), null)

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row8<Int?, String?, String?, String?, String?, String?, LocalDateTime?, LocalDateTime?> = super.fieldsRow() as Row8<Int?, String?, String?, String?, String?, String?, LocalDateTime?, LocalDateTime?>

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    fun <U> mapping(from: (Int?, String?, String?, String?, String?, String?, LocalDateTime?, LocalDateTime?) -> U): SelectField<U> = convertFrom(Records.mapping(from))

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    fun <U> mapping(toType: Class<U>, from: (Int?, String?, String?, String?, String?, String?, LocalDateTime?, LocalDateTime?) -> U): SelectField<U> = convertFrom(toType, Records.mapping(from))
}
