package com.sksamuel.elastic4s.http.search.queries.span

import com.sksamuel.elastic4s.http.search.queries.QueryBuilderFn
import com.sksamuel.elastic4s.searches.queries.span.SpanContainingQueryDefinition
import org.elasticsearch.common.xcontent.{XContentBuilder, XContentFactory}

object SpanContainingQueryBodyFn {

  def apply(q: SpanContainingQueryDefinition): XContentBuilder = {

    val builder = XContentFactory.jsonBuilder()

    builder.startObject()
    builder.startObject("span_containing")

    builder.rawField("little", QueryBuilderFn(q.little).bytes)
    builder.rawField("big", QueryBuilderFn(q.big).bytes)

    q.boost.foreach(builder.field("boost", _))
    q.queryName.foreach(builder.field("_name", _))

    builder.endObject()
    builder.endObject()
  }
}
