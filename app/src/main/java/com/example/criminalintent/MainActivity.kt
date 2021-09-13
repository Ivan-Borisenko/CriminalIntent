package com.example.criminalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        //запрос фрагмента по идентификатору
        
        if (currentFragment == null) {
            val fragment = CrimeFragment()
            //создаим новую транзакцию фрагмента, включив в нее одну операцию add, а затем закрепим
            //функция add(...) отвечает за основное содержание транзакции
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }   //add(...) и окружающий его код создаёт и закрепляет транзакцию фрагмента
    }
}