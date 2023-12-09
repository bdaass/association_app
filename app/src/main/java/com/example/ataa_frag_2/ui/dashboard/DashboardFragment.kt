package com.example.ataa_frag_2.ui.dashboard

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.Gravity
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.RelativeLayout
import android.widget.ScrollView
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment

import com.example.ataa_frag_2.R
import com.example.ataa_frag_2.databinding.FragmentDashboardBinding
import com.example.ataa_frag_2.ui.Book
import com.example.ataa_frag_2.ui.booklist
import com.example.ataa_frag_2.ui.episode


class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private lateinit var searchView: android.widget.SearchView
    private lateinit var listView: ListView
    private lateinit var resultTextView: TextView
    private lateinit var adapter: ArrayAdapter<String>
    public var current_activity: String = "init"
    private var currentLayoutIndex = 0
    private var showBackButton = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        current_activity="DASHBOARD"
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Sections"
        setHasOptionsMenu(false)
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val view = binding.root

        showToastWithActiveLayoutName()
        // Go to dashboard sub sections layouts
        binding.dashtodrous.setOnClickListener {
            switchToDrousLayout()
            showToastWithActiveLayoutName()
        }
        binding.dashtomaktaba.setOnClickListener {
            switchToMaktabaLayout()
            showToastWithActiveLayoutName()
        }
        binding.dashtodour.setOnClickListener {
            switchToDourLayout()
            showToastWithActiveLayoutName()
        }
        binding.dashtokashaf.setOnClickListener {
            switchToKashafLayout()
            showToastWithActiveLayoutName()
        }
        binding.dashtomaahad.setOnClickListener {
            switchToMaahadLayout()
            showToastWithActiveLayoutName()
        }
        binding.dashtomarkaztebbi.setOnClickListener {
            switchToMarkaztebbiLayout()
            showToastWithActiveLayoutName()
        }
        // dashboard click
        setHasOptionsMenu(true)
        // Sections btns 3D effects

        return  view
    }
    private fun switchToDrousLayout() {
        current_activity = "Section_5"
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Section_5"
        setHasOptionsMenu(true)
        // Replace the current layout with the Drous layout
        val container = requireView().findViewById<ViewGroup>(R.id.pageContainer)
        container.removeAllViews()
        // put drous layout
        val drousView = layoutInflater.inflate(R.layout.series_layout, null)
        container.addView(drousView)
        // create  drous layout details
        add_playlist_episodes(drousView.findViewById<HorizontalScrollView>(R.id.PL1), "serie_1")
        add_playlist_episodes(drousView.findViewById<HorizontalScrollView>(R.id.PL2), "serie_2")
        add_playlist_episodes(drousView.findViewById<HorizontalScrollView>(R.id.PL3), "serie_3")
        add_playlist_episodes(drousView.findViewById<HorizontalScrollView>(R.id.PL4), "serie_4")
        add_playlist_episodes(drousView.findViewById<HorizontalScrollView>(R.id.PL5), "serie_5")
    }
    private fun switchToMaktabaLayout() {
        setHasOptionsMenu(true)
        current_activity = "Section_4"
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Section_4"
        // Remove the current layout
        val container = requireView().findViewById<ViewGroup>(R.id.pageContainer)
        container.removeAllViews()
        // put maktaba layout
        val maktabaView = layoutInflater.inflate(R.layout.library_layout, null)
        container.addView(maktabaView)

        // create maktabe layout details
        add_five_pairs_library(maktabaView.findViewById<HorizontalScrollView>(R.id.H1), "type_1")
        add_five_pairs_library(maktabaView.findViewById<HorizontalScrollView>(R.id.H2), "type_2")
        add_five_pairs_library(maktabaView.findViewById<HorizontalScrollView>(R.id.H3), "type_3")
        add_five_pairs_library(maktabaView.findViewById<HorizontalScrollView>(R.id.H4), "type_4")
        add_five_pairs_library(maktabaView.findViewById<HorizontalScrollView>(R.id.H5), "type_5")
        add_five_pairs_library(maktabaView.findViewById<HorizontalScrollView>(R.id.H6), "type_6")
        add_five_pairs_library(maktabaView.findViewById<HorizontalScrollView>(R.id.H7), "type_7")
        add_five_pairs_library(maktabaView.findViewById<HorizontalScrollView>(R.id.H8), "type_8")
        add_five_pairs_library(maktabaView.findViewById<HorizontalScrollView>(R.id.H9), "type_9")
        add_five_pairs_library(maktabaView.findViewById<HorizontalScrollView>(R.id.H10), "type_10")
        add_five_pairs_library(maktabaView.findViewById<HorizontalScrollView>(R.id.H11), "type_11")
        add_five_pairs_library(maktabaView.findViewById<HorizontalScrollView>(R.id.H12), "type_12")
        add_five_pairs_library(maktabaView.findViewById<HorizontalScrollView>(R.id.H13), "type_13")
        // view all books
        // switch to maktaba_all section 1 activity
        val buttonall1 = maktabaView.findViewById<Button>(R.id.all_1)
        val buttonall2 = maktabaView.findViewById<Button>(R.id.all_2)
        val buttonall3 = maktabaView.findViewById<Button>(R.id.all_3)
        val buttonall4 = maktabaView.findViewById<Button>(R.id.all_4)
        val buttonall5 = maktabaView.findViewById<Button>(R.id.all_5)
        val buttonall6 = maktabaView.findViewById<Button>(R.id.all_6)
        val buttonall7 = maktabaView.findViewById<Button>(R.id.all_7)
        val buttonall8 = maktabaView.findViewById<Button>(R.id.all_8)
        val buttonall9 = maktabaView.findViewById<Button>(R.id.all_9)
        val buttonall10 = maktabaView.findViewById<Button>(R.id.all_10)
        val buttonall11 = maktabaView.findViewById<Button>(R.id.all_11)
        val buttonall12 = maktabaView.findViewById<Button>(R.id.all_12)
        val buttonall13 = maktabaView.findViewById<Button>(R.id.all_13)
        buttonall1.setOnClickListener { switchToallbooksLayout(1) }
        buttonall2.setOnClickListener { switchToallbooksLayout(2) }
        buttonall3.setOnClickListener { switchToallbooksLayout(3) }
        buttonall4.setOnClickListener { switchToallbooksLayout(4) }
        buttonall5.setOnClickListener { switchToallbooksLayout(5) }
        buttonall6.setOnClickListener { switchToallbooksLayout(6) }
        buttonall7.setOnClickListener { switchToallbooksLayout(7) }
        buttonall8.setOnClickListener { switchToallbooksLayout(8) }
        buttonall9.setOnClickListener { switchToallbooksLayout(9) }
        buttonall10.setOnClickListener { switchToallbooksLayout(10) }
        buttonall11.setOnClickListener { switchToallbooksLayout(11) }
        buttonall12.setOnClickListener { switchToallbooksLayout(12) }
        buttonall13.setOnClickListener { switchToallbooksLayout(13) }

        // search-listview issue
        searchView = maktabaView.findViewById(R.id.searchView)
        listView = maktabaView.findViewById(R.id.listView)
        val parent: ViewGroup = listView.parent as ViewGroup     // bring listview to front
        parent.bringChildToFront(listView)
        listView.visibility = View.GONE

        val bookNames = booklist.map { books -> "${books.name} - ${books.author}" }
        val Myadapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, bookNames)
        listView.adapter = Myadapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {//searchview submit query
                switchTomaktabasearchresultLayout(query)
                showToastWithActiveLayoutName()
                return false
            }

            override fun onQueryTextChange(query: String): Boolean {
                Myadapter.filter.filter(query)
                if (query.length > 1) {
                    listView.visibility = View.VISIBLE
                    val itemHeightRes = R.dimen.list_item_height
                    val itemHeight = resources.getDimensionPixelSize(itemHeightRes)

                    val layoutParams = listView.layoutParams
                    layoutParams.height = itemHeight
                    listView.layoutParams = layoutParams
                    listView.requestLayout()
                } else {
                    listView.visibility = View.GONE
                }
                return false
            }
        })
        // go to selected book activity from search
        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedBookName = Myadapter.getItem(position)?.substringBefore(" - ")
            val selectedBookAuthor = Myadapter.getItem(position)?.substringAfter(" - ")
            val selectedBook =
                booklist.find { it.name == selectedBookName && it.author == selectedBookAuthor }
            if (selectedBook != null) {
                switchTomaktabaselectedbookLayout(selectedBook.name, selectedBook.author)
                showToastWithActiveLayoutName()
            }
        }
    }

    private fun switchToDourLayout() {
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Section_3"
        current_activity = "Section_3"
        setHasOptionsMenu(true)
        // Replace the current layout with the door layout
        val container = requireView().findViewById<ViewGroup>(R.id.pageContainer)
        container.removeAllViews()
        // put dour layout
        val dourView = layoutInflater.inflate(R.layout.section_3_layout, null)
        container.addView(dourView)
    }
    private fun switchToKashafLayout() {
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Section_6"
        current_activity = "Section_6"
        setHasOptionsMenu(true)
        // Replace the current layout with the Maktaba layout
        val container = requireView().findViewById<ViewGroup>(R.id.pageContainer)
        container.removeAllViews()
        // put kashaf layout
        val kashafView = layoutInflater.inflate(R.layout.section_6_layout, null)
        container.addView(kashafView)
    }
    private fun switchToMaahadLayout() {
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Section_2"
        current_activity = "Section_2"
        setHasOptionsMenu(true)
        // Replace the current layout with the Maktaba layout
        val container = requireView().findViewById<ViewGroup>(R.id.pageContainer)
        container.removeAllViews()
        // put maktaba layout
        val maahadView = layoutInflater.inflate(R.layout.section_2_layout, null)
        container.addView(maahadView)
    }
    private fun switchToMarkaztebbiLayout() {
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Section_1"
        current_activity = "Section_1"
        setHasOptionsMenu(true)
        // Replace the current layout with the  layout
        val container = requireView().findViewById<ViewGroup>(R.id.pageContainer)
        container.removeAllViews()
        // put  layout
        val markaztebbiView = layoutInflater.inflate(R.layout.section_1_layout_1, null)
        container.addView(markaztebbiView)
    }
    // back to dashboard
    public fun switchToDashboardLayout() {
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Sections"
        current_activity = "DASHBOARD"
        setHasOptionsMenu(false)
        // Replace the current layout with the Dashboard layout
        val container = requireView().findViewById<ViewGroup>(R.id.pageContainer)
        container.removeAllViews()

        val dashboardView = layoutInflater.inflate(R.layout.fragment_dashboard, container, false)

        container.addView(dashboardView)

        val button1 = dashboardView.findViewById<Button>(R.id.dashtodrous)
        button1.setOnClickListener {
            switchToDrousLayout()
        }
        val button2 = dashboardView.findViewById<Button>(R.id.dashtomaktaba)
        button2.setOnClickListener {
            switchToMaktabaLayout()
        }
        val button3 = dashboardView.findViewById<Button>(R.id.dashtodour)
        button3.setOnClickListener {
            switchToDourLayout()
        }

        val button4 = dashboardView.findViewById<Button>(R.id.dashtokashaf)
        button4.setOnClickListener {
            switchToKashafLayout()
        }
        val button5 = dashboardView.findViewById<Button>(R.id.dashtomaahad)
        button5.setOnClickListener {
            switchToMaahadLayout()
        }

        val button6 = dashboardView.findViewById<Button>(R.id.dashtomarkaztebbi)
        button6.setOnClickListener {
            switchToMarkaztebbiLayout()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Drous FUNCTIONS
    private fun add_playlist_episodes(constraintLayout: HorizontalScrollView, serie: String) {
        val linearLayout = LinearLayout(requireContext())
        linearLayout.orientation = LinearLayout.HORIZONTAL
        linearLayout.id = View.generateViewId()

        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(30, 0, 0, 0) // Left margin of 30 pixels

        for (ep in episode) {
            if (ep.serie == serie) {
                val imageView = ImageView(requireContext())
                imageView.id = View.generateViewId()
                imageView.setImageResource(ep.iconName)
                imageView.layoutParams = ConstraintLayout.LayoutParams(700, 450)

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
        constraintLayout.addView(linearLayout)
    }

    // Maktaba FUNCTIONS
    private fun switchToallbooksLayout(type: Int) {
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Association library"
        current_activity = "LIBRARY_ALLBOOKS"
        setHasOptionsMenu(true)
        // Replace the current layout with the LIBRARY layout
        val container = requireView().findViewById<ViewGroup>(R.id.pageContainer)
        container.removeAllViews()
        // put library all books layout
        val libraryallbooks = layoutInflater.inflate(R.layout.library_all_books_layout, null)
        container.addView(libraryallbooks)
        // build the layout
        // Access the bookList from BookData class
        val books = booklist
        var titletext = ""
        var selectedtype = ""
        var allbooks = books.size
        // Update the UI based on the clicked button
        when (type) {

            1 -> {
                titletext = "type_1"
                selectedtype = "type_1"
            }

            2 -> {
                titletext = "type_2"
                selectedtype = "type_1"
            }

            3 -> {
                titletext = "type_3"
                selectedtype = "type_3"
            }

            4 -> {
                titletext = "type_4"
                selectedtype = "type_4"
            }

            5 -> {
                titletext = "type_5"
                selectedtype = "type_5"
            }

            6 -> {
                titletext = "type_6"
                selectedtype = "type_6"
            }

            7 -> {
                titletext = "type_7"
                selectedtype = "type_7"
            }

            8 -> {
                titletext = "type_8"
                selectedtype = "type_8"
            }

            9 -> {
                titletext = "type_9"
                selectedtype = "type_8"
            }

            10 -> {
                titletext = "type_10"
                selectedtype = "type_10"
            }

            11 -> {
                titletext = "type_11"
                selectedtype = "type_11"
            }
            12 -> {
                titletext = "type_12"
                selectedtype = "type_12"
            }


            13 -> {
                titletext = "type_13"
                selectedtype = "type_13"
                //bookslength= books.count { it.type == selectedtype }
            }
        }

        // after knowing which type is needed :
        // Create a new ConstraintLayout
        val constraintLayout = ConstraintLayout(requireContext())
        constraintLayout.layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.MATCH_PARENT
        )
        container.addView(constraintLayout)
        // Create the title TextView
        val titleTextView = TextView(requireContext())
        titleTextView.id = ViewCompat.generateViewId()
        titleTextView.text = titletext
        titleTextView.textSize = 20f
        titleTextView.setTypeface(null, Typeface.BOLD)
        constraintLayout.addView(titleTextView)

        // Create the ScrollView
        val scrollView = ScrollView(requireContext())
        scrollView.id = ViewCompat.generateViewId()
        scrollView.layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.MATCH_PARENT
        )
        constraintLayout.addView(scrollView)

        // Create a LinearLayout inside the ScrollView
        val linearLayout = LinearLayout(requireContext())
        linearLayout.id = ViewCompat.generateViewId()
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        scrollView.addView(linearLayout)

        ////////////////////////////////////////////////////////////////////////// / Set constraints for the title TextView
        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)
        constraintSet.connect(
            titleTextView.id, ConstraintSet.TOP,
            ConstraintSet.PARENT_ID, ConstraintSet.TOP,
            20 // Margin between the title and the top
        )
        constraintSet.connect(
            titleTextView.id, ConstraintSet.END,
            ConstraintSet.PARENT_ID, ConstraintSet.END,
            20 // Margin between the title and the right
        )
        constraintSet.applyTo(constraintLayout)

        ///////////////////////////////////////////////////////////////////////// Set constraints for the ScrollView
        val scrollViewConstraintSet = ConstraintSet()
        scrollViewConstraintSet.clone(constraintLayout)
        scrollViewConstraintSet.connect(
            scrollView.id, ConstraintSet.TOP,
            titleTextView.id, ConstraintSet.BOTTOM,
            130 // Margin between the top and the scroll view
        )
        scrollViewConstraintSet.connect(
            scrollView.id, ConstraintSet.BOTTOM,
            ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM,
            50 // Margin between the Bottom and the scroll view
        )
        scrollViewConstraintSet.applyTo(constraintLayout)

        ///////////////////////////////////////////////////////////////////////// / Create and add image and text pairs
        for (i in 0 until allbooks) {

            if (books[i].type == selectedtype) {
                val containerLayout = RelativeLayout(requireContext())
                containerLayout.id = ViewCompat.generateViewId()

                ///////////////////////////////////////////////////////////////////////////////////////// Create the background drawable for each line
                // Create a transparent color with a specific transparency level (0-255)
                val backgroundDrawable: Drawable = GradientDrawable().apply {
                    setColor(Color.argb(20, 0, 0, 0))
                    cornerRadius = 45f
                }
                containerLayout.background = backgroundDrawable
                val containerLayoutParams = RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
                )
                containerLayoutParams.setMargins(30, 0, 30, 20)
                containerLayout.layoutParams = containerLayoutParams

                linearLayout.addView(containerLayout)
                // Create the ImageView
                val imageView = ImageView(requireContext())
                imageView.id = ViewCompat.generateViewId()
                val imageLayoutParams = RelativeLayout.LayoutParams(350, 350)
                imageLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
                imageLayoutParams.setMargins(0, 20, 10, 20)  // image margin
                imageView.layoutParams = imageLayoutParams
                imageView.setImageResource(R.drawable.book_2)
                imageView.setImageResource(books[i].iconName)
                containerLayout.addView(imageView)
                // Create the TextView for the description
                val descriptionTextView = TextView(requireContext())
                descriptionTextView.id = ViewCompat.generateViewId()
                descriptionTextView.setTextColor(Color.BLACK)
                val text =
                    "name${books[i].name}\nauthor ${books[i].author}\neditor ${books[i].editor}\nVolumesnumber ${books[i].Volumesnumber}"
                val spannableText = SpannableStringBuilder(text)
                spannableText.setSpan(
                    StyleSpan(Typeface.BOLD),
                    text.indexOf("name"),
                    text.indexOf("name") + "name".length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                spannableText.setSpan(
                    StyleSpan(Typeface.BOLD),
                    text.indexOf("author"),
                    text.indexOf("author") + "author".length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                spannableText.setSpan(
                    StyleSpan(Typeface.BOLD),
                    text.indexOf("editor"),
                    text.indexOf("editor") + "editor".length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                spannableText.setSpan(
                    StyleSpan(Typeface.BOLD),
                    text.indexOf("Volumesnumber"),
                    text.indexOf("Volumesnumber") + "Volumesnumber".length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
                descriptionTextView.text = spannableText
                val descriptionLayoutParams = RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
                )
                descriptionLayoutParams.addRule(RelativeLayout.LEFT_OF, imageView.id)
                descriptionLayoutParams.setMargins(0, 30, 10, 0)  // text margin
                descriptionTextView.layoutParams = descriptionLayoutParams
                containerLayout.addView(descriptionTextView)
                linearLayout.gravity = Gravity.TOP
            }
        }
        showToastWithActiveLayoutName()
    }
    private fun add_five_pairs_library(constraintLayout: HorizontalScrollView, books_type: String) {
        val linearLayout = LinearLayout(requireContext())
        val cultureBooks = booklist.filter { it.type == books_type }.take(5)
        setHasOptionsMenu(true)
        linearLayout.orientation = LinearLayout.HORIZONTAL
        linearLayout.id = View.generateViewId()

        for (book in cultureBooks) {
            val imageView = ImageView(requireContext())
            imageView.id = View.generateViewId()
            imageView.setImageResource(book.iconName)
            imageView.layoutParams = ConstraintLayout.LayoutParams(300, 450)

            val textView = TextView(requireContext())
            textView.id = View.generateViewId()
            textView.text = book.name

            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(0, 0, 100, 0)

            val pairLayout = LinearLayout(requireContext())
            pairLayout.orientation = LinearLayout.VERTICAL
            pairLayout.addView(imageView)
            //pairLayout.addView(textView)
            pairLayout.layoutParams = layoutParams
            linearLayout.addView(pairLayout)

            // Set click listener for pairLayout

            pairLayout.setOnClickListener {
                switchTomaktabaselectedbookLayout(book.name, book.author)
                showToastWithActiveLayoutName()
            }
        }

        val layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.setMargins(0, 0, 0, 0)

        linearLayout.layoutParams = layoutParams
        constraintLayout.addView(linearLayout)

    }
    private fun switchTomaktabaselectedbookLayout(books_name: String, books_type: String) {
        (activity as? AppCompatActivity)?.supportActionBar?.title = "association library"
        current_activity = "LIBRARY_SELECTEDBOOK"
        setHasOptionsMenu(true)
        val container = requireView().findViewById<ViewGroup>(R.id.pageContainer)
        container.removeAllViews()
        val selectedbookView = layoutInflater.inflate(R.layout.library_selected_book_layout, null)
        container.addView(selectedbookView)

        val selectedBook = booklist.find { it.name == books_name }
        val iconName = selectedBook?.iconName
        val editor = selectedBook?.editor
        val Volumesnumber = selectedBook?.Volumesnumber

        val imageView = selectedbookView.findViewById<ImageView>(R.id.imageView)

        val textView_name = selectedbookView.findViewById<TextView>(R.id.text_name)
        val textView_author = selectedbookView.findViewById<TextView>(R.id.text_author)
        val textView_neditor = selectedbookView.findViewById<TextView>(R.id.text_editor)
        val textView_volumes = selectedbookView.findViewById<TextView>(R.id.text_volumes)

        textView_name.text = books_name
        textView_author.text = books_type
        textView_neditor.text = editor
        textView_volumes.text = Volumesnumber.toString()

        // Associate the iconName with the ImageView
        val iconResourceId =
            resources.getIdentifier(iconName.toString(), "drawable", requireContext().packageName)

        imageView.setImageResource(iconResourceId)
    }
    private fun switchTomaktabasearchresultLayout(searchQuery: String) {
        (activity as? AppCompatActivity)?.supportActionBar?.title = "Library"

        current_activity = "LIBRARY_SEARCHRESULT"
        setHasOptionsMenu(true)
        // Remove current layout
        val container = requireView().findViewById<ViewGroup>(R.id.pageContainer)
        container.removeAllViews()
        // put maktaba search layout
        val maktabasearchView = layoutInflater.inflate(R.layout.library_search_layout, null)
        container.addView(maktabasearchView)
        // add a list of books that have a name or author name contain the searchcode (icon in the right and information in the left, one book per line)
        val search_books = searchBooks(booklist, searchQuery.toString())
        // Create a new ConstraintLayout
        val constraintLayout = ConstraintLayout(requireContext())
        constraintLayout.layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.MATCH_PARENT
        )
        container.addView(constraintLayout)

        // Create the title TextView
        val titleTextView = TextView(requireContext())
        titleTextView.id = ViewCompat.generateViewId()
        titleTextView.text = "Search results : [${searchQuery}] :"
        titleTextView.textSize = 20f
        titleTextView.setTypeface(null, Typeface.BOLD)
        constraintLayout.addView(titleTextView)

        // Create the ScrollView
        val scrollView = ScrollView(requireContext())
        scrollView.id = ViewCompat.generateViewId()
        scrollView.layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.MATCH_PARENT
        )
        constraintLayout.addView(scrollView)

        // Create a LinearLayout inside the ScrollView
        val linearLayout = LinearLayout(requireContext())
        linearLayout.id = ViewCompat.generateViewId()
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        scrollView.addView(linearLayout)

        // Set constraints for the title TextView
        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)
        constraintSet.connect(
            titleTextView.id, ConstraintSet.TOP,
            ConstraintSet.PARENT_ID, ConstraintSet.TOP,
            20 // Set the desired margin between the title and the top
        )
        constraintSet.connect(
            titleTextView.id, ConstraintSet.END,
            ConstraintSet.PARENT_ID, ConstraintSet.END,
            20 // Set the desired margin between the title and the right
        )
        constraintSet.applyTo(constraintLayout)

        // Set constraints for the ScrollView
        val scrollViewConstraintSet = ConstraintSet()
        scrollViewConstraintSet.clone(constraintLayout)
        scrollViewConstraintSet.connect(
            scrollView.id, ConstraintSet.TOP,
            titleTextView.id, ConstraintSet.BOTTOM,
            150 // Set the desired margin between the title and the scroll view
        )
        scrollViewConstraintSet.connect(
            scrollView.id, ConstraintSet.BOTTOM,
            ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM,
            0 // Set the desired margin between the Bottom and the scroll view
        )
        scrollViewConstraintSet.applyTo(constraintLayout)

        // Create and add image and text pairs
        for (i in 0 until search_books.count()) {
            val containerLayout = RelativeLayout(requireContext())
            containerLayout.id = ViewCompat.generateViewId()

            ///////////////////////////////////////////////////////////////////////////////////////// Create the background drawable for each line
            // Create a transparent color with a specific transparency level (0-255)
            val backgroundDrawable: Drawable = GradientDrawable().apply {
                setColor(Color.argb(20, 0, 0, 0))
                cornerRadius = 45f
            }
            containerLayout.background = backgroundDrawable
            val containerLayoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )
            containerLayoutParams.setMargins(30, 0, 30, 20)
            containerLayout.layoutParams = containerLayoutParams

            linearLayout.addView(containerLayout)
            // Create the ImageView
            val imageView = ImageView(requireContext())
            imageView.id = ViewCompat.generateViewId()
            val imageLayoutParams = RelativeLayout.LayoutParams(350, 350)
            imageLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
            imageLayoutParams.setMargins(0, 20, 10, 20)
            imageView.layoutParams = imageLayoutParams
            imageView.setImageResource(R.drawable.book_3)
            imageView.setImageResource(search_books[i].iconName)
            containerLayout.addView(imageView)

            // Create the TextView for the description
            val descriptionTextView = TextView(requireContext())
            descriptionTextView.id = ViewCompat.generateViewId()


            val text =
                "name${search_books[i].name}\nauthor ${search_books[i].author}\neditor ${search_books[i].editor}\n Volumesnumber ${search_books[i].Volumesnumber}"

            val spannableText = SpannableStringBuilder(text)
            spannableText.setSpan(
                StyleSpan(Typeface.BOLD),
                text.indexOf("name"),
                text.indexOf("name") + "name".length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            spannableText.setSpan(
                StyleSpan(Typeface.BOLD),
                text.indexOf("author"),
                text.indexOf("author") + "author".length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            spannableText.setSpan(
                StyleSpan(Typeface.BOLD),
                text.indexOf("editor"),
                text.indexOf("editor") + "editor".length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            spannableText.setSpan(
                StyleSpan(Typeface.BOLD),
                text.indexOf("Volumesnumber"),
                text.indexOf("Volumesnumber") + "Volumesnumber".length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            descriptionTextView.text = spannableText

            val descriptionLayoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )
            descriptionLayoutParams.addRule(RelativeLayout.LEFT_OF, imageView.id)
            descriptionLayoutParams.setMargins(0, 30, 10, 0)
            descriptionTextView.layoutParams = descriptionLayoutParams
            containerLayout.addView(descriptionTextView)
        }
    }
    private fun searchBooks(bookList: List<Book>, searchQuery: String): List<Book> {
        val searchResults = mutableListOf<Book>()
        for (book in bookList) {
            if (book.name.toLowerCase().contains(searchQuery.toLowerCase()) ||
                book.author.toLowerCase().contains(searchQuery.toLowerCase())
            ) {
                searchResults.add(book)
            }
        }
        return searchResults
    }
    private fun showToastWithActiveLayoutName() {
        val layoutName = current_activity // Replace with the actual name of layout1
        if (layoutName != "DASHBOARD" ){
            showBackButton= true
            requireActivity().invalidateOptionsMenu()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        if (showBackButton) {
            // Add a menu item dynamically

            val menuItem = menu.add(Menu.NONE, 2, Menu.NONE, "Back")

            // Set a click listener for the menu item
            menuItem.setOnMenuItemClickListener {
                if (current_activity == "LIBRARY_ALLBOOKS" || current_activity == "LIBRARY_SELECTEDBOOK" || current_activity == "LIBRARY_SEARCHRESULT") {
                    switchToMaktabaLayout()
                    true // Return true to indicate that the event has been handled
                } else {
                    switchToDashboardLayout()
                    true
                }
            }
        }
    }
}