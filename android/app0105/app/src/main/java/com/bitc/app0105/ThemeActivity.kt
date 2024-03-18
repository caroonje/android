package com.bitc.app0105

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView


class ThemeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme)

//        AndroidManiFest.xml 의 activity 태그에  android:parentActivityName=".MainActivity"을 사용하지 않고 뒤로가기 버튼을 출력
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        Log.d("KSC-BackButton", "액션바의 뒤로가기 버튼 클릭")
        onBackPressed()
        return super.onSupportNavigateUp()
    }

//    소스 코드로 메뉴 추가하기
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        add() 메소드를 사용하여 메뉴에 추가하기
//        val menuItem1: MenuItem? = menu?.add(0,0,0,"menu1")
//        val menuItem2: MenuItem? = menu?.add(0,1,0,"menu2")

//        xml 파일로 생성한 메뉴 화면을 현재 액티비티의 메뉴에 추가함
        menuInflater.inflate(R.menu.menu_main,menu)

//    findItem(리소스ID) : 메뉴 xml 파일의 태그 중 지정한 id를 가지고 있는 태그를 검색하여 가져옴
    val menuItem1 = menu?.findItem(R.id.menu1)
    menuItem1?.setOnMenuItemClickListener {
        Log.d("KSC-menu","메뉴 1 클릭")
        Toast.makeText(this,"메뉴 1 클릭",Toast.LENGTH_SHORT).show()
        true
    }
//
    val menuItem4 = menu?.findItem(R.id.menu4)
    menuItem4?.setOnMenuItemClickListener(object:MenuItem.OnMenuItemClickListener {
        override fun onMenuItemClick(item:MenuItem):Boolean{
            Log.d("KSC-menu","메뉴 4 클릭")
            Toast.makeText(this@ThemeActivity,"메뉴 4 클릭",Toast.LENGTH_SHORT).show()
            return true
        }
    })

    val menuItem3 =menu?.findItem(R.id.menu3)
    val searchView = menuItem3?.actionView as SearchView
    searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
//        검색 버튼 클릭 시 이벥트 발생
        override fun onQueryTextSubmit(query: String?): Boolean {
            Log.d("KSC","입력한 내용 : $query")
            return true
        }
//        검색어 변경 시 이벤트 발생
        override fun onQueryTextChange(newText: String?): Boolean {
            Log.d("KSC","입력 중인 내용 : $newText")
            return true
        }
    })

        return super.onCreateOptionsMenu(menu)
    }

//    메뉴 버튼 클릭시 이벤트 처리
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId){
        0-> {
            Log.d("KSC","메뉴 1 클릭")
            Toast.makeText(this,"메뉴 1 클릭",Toast.LENGTH_SHORT).show()
            true
        }
        1 -> {
            Log.d("KSC","메뉴 2 클릭")
            Toast.makeText(this,"메뉴 2 클릭",Toast.LENGTH_SHORT).show()
            true
        }
        else -> super.onOptionsItemSelected(item)

    }


}