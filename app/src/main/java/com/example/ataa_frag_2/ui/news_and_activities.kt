package com.example.ataa_frag_2.ui

import com.example.ataa_frag_2.R

data class news_and_activities(val type: String, val iconName : Int, val link: String)
val news_and_activities_list = listOf(
    news_and_activities("news", R.drawable.news_1, "https://www.facebook.com/"),
    news_and_activities("news", R.drawable.news_2, "https://www.facebook.com/"),
    news_and_activities("news", R.drawable.news_3 ,  "https://www.facebook.com/"),


    news_and_activities("activities", R.drawable.act_1, "https://www.facebook.com/"),
    news_and_activities("activities", R.drawable.act_2, "https://www.facebook.com/"),
    )