package com.ur.urcap.coloredfolder.impl;

import com.ur.urcap.api.contribution.ProgramNodeContribution;
import com.ur.urcap.api.contribution.ProgramNodeService;
import com.ur.urcap.api.domain.URCapAPI;
import com.ur.urcap.api.domain.data.DataModel;

import java.io.InputStream;
import java.util.Locale;

public class ColoredFolderProgramNodeService implements ProgramNodeService {
	@Override
	public String getId() {
		return "ColoredFolder";
	}

	@Override
	public boolean isDeprecated() {
		return false;
	}

	@Override
	public boolean isChildrenAllowed() {
		return true;
	}

	@Override
	public String getTitle() {
		if (Locale.getDefault().getLanguage().equals("jp"))
			return "カラー付きフォルダ";
		else
			return "Colored Folder";

	}

	@Override
	public InputStream getHTML() {
		if (Locale.getDefault().getLanguage().equals("jp"))
			return this.getClass()
					.getResourceAsStream("/com/ur/urcap/coloredfolder/impl/ColoredFolderProgramNode_jp.html");
		else
			return this.getClass()
					.getResourceAsStream("/com/ur/urcap/coloredfolder/impl/ColoredFolderProgramNode_en.html");

	}

	@Override
	public ProgramNodeContribution createNode(URCapAPI api, DataModel model) {
		return new ColoredFolderProgramNodeContribution(api, model);
	}
}
