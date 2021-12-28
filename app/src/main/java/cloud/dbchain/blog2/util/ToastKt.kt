package cloud.dbchain.blog2.util

import cloud.dbchain.blog2.R
import dingshaoshuai.function.toast

/**
 * @author: Xiao Bo
 * @date: 30/8/2021
 */
fun toastSuccess() {
    toast(R.string.operation_successful)
}

fun toastFailure() {
    toast(R.string.operation_failed)
}