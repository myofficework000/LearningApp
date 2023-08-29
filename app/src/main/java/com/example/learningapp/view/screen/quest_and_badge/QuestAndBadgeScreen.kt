package com.example.learningapp.view.screen.quest_and_badge

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.learningapp.view.screen.HearAndChooseWordScreen
import com.example.learningapp.view.theme.Purple40
import com.example.learningapp.view.theme.QuestAndBadge_TabBackGround

/////testing
@Preview(showBackground = true)
@Composable
fun PreviewQuestAndBadgeScreen() {
    QuestAndBadgeScreen(rememberNavController())
}
/////////

// Use QuestAndBadgeScreen() as main
@Composable
fun QuestAndBadgeScreen(navController: NavController){
    var tabIndex by remember { mutableIntStateOf(0) }

    val tabs = listOf("QUEST", "BADGE")

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { index, title ->
                CustomTab(
                    title = title,
                    isSelected = index == tabIndex,
                    onTabClick = { tabIndex = index }
                )
            }
        }
        when (tabIndex) {
            0 -> QuestScreen()
            1 -> BadgeScreen()
        }
    }
}

@Composable
fun CustomTab(
    title: String,
    isSelected: Boolean,
    onTabClick: () -> Unit
) {
    val textColor = if (isSelected) Color.White else Color.Black

    Box(
        modifier = Modifier
            .clickable { onTabClick() }
            .background(QuestAndBadge_TabBackGround)
            .height(60.dp)
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            color = textColor,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
                .align(Alignment.Center)
        )
    }
}
