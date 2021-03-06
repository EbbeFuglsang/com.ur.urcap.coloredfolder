package com.ur.urcap.coloredfolder.impl;

import com.ur.urcap.api.contribution.ProgramNodeContribution;
import com.ur.urcap.api.domain.URCapAPI;
import com.ur.urcap.api.domain.data.DataModel;
import com.ur.urcap.api.domain.script.ScriptWriter;
import com.ur.urcap.api.ui.annotation.Input;
import com.ur.urcap.api.ui.component.*;
import com.ur.urcap.api.ui.component.InputEvent.EventType;

import javax.swing.JColorChooser;
import java.awt.Color;

import static com.ur.urcap.api.ui.component.InputEvent.EventType.ON_PRESSED;

public class ColoredCommentProgramNodeContribution implements ProgramNodeContribution {

	private final DataModel model;

	private final String FORECOLOR_DEFAULT = "128,128,128";

	/* コンストラクタ */
	public ColoredCommentProgramNodeContribution(URCapAPI api, DataModel model) {
		this.model = model;

	}

	/*
	 * テキストボックスの定義
	 */
	@Input(id = "inputComment")
	private InputTextField inputComment;

	/*
	 * ボタンの定義
	 */

	@Input(id = "btnSelectForeColor")
	private InputButton btnSelectForeColor;
	/*
	 * ラジオボタンの定義
	 */
	@Input(id = "inputColor0")
	private InputRadioButton inputColor0;

	@Input(id = "inputColor1")
	private InputRadioButton inputColor1;

	@Input(id = "inputColor2")
	private InputRadioButton inputColor2;

	@Input(id = "inputColor3")
	private InputRadioButton inputColor3;

	@Input(id = "inputColor4")
	private InputRadioButton inputColor4;

	@Input(id = "inputColor5")
	private InputRadioButton inputColor5;

	@Input(id = "inputColor6")
	private InputRadioButton inputColor6;

	@Input(id = "inputColor7")
	private InputRadioButton inputColor7;

	/*
	 * イベントハンドラ
	 */
	@Input(id = "inputComment")
	private void onChange_inputComment(InputEvent event) {
		if (event.getEventType() == EventType.ON_CHANGE)
			if (!inputComment.getText().isEmpty()) {
				model.set("inputComment", inputComment.getText());
				this.getTitle();
			} else
				model.remove("inputComment");

	}

	@Input(id = "btnSelectForeColor")
	private void onClick_btnSelectForeColor(InputEvent event) {
		if (event.getEventType() == ON_PRESSED) {

			Color color = JColorChooser.showDialog(null, "",
					convertStringRGBToColor(model.get("btnSelectForeColor", FORECOLOR_DEFAULT)));

			if (color != null) {
				model.set("btnSelectForeColor", convertColorToStringRGB(color));

			}

		}
	}

	@Input(id = "inputColor0")
	private void onChange_inputColor0(InputEvent event) {
		if (event.getEventType() == EventType.ON_CHANGE)
			model.set("inputColor0", inputColor0.isSelected());
	}

	@Input(id = "inputColor1")
	private void onChange_inputColor1(InputEvent event) {
		if (event.getEventType() == EventType.ON_CHANGE)
			model.set("inputColor1", inputColor1.isSelected());
	}

	@Input(id = "inputColor2")
	private void onChange_inputColor2(InputEvent event) {
		if (event.getEventType() == EventType.ON_CHANGE)
			model.set("inputColor2", inputColor2.isSelected());
	}

	@Input(id = "inputColor3")
	private void onChange_inputColor3(InputEvent event) {
		if (event.getEventType() == EventType.ON_CHANGE)
			model.set("inputColor3", inputColor3.isSelected());
	}

	@Input(id = "inputColor4")
	private void onChange_inputColor4(InputEvent event) {
		if (event.getEventType() == EventType.ON_CHANGE)
			model.set("inputColor4", inputColor4.isSelected());
	}

	@Input(id = "inputColor5")
	private void onChange_inputColor5(InputEvent event) {
		if (event.getEventType() == EventType.ON_CHANGE)
			model.set("inputColor5", inputColor5.isSelected());
	}

	@Input(id = "inputColor6")
	private void onChange_inputColor6(InputEvent event) {
		if (event.getEventType() == EventType.ON_CHANGE)
			model.set("inputColor6", inputColor6.isSelected());
	}

	@Input(id = "inputColor7")
	private void onChange_inputColor7(InputEvent event) {
		if (event.getEventType() == EventType.ON_CHANGE)
			model.set("inputColor7", inputColor7.isSelected());
	}

	private Color convertStringRGBToColor(String modelString) {
		int color_r, color_g, color_b;

		color_r = Integer.valueOf(modelString.split(",")[0]);
		color_g = Integer.valueOf(modelString.split(",")[1]);
		color_b = Integer.valueOf(modelString.split(",")[2]);

		return new Color(color_r, color_g, color_b);

	}

	private String convertColorToStringRGB(Color color) {
		int color_r, color_g, color_b;

		color_r = color.getRed();
		color_g = color.getGreen();
		color_b = color.getBlue();

		return String.valueOf(color_r) + "," + String.valueOf(color_g) + "," + String.valueOf(color_b);
	}

	/* 設定画面を表示したときの処理 */
	@Override
	public void openView() {
		// ノード名称設定ボックス
		inputComment.setText(model.get("inputComment", "Comment"));

		// ラジオボタン
		if (model.get("inputColor0", false))
			inputColor0.setSelected();
		if (model.get("inputColor1", false))
			inputColor1.setSelected();
		if (model.get("inputColor2", false))
			inputColor2.setSelected();
		if (model.get("inputColor3", false))
			inputColor3.setSelected();
		if (model.get("inputColor4", false))
			inputColor4.setSelected();
		if (model.get("inputColor5", false))
			inputColor5.setSelected();
		if (model.get("inputColor6", false))
			inputColor6.setSelected();
		if (model.get("inputColor7", true))
			inputColor7.setSelected();

	}

	@Override
	public void closeView() {

	}

	@Override
	public String getTitle() {
		Color color;

		// 青 blue
		if (model.get("inputColor0", false)) {
			color = new Color(0, 0, 255);
		}
		// 緑 green
		else if (model.get("inputColor1", false)) {
			color = new Color(0, 153, 51);
		}
		// 赤 red
		else if (model.get("inputColor2", false)) {
			color = new Color(255, 0, 0);
		}
		// ピンク pink
		else if (model.get("inputColor3", false)) {
			color = new Color(255, 0, 255);
		}
		// 茶 brown
		else if (model.get("inputColor4", false)) {
			color = new Color(153, 153, 0);
		}
		// 紫 purple
		else if (model.get("inputColor5", false)) {
			color = new Color(204, 0, 204);
		}
		// 紺 dark blue
		else if (model.get("inputColor6", false)) {
			color = new Color(0, 0, 51);
		}
		// カスタムの場合 custom color
		else {
			color = convertStringRGBToColor(model.get("btnSelectForeColor", FORECOLOR_DEFAULT));
		}

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("#");

		String r = Integer.toHexString(color.getRed());
		String g = Integer.toHexString(color.getGreen());
		String b = Integer.toHexString(color.getBlue());

		stringBuilder.append(r.length() == 1 ? "0" + r : r);
		stringBuilder.append(g.length() == 1 ? "0" + g : g);
		stringBuilder.append(b.length() == 1 ? "0" + b : b);

		String htmlStart = "<html><span style='color:" + stringBuilder.toString() + ";'>'";
		String htmlEnd = "'</span></html>";

		return htmlStart + model.get("inputComment", "Comment") + htmlEnd;

	}

	@Override
	public boolean isDefined() {
		return true;
	}

	@Override
	public void generateScript(ScriptWriter writer) {
	}

}