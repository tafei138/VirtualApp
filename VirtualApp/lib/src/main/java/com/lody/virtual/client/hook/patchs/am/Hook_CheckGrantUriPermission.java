package com.lody.virtual.client.hook.patchs.am;

import java.lang.reflect.Method;

import com.lody.virtual.client.hook.base.Hook;
import com.lody.virtual.client.hook.utils.HookUtils;

/**
 * @author Lody
 *
 *
 *         原型： public int checkGrantUriPermission(int callingUid, String
 *         targetPkg, Uri uri, int modeFlags)
 */
/* package */ class Hook_CheckGrantUriPermission extends Hook {

	@Override
	public String getName() {
		return "checkGrantUriPermission";
	}

	@Override
	public Object onHook(Object who, Method method, Object... args) throws Throwable {
		HookUtils.replaceFirstAppPkg(args);
		return method.invoke(who, args);
	}

	@Override
	public boolean isEnable() {
		return isAppProcess();
	}
}
