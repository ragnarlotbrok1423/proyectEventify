package com.dev.eventify.components

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.dev.eventify.R
import com.dev.eventify.ui.themes.EventifyTheme

@Composable
fun GifImage(
    modifier: Modifier = Modifier,
    gif: Int
) {

    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }

        }
        .build()

    Image(
        painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(context)
                .data(gif)
                .size(Size.ORIGINAL)
                .build(),
            imageLoader = imageLoader
        ),
        contentDescription = null,
        modifier = modifier,
    )

}

@Composable
fun ImageFit(img: Int, size: Dp){
    Image(painter = painterResource(id = img),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .size(size)
    )
}

@Composable
fun ImageMaxWidth(img: Int){
    Image(painter = painterResource(id = img),
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Preview
@Composable
fun ImagePreview(){
//    Gif solo es visible cuando se corre el app
//    GifImage(modifier = Modifier.fillMaxWidth(), R.drawable.splash_icon)
    EventifyTheme(darkTheme = false){

        ImageFit(R.drawable.splash_icon, dimensionResource(id = R.dimen.app_icon_size))
    }

}