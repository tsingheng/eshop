package net.shangtech.eshop.manager.view;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class TilesConfigurer extends org.springframework.web.servlet.view.tiles3.TilesConfigurer {
	
	private String locationPattern;

	public String getLocationPattern() {
		return locationPattern;
	}

	public void setLocationPattern(String locationPattern) throws IOException {
		this.locationPattern = locationPattern;
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
	    Resource[] resources = resolver.getResources(this.locationPattern);
	    if(resources != null){
	    	String[] definitions = new String[resources.length];
	    	for(int i = 0; i < resources.length; i++){
	    		definitions[i] = "classpath:tiles/" + resources[i].getFilename(); 
	    	}
	    	super.setDefinitions(definitions);
	    }
	}
	
}
