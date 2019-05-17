package com.apifortress.mule.fileapihelper;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.processor.MessageProcessor;

public class FileReaderProcessor implements MessageProcessor {
	
	String directory;

	@Override
	public MuleEvent process(MuleEvent event) throws MuleException {
		String filename = (String) event.getMessage().getPayload();
		try {
			event.getMessage().setPayload(IOUtils.toString(new FileInputStream(new File(directory+filename))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return event;
	}
	
	public void setDirectory(String directory) {
		if(!directory.endsWith(File.separator))
			directory+=File.separator;
		this.directory = directory;
	}

}
