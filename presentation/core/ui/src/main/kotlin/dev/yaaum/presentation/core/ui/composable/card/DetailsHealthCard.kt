@file:OptIn(ExperimentalAnimationApi::class)

package dev.yaaum.presentation.core.ui.composable.card

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import androidx.constraintlayout.compose.Transition
import androidx.constraintlayout.compose.layoutId
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
    modifier: Modifier =
        Modifier,
) {
    val isOpened = remember {
        mutableStateOf(true)
    }

    val cardId = "card_id"
    val weekId = "week_id"
    val monthId = "month_id"
    val yearId = "year_id"
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
        val card = createRefFor(cardId)
        val week = createRefFor(weekId)
        val month = createRefFor(monthId)
        val year = createRefFor(yearId)
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
            top.linkTo(year.bottom, paddingSmall)
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
        constrain(week) {
            top.linkTo(card.top, paddingMedium)
            start.linkTo(card.start, paddingSmall)
        }
        constrain(month) {
            top.linkTo(card.top, paddingMedium)
            start.linkTo(week.end, paddingSmall)
        }
        constrain(year) {
            top.linkTo(card.top, paddingMedium)
            start.linkTo(month.end, paddingSmall)
        }
    }

    val constraintSetEnd = ConstraintSet {
        val card = createRefFor(cardId)
        val week = createRefFor(weekId)
        val month = createRefFor(monthId)
        val year = createRefFor(yearId)
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
            top.linkTo(year.bottom, paddingSmall)
            bottom.linkTo(parent.bottom, paddingSmall)
            start.linkTo(parent.start, paddingSmall)
            end.linkTo(parent.end, paddingSmall)
            width = Dimension.matchParent
            height = Dimension.value(0.dp)
        }
        constrain(changeState) {
            top.linkTo(card.top, paddingMedium)
            end.linkTo(card.end, paddingSmall)
        }
        constrain(week) {
            top.linkTo(card.top, paddingMedium)
            start.linkTo(card.start, paddingSmall)
        }
        constrain(month) {
            top.linkTo(card.top, paddingMedium)
            start.linkTo(week.end, paddingSmall)
        }
        constrain(year) {
            top.linkTo(card.top, paddingMedium)
            start.linkTo(month.end, paddingSmall)
        }
    }

    val transition = Transition(
        from = "start",
        to = "end",
    ) {
        val card = createRefFor(cardId)
        val week = createRefFor(weekId)
        val month = createRefFor(monthId)
        val year = createRefFor(yearId)
        val chart = createRefFor(chartId)
        val totalTitle = createRefFor(totalTitleId)
        val changeState = createRefFor(changeStateId)

        @Suppress("MagicNumber")
        keyAttributes(week, month, year, chart) {
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

        Text(
            text = "application-name",
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
            // TODO: fix
            iconSize = 24.dp,
            onClick = {
                isOpened.value = isOpened.value.not()
            },
        )

        YaaumCircleButton(
            icon = R.drawable.icon_fire_bold_24,
            modifier = Modifier
                .layoutId(weekId),
            defaultBackgroundColor = YaaumTheme.colors.primary,
            pressedBackgroundColor = YaaumTheme.colors.secondary,
            // TODO: fix
            iconSize = 24.dp,
            onClick = {
            },
        )

        YaaumCircleButton(
            icon = R.drawable.icon_fire_bold_24,
            modifier = Modifier
                .layoutId(monthId),
            defaultBackgroundColor = YaaumTheme.colors.primary,
            pressedBackgroundColor = YaaumTheme.colors.secondary,
            // TODO: fix
            iconSize = 24.dp,
            onClick = {
            },
        )
        YaaumCircleButton(
            icon = R.drawable.icon_fire_bold_24,
            modifier = Modifier
                .layoutId(yearId),
            defaultBackgroundColor = YaaumTheme.colors.primary,
            pressedBackgroundColor = YaaumTheme.colors.secondary,
            // TODO: fix
            iconSize = 24.dp,
            onClick = {
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DetailsHealthCard_Dark() {
    YaaumTheme(useDarkTheme = true) {
        DetailsHealthCard()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_DetailsHealthCard_Light() {
    YaaumTheme(useDarkTheme = false) {
        DetailsHealthCard()
    }
}
