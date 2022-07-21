package com.nhn.commerce.service

import com.nhn.commerce.model.Product
import com.nhn.commerce.repository.ProductRepository
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.NumberFormatException

@Service
class ProductService(
    private val productRepository: ProductRepository,
) {
    //fun findProductList(): List<Product> = productRepository.findProductList()

    @Transactional
    fun findAllProduct(): List<Product> {
        return productRepository.findAll()
    }

    @Transactional
    fun create(product: Product) {
        productRepository.save(product)
    }

    @Transactional
    fun findByProductNo(productNo: Int): Any {
        return productRepository.findById(productNo)
    }
    @Transactional
    fun deleteByProductNo(productNo: Int) {
        productRepository.deleteById(productNo)
    }

    fun Int.isPositive(): Boolean = this > 0

}
