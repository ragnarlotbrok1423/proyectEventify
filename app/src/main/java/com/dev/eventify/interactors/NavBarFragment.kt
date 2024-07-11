package com.dev.eventify.interactors
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.dev.eventify.R

class NavBarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.navbar, container, false)

        val buttonHome: ImageView = view.findViewById(R.id.button_home)
        val icoFac: ImageView = view.findViewById(R.id.icofac)
        val moreButton: ImageView = view.findViewById(R.id.more_button)
        val personButt: ImageView = view.findViewById(R.id.person_butt)

        buttonHome.setOnClickListener {
            val intent = Intent(activity, ViewHome::class.java)
            startActivity(intent)
        }

        icoFac.setOnClickListener {
            val intent = Intent(activity, ViewFac::class.java)
            startActivity(intent)
        }

        moreButton.setOnClickListener {
            val intent = Intent(activity, ViewPost::class.java)
            startActivity(intent)
        }

        personButt.setOnClickListener {
            val intent = Intent(activity, ViewProfile::class.java)
            startActivity(intent)
        }

        return view
    }
}
class NavBarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_navbar, container, false)

        val buttonHome: ImageView = view.findViewById(R.id.button_home)
        val icoFac: ImageView = view.findViewById(R.id.icofac)
        val moreButton: ImageView = view.findViewById(R.id.more_button)
        val personButt: ImageView = view.findViewById(R.id.person_butt)

        // Check which fragment is currently running and adjust the margin if needed
        adjustButtonMargin(buttonHome, ViewHome::class.java)
        adjustButtonMargin(icoFac, ViewFac::class.java)
        adjustButtonMargin(moreButton, ViewPost::class.java)
        adjustButtonMargin(personButt, ViewProfile::class.java)

        buttonHome.setOnClickListener {
            val intent = Intent(activity, ViewHome::class.java)
            startActivity(intent)
        }

        icoFac.setOnClickListener {
            val intent = Intent(activity, ViewFac::class.java)
            startActivity(intent)
        }

        moreButton.setOnClickListener {
            val intent = Intent(activity, ViewPost::class.java)
            startActivity(intent)
        }

        personButt.setOnClickListener {
            val intent = Intent(activity, ViewProfile::class.java)
            startActivity(intent)
        }

        return view
    }

    private fun adjustButtonMargin(button: ImageView, fragmentClass: Class<*>) {
        if (activity?.supportFragmentManager?.findFragmentById(R.id.fragment_container)!!::class.java == fragmentClass) {
            val params = button.layoutParams as RelativeLayout.LayoutParams
            params.topMargin -= 20 // Move up by 20px
            button.layoutParams = params
        }
    }
}