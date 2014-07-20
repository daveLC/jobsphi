package uk.co.jobsphi

class JobController {

    def index() {}

    def list() {

        def jobs = Job.list([max: 20, offset: 0])
        def total = Job.count

        [jobs: jobs, total: total]
    }
}
