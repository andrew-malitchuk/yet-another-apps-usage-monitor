package dev.yaaum.ui.theme

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.RectangleShape
import dev.yaaum.ui.theme.common.YaaumShape

val shapes = YaaumShape(
    default = RectangleShape,
    extraSmall = RoundedCornerShape(CornerSize(corners.extraSmall)),
    small = RoundedCornerShape(CornerSize(corners.small)),
    smallMedium = RoundedCornerShape(CornerSize(corners.smallMedium)),
    medium = RoundedCornerShape(CornerSize(corners.medium)),
    extraMedium = RoundedCornerShape(CornerSize(corners.extraMedium)),
    large = RoundedCornerShape(CornerSize(corners.large)),
    extraLarge = RoundedCornerShape(CornerSize(corners.extraLarge)),
    largest = RoundedCornerShape(CornerSize(corners.largest)),
)
