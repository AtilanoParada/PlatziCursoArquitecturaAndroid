package com.anncode.offersandcoupons.model

import com.anncode.offersandcoupons.presenter.CouponPresenter

class CouponsInteractorImpl(couponPresenter: CouponPresenter) : CouponsInteractor {
    private var couponRepository: CouponRepository = CouponRepositoryImpl(couponPresenter)

    override fun getCouponsAPI() {
        couponRepository.getCouponsAPI()
    }
}