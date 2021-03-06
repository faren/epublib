package nl.siegmann.epublib.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import nl.siegmann.epublib.service.MediatypeService;

/**
 * A Book's collection of Metadata.
 * In the future it should contain all Dublin Core attributes, for now it contains a set of often-used ones.
 * 
 * @author paul
 *
 */
public class Metadata {

	public static final String DEFAULT_LANGUAGE = "en";
	
	private List<Author> authors = new ArrayList<Author>();
	private List<Author> contributors = new ArrayList<Author>();
	private List<Date> dates = new ArrayList<Date>();
	private String language = DEFAULT_LANGUAGE;
	private Map<QName, String> otherProperties = new HashMap<QName, String>();
	private List<String> rights = new ArrayList<String>();
	private List<String> titles = new ArrayList<String>();
	private List<Identifier> identifiers = new ArrayList<Identifier>();
	private List<String> subjects = new ArrayList<String>();
	private String format = MediatypeService.EPUB.getName();
	private List<String> types = new ArrayList<String>();
	private Guide guide = new Guide();
	
	/*
	 * 
	 
	 Contributor  	An entity responsible for making contributions to the content of the resource
Coverage 	The extent or scope of the content of the resource
Creator 	An entity primarily responsible for making the content of the resource
Format 	The physical or digital manifestation of the resource
Date 	A date of an event in the lifecycle of the resource
Description 	An account of the content of the resource
Identifier 	An unambiguous reference to the resource within a given context
Language 	A language of the intellectual content of the resource
Publisher 	An entity responsible for making the resource available
Relation 	A reference to a related resource
Rights 	Information about rights held in and over the resource
Source 	A Reference to a resource from which the present resource is derived
Subject 	A topic of the content of the resource
Title 	A name given to the resource
Type 	The nature or genre of the content of the resource
	 
	 
	 */
	
	
	/**
	 * Metadata properties not hard-coded like the author, title, etc.
	 * 
	 * @return
	 */
	public Map<QName, String> getOtherProperties() {
		return otherProperties;
	}
	public void setOtherProperties(Map<QName, String> otherProperties) {
		this.otherProperties = otherProperties;
	}
	
	public Date addDate(Date date) {
		this.dates.add(date);
		return date;
	}
	
	public List<Date> getDates() {
		return dates;
	}
	public void setDates(List<Date> dates) {
		this.dates = dates;
	}

	public Author addAuthor(Author author) {
		authors.add(author);
		return author;
	}
	
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
		
	public Author addContributor(Author contributor) {
		contributors.add(contributor);
		return contributor;
	}
	
	public List<Author> getContributors() {
		return contributors;
	}
	public void setContributors(List<Author> contributors) {
		this.contributors = contributors;
	}
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public List<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	public void setRights(List<String> rights) {
		this.rights = rights;
	}
	public List<String> getRights() {
		return rights;
	}
	public String addTitle(String title) {
		this.titles.add(title);
		return title;
	}
	public void setTitles(List<String> titles) {
		this.titles = titles;
	}
	public List<String> getTitles() {
		return titles;
	}
	public Identifier addIdentifier(Identifier identifier) {
		this.identifiers.add(identifier);
		return identifier;
	}
	public void setIdentifiers(List<Identifier> identifiers) {
		this.identifiers = identifiers;
	}
	public List<Identifier> getIdentifiers() {
		return identifiers;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getFormat() {
		return format;
	}

	public String addType(String type) {
		this.types.add(type);
		return type;
	}
	
	
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public Resource getCoverPage() {
		return guide.getCoverPage();
	}
	public void setCoverPage(Resource coverPage) {
		guide.setCoverPage(coverPage);
	}
	public Resource getCoverImage() {
		return guide.getCoverImage();
	}
	public void setCoverImage(Resource coverImage) {
		guide.setCoverImage(coverImage);
	}
	public Guide getGuide() {
		return guide;
	}
}
