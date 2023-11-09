package dev.yaaum.presentation.core.ui.composable.card

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
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
import dev.yaaum.presentation.core.ui.composable.button.circle.YaaumDefaultCircleButton
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

@Composable
@Suppress("LongMethod", "UnusedParameter", "UNUSED_VARIABLE")
fun ProgressHealthCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    isFoo: Boolean,
) {
    val cardId = "card_id"
    val totalTitleId = "total_title_id"
    val totalValueId = "total_value_id"
    val selectedTitleId = "selected_title_id"
    val selectedValueId = "selected_value_id"
    val deltaTitleId = "delta_title_id"
    val deltaValueId = "delta_value_id"
    val chartId = "chart_id"
    val totalIconId = "total_icon_id"
    val selectedIconId = "selected_icon_id"
    val deltaIconId = "delta_icon_id"
    val actionIconId = "action_icon_id"

    val paddingMedium = YaaumTheme.spacing.medium
    val paddingSmall = YaaumTheme.spacing.small

    @Suppress("MagicNumber")
    val progress by animateFloatAsState(
        targetValue = if (isFoo) 0f else 1f,
//        tween(500),
        label = "",
    )

    val constraintSetStart = ConstraintSet {
        val card = createRefFor(cardId)
        val totalTitle = createRefFor(totalTitleId)
        val totalValue = createRefFor(totalValueId)
        val totalIcon = createRefFor(totalIconId)
        val selectedTitle = createRefFor(selectedTitleId)
        val selectedValue = createRefFor(selectedValueId)
        val selectedIcon = createRefFor(selectedIconId)
        val deltaTitle = createRefFor(deltaTitleId)
        val deltaValue = createRefFor(deltaValueId)
        val deltaIcon = createRefFor(deltaIconId)
        val chart = createRefFor(chartId)
        val action = createRefFor(actionIconId)

        constrain(action) {
            top.linkTo(parent.top, paddingSmall)
            end.linkTo(parent.end)
        }

        constrain(card) {
            top.linkTo(action.bottom, paddingMedium)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.matchParent
            height = Dimension.fillToConstraints
        }

        constrain(totalIcon) {
            top.linkTo(card.top, paddingSmall)
            start.linkTo(card.start, paddingMedium)
        }
        constrain(totalTitle) {
            top.linkTo(totalIcon.top, paddingMedium)
            bottom.linkTo(totalIcon.bottom, paddingMedium)
            start.linkTo(totalIcon.end, paddingSmall)
        }
        constrain(totalValue) {
            top.linkTo(totalTitle.bottom, paddingSmall)
            start.linkTo(card.start, paddingMedium)
        }

        constrain(selectedIcon) {
            top.linkTo(totalValue.bottom, paddingSmall)
            start.linkTo(card.start, paddingMedium)
        }
        constrain(selectedTitle) {
            top.linkTo(selectedIcon.top, paddingMedium)
            bottom.linkTo(selectedIcon.bottom, paddingMedium)
            start.linkTo(selectedIcon.end, paddingSmall)
        }
        constrain(selectedValue) {
            top.linkTo(selectedTitle.bottom, paddingSmall)
            start.linkTo(card.start, paddingMedium)
        }

        constrain(deltaIcon) {
            top.linkTo(selectedValue.bottom, paddingSmall)
            start.linkTo(card.start, paddingMedium)
        }
        constrain(deltaTitle) {
            top.linkTo(deltaIcon.top, paddingMedium)
            bottom.linkTo(deltaIcon.bottom, paddingMedium)
            start.linkTo(deltaIcon.end, paddingSmall)
        }
        constrain(deltaValue) {
            top.linkTo(deltaTitle.bottom, paddingSmall)
            start.linkTo(card.start, paddingMedium)
        }

        constrain(chart) {
            top.linkTo(card.top, paddingMedium)
            end.linkTo(card.end, paddingMedium)
            bottom.linkTo(card.bottom, paddingMedium)
            start.linkTo(selectedValue.end, paddingMedium)
            width = Dimension.ratio("1:1")
            height = Dimension.fillToConstraints
        }
    }

    val constraintSetEnd = ConstraintSet {
        val card = createRefFor(cardId)
        val totalTitle = createRefFor(totalTitleId)
        val totalValue = createRefFor(totalValueId)
        val totalIcon = createRefFor(totalIconId)
        val selectedTitle = createRefFor(selectedTitleId)
        val selectedValue = createRefFor(selectedValueId)
        val selectedIcon = createRefFor(selectedIconId)
        val deltaTitle = createRefFor(deltaTitleId)
        val deltaValue = createRefFor(deltaValueId)
        val deltaIcon = createRefFor(deltaIconId)
        val chart = createRefFor(chartId)
        val action = createRefFor(actionIconId)

        constrain(action) {
            top.linkTo(parent.top, paddingSmall)
            end.linkTo(parent.end)
        }

        constrain(card) {
            top.linkTo(action.top)
            bottom.linkTo(action.bottom)
            start.linkTo(parent.start)
            end.linkTo(action.start, paddingMedium)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        }

        constrain(totalTitle) {
            top.linkTo(card.top, paddingMedium)
            start.linkTo(card.start, paddingMedium)
        }
        constrain(totalValue) {
            top.linkTo(card.top, paddingMedium)
            start.linkTo(card.start, paddingMedium)
            bottom.linkTo(card.bottom, paddingMedium)
        }

        constrain(selectedIcon) {
            top.linkTo(card.top, paddingMedium)
            start.linkTo(card.start, paddingMedium)
            bottom.linkTo(card.bottom, paddingMedium)
        }
        constrain(selectedTitle) {
            top.linkTo(card.top, paddingMedium)
            start.linkTo(totalTitle.end, paddingMedium)
        }
        constrain(selectedValue) {
            top.linkTo(selectedIcon.top, paddingMedium)
            start.linkTo(selectedIcon.end, paddingSmall)
            bottom.linkTo(selectedIcon.bottom, paddingMedium)
        }

        constrain(deltaIcon) {
            top.linkTo(card.top, paddingMedium)
            start.linkTo(card.start, paddingMedium)
            bottom.linkTo(card.bottom, paddingMedium)
        }
        constrain(deltaTitle) {
            top.linkTo(card.top, paddingMedium)
            start.linkTo(selectedTitle.end, paddingMedium)
        }
        constrain(deltaValue) {
            top.linkTo(deltaIcon.top, paddingMedium)
            start.linkTo(deltaIcon.end, paddingSmall)
            end.linkTo(card.end, paddingSmall)
            bottom.linkTo(deltaIcon.bottom, paddingMedium)
            width = Dimension.fillToConstraints
        }

        constrain(chart) {
            top.linkTo(card.top, paddingMedium)
            end.linkTo(card.end, paddingMedium)
            bottom.linkTo(card.bottom, paddingMedium)
            start.linkTo(selectedValue.end, paddingMedium)
            width = Dimension.value(0.dp)
            height = Dimension.value(0.dp)
        }
    }

    val transition = Transition(
        from = "start",
        to = "end",
    ) {
        val card = createRefFor(cardId)
        val totalTitle = createRefFor(totalTitleId)
        val totalValue = createRefFor(totalValueId)
        val totalIcon = createRefFor(totalIconId)
        val selectedTitle = createRefFor(selectedTitleId)
        val selectedValue = createRefFor(selectedValueId)
        val selectedIcon = createRefFor(selectedIconId)
        val deltaTitle = createRefFor(deltaTitleId)
        val deltaValue = createRefFor(deltaValueId)
        val deltaIcon = createRefFor(deltaIconId)
        val chart = createRefFor(chartId)

        @Suppress("MagicNumber")
        keyAttributes(
            totalIcon,
            totalTitle,
            totalValue,
            selectedIcon,
            selectedTitle,
            selectedValue,
            deltaTitle,
            chart,
        ) {
            frame(25) {
                alpha = 0f
            }
            frame(100) {
                alpha = 0f
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
        ) {
        }

        Text(
            text = "Total",
            style = YaaumTheme.typography.caption,
            color = YaaumTheme.colors.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .layoutId(totalTitleId),
        )
        Text(
            text = "12h 30m 56s",
            style = YaaumTheme.typography.title,
            color = YaaumTheme.colors.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .layoutId(totalValueId),
        )

        Text(
            text = "Selected",
            style = YaaumTheme.typography.caption,
            color = YaaumTheme.colors.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .layoutId(selectedTitleId),
        )

        Text(
            text = "12h 30m 56s",
            style = YaaumTheme.typography.title,
            color = YaaumTheme.colors.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .layoutId(selectedValueId),
        )

        Text(
            text = "Delta",
            style = YaaumTheme.typography.caption,
            color = YaaumTheme.colors.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .layoutId(deltaTitleId),
        )

        Text(
            text = "12h 30m 56s",
            style = YaaumTheme.typography.title,
            color = YaaumTheme.colors.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .layoutId(deltaValueId),
        )

        Box(
            modifier = Modifier
                .background(YaaumTheme.colors.background)
                .layoutId(chartId),
        )

        // TODO: fix
        Icon(
            painter = painterResource(id = R.drawable.icon_sigma_bold_24),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .layoutId(totalIconId),
        )
        // TODO: fix
        Icon(
            painter = painterResource(id = R.drawable.icon_bookmarks_bold_24),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .layoutId(selectedIconId),
        )
        // TODO: fix
        Icon(
            painter = painterResource(id = R.drawable.icon_percent_bold_24),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .layoutId(deltaIconId),
        )

        YaaumDefaultCircleButton(
            modifier = Modifier
                .layoutId(actionIconId),
            icon = ImageVector.vectorResource(R.drawable.icon_fire_bold_24),
            onClick = {
                onClick?.invoke()
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ProgressHealthCard_Dark() {
    YaaumTheme(useDarkTheme = true) {
        ProgressHealthCard(isFoo = true)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ProgressHealthCard_Light() {
    YaaumTheme(useDarkTheme = false) {
        ProgressHealthCard(isFoo = false)
    }
}
