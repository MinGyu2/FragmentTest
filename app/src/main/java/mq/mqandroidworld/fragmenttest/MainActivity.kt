package mq.mqandroidworld.fragmenttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import mq.mqandroidworld.fragmenttest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        supportFragmentManager.beginTransaction().add(R.id.fragment_container_view_tag, FragmentTest()).commit()
        supportFragmentManager.beginTransaction().add(binding.fragmentContainerViewTag.id, FragmentTest()).commit()

        binding.btMain.setOnClickListener {
            val fragment = supportFragmentManager.findFragmentById(binding.fragmentContainerViewTag.id) as FragmentTest
            fragment.setChangeText("메인에서 누른 겁니다!!")
        }
    }
}