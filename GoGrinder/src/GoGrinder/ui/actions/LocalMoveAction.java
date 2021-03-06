/*
* GoGrinder - a program to practice Go problems
* Copyright (c) 2004-2006 Tim Kington
* timkington@users.sourceforge.net
*
* This program is free software; you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation; either version 2 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*
*/

package GoGrinder.ui.actions;

import java.awt.event.ActionEvent;

import GoGrinder.Main;
import GoGrinder.Messages;
import GoGrinder.WGFController;
import GoGrinder.ui.WGFFrame;

/**
 * @author tkington
 */
public class LocalMoveAction extends WGFAction {
	public LocalMoveAction(WGFFrame frame, WGFController controller) {
		super(frame, controller);
		putValue(NAME, Messages.getString("LocalMoveAction.AddRemoveLocalMoves")); //$NON-NLS-1$
		putValue(SHORT_DESCRIPTION, Messages.getString("LocalMoveAction.AddRemoveLocalMoves")); //$NON-NLS-1$
		//putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		putValue(SMALL_ICON, Main.getIcon("LocalStone.png", frame)); //$NON-NLS-1$
	}
	
	public void actionPerformed(ActionEvent evt) {
		controller.setEditTool(WGFController.TOOL_LOCALMOVE);
	}
}
