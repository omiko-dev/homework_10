package com.example.homework_10

data class SettingItem(val id: Int, val icon: Int, val title: String, val settingItemType: SettingItemType)
enum class SettingItemType {
    Normal,
    WithMessage,
    WithSwitch,
    RedItem
}
