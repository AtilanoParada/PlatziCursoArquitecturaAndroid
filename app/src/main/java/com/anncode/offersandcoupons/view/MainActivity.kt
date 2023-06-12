package com.anncode.offersandcoupons.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.databinding.ActivityMainBinding
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.viewmodel.CouponViewModel

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private var couponViewModel: CouponViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        // View
        setupBindings(savedInstanceState)
    }

    fun setupBindings(savedInstanceState: Bundle?) {
        var activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        couponViewModel = ViewModelProviders.of(this)[CouponViewModel::class.java]
        activityMainBinding.model = CouponViewModel()
        setupListUpdate()
    }

    fun setupListUpdate() {
        try {
            // callCoupons
            couponViewModel?.callCoupons()

            // getCoupons
            couponViewModel?.getCoupons()?.observe(this, Observer { coupons: List<Coupon> ->
                Log.w("COUPON", coupons[0].title)
                couponViewModel?.setCouponsInRecyclerAdapter(coupons)
            })
            setupListClick()
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }

    fun setupListClick() {
        couponViewModel?.getCouponSelected()?.observe(this,
            Observer { coupon: Coupon ->
                Log.i("CLICK", coupon.title)

            })
    }
}
