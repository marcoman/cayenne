package org.apache.cayenne.access.sqlbuilder;

import org.apache.cayenne.CayenneRuntimeException;
import org.apache.cayenne.access.sqlbuilder.sqltree.Node;
import org.apache.cayenne.access.sqlbuilder.sqltree.ThenNode;

/**
 * @since 5.0
 */
class WhenBuilder implements NodeBuilder {

    NodeBuilder result;
    CaseWhenBuilder builder;

    public WhenBuilder(CaseWhenBuilder caseWhenBuilder) {
        this.builder = caseWhenBuilder;
    }

    CaseWhenBuilder then(NodeBuilder result) {
        this.result = result;
        builder.getNodeBuilders().add(this);
        return builder;
    }
    @Override
    public Node build() {
        if(result == null) {
            throw new CayenneRuntimeException("\"Then\" result must be defined after the \"When\" condition ");
        }
        ThenNode thenNode = new ThenNode();
        thenNode.addChild(result.build());
        return thenNode;
    }
}