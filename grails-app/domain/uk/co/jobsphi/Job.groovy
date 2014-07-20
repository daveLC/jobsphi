package uk.co.jobsphi

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString(includeNames = true, includeFields = true, excludes = 'metaClass')
@EqualsAndHashCode
class Job {

	String jobId
	String title
	String country
	String region
	String place
	String salary
	String company
	String industry
	String type
	String description
	String applyLink
	Date dateAdded
	Date dateCreated
	Date lastUpdated
	
	static mapping = {

        title type: 'text'
        salary type: 'text'
		description type: 'text'
        applyLink type: 'text'
		version: false
	}
	
    static constraints = {
	
		jobId 		nullable:false, unique:true
		title 		nullable:false
		country		nullable:true, blank:true
		region		nullable:true, blank:true
		place		nullable:true, blank:true
		salary		nullable:true, blank:true
		company		nullable:true, blank:true
		industry	nullable:true, blank:true
		type		nullable:true, blank:true
		description	nullable:true, blank:true
		applyLink	nullable:true, blank:true
		dateAdded	nullable:true, blank:true
    }
}
