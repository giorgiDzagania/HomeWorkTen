package com.exercise.tbchomeworkten

data class Info(
    val id: Int,
    val icon: Int,
    val title: String,
    val additionalTextView: String?,
    val arrowIcon: Int,
    val checkboxValue: Boolean?,
    val type: ItemType,
    var isClicked: Boolean = false
)

enum class ItemType {
    ARROW, CHECKBOX, DEFAULT
}
