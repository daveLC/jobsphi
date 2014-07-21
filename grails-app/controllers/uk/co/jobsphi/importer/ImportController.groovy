package uk.co.jobsphi.importer

class ImportController {

    def ujmScraperImportService

    def index() {
        def files = ujmScraperImportService.listFiles()
        [files:files]
    }

    def importFile(String fileName) {
        ujmScraperImportService.importFile(fileName)
        flash.message = "Import completed successfully"
        redirect(action: 'index')
    }
}
