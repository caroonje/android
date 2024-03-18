package com.bitc.app0111

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bitc.app0111.databinding.ActivityDataBaseBinding

class DatabaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDataBaseBinding
    private lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityDataBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

         dbHelper = DBHelper(this)
        val database = dbHelper.writableDatabase
//        데이터 추가
        binding.btnInsert.setOnClickListener {
            val name = binding.etName.text.toString()
            val phone = binding.etPhone.text.toString()
            val email = binding.etEmail.text.toString()
            val address = binding.etAddress.text.toString()

            val data = PhoneBookData(name =name, phone = phone, email = email, address = address)
            dbHelper.dbInsert(database,data)

            clearEditTextFields()
        }
        binding.btnUpdate.setOnClickListener {
            val seq = binding.etSeq.text.toString().toInt()
            val name = binding.etName.text.toString()
            val phone = binding.etPhone.text.toString()
            val email = binding.etEmail.text.toString()
            val address = binding.etAddress.text.toString()
            val data = PhoneBookData(seq = seq, name =name, phone = phone, email = email, address = address)
            dbHelper.dbUpdate(database,data)
            clearEditTextFields()

        }
        binding.btnDelete.setOnClickListener {
            val seq = binding.etSeq.text.toString().toInt()
            val name = binding.etName.text.toString()
            val phone = binding.etPhone.text.toString()
            val email = binding.etEmail.text.toString()
            val address = binding.etAddress.text.toString()
            val data = PhoneBookData(seq = seq, name =name, phone = phone, email = email, address = address)
            dbHelper.dbDelete(database,data)

            clearEditTextFields()

        }
        binding.btnSelect.setOnClickListener {
            val text = dbHelper.dbSelect(database)
            binding.tvResult.text = text
            clearEditTextFields()

        }
//문제1) UI에 이름 ,전화번호 ,이메일, 주소를 입력받는 필드를 생성하고 해당 데이터를 가지고 사용자를 추가,수정,삭제,조회 하도록 수정하세요


    }
    private fun clearEditTextFields() {
        binding.etSeq.text.clear()
        binding.etName.text.clear()
        binding.etPhone.text.clear()
        binding.etEmail.text.clear()
        binding.etAddress.text.clear()
    }




}