package dev.yaaum.presentation.core.ui.composable.card

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import androidx.constraintlayout.compose.Transition
import androidx.constraintlayout.compose.layoutId
import dev.yaaum.common.core.ext.asHours
import dev.yaaum.presentation.core.localisation.UiText
import dev.yaaum.presentation.core.models.GeneralTimeUsageStatisticUiModel
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.button.circle.YaaumCircleButton
import dev.yaaum.presentation.core.ui.composable.button.ordinary.YaaumOrdinaryButton
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

/**
 * Detalization for screen usage
 */
@Composable
@Suppress("LongMethod", "UNUSED_VARIABLE")
fun ProgressHealthCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    onBackClick: (() -> Unit)? = null,
    isOpened: Boolean,
    health: GeneralTimeUsageStatisticUiModel?,
    rate: String?,
) {
    val backId = "back_id"
    val cardId = "card_id"
    val totalTitleId = "total_title_id"
    val totalValueId = "total_value_id"
    val selectedTitleId = "selected_title_id"
    val selectedValueId = "selected_value_id"
    val deltaTitleId = "delta_title_id"
    val deltaValueId = "delta_value_id"
    val totalIconId = "total_icon_id"
    val selectedIconId = "selected_icon_id"
    val deltaIconId = "delta_icon_id"
    val actionIconId = "action_icon_id"

    val statusId = "status_id"
    val statusDescriptionId = "status_description_id"

    val paddingMedium = YaaumTheme.spacing.medium
    val paddingSmall = YaaumTheme.spacing.small

    @Suppress("MagicNumber")
    val progress by animateFloatAsState(
        targetValue = if (isOpened) 0f else 1f,
        label = "",
    )

    val constraintSetStart = ConstraintSet {
        val back = createRefFor(backId)
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
        val action = createRefFor(actionIconId)

        val status = createRefFor(statusId)
        val statusDescription = createRefFor(statusDescriptionId)

        constrain(back) {
            top.linkTo(parent.top, paddingSmall)
            start.linkTo(parent.start)
        }

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
            bottom.linkTo(card.bottom, paddingMedium)
        }

        constrain(status) {
            top.linkTo(card.top, paddingSmall)
            end.linkTo(card.end, paddingSmall)
        }

        constrain(statusDescription) {
            top.linkTo(status.bottom, paddingSmall)
            end.linkTo(card.end, paddingSmall)
        }
    }

    val constraintSetEnd = ConstraintSet {
        val back = createRefFor(backId)
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
        val action = createRefFor(actionIconId)

        val status = createRefFor(statusId)
        val statusDescription = createRefFor(statusDescriptionId)

        constrain(back) {
            top.linkTo(parent.top, paddingSmall)
            start.linkTo(parent.start)
        }

        constrain(action) {
            top.linkTo(parent.top, paddingSmall)
            end.linkTo(parent.end)
        }

        constrain(card) {
            top.linkTo(action.top)
            bottom.linkTo(action.bottom)
            start.linkTo(back.end, paddingMedium)
            end.linkTo(parent.end)
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

        constrain(status) {
            top.linkTo(card.top, paddingSmall)
            end.linkTo(card.end, paddingSmall)
        }

        constrain(statusDescription) {
//            top.linkTo(status.bottom, paddingSmall)
//            end.linkTo(card.end, paddingSmall)
            top.linkTo(parent.top, paddingSmall)
            end.linkTo(parent.end)
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
        val actionIcon = createRefFor(actionIconId)

        val status = createRefFor(statusId)
        val statusDescription = createRefFor(statusDescriptionId)

        @Suppress("MagicNumber")
        keyAttributes(
            totalIcon,
            totalTitle,
            totalValue,
            selectedIcon,
            selectedTitle,
            selectedValue,
            deltaTitle,
            status,
            statusDescription,
        ) {
            frame(25) {
                alpha = 0f
            }
            frame(100) {
                alpha = 0f
            }
        }
        @Suppress("MagicNumber")
        keyAttributes(actionIcon) {
            frame(0) {
                alpha = 1f
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

        YaaumOrdinaryButton(
            icon = R.drawable.icon_caret_left_bold_24,
            modifier = Modifier
                .layoutId(backId),
            defaultBackgroundColor = YaaumTheme.colors.secondary,
            pressedBackgroundColor = YaaumTheme.colors.primary,
            iconSize = YaaumTheme.icons.smallMedium,
            onClick = {
                onBackClick?.invoke()
            },
        )

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
            text = health?.totalAppsUsage?.asHours() ?: "NI",
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
            text = health?.totalChosenAppsUsage?.asHours() ?: "NI",
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
            text = (
                (health?.totalAppsUsage ?: 0L) - (
                    health?.totalChosenAppsUsage
                        ?: 0L
                    )
                ).asHours(),
            style = YaaumTheme.typography.title,
            color = YaaumTheme.colors.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .layoutId(deltaValueId),
        )
        Icon(
            painter = painterResource(id = R.drawable.icon_sigma_bold_24),
            contentDescription = null,
            tint = YaaumTheme.colors.onSecondary,
            modifier = Modifier
                .size(YaaumTheme.icons.small)
                .clip(CircleShape)
                .background(YaaumTheme.colors.secondary)
                .padding(YaaumTheme.spacing.extraSmall)
                .layoutId(totalIconId),
        )
        Icon(
            painter = painterResource(id = R.drawable.icon_bookmarks_bold_24),
            contentDescription = null,
            tint = YaaumTheme.colors.onSecondary,
            modifier = Modifier
                .size(YaaumTheme.icons.small)
                .clip(CircleShape)
                .background(YaaumTheme.colors.secondary)
                .padding(YaaumTheme.spacing.extraSmall)
                .layoutId(selectedIconId),
        )
        Icon(
            painter = painterResource(id = R.drawable.icon_percent_bold_24),
            contentDescription = null,
            tint = YaaumTheme.colors.onSecondary,
            modifier = Modifier
                .size(YaaumTheme.icons.small)
                .clip(CircleShape)
                .background(YaaumTheme.colors.secondary)
                .padding(YaaumTheme.spacing.extraSmall)
                .layoutId(deltaIconId),
        )
        YaaumCircleButton(
            icon = R.drawable.icon_plus_bold_24,
            modifier = Modifier
                .layoutId(actionIconId),
            defaultBackgroundColor = YaaumTheme.colors.primary,
            pressedBackgroundColor = YaaumTheme.colors.secondary,
            iconSize = YaaumTheme.icons.smallMedium,
            onClick = {
                onClick?.invoke()
            },
        )

        Text(
            text = UiText.StringResource(dev.yaaum.presentation.core.localisation.R.string.health_rate)
                .asString(LocalContext.current),
            style = YaaumTheme.typography.subHeading,
            color = YaaumTheme.colors.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .layoutId(statusId),
        )

        Text(
            text = rate ?: "NI",
            style = YaaumTheme.typography.display,
            color = YaaumTheme.colors.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .layoutId(statusDescriptionId),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ProgressHealthCard_Dark() {
    YaaumTheme(useDarkTheme = true) {
        @Suppress("MagicNumber")
        ProgressHealthCard(
            isOpened = false,
            health = GeneralTimeUsageStatisticUiModel(10L, 20L, 30L),
            rate = "A",
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ProgressHealthCard_Light() {
    YaaumTheme(useDarkTheme = false) {
        @Suppress("MagicNumber")
        ProgressHealthCard(
            isOpened = false,
            health = GeneralTimeUsageStatisticUiModel(10L, 20L, 30L),
            rate = "A",
        )
    }
}
