package mq.mqandroidworld.fragmenttest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import mq.mqandroidworld.fragmenttest.databinding.FragmentMainBinding

class FragmentTest:Fragment() {
    private var _binding: FragmentMainBinding? = null   // onCreateView 와 onDestroy 에서만 쓰인다.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        _binding?.fragmentContainerViewTag?.text = "바인딩 성공!"
        binding.searchButton.setOnClickListener {
            Toast.makeText(context,"나는 플래그먼트 이다.",Toast.LENGTH_SHORT).show()
            binding.fragmentContainerViewTag.text = binding.editQuery.text.toString()
            binding.editQuery.setText("")
        }
        //super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }
    fun setChangeText(str:String){
        binding.fragmentContainerViewTag.text = str
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}