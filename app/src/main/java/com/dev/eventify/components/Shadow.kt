package com.dev.eventify.components

import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

//@Preview
//@Composable
//fun IconShadow() {
//    val context = LocalContext.current
//    val iconRes = R.drawable.ic_share
//    val shape = remember(context, iconRes) {
//        val drawable = ContextCompat.getDrawable(context, iconRes)
//        val path = requireNotNull(drawable).toBitmap().toPath()
//        GenericShape { _, _ -> addPath(path.asComposePath()) }
//    }
//
//    Icon(
//        painter = painterResource(iconRes),
//        contentDescription = null,
//        tint = Color.White,
//        modifier = Modifier
//            .padding(16.dp)
//            .shadow(
//                elevation = 3.dp,
//                shape = shape,
//            ),
//    )
//}

//fun Modifier.shadowCustom(
//    color: Color = Color.Black,
//    offsetX: Dp = 0.dp,
//    offsetY: Dp = 0.dp,
//    blurRadius: Dp = 0.dp,
//    shapeRadius: Dp = 0.dp,
//)
//= composed {
//    val paint: Paint = remember { Paint() }
//    val blurRadiusPx = blurRadius.px(LocalDensity.current)
//    val maskFilter = remember {
//        BlurMaskFilter(blurRadiusPx, BlurMaskFilter.Blur.NORMAL)
//    }
//    drawBehind {
//        drawIntoCanvas { canvas ->
//            val frameworkPaint = paint.asFrameworkPaint()
//            if (blurRadius != 0.dp) {
//                frameworkPaint.maskFilter = maskFilter
//            }
//            frameworkPaint.color = color.toArgb()
//
//            val leftPixel = offsetX.toPx()
//            val topPixel = offsetY.toPx()
//            val rightPixel = size.width + leftPixel
//            val bottomPixel = size.height + topPixel
//
//            if (shapeRadius > 0.dp) {
//                val radiusPx = shapeRadius.toPx()
//                canvas.drawRoundRect(
//                    left = leftPixel,
//                    top = topPixel,
//                    right = rightPixel,
//                    bottom = bottomPixel,
//                    radiusX = radiusPx,
//                    radiusY = radiusPx,
//                    paint = paint,
//                )
//            } else {
//                canvas.drawRect(
//                    left = leftPixel,
//                    top = topPixel,
//                    right = rightPixel,
//                    bottom = bottomPixel,
//                    paint = paint,
//                )
//            }
//        }
//    }
//}

private fun Dp.px(density: Density): Float =
    with(density) { toPx() }

