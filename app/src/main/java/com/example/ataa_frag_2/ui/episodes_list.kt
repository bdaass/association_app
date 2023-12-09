package com.example.ataa_frag_2.ui

import com.example.ataa_frag_2.R

data class youtube_episodes(val serie: String, val link: String, val iconName : Int)
val episode = listOf(
    youtube_episodes("serie_1", "https://youtu.be/", R.drawable.s4_e3),
    youtube_episodes("serie_1", "https://youtu.be/", R.drawable.s4_e4),
    youtube_episodes("serie_1", "https://youtu.be/", R.drawable.s4_e5),

    youtube_episodes("serie_2", "https://youtu.be/", R.drawable.s3_e3),
    youtube_episodes("serie_2", "https://youtu.be/", R.drawable.s3_e4),
    youtube_episodes("serie_2", "https://youtu.be/", R.drawable.s4_e1),

    youtube_episodes("serie_3", "https://youtu.be/", R.drawable.s2_e4),
    youtube_episodes("serie_3", "https://youtu.be/", R.drawable.s3_e1),
    youtube_episodes("serie_3", "https://youtu.be/", R.drawable.s3_e2),

    youtube_episodes("serie_4", "https://youtu.be/", R.drawable.s2_e1),
    youtube_episodes("serie_4", "https://youtu.be/", R.drawable.s2_e2),
    youtube_episodes("serie_4", "https://youtu.be/", R.drawable.s2_e3),

    youtube_episodes("serie_5", "https://youtu.be/", R.drawable.s1_e3),
    youtube_episodes("serie_5", "https://youtu.be/", R.drawable.s1_e4),
    youtube_episodes("serie_5", "https://youtu.be/", R.drawable.s1_e2),
)