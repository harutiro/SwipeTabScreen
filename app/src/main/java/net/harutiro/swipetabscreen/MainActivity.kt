package net.harutiro.swipetabscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import net.harutiro.swipetabscreen.ui.theme.SwipeTabScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwipeTabScreenTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TestTabs()
                }
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TestTabs() {
    var tabIndex by remember { mutableStateOf(0) }
    val tabTitles = listOf("Hello", "There", "World")
    val pagerState = rememberPagerState() // 2.
    val scope = rememberCoroutineScope()

    Column {
//        TabRow(selectedTabIndex = tabIndex,
//            indicator = { tabPositions -> // 3.
//                TabRowDefaults.Indicator(
////                    Modifier.pagerTabIndicatorOffset(
////                        pagerState,
////                        tabPositions
////                    )
//                )
//            }) {
//            tabTitles.forEachIndexed { index, title ->
//                Tab(selected = tabIndex == index,
//                    onClick = {
//                        scope.launch {
//                            tabIndex = index
//                            pagerState.animateScrollToPage(index)
//                        }
//                    },
//                    text = { Text(text = title) })
//            }
//        }
        VerticalPager(
            count = tabTitles.size,
            state = pagerState,
        ) { tabIndex ->
            Text(
                tabIndex.toString(),
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            )
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SwipeTabScreenTheme {
        TestTabs()
    }
}