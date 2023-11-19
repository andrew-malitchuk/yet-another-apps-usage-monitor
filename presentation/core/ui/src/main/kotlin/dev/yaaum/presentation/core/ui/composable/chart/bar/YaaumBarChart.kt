package dev.yaaum.presentation.core.ui.composable.chart.bar

import android.graphics.Paint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import kotlinx.coroutines.delay

/**
 * Customizable bar chart
 *
 * @param modifier
 * @param data content to display
 * @param barCornersRadius
 * @param barColor
 * @param barWidth
 * @param height
 * @param labelOffset
 */
@Suppress("MagicNumber", "LongMethod")
@ExperimentalAnimationApi
@Composable
fun YaaumBarChart(
    modifier: Modifier = Modifier,
    data: Map<Any, Float>,
    barCornersRadius: Float = 25f,
    barColor: Color = Color.Blue,
    barWidth: Float = 50f,
    height: Dp,
    labelOffset: Float = 60f,
) {
    var screenSize by remember {
        mutableStateOf(Size.Zero)
    }

    var chosenBar by remember {
        mutableStateOf(-1)
    }
    var chosenBarKey by remember {
        mutableStateOf("")
    }

    LaunchedEffect(chosenBar) {
        delay(3000)
        chosenBarKey = ""
    }

    val localLabelColor =
        YaaumTheme.colors.primary

    val labelColor: Color = YaaumTheme.colors.onBackground

    val fontSize = YaaumTheme.fontSize.display.value

    val popupCorner = YaaumTheme.corners.small.value

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .clip(shape = RoundedCornerShape(YaaumTheme.corners.medium))
            .background(
                color = YaaumTheme.colors.onPrimary,
            )
            .animateContentSize(),
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = 65.dp,
                    bottom = YaaumTheme.spacing.medium,
                    start = YaaumTheme.spacing.large,
                    end = YaaumTheme.spacing.large,

                )
                .pointerInput(Unit) {
                    this.detectTapGestures(onPress = {
                        chosenBar = detectPosition(
                            screenSize = screenSize,
                            offset = it,
                            listSize = data.size,
                            itemWidth = barWidth,
                        )
                        if (chosenBar >= 0) {
                            chosenBarKey = data.toList()[chosenBar].first.toString()
                        }
                    })
                },
            onDraw = {
                screenSize = size
                val spaceBetweenBars =
                    (size.width - (data.size * barWidth)) / (data.size - 1)
                val maxBarHeight = data.values.maxOf { it }
                val barScale = size.height / maxBarHeight
                val paint = Paint().apply {
                    this.color = labelColor.toArgb()
                    textAlign = Paint.Align.CENTER
                    textSize = fontSize
                }

                var spaceStep = 0f

                for (item in data) {
                    val topLeft = Offset(
                        x = spaceStep,
                        y = size.height - item.value * barScale - labelOffset,
                    )
                    // Bars
                    drawRoundRect(
                        color = barColor,
                        topLeft = topLeft,
                        size = Size(
                            width = barWidth,
                            height = size.height - topLeft.y - labelOffset,
                        ),
                        cornerRadius = CornerRadius(barCornersRadius, barCornersRadius),
                    )
                    // X
                    drawContext.canvas.nativeCanvas.drawText(
                        item.key.toString(),
                        spaceStep + barWidth / 2,
                        size.height,
                        paint,
                    )
                    // Labels
                    if (chosenBarKey == item.key.toString()) {
                        drawRoundRect(
                            color = localLabelColor,
                            topLeft = Offset(x = topLeft.x - 40f, y = topLeft.y - 100),
                            size = Size(140f, 80f),
                            cornerRadius = CornerRadius(popupCorner, popupCorner),
                        )
                        val path = Path().apply {
                            moveTo(topLeft.x + 50f, topLeft.y - 20)
                            lineTo(topLeft.x + 25f, topLeft.y)
                            lineTo(topLeft.x, topLeft.y - 20)
                            lineTo(topLeft.x + 50f, topLeft.y - 20)
                        }
                        drawIntoCanvas { canvas ->
                            canvas.drawOutline(
                                outline = Outline.Generic(path = path),
                                paint = androidx.compose.ui.graphics.Paint().apply {
                                    color = localLabelColor
                                },
                            )
                        }

                        drawContext.canvas.nativeCanvas.drawText(
                            item.value.toString(),
                            topLeft.x + 25,
                            topLeft.y - 50,
                            paint,
                        )
                    }

                    spaceStep += spaceBetweenBars + barWidth
                }
            },
        )
    }
}

// TODO: move me
private fun detectPosition(screenSize: Size, offset: Offset, listSize: Int, itemWidth: Float): Int {
    val spaceBetweenBars =
        (screenSize.width - (listSize * itemWidth)) / (listSize - 1)
    var spaceStep = 0f
    for (i in 0 until listSize) {
        if (offset.x in spaceStep..(spaceStep + itemWidth)) {
            return i
        }
        spaceStep += spaceBetweenBars + itemWidth
    }
    return -1
}

@Suppress("MagicNumber")
@OptIn(ExperimentalAnimationApi::class)
@Preview(showBackground = true)
@Composable
fun Preview_YaaumBarChart_Dark() {
    YaaumTheme(useDarkTheme = true) {
        YaaumBarChart(
            modifier = Modifier,
            data = mapOf(
                Pair("Jan", 6f),
                Pair("Feb", 0.25f),
                Pair("Mar", 9f),
                Pair("Apr", 7f),
                Pair("May", 8f),
                Pair("Jun", 9f),
                Pair("Jul", 3f),
                Pair("Aug", 11f),
                Pair("Sep", 15f),
            ),
            height = 250.dp,
        )
    }
}

@Suppress("MagicNumber")
@OptIn(ExperimentalAnimationApi::class)
@Preview(showBackground = true)
@Composable
fun Preview_YaaumBarChart_Light() {
    YaaumTheme(useDarkTheme = false) {
        YaaumBarChart(
            modifier = Modifier,
            data = mapOf(
                Pair("Jan", 6f),
                Pair("Feb", 0.25f),
                Pair("Mar", 9f),
                Pair("Apr", 7f),
                Pair("May", 8f),
                Pair("Jun", 9f),
                Pair("Jul", 3f),
                Pair("Aug", 11f),
                Pair("Sep", 15f),
            ),
            height = 250.dp,
        )
    }
}
