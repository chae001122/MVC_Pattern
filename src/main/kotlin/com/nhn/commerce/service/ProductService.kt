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
        try{
            val newProduct = product.let {
                "{상품이름 : ${product.productName}, 상품 가격 : ${product.salePrice}}"
            }
            println("상품 정보 확인")
            println(newProduct)
            println("====================")

            val productPrice:Int = product.salePrice.toInt()
            if(productPrice.isPositive())
                throw Exception("가격은 양수여야 합니다.")

            productRepository.save(product)
        } catch (e: NumberFormatException) {
            throw Exception("Not Number : 가격 입력값은 숫자로 이뤄져야 합니다.")
        }
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
