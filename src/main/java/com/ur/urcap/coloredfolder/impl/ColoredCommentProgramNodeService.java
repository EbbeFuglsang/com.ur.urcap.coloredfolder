package com.ur.urcap.coloredfolder.impl;

import com.ur.urcap.api.contribution.ProgramNodeContribution;
import com.ur.urcap.api.contribution.ProgramNodeService;
import com.ur.urcap.api.domain.URCapAPI;
import com.ur.urcap.api.domain.data.DataModel;

import java.io.InputStream;
import java.util.Locale;

public class ColoredCommentProgramNodeService implements ProgramNodeService {
	@Override
	public String getId() {
		return "ColoredComment";
	}

	@Override
	public boolean isDeprecated() {
		return false;
	}

	@Override
	public boolean isChildrenAllowed() {
		return false;
	}

	@Override
	public String getTitle() {
		if (Locale.getDefault().getLanguage().equals("jp"))
			return "カラー付きコメント";
		else
			return "Colored Comment";
	}

	@Override
	public InputStream getHTML() {
		if (Locale.getDefault().getLanguage().equals("jp"))
			return this.getClass()
					.getResourceAsStream("/com/ur/urcap/coloredfolder/impl/ColoredCommentProgramNode_jp.html");
		else
			return this.getClass()
					.getResourceAsStream("/com/ur/urcap/coloredfolder/impl/ColoredCommentProgramNode_en.html");

	}

	@Override
	public ProgramNodeContribution createNode(URCapAPI api, DataModel model) {
		return new ColoredCommentProgramNodeContribution(api, model);
	}
}
