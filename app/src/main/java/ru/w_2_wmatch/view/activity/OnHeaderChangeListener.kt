package ru.w_2_wmatch.view.activity

interface OnHeaderChangeListener {
    fun onTitleTextChange(newText: String)
    fun onBackClick()
    fun hideBackArrow()
    fun showBackArrow()
    fun hideBackTitle()
    fun showBackTitle()
    fun hideAvatar()
    fun showAvatar()
    fun hideNotification()
    fun showNotification()
    fun onTitleTextChange(idRes: Int)
}