@file:OptIn(ExperimentalAnimationApi::class)

package dev.yaaum.presentation.core.ui.composable.card

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import androidx.constraintlayout.compose.Transition
import androidx.constraintlayout.compose.layoutId
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.models.DayUsageStatisticUiModel
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.button.circle.YaaumCircleButton
import dev.yaaum.presentation.core.ui.composable.chart.bar.YaaumBarChart
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

/**
 * Display graph with usage statistic per day
 */
@OptIn(ExperimentalAnimationApi::class)
@Suppress("LongMethod")
@Composable
fun DetailsHealthCard(
    data: List<DayUsageStatisticUiModel>?,
    modifier: Modifier =
        Modifier,
) {
    val isOpened = remember {
        mutableStateOf(true)
    }

    val cardId = "card_id"
    val iconId = "icon_id"
    val chartId = "chart_id"
    val totalTitleId = "total_title_id"
    val changeStateId = "change_state_id"

    val paddingMedium = YaaumTheme.spacing.medium
    val paddingSmall = YaaumTheme.spacing.small

    @Suppress("MagicNumber")
    val progress by animateFloatAsState(
        targetValue = if (isOpened.value) 0f else 1f,
        label = "",
    )

    val constraintSetStart = ConstraintSet {
        val icon = createRefFor(iconId)
        val card = createRefFor(cardId)
        val chart = createRefFor(chartId)
        val totalTitle = createRefFor(totalTitleId)
        val changeState = createRefFor(changeStateId)

        constrain(card) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.matchParent
            height = Dimension.fillToConstraints
        }
        constrain(totalTitle) {
            top.linkTo(parent.top, paddingSmall)
            bottom.linkTo(parent.bottom, paddingSmall)
            start.linkTo(parent.start, paddingSmall)
        }
        constrain(chart) {
            top.linkTo(changeState.bottom, paddingSmall)
            bottom.linkTo(parent.bottom, paddingSmall)
            start.linkTo(parent.start, paddingSmall)
            end.linkTo(parent.end, paddingSmall)
            width = Dimension.matchParent
            height = Dimension.ratio("1:1")
        }
        constrain(changeState) {
            top.linkTo(card.top, paddingMedium)
            end.linkTo(card.end, paddingSmall)
        }
        constrain(icon) {
            top.linkTo(card.top, paddingMedium)
            start.linkTo(card.start, paddingSmall)
        }
    }

    val constraintSetEnd = ConstraintSet {
        val icon = createRefFor(iconId)
        val card = createRefFor(cardId)
        val chart = createRefFor(chartId)
        val totalTitle = createRefFor(totalTitleId)
        val changeState = createRefFor(changeStateId)

        constrain(card) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.matchParent
            height = Dimension.fillToConstraints
        }
        constrain(totalTitle) {
            top.linkTo(icon.top)
            bottom.linkTo(icon.bottom)
            start.linkTo(icon.end, paddingSmall)
        }
        constrain(chart) {
            top.linkTo(changeState.bottom, paddingSmall)
            bottom.linkTo(parent.bottom, paddingSmall)
            start.linkTo(parent.start, paddingSmall)
            end.linkTo(parent.end, paddingSmall)
            width = Dimension.matchParent
            height = Dimension.value(0.dp)
        }
        constrain(changeState) {
            top.linkTo(card.top)
            bottom.linkTo(card.bottom)
            end.linkTo(card.end, paddingSmall)
        }
        constrain(icon) {
            top.linkTo(card.top, paddingSmall)
            bottom.linkTo(card.bottom, paddingSmall)
            start.linkTo(card.start, paddingSmall)
        }
    }

    val transition = Transition(
        from = "start",
        to = "end",
    ) {
        val icon = createRefFor(iconId)
        val chart = createRefFor(chartId)
        val totalTitle = createRefFor(totalTitleId)
        val changeState = createRefFor(changeStateId)

        @Suppress("MagicNumber")
        keyAttributes(chart) {
            frame(0) {
                alpha = 1f
            }
            frame(25) {
                alpha = 0f
            }
            frame(100) {
                alpha = 0f
            }
        }

        @Suppress("MagicNumber")
        keyAttributes(icon) {
            frame(0) {
                alpha = 0f
            }
            frame(100) {
                alpha = 1f
            }
        }

        @Suppress("MagicNumber")
        keyAttributes(totalTitle) {
            frame(0) {
                alpha = 0f
            }
            frame(25) {
                alpha = 1f
            }
            frame(100) {
                alpha = 1f
            }
        }
        @Suppress("MagicNumber")
        keyAttributes(changeState) {
            frame(0) {
                this.rotationZ = 0f
            }
            frame(100) {
                this.rotationZ = 180f
            }
        }
    }

    val motionScene = MotionScene {
        addConstraintSet(
            name = "start",
            constraintSet = constraintSetStart,
        )
        addConstraintSet(
            name = "end",
            constraintSet = constraintSetEnd,
        )

        addTransition(
            name = "default",
            transition = transition,
        )
    }

    MotionLayout(
        motionScene = motionScene,
        progress = progress,
        modifier = modifier
            .fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .layoutId(cardId)
                .clip(RoundedCornerShape(YaaumTheme.corners.medium))
                .background(YaaumTheme.colors.surface),
        )
        @Suppress("MagicNumber")
        YaaumBarChart(
            modifier = Modifier
                .layoutId(chartId),
            // TODO: fix
            data = data?.let {
                val temp = mutableMapOf<Any, Float>()
                data.filter { it.appUsage != 0L }.forEach {
                    temp[it.weekDay.asString(LocalContext.current)] = it.appUsage.toFloat()
                }
                temp
            } ?: emptyMap(),
            height = 250.dp,
        )
        Text(
            text = UiText
                .StringResource(dev.yaaum.presentation.core.localisation.R.string.health_month)
                .asString(LocalContext.current),
            style = YaaumTheme.typography.title,
            color = YaaumTheme.colors.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .layoutId(totalTitleId),
        )

        YaaumCircleButton(
            icon = R.drawable.icon_caret_up_bold_24,
            modifier = Modifier
                .layoutId(changeStateId),
            defaultBackgroundColor = YaaumTheme.colors.primary,
            pressedBackgroundColor = YaaumTheme.colors.secondary,
            iconSize = YaaumTheme.icons.small,
            onClick = {
                isOpened.value = isOpened.value.not()
            },
        )
        Box(
            modifier = Modifier
                .size(YaaumTheme.icons.medium)
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(YaaumTheme.corners.medium))
                .layoutId(iconId)
                .background(YaaumTheme.colors.secondary),
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_chart_pie_slice_bold_24),
                colorFilter = ColorFilter.tint(YaaumTheme.colors.onPrimary),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
                    .padding(YaaumTheme.spacing.small),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DetailsHealthCard_Dark() {
    YaaumTheme(useDarkTheme = true) {
        DetailsHealthCard(
            data = null,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DetailsHealthCard_Light() {
    YaaumTheme(useDarkTheme = false) {
        DetailsHealthCard(
            data = null,
        )
    }
}
