package uk.co.jobsphi.importer

import au.com.bytecode.opencsv.CSVReader
import uk.co.jobsphi.Job

class UjmScraperImportService {

    def grailsApplication
    static def importBasePath = "/scrape-data/"
    static transactional = false

    static def JOB_ID = 0
    static def TITLE = 1
    static def LOCATION = 2
    static def SALARY = 3
    static def COMPANY = 5
    static def INDUSTRY = 6
    static def TYPE = 7
    static def DESCRIPTION = 9
    static def APPLY_LINK = 10
    static def DATE_ADDED = 13

    static def regionMap = [
            'HC': 'Home Counties',
            'ANGL': 'Anglia',
            'London': 'London',
            'SW': 'South West',
            'MID': 'Midlands',
            'Southern': 'Southern',
            'WA': 'Wales',
            'Yorkshire': 'Yorkshire',
            'NW': 'North West',
    ]

    def listFiles() {
        grailsApplication.mainContext.getResource(importBasePath).getFile().list()
    }

    def importFile(String fileName) {

		//def pathToFile = "/scrape-data/UJM-scrape-2014-07-18.csv"
        //def pathToFile = "/scrape-data/test.csv"
        def myFile = grailsApplication.mainContext.getResource(importBasePath+fileName).getFile()

        CSVReader reader = new CSVReader(new FileReader(myFile as File));
        List rows = reader.readAll();

        rows.each { row ->

            if (!isFirstRow(row)) {
                try {
                    processRow (row)
                }
                catch (e) {
                    println "Error processing row: $row"
                    println "Reason: $e.message"
                }
            }
        }
    }

    def isFirstRow (row) {
        row.first() == 'jobid'
    }

    def processRow (row) {

        def job = new Job()

        job.jobId = row[JOB_ID]
        job.title = row[TITLE]

        def location = processLocation(row[LOCATION])

        job.country = location.country
        job.region = location.region
        job.place = location.place
        job.salary = row[SALARY]
        job.company = row[COMPANY]
        job.industry = row[INDUSTRY]
        job.type = row[TYPE]
        job.description = row[DESCRIPTION]
        job.applyLink = row[APPLY_LINK]
        job.dateAdded = processDateAdded(row[DATE_ADDED])

        job.save(failOnError: true)
    }


    def processLocation (String location) {

        def parts = location.split('-')
        [country: parts[0], region: mapRegion(parts[1]), place: parts[2]]
    }

    def mapRegion (code) {
        regionMap.get(code) ?: code
    }

    def processDateAdded (String date) {
        Date.parse("yyyy-MM-dd", date)
    }
}
