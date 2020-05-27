package com.ur.urcap.coloredfolder.impl;

import com.ur.urcap.api.contribution.ProgramNodeService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
	@Override
	public void start(BundleContext context) throws Exception {

		context.registerService(ProgramNodeService.class, new ColoredCommentProgramNodeService(), null);
		context.registerService(ProgramNodeService.class, new ColoredFolderProgramNodeService(), null);

	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
	}
}
