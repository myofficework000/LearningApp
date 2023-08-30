package com.example.learningapp.view.screen.choose_section

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.foundation.shape.CircleShape

import androidx.compose.ui.Alignment

import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp
import com.example.learningapp.R
import com.example.learningapp.modal.dto.DailyQuest
import com.example.learningapp.modal.dto.Section
import com.example.learningapp.view.theme.dot_notSelected
import com.example.learningapp.view.theme.dot_selected


@Preview(showBackground = true)
@Composable
fun PreviewChooseSectionScreen() {
    ChooseSectionScreen(rememberNavController())
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChooseSectionScreen(navController: NavController){
    Box {
        // [START android_compose_pager_indicator]
        val listOfSection = getListOfSection()
        val pageCount = listOfSection.size
        val pagerState = rememberPagerState(pageCount = {
            pageCount
        })
        HorizontalPager(
            state = pagerState
        ) { page ->
            // Our page content
            SectionScreen(section = listOfSection.get(page))
        }
        Row(
            Modifier
                .height(50.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pageCount) { iteration ->
                val color = if (pagerState.currentPage == iteration) dot_selected else dot_notSelected
                Box(
                    modifier = Modifier
                        .padding(5.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(10.dp)

                )
            }
        }
        // [END android_compose_pager_indicator]
    }

}
fun getListOfSection() = listOf(
    Section("Section 1",
        "Start with essential phrases and simple grammar concepts",
        1,
        5,
        R.drawable.owl_study,
        true),
    Section("Section 2",
        "Learn words phrases and grammar concepts for basic interactions",
        0,
        5,
        R.drawable.mountain_bike,
        false),
    Section("Section 10",
        "Learn words phrases and grammar concepts for basic interactions",
        0,
        10,
        R.drawable.owl_1,
        false),
)
