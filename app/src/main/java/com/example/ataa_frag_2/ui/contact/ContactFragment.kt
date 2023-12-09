package com.example.ataa_frag_2.ui.contact

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ataa_frag_2.R
import com.example.ataa_frag_2.databinding.FragmentContactBinding
import com.example.ataa_frag_2.ui.contact.ContactViewModel

class ContactFragment : Fragment() {

    private var _binding: FragmentContactBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val contactViewModel =
            ViewModelProvider(this).get(ContactViewModel::class.java)

        _binding = FragmentContactBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // maps listener
        val mapLocationTextView: TextView = binding.maplocation
        val mapLocationText = "Site"

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(view: View) {
                // Perform the desired action when the text is clicked
                val locationUrl = "https://goo.gl/maps/"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(locationUrl))
                startActivity(intent)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = true  // Add underline to the clickable text
                ds.color = Color.parseColor("#039BE5")  // Set the text color
            }
        }

        val spannableString = SpannableString(mapLocationText)
        spannableString.setSpan(clickableSpan, 0, mapLocationText.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        mapLocationTextView.apply {
            text = spannableString
            movementMethod = LinkMovementMethod.getInstance()  // Enable link-like behavior
        }


        // insta listener
        val instaLogoImageView: ImageView = binding.instaLogo
        instaLogoImageView.setOnClickListener {
            // Perform the desired action when the ImageView is clicked
            val instaUrl = "https://www.instagram.com/" // Replace with the actual Instagram URL
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(instaUrl))
            startActivity(intent)
        }
        // FB ataa listener
        val fbataaLogoImageView: ImageView = binding.fbLogoAtaa
        fbataaLogoImageView.setOnClickListener {
            // Perform the desired action when the ImageView is clicked
            val instaUrl = "https://www.facebook.com/" // Replace with the actual Instagram URL
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(instaUrl))
            startActivity(intent)
        }
        // FB chabab listener
        val fbchababLogoImageView: ImageView = binding.fbLogoChabab
        fbchababLogoImageView.setOnClickListener {
            // Perform the desired action when the ImageView is clicked
            val instaUrl = "https://www.facebook.com/" // Replace with the actual Instagram URL
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(instaUrl))
            startActivity(intent)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}