package com.nhn.commerce.controller

import com.nhn.commerce.model.Product
import com.nhn.commerce.repository.ProductRepository
import com.nhn.commerce.service.ProductService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.GetMapping
import java.util.*
import org.springframework.web.bind.annotation.PathVariable


@Controller
class ProductController(
    private val productService: ProductService,
) {
//    @GetMapping("/product")
//    fun getProductList(model: Model): String {
//        model.addAttribute("productList", productService.findProductList())
//        return "product"
//    }

    @GetMapping("/product")
    fun getAllUsers(model: Model): String {
        val list: List<Product> = productService.findAllProduct()
        model.addAttribute("productList", list)
        return "product"
    }


    // TODO (상품 상세 조회 기능 + Exception 처리)
    @GetMapping(path = ["/see/{productNo}"])
    fun seeProductById(model: Model, @PathVariable("productNo") productNo: Int): String? {
        model.addAttribute("product", productService.findByProductNo(productNo))
        return "see-product"
    }

    @PostMapping(path = ["/seeProduct"])
    fun afterSeeProduct(): String? {
        return "redirect:/product"
    }

    // TODO (상품 추가 기능)
    @GetMapping(path = ["/add"])
    fun addProduct(): String? {
        return "add-user"
    }

    @PostMapping(path = ["/createProduct"])
    fun createNewProduct(@ModelAttribute product: Product): String? {
        println(product)
        productService.create(product)
        println(product)
        return "redirect:/product";
    }
    // TODO (상품 수정 기능 + Exception 처리)
    @GetMapping(path = ["/edit/{productNo}"])
    fun editUserById(model: Model, @PathVariable("productNo") productNo: Int): String? {
        model.addAttribute("product", productService.findByProductNo(productNo))
        return "edit-user"
    }

    @PostMapping(path = ["/editUser"])
    fun editUser(@ModelAttribute product: Product): String? {
        productService.create(product)
        return "redirect:/product"
    }


    // TODO (상품 삭제 기능 + Exception 처리)
    @GetMapping(path = ["/delete/{productNo}"])
    fun deleteUserById(@PathVariable("productNo") productNo: Int): String? {
        productService.deleteByProductNo(productNo)
        return "redirect:/product"
    }
}
