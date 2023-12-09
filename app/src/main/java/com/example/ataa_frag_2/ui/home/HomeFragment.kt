package com.example.ataa_frag_2.ui.home

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ataa_frag_2.R
import com.example.ataa_frag_2.databinding.FragmentHomeBinding
import com.example.ataa_frag_2.ui.episode
import com.example.ataa_frag_2.ui.news_and_activities_list
import android.os.Handler


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var scrollRunnable: Runnable
    private val scrollHandler = Handler()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        // rotating the logo
        val imageView = binding.ataaLogo // Replace with the actual ImageView ID from your layout

        val rotationAnimator = ObjectAnimator.ofFloat(imageView, "rotationY", 0f, 360f).apply {
            duration = 2000 // Set the duration of each rotation (in milliseconds)
        }
        val pauseDuration: Long = 1000 // Set the duration of the pause (in milliseconds) as Long
        val animatorSet = AnimatorSet().apply {
            play(rotationAnimator).before(ObjectAnimator.ofFloat(imageView, "rotationY", 0f, 0f).setDuration(pauseDuration))
        }
        animatorSet.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                imageView.postDelayed({
                    animatorSet.start()
                }, pauseDuration)
            }
        })
        animatorSet.start()

        // add 5 news and activities
        val scrollView = binding.newsScroll
        val numNews= add_news(scrollView, "news")

        val dpValue = 400 // The dimension value in dp
        val scale = resources.displayMetrics.density // Get the screen density
        val imageWidth = (dpValue * scale + 0.5f).toInt() // Convert dp to pixels

        startAutoScrolling(scrollView, imageWidth, numNews)
        val scrollView5 = binding.activitiesScroll
        val numActivities = add_activities(scrollView5, "activities")
        startAutoScrolling(scrollView5, imageWidth, numActivities)
        return root
    }
    private fun add_news(scrollView: HorizontalScrollView, type: String) : Int {
        var numNews=0
        val linearLayout = LinearLayout(requireContext())
        linearLayout.orientation = LinearLayout.HORIZONTAL
        linearLayout.id = View.generateViewId()

        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(0, 0, 0, 0) // Left margin of 30 pixels

        for (ep in news_and_activities_list) {
            if (ep.type == type) {
                numNews+=1
                val imageView = ImageView(requireContext())
                imageView.id = View.generateViewId()
                imageView.setImageResource(ep.iconName)
                imageView.layoutParams = LinearLayout.LayoutParams(
                    resources.getDimensionPixelSize(R.dimen.image_width),
                    resources.getDimensionPixelSize(R.dimen.image_height)
                )

                val pairLayout = LinearLayout(requireContext())
                pairLayout.orientation = LinearLayout.VERTICAL
                pairLayout.addView(imageView)
                pairLayout.layoutParams = layoutParams

                linearLayout.addView(pairLayout)
                // Set click listener for pairLayout
                pairLayout.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(ep.link))
                    startActivity(intent)
                }
            }
        }
        linearLayout.layoutParams = layoutParams

        val innerLinearLayout = scrollView.findViewById<LinearLayout>(R.id.linearLayout3)
        innerLinearLayout.addView(linearLayout)
        return numNews
    }
    private fun add_activities(scrollView: HorizontalScrollView, type: String): Int  {
        var numACT=0
        val linearLayout = LinearLayout(requireContext())
        linearLayout.orientation = LinearLayout.HORIZONTAL
        linearLayout.id = View.generateViewId()

        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(0, 0, 0, 0) // Left margin of 30 pixels

        for (ep in news_and_activities_list) {
            if (ep.type == type) {
                numACT+=1
                val imageView = ImageView(requireContext())
                imageView.id = View.generateViewId()
                imageView.setImageResource(ep.iconName)
                imageView.layoutParams = LinearLayout.LayoutParams(
                    resources.getDimensionPixelSize(R.dimen.image_width),
                    resources.getDimensionPixelSize(R.dimen.image_height)
                )

                val pairLayout = LinearLayout(requireContext())
                pairLayout.orientation = LinearLayout.VERTICAL
                pairLayout.addView(imageView)
                pairLayout.layoutParams = layoutParams

                linearLayout.addView(pairLayout)
                // Set click listener for pairLayout
                pairLayout.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(ep.link))
                    startActivity(intent)
                }
            }
        }
        linearLayout.layoutParams = layoutParams

        val innerLinearLayout = scrollView.findViewById<LinearLayout>(R.id.linearLayout4)
        innerLinearLayout.addView(linearLayout)
        return  numACT
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun startAutoScrolling(scrollView: HorizontalScrollView, imageWidth: Int, numImages: Int) {
        val scrollMax = numImages*imageWidth
        var scrollX = 0
        var scrollDirection = 1 // 1 for scrolling to the right, -1 for scrolling to the left

        val scrollRunnable = object : Runnable {
            override fun run() {
                val animator = ObjectAnimator.ofInt(scrollView, "scrollX", scrollX)
                animator.duration = 1000 // Set the duration of the scroll animation (in milliseconds)
                animator.start()

                scrollX += imageWidth * scrollDirection

                if (scrollX >= scrollMax || scrollX == 0) {
                    scrollDirection *= -1 // Reverse the scroll direction
                }

                // Delay the next scroll by 1 second (1000 milliseconds)
                scrollView.postDelayed(this, 2500)
            }
        }

        scrollView.postDelayed(scrollRunnable, 2000)
    }


}