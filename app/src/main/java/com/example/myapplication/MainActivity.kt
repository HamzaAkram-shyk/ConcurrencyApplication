package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.AndroidUiDispatcher.Companion.Main
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.concurency.Demo
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: ViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = ViewModelFactory(20)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.apply {
            name.text = "Hello its databinding. ......."
        }

//        binding.addBtn.setOnClickListener {
//            viewModel.updateScore(10)
//        }
//        viewModel.scoreObserve.observe(this, Observer { num ->
//            binding.name.text = "$num"
//        })
        viewModel.textObserve.observe(this, Observer {
            Toast.makeText(this, "change = $it", Toast.LENGTH_SHORT).show()
        })
        lifecycleScope.launch {
            Log.d("thread", "${Thread.currentThread().name}")
            try {
                val num = Demo().getStream()
                Toast.makeText(this@MainActivity, "Num = ${num}", Toast.LENGTH_SHORT).show()
            }catch (e:Exception){
                Toast.makeText(this@MainActivity, "Exception ${e.localizedMessage.toString()}", Toast.LENGTH_SHORT).show()
            }
        }


    }


}