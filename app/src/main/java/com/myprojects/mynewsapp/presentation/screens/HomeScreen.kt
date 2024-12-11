package com.myprojects.mynewsapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.myprojects.mynewsapp.domain.model.Article
import com.myprojects.mynewsapp.presentation.HomeStateHolder
import com.myprojects.mynewsapp.presentation.viewmodel.NewsViewModel

@Composable
fun HomeScreen(viewModel: NewsViewModel = hiltViewModel()) {
    val res: HomeStateHolder = viewModel.articles.value

    if (res.isLoading) {
        Box(Modifier.fillMaxSize()) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    }
    if (res.error.isNotBlank()) {
        Box(Modifier.fillMaxSize()) {
            Text(text = res.error, Modifier.align(Alignment.Center))
        }
    }
    res.data?.let {
        LazyColumn {
            items(it) {
                NewsArticleItem(it)
            }
        }
    }
}

@Composable
fun NewsArticleItem(it: Article) {
    Column {
        Image(
            painter = rememberImagePainter(data = it.urlToImage), contentDescription = "",
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = it.title,
            style = TextStyle(color = Color.Red),
            modifier = Modifier.padding(12.dp),
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )
    }

}