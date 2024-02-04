package com.jpa.example.jpademo;

import com.jpa.example.jpademo.entity.Coupon;
import com.jpa.example.jpademo.repository.CouponRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class JpaDemoApplicationTests {

	@Autowired
	private CouponRepository couponRepository;

	@BeforeEach
	void testCoupon() {
		Coupon coupon = new Coupon();
		coupon.setCode("DEV");
		coupon.setAmount(new BigDecimal(20));

		couponRepository.save(coupon);

		Assertions.assertNotNull(coupon.getId());
	}

	@Test
	void getCoupon() {
		Coupon coupon = couponRepository.findAll().get(0);
		System.out.println(coupon);
		Assertions.assertNotNull(coupon);
	}

}
