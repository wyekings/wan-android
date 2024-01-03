package com.wyekings.doreamon

/**
 *  @author wye on 6/13/23
 */

enum class DoraemonBuildType(val applicationIdSuffix: String? = null) {
    DEBUG(".debug"),
    RELEASE,
}