package com.challenge.codewars.feature.member.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navArgs
import androidx.navigation.ui.setupWithNavController
import com.challenge.codewars.R
import com.challenge.codewars.databinding.ActivityMemberBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MemberActivity : AppCompatActivity() {

    private var binding: ActivityMemberBinding? = null
    val args by navArgs<MemberActivityArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemberBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setUpViews()
    }

    private fun setUpViews() {
        val navHost =
            supportFragmentManager.findFragmentById(R.id.member_fragment_container) as NavHostFragment
        val navController = navHost.navController
        binding?.memberBottomNavigation?.setupWithNavController(navController)
    }
}
