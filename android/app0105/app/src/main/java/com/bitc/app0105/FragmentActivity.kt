package com.bitc.app0105

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.bitc.app0105.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        프래그먼트를 제어하는 프래그먼트 매니저 가져오기
        val fragmentManager:FragmentManager = supportFragmentManager
//        SQL의 트랜잭션과 같이 프래그먼트 화면을 변경하기 전에 미리 설정을 하고 commit()을 실행하면 화면이 변경됨
        var transaction:FragmentTransaction = fragmentManager.beginTransaction()

//        화면 변경에 사용할 실제 프래그먼트 클래스 객체
        val fragment1 = Fragment1()
        val fragment2 = Fragment2()

//        프래그먼트 트랜잭션에 프래그먼트를 추가함, add()
//        첫번째 매개변수로 프래그먼트를 출력할 Layout을 선택
//        두번째 매개변수로 사용자가 생성한 프래그먼트 객체를 설정
        transaction.add(R.id.baseLayout,fragment1)
//        commit() 실행시 추가하거나 변경한 프래그먼트로 화면을 전환
//        commit() 실행시 트랜잭션이 종료됨
        transaction.commit()

        binding.btnFragment1.setOnClickListener {
//            화면을 변경 시 트랜젝션을 새로 지정해야 함
            transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.baseLayout,fragment1)
//            트랜잭션과 관련된 화면전환 및 상태 변경을 최적화
            transaction.setReorderingAllowed(true)
//            프래그먼트를 사용하여 여러번 화면을 변경했을 경우 변경 내역을 저장하고 있다가 뒤로가기 버튼 클릭시 저장된 프래그먼트로 전환+
//            transaction.addToBackStack("")
            transaction.commit()
        }
        binding.btnFragment2.setOnClickListener {
            transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.baseLayout,fragment2)
            transaction.setReorderingAllowed(true)
//            transaction.addToBackStack("")
            transaction.commit()
        }
    }
}