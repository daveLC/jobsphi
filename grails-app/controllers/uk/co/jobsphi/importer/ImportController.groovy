package uk.co.jobsphi.importer

class ImportController {

    def ujmScraperImportService

    def index() {
        ujmScraperImportService.importFile()
        render 'done'
    }

}
