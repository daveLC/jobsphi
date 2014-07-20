package uk.co.jobsphi

import grails.rest.RestfulController

class JobController extends RestfulController {

    static responseFormats = ['json', 'xml']

    JobController() {
        super(Job)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Job.list(params), model:[bookCount: Job.count()]
    }

    def list() {

        def jobs = Job.list([max: 20, offset: params.offset ?:0])
        def total = Job.count

        [jobs: jobs, total: total]
    }
}
