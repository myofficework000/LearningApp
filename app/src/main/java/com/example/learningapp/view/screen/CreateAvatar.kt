package com.example.learningapp.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.School
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.learningapp.R


@Preview
@Composable
fun CreateAvatar(){
    val tabOptions = listOf(
        stringResource(R.string.skin_tone) to Icons.Outlined.Person,
        stringResource(R.string.expression) to Icons.Outlined.Face,
        stringResource(R.string.headwear) to Icons.Outlined.School
    )
    var selectedTab by remember { mutableStateOf(tabOptions[0].first) }
    var selectedSkinTone by remember { mutableStateOf(getSkinTone()[0]) }
    var selectedExpression by remember { mutableStateOf(getExpression()[0]) }
    var selectedHatColor by remember { mutableStateOf<Color?>(null) }
    var selectedHat by remember { mutableStateOf<Int?>(null) }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()

    ) {
        val (buttonsRow, previewBox, iconTabs, optionsContainer) = createRefs()
        val guideline = createGuidelineFromTop(0.4f)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(buttonsRow) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "close",
                    tint = Color.Gray)
            }

            Text(
                text = stringResource(R.string.create_avatar),
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )

            TextButton(
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = stringResource(R.string.done),
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Box(
            modifier = Modifier
                .constrainAs(previewBox) {
                    top.linkTo(buttonsRow.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(guideline)
                    height = Dimension.fillToConstraints
                }
                .background(Color.LightGray)
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 30.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(selectedSkinTone, CircleShape)
                    .align(Alignment.BottomCenter)
            )
            Image(
                modifier = Modifier
                    .size(120.dp)
                    .offset(0.dp, -15.dp)
                    .align(Alignment.BottomCenter),
                painter = painterResource(selectedExpression),
                contentDescription = null)

            selectedHat?.let { painterResource(it) }?.let {
                Image(
                    modifier = Modifier
                        .size(170.dp)
                        .align(Alignment.Center)
                        .offset(0.dp, -30.dp),
                    painter = it,
                    contentDescription = null,
                    colorFilter = selectedHatColor?.let { it1 -> ColorFilter.tint(it1) })
            }
        }

        TabRow(
            modifier = Modifier
                .constrainAs(iconTabs){
                    top.linkTo(previewBox.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            selectedTabIndex = tabOptions.indexOfFirst { it.first == selectedTab },
            indicator = {tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[tabOptions.indexOfFirst { it.first == selectedTab }])
                )
            }
        ) {
            tabOptions.forEach { tab ->
                Tab(
                    selected = selectedTab == tab.first,
                    onClick = { selectedTab = tab.first }
                ) {
                    Icon(
                        imageVector = tab.second,
                        contentDescription = tab.first,
                        tint = if (selectedTab == tab.first) Color.Blue else Color.Gray,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }

        when (selectedTab){
            stringResource(R.string.skin_tone) ->  SkinToneOptions(
                modifier = Modifier
                    .constrainAs(optionsContainer) {
                        top.linkTo(iconTabs.bottom, 10.dp)
                        start.linkTo(parent.start, 10.dp)
                        end.linkTo(parent.end, 10.dp)
                    }
            ) { selectedColor ->
                selectedSkinTone = selectedColor
            }
            stringResource(R.string.expression) -> FacialExpressionOptions(
                modifier = Modifier
                    .constrainAs(optionsContainer) {
                        top.linkTo(iconTabs.bottom, 10.dp)
                        start.linkTo(parent.start, 10.dp)
                        end.linkTo(parent.end, 10.dp)
                    }
                    .fillMaxWidth()
            ){selectedFacialExpression ->
                selectedExpression = selectedFacialExpression
            }
            stringResource(R.string.headwear) -> HatOptions(
                modifier = Modifier
                    .constrainAs(optionsContainer) {
                        top.linkTo(iconTabs.bottom, 10.dp)
                        start.linkTo(parent.start, 30.dp)
                        end.linkTo(parent.end, 10.dp)
                    }
                    .fillMaxWidth(),
                onHatColorSelected = {selectedHeadwearColor -> selectedHatColor = selectedHeadwearColor},
                onHatSelected = {selectedHeadwear -> selectedHat = selectedHeadwear}
            )
        }
    }
}

@Composable
fun SkinToneOptions(modifier: Modifier, onSkinToneSelected: (Color) -> Unit){
    var selectedSkinTone by remember { mutableStateOf<Color?>(null) }
    Column(modifier = modifier){
        Text(
            modifier = Modifier.padding(10.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            text = stringResource(R.string.skin_tone)
        )
        Row {
            getSkinTone().forEach {skinTone->
                Box(
                    modifier = Modifier
                        .size(65.dp)
                        .border(
                            2.dp,
                            if (skinTone == selectedSkinTone) Color.Blue else Color.LightGray,
                            RectangleShape
                        )
                        .background(Color.Transparent, RectangleShape)
                        .clickable {
                            selectedSkinTone = skinTone
                            onSkinToneSelected(skinTone)
                        }
                        .padding(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(skinTone, RectangleShape)
                    )
                }
                Spacer(modifier = Modifier.size(10.dp))
            }
        }
    }
}

@Composable
fun FacialExpressionOptions(modifier: Modifier, onExpressionSelected: (Int) -> Unit){
    var selectedExpression by remember { mutableStateOf<Int?>(null) }
    Column(modifier = modifier){
        Text(
            modifier = Modifier.padding(10.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            text = stringResource(R.string.expression)
        )
        Row {
            getExpression().forEach {expression->
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .border(
                            2.dp,
                            if (expression == selectedExpression) Color.Blue else Color.LightGray,
                            RectangleShape
                        )
                        .background(Color.Transparent, RectangleShape)
                        .clickable {
                            selectedExpression = expression
                            onExpressionSelected(expression)
                        }
                        .padding(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(90.dp)
                            .background(getSkinTone()[0], CircleShape)
                            .padding(15.dp)
                    ) {
                        Image(
                            modifier = Modifier
                                .size(70.dp)
                                .align(Alignment.Center),
                            painter = painterResource(expression),
                            contentDescription = null)
                    }
                }
                Spacer(modifier = Modifier.size(20.dp))
                }
            }
        }
    }

@Composable
fun HatOptions(modifier: Modifier, onHatColorSelected: (Color) -> Unit, onHatSelected: (Int) -> Unit){
    var selectedHatColor by remember { mutableStateOf<Color?>(null) }
    var selectedHat by remember { mutableStateOf<Int?>(null) }
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(10.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            text = stringResource(R.string.headwear_color)
        )
        Row {
            getHatColor().forEach { hatColor->
                Box(
                    modifier = Modifier
                        .size(65.dp)
                        .border(
                            2.dp,
                            if (hatColor == selectedHatColor) Color.Blue else Color.LightGray,
                            RectangleShape
                        )
                        .background(Color.Transparent, RectangleShape)
                        .clickable {
                            selectedHatColor = hatColor
                            onHatColorSelected(hatColor)
                        }
                        .padding(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(hatColor, RectangleShape)
                    )
                }
                Spacer(modifier = Modifier.size(10.dp))
            }
        }

        Text(
            modifier = Modifier.padding(10.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            text = stringResource(R.string.headwear)
        )

        Row {
            getHat().forEach { hat->
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .border(
                            2.dp,
                            if (hat == selectedHat) Color.Blue else Color.LightGray,
                            RectangleShape
                        )
                        .background(Color.Transparent, RectangleShape)
                        .clickable {
                            selectedHat = hat
                            onHatSelected(hat)
                        }
                        .padding(10.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .size(70.dp)
                            .align(Alignment.Center),
                        painter = painterResource(hat),
                        contentDescription = null)
                }
                Spacer(modifier = Modifier.size(20.dp))
            }
        }
    }
}

fun getSkinTone() = listOf(
    Color(0xFF6c3d38),
    Color(0xFF7c4a3d),
    Color(0xFF8a4924),
    Color(0xFF94513d),
    Color(0xFF975d2e),
    Color(0xFFa36646)
)

fun getExpression() = listOf(
    R.drawable.facial_expression_2,
    R.drawable.facial_expression_1,
    R.drawable.facial_expression_3,
    R.drawable.facial_expression_4
)

fun getHatColor() = listOf(
    Color.Blue,
    Color.Green,
    Color.Yellow,
    Color.Magenta
)

fun getHat() = listOf(
    R.drawable.hat_cap,
    R.drawable.hat_christmas,
    R.drawable.hat_graduation,
    R.drawable.hat_panama
)
