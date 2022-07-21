package com.nhn.commerce.repository

import com.nhn.commerce.model.Product
import org.apache.ibatis.annotations.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Mapper
@Repository
interface ProductRepository : JpaRepository<Product, Int>{
//    @Select("SELECT * FROM product")
//    fun findProductList(): List<Product>


}
