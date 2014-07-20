// Place your Spring DSL code here

import grails.rest.render.json.JsonCollectionRenderer
import grails.rest.render.xml.*
import grails.rest.render.json.JsonRenderer
import uk.co.jobsphi.Job

beans = {
    jobXmlRenderer(XmlRenderer, Job) {
        excludes = ['class']
    }
    jobJSONRenderer(JsonRenderer, Job) {
        excludes = ['class']
    }
    jobXmlCollectionRenderer(XmlCollectionRenderer, Job) {
        excludes = ['class']
    }
    jobJSONCollectionRenderer(JsonCollectionRenderer, Job) {
        excludes = ['class']
    }
}
