package com.example.homework_10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: SettingItemAdapter
    private val testList: MutableList<SettingItem> = mutableListOf(
        SettingItem(0, R.drawable.ic_user, "Edit Profile", SettingItemType.Normal),
        SettingItem(1, R.drawable.ic_address, "Address", SettingItemType.Normal),
        SettingItem(2, R.drawable.ic_notification, "Notification", SettingItemType.Normal),
        SettingItem(3, R.drawable.ic_payment, "Payment", SettingItemType.Normal),
        SettingItem(4, R.drawable.ic_security, "Security", SettingItemType.Normal),
        SettingItem(5, R.drawable.ic_language, "Language", SettingItemType.WithMessage),
        SettingItem(6, R.drawable.ic_eye, "Dark Mode", SettingItemType.WithSwitch),
        SettingItem(7, R.drawable.ic_lock, "Privacy Policy", SettingItemType.Normal),
        SettingItem(8, R.drawable.ic_help, "Help Center", SettingItemType.Normal),
        SettingItem(9, R.drawable.ic_people, "Invite Friend", SettingItemType.Normal),
        SettingItem(10, R.drawable.ic_log_out, "Logout", SettingItemType.RedItem)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecycler()
    }

    private fun setUpRecycler(){
        adapter = SettingItemAdapter()
        adapter.setList(testList)
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter
    }
}