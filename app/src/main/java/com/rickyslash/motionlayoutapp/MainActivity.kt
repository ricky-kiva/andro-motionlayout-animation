package com.rickyslash.motionlayoutapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }
}

// 3 important part in implementing animation in Android:
// - Property Animation: animate almost every View in an app, programmatically (change size, move, toggle visibility, etc)
// - Activity Transition: animate transition between activity, programmatically or using XML
// --- 3 type of Activity Transition: Enter, Exit, & Shared Element
// - Motion Layout: a hybrid of Property Animation & Transition Activity
// --- it is a subclass of ConstraintLayout that fills the gap between layout transition & motion

// MotionLayout is a `subclass` from `ConstraintLayout` with support for `View's animation`
// - MotionLayout can insert `complex transition` `directly` to `layout file`
// - MotionLayout is declarative, it means it can describe any transition to XML (even it's complex)

// This needed to make MotionLayout:
// - ConstraintLayout dependency
// - MotionLayout file
// --- <androidx.constraintlayout.motion.widget.MotionLayout .../>
// - MotionScene file
// --- isa file to animate things inside MotionLayout

// MotionLayout toolbar:
// - Create ConstraintSet: make new ConstraintSet based on available ConstraintSet
// - Create Transition between ConstraintSets: Connect one ConstraintSet to another
// - Create click or swipe handler: Add trigger for transition (click/swipe)
// - Cycle between layout: change MotionLayout panel layout

// MotionLayout Transition panel:
// - MotionLayout: set initial position before animation (the box that stands alone in the panel)
// - ConstraintSet: set appearance each ConstraintSet (2 box that is connected in the panel)
// - Transition: set how transition is triggered (the line that is connecting in the panel)

// MotionLayout Editor: to manage each transition animation from each View in details
// MotionLayout Properties: properties of MotionLayout that could be set