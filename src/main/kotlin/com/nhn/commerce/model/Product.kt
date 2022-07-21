package com.nhn.commerce.model

import BaseTimeEntity
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.lang.reflect.Constructor
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "product")
@EntityListeners
class Product(
    @Id
    val productNo: Int,
    val productName: String,

//    @CreatedDate
//    @Column(nullable = true, updatable = false)
//    override val registerYmdt: LocalDateTime = LocalDateTime.now(),
    val salePrice: Int,

//    @LastModifiedDate
//    @Column(nullable = true)
//    override var updateYmdt: LocalDateTime = LocalDateTime.now(),
) : BaseTimeEntity(){

}

