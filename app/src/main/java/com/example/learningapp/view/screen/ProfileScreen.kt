package com.example.learningapp.view.screen


import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.learningapp.R
import com.example.learningapp.modal.dto.Statistics
import com.example.learningapp.view.theme.ColorBlue
import com.example.learningapp.view.theme.ColorYellow
import com.example.learningapp.view.theme.GreyWhite
import com.example.learningapp.view.theme.LightBlue1
import com.example.learningapp.view.theme.LightGrey
import com.example.learningapp.view.theme.lightBlack


@Preview(showBackground = true)
@Composable
fun ProfileScreen() {
    val state = rememberScrollState()

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state)
    ) {

        val (boxProfile, profileName, dividerOne, flagImage, profileId,
            personJoined, following, followers, cardView,
            btnUp, btnAddFriends, dividerTwo, listView,statisticsText,achievementsText,AchievementsCard) = createRefs()
        val guidLine = createGuidelineFromTop(0.2f)


        Box(
            modifier = Modifier
                .background(LightBlue1)
                .constrainAs(boxProfile) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(guidLine)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                },
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                modifier = Modifier.size(150.dp),
                painter = painterResource(R.drawable.profile1), contentDescription = "image",

                )
        }

        Divider(thickness = 2.dp,
            color = Color.LightGray,
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .constrainAs(dividerOne) {
                    start.linkTo(parent.start)
                    top.linkTo(boxProfile.bottom)
                }
                .padding(top = 50.dp))

        Text(text = "Pavani Velma",
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .constrainAs(profileName) {
                    top.linkTo(boxProfile.bottom)
                    start.linkTo(parent.start)
                }
                .padding(start = 10.dp, top = 20.dp))

        Image(
            painter = painterResource(R.drawable.india_flag1), contentDescription = "image",
            modifier = Modifier
                .height(40.dp)
                .width(40.dp)
                .constrainAs(flagImage) {
                    top.linkTo(boxProfile.bottom)
                    end.linkTo(parent.end)
                }
                .padding(top = 20.dp, end = 15.dp)
        )
        Text(text = "Pavani Velma",
            fontSize = 20.sp,
            modifier = Modifier
                .constrainAs(profileId) {
                    top.linkTo(profileName.bottom)
                    start.linkTo(parent.start)
                }
                .padding(start = 10.dp, top = 10.dp))

        Text(text = "Pavani Velma",
            fontSize = 20.sp,
            modifier = Modifier
                .constrainAs(personJoined) {
                    top.linkTo(profileId.bottom)
                    start.linkTo(parent.start)
                }
                .padding(start = 10.dp, top = 10.dp))

        Text(text = "0 Following",
            fontWeight = FontWeight.Bold,
            color = ColorBlue,
            fontSize = 20.sp,
            modifier = Modifier
                .constrainAs(following) {
                    top.linkTo(personJoined.bottom)
                    start.linkTo(parent.start)
                }
                .padding(start = 10.dp, top = 10.dp))

        Text(text = "0 Followers",
            fontWeight = FontWeight.Bold,
            color = ColorBlue,
            fontSize = 20.sp,
            modifier = Modifier
                .constrainAs(followers) {
                    top.linkTo(personJoined.bottom)
                    start.linkTo(following.end)
                }
                .padding(start = 10.dp, top = 10.dp))


        OutlinedButton(
            onClick = { },
            border = BorderStroke(2.dp, LightGrey.copy(alpha = 0.5f)),
            modifier = Modifier
                .constrainAs(btnAddFriends) {
                    start.linkTo(parent.start)
                    top.linkTo(following.bottom)
                }
                .padding(start = 4.dp, top = 10.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.baseline_person_add_alt_1_24),
                contentDescription = "image",
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "ADD FRIENDS", color = ColorBlue,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }


        OutlinedButton(
            onClick = { },
            border = BorderStroke(2.dp, LightGrey.copy(alpha = 0.5f)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .wrapContentWidth()
                .constrainAs(btnUp) {
                    start.linkTo(btnAddFriends.end, 10.dp)
                    width = Dimension.fillToConstraints
                    top.linkTo(following.bottom)
                }
                .padding(start = 4.dp, top = 10.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.up), contentDescription = "image",
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
            )
        }
        Divider(thickness = 2.dp,
            color = Color.LightGray,
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .constrainAs(dividerTwo) {
                    start.linkTo(parent.start)
                    top.linkTo(btnUp.bottom)
                }
                .padding(top = 30.dp))

        CardView2(Modifier.constrainAs(cardView) {
            start.linkTo(parent.start)
            top.linkTo(dividerTwo.bottom)
        })

        LazyVerticalGrid(
            GridCells.Fixed(2),
            userScrollEnabled = false,
            modifier = Modifier
                .padding(top = 8.dp)
                .constrainAs(listView) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(statisticsText.bottom)
                }
                .height(250.dp)
        ) {
            items(statistics()) { statistics ->
                StatisticsStreak(statistics)
            }
        }

        Text(text = "Statistics",
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            modifier = Modifier
                .constrainAs(statisticsText) {
                    top.linkTo(cardView.bottom)
                    start.linkTo(parent.start)
                }
                .padding(start = 10.dp, top = 10.dp))

        Text(text = "Achievements",
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            modifier = Modifier
                .constrainAs(achievementsText) {
                    top.linkTo(listView.bottom)
                    start.linkTo(parent.start)
                }
                .padding(start = 10.dp))

        Achievements(
            Modifier
                .wrapContentSize()
                .constrainAs(AchievementsCard) {
                    top.linkTo(achievementsText.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })


    }
}



@SuppressLint("SuspiciousIndentation")
@Composable
fun CardView2(modifier: Modifier){


    Card(modifier =
    modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(top = 20.dp, start = 10.dp, end = 10.dp),
        border = BorderStroke(1.dp, Color.Gray),
        colors = CardDefaults.cardColors(containerColor = ColorBlue)
    ) {
        ConstraintLayout(modifier = Modifier.wrapContentSize()) {
            
            val(image,completeProfileText, text, btnContinue) = createRefs()
            Image(
                painter = painterResource(R.drawable.baseline_person_3_24), contentDescription = "image",
                modifier = Modifier
                    .height(60.dp)
                    .width(60.dp)
                    .constrainAs(image) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    }
                    .padding(start = 10.dp, top = 20.dp))

            Text(text = "Complete Your Profile",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier
                    .constrainAs(completeProfileText) {
                        top.linkTo(parent.top)
                        start.linkTo(image.end)
                    }
                    .padding(start = 10.dp, top = 10.dp))

            Text(text = stringResource(id = R.string.complete_sentence),
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier
                    .constrainAs(text) {
                        top.linkTo(completeProfileText.bottom)
                        start.linkTo(image.end)
                    }
                    .padding(start = 10.dp, top = 8.dp))

            Button(
                onClick = {},
                colors= ButtonDefaults.buttonColors(Color.White),
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                    .constrainAs(btnContinue) {
                        top.linkTo(text.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                Text(text = stringResource(R.string.Button_Continue_Caps),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = ColorBlue,
                    modifier = Modifier.padding(vertical = 8.dp))
            }





        }

    }

}

@Composable
fun StatisticsStreak(statistics: Statistics){
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, GreyWhite),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        ConstraintLayout(
            Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            val (image, title, titleDesc) = createRefs()

            Image(painter = painterResource(id = statistics.image),
                contentDescription = " Img ",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .height(30.dp)
                    .width(30.dp)
                    .constrainAs(image) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    })

            Spacer(modifier = Modifier.size(10.dp))

            Text(text =statistics.title ,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = lightBlack,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .constrainAs(title) {
                        top.linkTo(parent.top)
                        start.linkTo(image.end)
                    })

            Text(text =statistics.titleDesc ,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Gray,
                modifier = Modifier
                    .constrainAs(titleDesc) {
                        top.linkTo(title.bottom)
                        start.linkTo(image.end)
                    })

        }
    }
}

@Composable
fun Achievements(modifier: Modifier){
    Card(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, GreyWhite),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        ConstraintLayout(
            Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            val (image, title, dividerOne,btnReward,imag1,wildFireText,
                threeDayStreak, progressBar,dividerTwo,imageThree,sage
                    ,earn100,progressBarTwo,dividerThree,view10,vectorImage) = createRefs()

            Image(painter = painterResource(id = R.drawable.yellow_streak),
                contentDescription = " Img ",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .height(150.dp)
                    .width(130.dp)
                    .constrainAs(image) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    })

            Spacer(modifier = Modifier.size(10.dp))

            Text(text ="Photogenic",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge,
                color = lightBlack,
                modifier = Modifier
                    .padding(10.dp)
                    .constrainAs(title) {
                        top.linkTo(parent.top)
                        start.linkTo(image.end)
                        end.linkTo(parent.end)
                    }
                    .padding(top = 15.dp))


            Button(
                onClick = {},
                colors= ButtonDefaults.buttonColors(ColorBlue),
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 16.dp)
                    .constrainAs(btnReward) {
                        top.linkTo(title.bottom)
                        start.linkTo(image.end)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                    }
            ) {
                Text(text = "Claim Reward",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(vertical = 8.dp))
            }

            Divider(thickness = 2.dp,
                color = Color.Black,
                modifier = Modifier.width(100.dp)
                    .height(1.dp)
                    .fillMaxWidth()
                    .constrainAs(dividerOne) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(image.bottom)
                    }
                    .padding(top = 10.dp))


            Image(painter = painterResource(id = R.drawable.red_image),
                contentDescription = " Img ",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .height(150.dp)
                    .width(130.dp)
                    .constrainAs(imag1) {
                        start.linkTo(parent.start)
                        top.linkTo(dividerOne.bottom)
                    })

            Spacer(modifier = Modifier.size(10.dp))


            Text(text ="wildFire" ,
                fontWeight= FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge,
                color = lightBlack,
                modifier = Modifier
                    .padding(10.dp)
                    .constrainAs(wildFireText) {
                        top.linkTo(dividerOne.bottom)
                        start.linkTo(imag1.end)

                    }
                    .padding(start = 10.dp, top = 20.dp))

            Text(text ="Reach a 3 day streak" ,
                style = MaterialTheme.typography.bodyLarge,
                color = lightBlack,
                modifier = Modifier
                    .padding(10.dp)
                    .constrainAs(threeDayStreak) {
                        top.linkTo(wildFireText.bottom)
                        start.linkTo(imag1.end)
                    }
                    .padding(start = 10.dp))

            LinearProgressIndicator(progress =0.1f,
                color = ColorYellow,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(progressBar) {
                        top.linkTo(threeDayStreak.bottom)
                        start.linkTo(imag1.end)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints

                    })


            Divider(thickness = 2.dp,
                color = Color.LightGray,
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .constrainAs(dividerTwo) {
                        start.linkTo(parent.start)
                        top.linkTo(progressBar.bottom)
                    }
                    .padding(top = 10.dp))

            Image(painter = painterResource(id = R.drawable.third_image),
                contentDescription = " Img ",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .height(150.dp)
                    .width(130.dp)
                    .constrainAs(imageThree) {
                        start.linkTo(parent.start)
                        top.linkTo(imag1.bottom)
                    })

            Spacer(modifier = Modifier.size(10.dp))

            Text(text ="Sage" ,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight =FontWeight.Bold,
                color = lightBlack,
                modifier = Modifier
                    .padding(10.dp)
                    .constrainAs(sage) {
                        top.linkTo(imageThree.top)
                        start.linkTo(imageThree.end)

                    }
                    .padding(top = 20.dp))

            Text(text ="Earn 100 XP" ,
                style = MaterialTheme.typography.bodyLarge,
                color = lightBlack,
                modifier = Modifier
                    .padding(10.dp)
                    .constrainAs(earn100) {
                        top.linkTo(sage.bottom)
                        start.linkTo(imageThree.end)

                    })
            LinearProgressIndicator(progress =0.1f,

                color = ColorYellow,
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(progressBarTwo) {
                        start.linkTo(imageThree.end)
                        end.linkTo(parent.end)
                        top.linkTo(earn100.bottom)
                        width = Dimension.fillToConstraints
                    }
            )
            Divider(thickness = 2.dp,
                color = Color.LightGray,
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .constrainAs(dividerThree) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(progressBarTwo.bottom)
                    }
                    .padding(top = 10.dp))

            Text(text ="View 10 more" ,
                style = MaterialTheme.typography.bodyLarge,
                color = lightBlack,
                modifier = Modifier
                    .padding(10.dp)
                    .constrainAs(view10) {
                        top.linkTo(imageThree.bottom)
                        start.linkTo(parent.start)
                    })

            Image(painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                contentDescription = " Img ",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .height(30.dp)
                    .width(30.dp)
                    .constrainAs(vectorImage) {
                        end.linkTo(parent.end)
                        top.linkTo(imageThree.bottom)
                    })

        }
    }

}
fun statistics() = listOf(
    Statistics(R.drawable.streak, "1","Day streak"),
    Statistics(R.drawable.star, "1","Total XP"),
    Statistics(R.drawable.league, "No Current","Current League"),
    Statistics(R.drawable.medal, "0","Top 3 finishes")
)