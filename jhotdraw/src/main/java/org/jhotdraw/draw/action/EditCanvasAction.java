/*
 * @(#)EditCanvasAction.java
 *
 * Copyright (c) 2007 The authors and contributors of JHotDraw.
 * You may not use, copy or modify this file, except in compliance with the 
 * accompanying license terms.
 */

package org.jhotdraw.draw.action;

import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.util.prefs.Preferences;
import javax.swing.*;
import org.jhotdraw.app.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.util.*;
import org.jhotdraw.util.prefs.PreferencesUtil;

/**
 * EditCanvasAction.
 * <p>
 * XXX - We shouldn't have a dependency to the application framework
 * from within the drawing framework.
 *
 * @author Werner Randelshofer
 * @version $Id: EditCanvasAction.java 788 2014-03-22 07:56:28Z rawcoder $
 */
public class EditCanvasAction extends AbstractDrawingViewAction {
    private static final long serialVersionUID = 1L;
    public static final String ID = "view.editCanvas";
    private JFrame frame;
    private EditCanvasPanel settingsPanel;
    private PropertyChangeListener propertyChangeHandler;
    private Application app;
    
    /** Creates a new instance. */
    public EditCanvasAction(Application app, DrawingEditor editor) {
        super(editor);
        this.app = app;
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        labels.configureAction(this, ID);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        getFrame().setVisible(true);
    }
    
   @Override protected void updateViewState() {
        if (getView() != null && settingsPanel != null) {
            settingsPanel.setDrawing(getView().getDrawing());
        }
    }
    
    protected Application getApplication() {
        return app;
    }
    
    protected JFrame getFrame() {
        if (frame == null) {
            ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
            frame = new JFrame();
            frame.setTitle(labels.getString("window.editCanvas.title"));
            frame.setResizable(false);
            settingsPanel = new EditCanvasPanel();
            frame.add(settingsPanel);
            frame.pack();
            Preferences prefs = PreferencesUtil.userNodeForPackage(getClass());
            PreferencesUtil.installFramePrefsHandler(prefs, "canvasSettings", frame);
            getApplication().addWindow(frame, null);
        }
            settingsPanel.setDrawing(getView().getDrawing());
        return frame;
    }
}