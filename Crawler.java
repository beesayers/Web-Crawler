import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler<T>
{
	private Node temp;
	private queue q;
	private stack s;
	private String tempURL;

	Crawler()														// default constructor
	{
	}
	
	public void goQ(String URL, int maxsize) throws IOException		// crawl from starting webpage using a queue of either unlimited or limited size (to be determined by the user)
	{
		temp = new Node(URL, null);
		q = new queue(maxsize);
		q.enqueue(temp);
		
		if (maxsize > 0)
		{
			q.setSize(maxsize);
		}
		
		while(q.getSize() != 0)
		{
			tempURL = q.dequeue().getData().toString();
			
			Document doc = Jsoup.connect(tempURL).get();
			String title = doc.title();
			Elements links2follow = doc.select("a[href]");
			
			if(!title.equals(""))
	    	{
	    		System.out.println(doc.title());		
	    	}
			
			for(Element link: links2follow)									
	    	{
	    		if(link.attr("href").contains("alaska.edu"))
	    		{
	    			temp = new Node(link.attr("abs:href"), null);
	    			q.enqueue(temp);
	    		}
	    	}
		}	
	}

	public void goS(String URL, int maxsize) throws IOException		// crawl from starting webpage using a stack of either unlimited or limited size (to be determined by the user)
	{
		temp = new Node(URL, null);
		s = new stack();
		s.push(temp);
		
		if (maxsize > 0)
		{
			s.setSize(maxsize);
		}
		
		while(s.getSize() != 0)
		{
			tempURL = s.pop().getData().toString();
			
			Document doc = Jsoup.connect(tempURL).get();
			String title = doc.title();
			Elements links2follow = doc.select("a[href]");
			
			if(!title.equals(""))
	    	{
	    		System.out.println(doc.title());		
	    	}
			
			for(Element link: links2follow)									
	    	{
	    		if(link.attr("href").contains("alaska.edu"))
	    		{
	    			temp = new Node(link.attr("abs:href"), null);
	    			s.push(temp);
	    		}
	    	}
		}
	}

}
