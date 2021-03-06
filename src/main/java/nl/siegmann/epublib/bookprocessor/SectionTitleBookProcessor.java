package nl.siegmann.epublib.bookprocessor;

import java.io.IOException;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.domain.Section;
import nl.siegmann.epublib.epub.EpubWriter;

import org.apache.commons.lang.StringUtils;
import org.xml.sax.InputSource;

public class SectionTitleBookProcessor implements BookProcessor {

	@Override
	public Book processBook(Book book, EpubWriter epubWriter) {
		XPath xpath = createXPathExpression();
		processSections(book.getTocSections(), book, xpath);
		return book;
	}

	private void processSections(List<Section> sections, Book book, XPath xpath) {
		for(Section section: sections) {
			if(! StringUtils.isBlank(section.getTitle())) {
				continue;
			}
			try {
				String title = getTitle(section, book, xpath);
				section.setTitle(title);
			} catch (XPathExpressionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	private String getTitle(Section section, Book book, XPath xpath) throws IOException, XPathExpressionException {
		Resource resource = section.getResource();
		if(resource == null) {
			return null;
		}
		InputSource inputSource = new InputSource(resource.getInputStream());
		String title = xpath.evaluate("/html/head/title", inputSource);
		return title;
	}
	
	
	private XPath createXPathExpression() {
		return XPathFactory.newInstance().newXPath();
	}
}
