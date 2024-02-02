package dev.yaaum.presentation.core.ui.composable.card

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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import androidx.constraintlayout.compose.Transition
import androidx.constraintlayout.compose.layoutId
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import dev.yaaum.presentation.core.models.ApplicationsUiModel
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.composable.button.circle.YaaumCircleButton
import dev.yaaum.presentation.core.ui.composable.button.ordinary.YaaumOrdinaryButton
import dev.yaaum.presentation.core.ui.theme.YaaumTheme
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import io.github.serpro69.kfaker.Faker

/**
 * Contains general information about application
 */
@Composable
@Suppress("LongMethod", "UnusedParameter", "UNUSED_VARIABLE")
fun ApplicationDetalizationCard(
    modifier: Modifier = Modifier,
    applicationsUiModel: ApplicationsUiModel,
    onBackClick: (() -> Unit)? = null,
) {
    val isOpened = remember {
        mutableStateOf(true)
    }

    val backId = "back_id"
    val cardId = "card_id"
    val totalTitleId = "total_title_id"
    val packageNameId = "package_name_id"
    val applicationBoxId = "application_box_id"
    val changeStateId = "change_state_id"

    val paddingMedium = YaaumTheme.spacing.medium
    val paddingSmall = YaaumTheme.spacing.small

    @Suppress("MagicNumber")
    val progress by animateFloatAsState(
        targetValue = if (isOpened.value) 0f else 1f,
        label = "",
    )

    val constraintSetStart = ConstraintSet {
        val back = createRefFor(backId)
        val card = createRefFor(cardId)
        val totalTitle = createRefFor(totalTitleId)
        val applicationBox = createRefFor(applicationBoxId)
        val packageName = createRefFor(packageNameId)
        val changeState = createRefFor(changeStateId)

        constrain(back) {
            top.linkTo(parent.top, paddingSmall)
            start.linkTo(parent.start, paddingSmall)
        }

        constrain(card) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.matchParent
            height = Dimension.fillToConstraints
        }

        @Suppress("MagicNumber")
        constrain(applicationBox) {
            top.linkTo(card.top, paddingMedium)
            start.linkTo(card.start, paddingSmall)
            end.linkTo(card.end, paddingSmall)
            width = Dimension.percent(0.5f)
            height = Dimension.ratio("1:1")
        }

        constrain(totalTitle) {
            top.linkTo(applicationBox.bottom, paddingSmall)
            start.linkTo(card.start, paddingSmall)
            end.linkTo(card.end, paddingSmall)
            width = Dimension.wrapContent
        }

        constrain(packageName) {
            top.linkTo(totalTitle.bottom, paddingSmall)
            start.linkTo(card.start, paddingSmall)
            end.linkTo(card.end, paddingSmall)
            bottom.linkTo(card.bottom, paddingSmall)
            width = Dimension.wrapContent
        }

        constrain(changeState) {
            top.linkTo(card.top, paddingSmall)
            end.linkTo(card.end, paddingSmall)
        }
    }

    val constraintSetEnd = ConstraintSet {
        val back = createRefFor(backId)
        val card = createRefFor(cardId)
        val totalTitle = createRefFor(totalTitleId)
        val applicationBox = createRefFor(applicationBoxId)
        val packageName = createRefFor(packageNameId)
        val changeState = createRefFor(changeStateId)

        constrain(back) {
            top.linkTo(parent.top, paddingSmall)
            start.linkTo(parent.start)
        }

        constrain(card) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(back.end, paddingSmall)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        }

        constrain(applicationBox) {
            top.linkTo(card.top, paddingSmall)
            start.linkTo(card.start, paddingSmall)
            bottom.linkTo(card.bottom, paddingSmall)
        }

        constrain(totalTitle) {
            top.linkTo(card.top)
            bottom.linkTo(card.bottom)
            start.linkTo(applicationBox.end, paddingSmall)
            end.linkTo(card.end, paddingSmall)
            width = Dimension.fillToConstraints
        }

        constrain(packageName) {
            top.linkTo(totalTitle.bottom, paddingSmall)
            start.linkTo(card.start, paddingSmall)
            end.linkTo(card.end, paddingSmall)
            bottom.linkTo(card.bottom, paddingSmall)
            width = Dimension.value(0.dp)
            height = Dimension.value(0.dp)
        }

        constrain(changeState) {
            top.linkTo(card.top)
            bottom.linkTo(card.bottom)
            end.linkTo(card.end, paddingSmall)
        }
    }

    val transition = Transition(
        from = "start",
        to = "end",
    ) {
        val back = createRefFor(backId)
        val card = createRefFor(cardId)
        val totalTitle = createRefFor(totalTitleId)
        val packageName = createRefFor(packageNameId)
        val changeState = createRefFor(changeStateId)

        @Suppress("MagicNumber")
        keyAttributes(back) {
            frame(0) {
                alpha = 1f
            }
            frame(50) {
                alpha = 0f
            }
            frame(100) {
                alpha = 1f
            }
        }
        @Suppress("MagicNumber")
        keyAttributes(packageName) {
            frame(25) {
                alpha = 0f
            }
            frame(100) {
                alpha = 0f
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
            text = applicationsUiModel.applicationName ?: "SWW",
            style = YaaumTheme.typography.title,
            color = YaaumTheme.colors.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .layoutId(totalTitleId),
        )

        Text(
            text = applicationsUiModel.packageName ?: "SWW",
            style = YaaumTheme.typography.caption,
            color = YaaumTheme.colors.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .layoutId(packageNameId),
        )

        Box(
            modifier = Modifier
                .size(YaaumTheme.icons.medium)
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(YaaumTheme.corners.medium))
                .background(YaaumTheme.colors.secondary)
                .layoutId(applicationBoxId),
        ) {
            val icon = applicationsUiModel.packageName?.let { pn ->
                LocalContext.current.packageManager.getApplicationIcon(pn)
            }
            Image(
                painter = rememberDrawablePainter(icon),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
                    .padding(YaaumTheme.spacing.small),
            )
        }
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
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationDetalizationCard_Dark() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = true) {
        ApplicationDetalizationCard(
            applicationsUiModel = ApplicationsUiModel(
                uuid = null,
                packageName = faker.quote.fortuneCookie(),
                applicationName = faker.quote.fortuneCookie(),
                isChosen = false,
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationDetalizationCard_Light() {
    val faker = Faker()
    YaaumTheme(useDarkTheme = false) {
        ApplicationDetalizationCard(
            applicationsUiModel = ApplicationsUiModel(
                uuid = null,
                packageName = faker.quote.fortuneCookie(),
                applicationName = faker.quote.fortuneCookie(),
                isChosen = false,
            ),
        )
    }
}
