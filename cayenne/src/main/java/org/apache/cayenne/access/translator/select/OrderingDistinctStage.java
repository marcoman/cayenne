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

package org.apache.cayenne.access.translator.select;

import org.apache.cayenne.query.Ordering;

class OrderingDistinctStage extends OrderingAbstractStage {

    @Override
    public void perform(TranslatorContext context) {
        if (context.getQuery().getOrderings() == null) {
            return;
        }

        if (isDistinct(context)) {
            // If query is DISTINCT then we need to add the order column as a result column
            QualifierTranslator qualifierTranslator = context.getQualifierTranslator();
            for (Ordering ordering : context.getQuery().getOrderings()) {
                processOrdering(qualifierTranslator, context, ordering);
            }
        }
    }

    private boolean isDistinct(TranslatorContext context) {
        return !context.isDistinctSuppression()
                && (context.getQuery().isDistinct()
                || context.getTableTree().hasToManyJoin());
    }
}
