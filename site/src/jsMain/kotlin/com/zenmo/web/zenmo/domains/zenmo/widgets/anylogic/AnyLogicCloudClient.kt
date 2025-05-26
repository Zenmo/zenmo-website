package com.zenmo.web.zenmo.domains.zenmo.widgets.anylogic

import js.array.JsArray
import js.core.JsAny
import js.core.JsNumber
import js.promise.Promise

/**
 * AnyLogic JavaScript client declaration. Incomplete.
 *
 * See https://anylogic.help/cloud/api/js.html
 */
external class CloudClient(apiKey: String, host: String?) {
    companion object {
        fun create(apiKey: String, host: String?): CloudClient
    }

    fun getModelById(id: String): Promise<Model>
    fun getModelByName(name: String): Promise<Model>
    fun getModelVersionById(model: Model, versionId: String): Promise<Model>
    fun getModelVersionByNumber(model: Model, versionNumber: Int): Promise<ModelVersion>
    fun getLatestModelVersion(modelOrName: Model): Promise<ModelVersion>
    fun getLatestModelVersion(modelOrName: String): Promise<ModelVersion>

    fun createDefaultInputs(version: ModelVersion): Inputs
    fun createInputsFromExperiment(version: ModelVersion, experimentName: String): Inputs

    fun startAnimation(inputs: Inputs, divId: String): Promise<Animation>
}

external interface Model {
    val id: String
    val name: String
    val description: String

    @OptIn(ExperimentalJsCollectionsApi::class)
    val modelVersions: JsArray<String> // UUID's
    val published: Boolean
}

external interface ModelVersion {
    val id: String
    val version: Int
    val experimentTemplate: ExperimentTemplate
}

external interface ExperimentTemplate {
    val inputs: JsArray<JsAny>
    val outputs: JsArray<JsAny>
    val dashboard: JsAny
}

interface Inputs {
    fun getInput(name: String): JsAny
    fun setInput(name: String, value: JsAny): Unit
    fun setRangeInput(name: String, min: JsNumber, max: JsNumber, step: JsNumber): Unit
    fun setNumberOfReplications(num: Int): Unit
}

interface Animation {

}

