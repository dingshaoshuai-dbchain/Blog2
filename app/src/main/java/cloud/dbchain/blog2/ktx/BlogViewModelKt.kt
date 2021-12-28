package cloud.dbchain.blog2.ktx

import cloud.dbchain.blog2.R
import cloud.dbchain.network.Code
import cloud.dbchain.network.bean.BaseResponse
import dingshaoshuai.base.ktx.launchLoading
import dingshaoshuai.base.mvvm.BaseViewModel
import dingshaoshuai.baseext.ktx.launchPageSwitch
import dingshaoshuai.baseext.mvvm.BasePageViewModel
import dingshaoshuai.function.toast

/**
 * @author: Xiao Bo
 * @date: 30/8/2021
 */
inline fun <T> BaseViewModel.launchApp(
    crossinline blockIO: suspend () -> BaseResponse<T>?,
    crossinline checkBlock: (BaseResponse<T>?) -> Boolean = {
        Code.isSuccess(it)
    },
    crossinline successBlock: suspend (BaseResponse<T>?) -> Unit,
    crossinline failureBlock: (BaseResponse<T>?) -> Unit = {
        // 拦截器里已经提示过了非网络异常的情况，所以 == null（网络异常的情况），需要在这里提示
        if (it == null) {
            toast(R.string.network_error)
        }
    },
    displayLoadingDialog: Boolean = true,
    crossinline completeBlock: (BaseResponse<T>?) -> Unit = {}
) {
    launchLoading(
        blockIO = blockIO,
        checkBlock = checkBlock,
        successBlock = successBlock,
        failureBlock = failureBlock,
        displayLoadingDialog = displayLoadingDialog,
        completeBlock = completeBlock
    )
}

inline fun <T> BasePageViewModel.launchAppPageSwitch(
    crossinline blockIO: suspend () -> T?,
    crossinline checkErrorBlock: (T?) -> Boolean = {
        it == null
    },
    crossinline checkEmptyBlock: (T?) -> Boolean,
    crossinline successBlock: suspend (T?) -> Unit,
    crossinline failureBlock: (T?) -> Unit = {},
    crossinline completeBlock: (T?) -> Unit = {}
) {
    launchPageSwitch(
        blockIO = blockIO,
        checkErrorBlock = checkErrorBlock,
        checkEmptyBlock = checkEmptyBlock,
        successBlock = successBlock,
        failureBlock = failureBlock,
        completeBlock = completeBlock
    )
}
