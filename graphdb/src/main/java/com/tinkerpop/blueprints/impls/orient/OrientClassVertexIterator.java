package com.tinkerpop.blueprints.impls.orient;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.orientechnologies.orient.core.metadata.schema.OClass;
import com.tinkerpop.blueprints.Vertex;

public class OrientClassVertexIterator implements Iterator<Vertex> {
  private Iterator<Vertex> iterator;
  private OClass klass;
  private OrientVertex     vertex;
  private OrientBaseGraph graph;

  public OrientClassVertexIterator(OrientBaseGraph graph, Iterator<Vertex> iterator, String klass) {
    this.iterator = iterator;
    this.graph = graph;
    this.klass = graph.getRawGraph().getMetadata().getSchema().getClass(klass);
  }

  @Override
  public boolean hasNext() {
    if(vertex == null) {
      while (iterator.hasNext()) {
        vertex = (OrientVertex) iterator.next();
        if (vertex != null && klass.isSuperClassOf(vertex.getRecord().getSchemaClass())) {
          return true;
        }
      }
    }
    else {
      return true;
    }
    return false;
  }

  @Override
  public Vertex next() {
    if (vertex == null) {
      if (!hasNext())
        throw new NoSuchElementException();
    }

    OrientVertex cur = vertex;
    vertex = null;
    return cur;
  }

}
