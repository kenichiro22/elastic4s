package com.sksamuel.elastic4s.searches.aggs

import com.sksamuel.elastic4s.script.ScriptDefinition
import com.sksamuel.elastic4s.searches.aggs.pipeline.PipelineAggregationDefinition
import com.sksamuel.exts.OptionImplicits._

case class GeoBoundsAggregationDefinition(name: String,
                                          field: Option[String] = None,
                                          format: Option[String] = None,
                                          missing: Option[AnyRef] = None,
                                          wrapLongitude: Option[Boolean] = None,
                                          script: Option[ScriptDefinition] = None,
                                          pipelines: Seq[PipelineAggregationDefinition] = Nil,
                                          subaggs: Seq[AggregationDefinition] = Nil,
                                          metadata: Map[String, AnyRef] = Map.empty)
  extends AggregationDefinition {

  type T = GeoBoundsAggregationDefinition

  def field(field: String): T = copy(field = field.some)
  def wrapLongitude(wrapLongitude: Boolean): T = copy(wrapLongitude = wrapLongitude.some)
  def format(format: String): T = copy(format = format.some)
  def missing(missing: AnyRef): T = copy(missing = missing.some)
  def script(script: ScriptDefinition): T = copy(script = script.some)

  override def pipelines(pipelines: Iterable[PipelineAggregationDefinition]): T = copy(pipelines = pipelines.toSeq)
  override def subAggregations(aggs: Iterable[AggregationDefinition]): T = copy(subaggs = aggs.toSeq)
  override def metadata(map: Map[String, AnyRef]): T = copy(metadata = metadata)
}
