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
fun ApplicationDetalizationCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
) {
    val isFoo = remember {
        mutableStateOf(true)
    }

    val cardId = "card_id"
    val totalTitleId = "total_title_id"
    val packageNameId = "package_name_id"
    val applicationBoxId = "application_box_id"
    val changeStateId = "change_state_id"

    val paddingMedium = YaaumTheme.spacing.medium
    val paddingSmall = YaaumTheme.spacing.small

    @Suppress("MagicNumber")
    val progress by animateFloatAsState(
        targetValue = if (isFoo.value) 0f else 1f,
        label = "",
    )

    val constraintSetStart = ConstraintSet {
        val card = createRefFor(cardId)
        val totalTitle = createRefFor(totalTitleId)
        val applicationBox = createRefFor(applicationBoxId)
        val packageName = createRefFor(packageNameId)
        val changeState = createRefFor(changeStateId)

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
            top.linkTo(card.top, paddingMedium)
            end.linkTo(card.end, paddingSmall)
        }
    }

    val constraintSetEnd = ConstraintSet {
        val card = createRefFor(cardId)
        val totalTitle = createRefFor(totalTitleId)
        val applicationBox = createRefFor(applicationBoxId)
        val packageName = createRefFor(packageNameId)
        val changeState = createRefFor(changeStateId)

        constrain(card) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.matchParent
            height = Dimension.fillToConstraints
        }

        constrain(applicationBox) {
            top.linkTo(card.top, paddingSmall)
            start.linkTo(card.start, paddingSmall)
            bottom.linkTo(card.bottom, paddingSmall)
//            width =  Dimension.fillToConstraints
//            height =  Dimension.fillToConstraints
//            width = Dimension.value(64.dp)
//            height = Dimension.value(64.dp)
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
            top.linkTo(card.top, paddingMedium)
            end.linkTo(card.end, paddingSmall)
        }
    }

    val transition = Transition(
        from = "start",
        to = "end",
    ) {
        val card = createRefFor(cardId)
        val totalTitle = createRefFor(totalTitleId)
        val packageName = createRefFor(packageNameId)
        val changeState = createRefFor(changeStateId)

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

        Text(
            text = "application-name",
            style = YaaumTheme.typography.title,
            color = YaaumTheme.colors.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .layoutId(totalTitleId),
        )

        Text(
            // TODO: fix
            text = "package-name",
            style = YaaumTheme.typography.caption,
            color = YaaumTheme.colors.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .layoutId(packageNameId),
        )

        Box(
            modifier = Modifier
                .size(48.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(YaaumTheme.corners.medium))
                .background(YaaumTheme.colors.secondary)
                .layoutId(applicationBoxId),
        ) {
//            val icon = applicationsUiModel.packageName?.let { pn ->
//                LocalContext.current.packageManager.getApplicationIcon(pn)
//            }
            Image(
                painter = painterResource(id = R.drawable.icon_palette_regular_24),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
                    .padding(YaaumTheme.spacing.small),
            )
        }
        YaaumDefaultCircleButton(
            modifier = Modifier
                // TODO: fix
                .size(32.dp)
                .layoutId(changeStateId),
            icon = ImageVector.vectorResource(id = R.drawable.icon_caret_up_bold_24),
            onClick = {
                isFoo.value = isFoo.value.not()
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationDetalizationCard_Dark() {
    YaaumTheme(useDarkTheme = true) {
        ApplicationDetalizationCard()
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_ApplicationDetalizationCard_Light() {
    YaaumTheme(useDarkTheme = false) {
        ApplicationDetalizationCard()
    }
}
