package com.anncode.offersandcoupons.view

import com.anncode.offersandcoupons.model.Coupon

interface CouponView {
    // View
    fun showCoupons(coupons: ArrayList<Coupon>?)

    // Presenter
    fun getCoupons()
}