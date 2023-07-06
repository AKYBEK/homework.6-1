package com.example.hw_1_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.hw_1_6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val activityLaunch =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == android.app.Activity.RESULT_OK) {
                binding.edit.setText(result.data?.getStringExtra(MA_SA_TEXT))
            }

            fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                binding = ActivityMainBinding.inflate(layoutInflater)
                setContentView(binding.root)
            }
        }

            private fun iniListener() {
                binding.btn.setOnClickListener {
                    if (binding.edit.text.isEmpty()) {
                        android.widget.Toast.makeText(
                            this,
                            "Вы не ввели текст",
                            android.widget.Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        val intent = android.content.Intent(this, SecondActivity::class.java)
                        intent.putExtra(MA_SA_TEXT, binding.edit.text.toString())
                        activityLaunch.launch(intent)
                    }
                }
            }

            companion object {
            const val MA_SA_TEXT = "MA_SA_TEXT"
        }
        }





