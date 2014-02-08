/*
 * Copyright 2014 The Apache Software Foundation
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.phoenix.parse;

import java.sql.SQLException;



/**
 * 
 * Node representing the selection of all columns (*) in the SELECT clause of SQL
 *
 * 
 * @since 0.1
 */
public class WildcardParseNode extends TerminalParseNode {
    private final boolean isRewrite;    
    public static final WildcardParseNode INSTANCE = new WildcardParseNode(false);
    public static final WildcardParseNode REWRITE_INSTANCE = new WildcardParseNode(true);

    private WildcardParseNode(boolean isRewrite) {
        this.isRewrite = isRewrite;
    }

    @Override
    public <T> T accept(ParseNodeVisitor<T> visitor) throws SQLException {
        return visitor.visit(this);
    }

    @Override
    public String toString() {
        return "*";
    }

    public boolean isRewrite() {
        return isRewrite;
    }    
    
}