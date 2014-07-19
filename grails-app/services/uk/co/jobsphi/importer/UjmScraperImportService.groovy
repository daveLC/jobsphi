package uk.co.jobsphi.importer

import grails.transaction.Transactional

@Transactional
class UjmScraperImportService {

    def importFile() {

		
		def pathToFile = "scrape-data/UJM-scrape-2014-07-18.csv"
		
		
		File importFile = new File (pathToFile)
		
		
		def content = importFile.text()
		
    }
}
