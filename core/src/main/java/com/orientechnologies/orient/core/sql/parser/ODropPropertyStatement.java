/* Generated By:JJTree: Do not edit this line. ODropPropertyStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

import java.util.Map;

public class ODropPropertyStatement extends OStatement {

  protected OIdentifier className;
  protected OIdentifier propertyName;
  protected boolean force = false;

  public ODropPropertyStatement(int id) {
    super(id);
  }

  public ODropPropertyStatement(OrientSql p, int id) {
    super(p, id);
  }

  @Override public void toString(Map<Object, Object> params, StringBuilder builder) {
    builder.append("DROP PROPERTY ");
    className.toString(params, builder);
    builder.append(".");
    propertyName.toString(params, builder);
    if(force){
      builder.append(" FORCE");
    }
  }
}
/* JavaCC - OriginalChecksum=6a9b4b1694dc36caf2b801218faebe42 (do not edit this line) */
