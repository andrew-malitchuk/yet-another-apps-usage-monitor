package dev.yaaum.presentation.core.platform.mvi

import dev.yaaum.common.core.error.base.BaseError

// /**
// * Cover almost all states for screen on MVI
// */
// abstract class State {
//    /**
//     * Content fetched and ready to be shown
//     *
//     * @param content
//     */
//    abstract class Fetched<T>(open val content: T) : State()
//    abstract class Loading() : State()
//
//    /**
//     * Represent state when [error] happened
//     */
//    @Suppress("MemberVisibilityCanBePrivate")
//    abstract class Error(
//        val error: BaseError
//    ) : State()
//
//    /**
//     * Nothing to show
//     */
//    abstract class Empty() : State()
// }

interface State

abstract class Fetched<T>(open val content: T) : State
open class Loading : State

/**
 * Represent state when [error] happened
 */
@Suppress("MemberVisibilityCanBePrivate")
open class Error(
    val error: BaseError,
) : State

/**
 * Nothing to show
 */
open class Empty : State
