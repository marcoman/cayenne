/*****************************************************************
 *   Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 ****************************************************************/
package org.apache.cayenne.swing.components.tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

/**
 * @since 5.0
 */
public class CheckBoxTreeCellRenderer extends JCheckBox implements TreeCellRenderer {

    private static final String TREE_SELECTION_BACKGROUND = "Tree.selectionBackground";
    private static final String TREE_BACKGROUND = "Tree.background";

    protected final TreeCellRenderer defaultRenderer;

    public CheckBoxTreeCellRenderer() {
        defaultRenderer = new DefaultTreeCellRenderer();
        setOpaque(false);
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {
        if (!(value instanceof DefaultMutableTreeNode)) {
            return defaultRenderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        }
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        Object userObject = node.getUserObject();
        if (!(userObject instanceof CheckBoxNodeData)) {
            return defaultRenderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        }
        CheckBoxNodeData data = ((CheckBoxNodeData) node.getUserObject());

        setBackground(UIManager.getColor(selected ? TREE_SELECTION_BACKGROUND : TREE_BACKGROUND));
        setSelected(data.getState() != CheckBoxNodeData.State.INDETERMINATE && data.isSelected());

        return this;
    }
}
