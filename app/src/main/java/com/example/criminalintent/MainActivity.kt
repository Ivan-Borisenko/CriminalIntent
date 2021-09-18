package com.example.criminalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(),
CrimeListFragment.Callbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        //запрос фрагмента по идентификатору

        if (currentFragment == null) {
            val fragment = CrimeListFragment.newInstance()
            //создаим новую транзакцию фрагмента, включив в нее одну операцию add, а затем закрепим
            //функция add(...) отвечает за основное содержание транзакции
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }   //add(...) и окружающий его код создаёт и закрепляет транзакцию фрагмента
    }

    override fun onCrimeSelected(crimeId: UUID) {
        //Log.d(TAG, "MainActivity.onCrimeSelected: $crimeId")
        //val fragment = CrimeFragment()
        val fragment = CrimeFragment.newInstance(crimeId)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}