package dev.yaaum.presentation.core.ui.composable.loader

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.lerp
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

/**
 * Simple loader
 */
@Suppress("MagicNumber")
@Composable
fun YaaumLoader(
    modifier: Modifier = Modifier,
) {
    val transition = rememberInfiniteTransition(label = "")

    val particleOffsetFraction by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 500
                0F atFraction 0.11F with EaseInOut
                1F atFraction 1F
            },
        ),
        label = "",
    )

    val particleColor by transition.animateColor(
        initialValue = YaaumTheme.colors.primary,
        targetValue = YaaumTheme.colors.primary,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 500
            },
        ),
        label = "",
    )

    Canvas(modifier = modifier.size(64.dp)) {
        val particleOffsets = listOf(
            Offset(0F, size.height / 2),
            Offset(size.width / 2, size.height / 2),
            Offset(size.width, size.height / 2),
        )

        val minParticleRadius = (1 / 8F * size.minDimension) / 2
        val maxParticleRadius = 3 * minParticleRadius
        val particleRadii = listOf(minParticleRadius, maxParticleRadius, minParticleRadius)

        particleOffsets.forEachIndexed { index, offset ->
            drawCircle(
                color = particleColor,
                radius = lerp(
                    min = particleRadii[index],
                    max = particleRadii[(index + 1) % 3],
                    fraction = particleOffsetFraction,
                ),
                center = lerp(
                    start = offset,
                    stop = particleOffsets[(index + 1) % 3],
                    fraction = particleOffsetFraction,
                ),
            )
        }
    }
}

// TODO: move me
internal fun lerp(min: Float, max: Float, fraction: Float) = min + (max - min) * fraction
